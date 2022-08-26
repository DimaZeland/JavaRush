package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("участник с именем " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));

                } else if (MessageType.NAME_ACCEPTED == message.getType())
                {
                    notifyConnectionStatusChanged(true);
                    return;
                } else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            // Цикл обработки сообщений сервера
            while (true)
            {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT)
                { // Сервер прислал сообщение с текстом
                    processIncomingMessage(message.getData());
                } else if (MessageType.USER_ADDED == message.getType())
                {
                    informAboutAddingNewUser(message.getData());
                } else if (MessageType.USER_REMOVED == message.getType())
                {
                    informAboutDeletingNewUser(message.getData());
                } else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run()
        {
            String address = getServerAddress();
            int port = getServerPort();
            try
            {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите адрес порта сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите ваше имя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e)
        {
            ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            clientConnected = false;
        } catch (ClassNotFoundException e)
        {

        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try
        {
            synchronized (this)
            {
                wait();
            }
        } catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        // Пока не будет введена команда exit, считываем сообщения с консоли и отправляем их на сервер
        while (clientConnected)
        {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit"))
                break;

            if (shouldSendTextFromConsole())
                sendTextMessage(text);
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }
}
