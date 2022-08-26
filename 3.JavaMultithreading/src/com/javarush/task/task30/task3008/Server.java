package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*
Итак, чтобы насладиться плодами наших титанических:
1. Запускаем программу из класса Server
2. В консоли вводим любое число для указания порта, например: 1234 (только не 0(ноль). Вообще вроде бы желательно указывать от 1025 до 49151, а полный диапазон от 0 до 65535, но с нулём у меня не работает)
В консоли появится надпись "Cервер запущен". Отлично, идём дальше.
3. Переходим в класс ClientGuiController и запускаем программу из этого класса.
Программа в отдельном окошке запросит адрес сервера - вводим "127.0.0.1" или "localhost". (Без кавычек. Это наш локальный адрес, адрес нашего компьютера).
Затем программа запросит порт сервиса. Указываем тот порт, который мы вводили в п.2, в нашем примере это 1234
Программа просит придумать имя, под которым мы будем отображаться в чате - указываем любое имя.
4. Далее переходим в класс BotClient и запускаем программу из этого класса.
В консоли также вводим адрес сервера и номер порта,
в нашем примере это localhost и 1234 соответственно.

В окне чата бот умеет отвечать на наши сообщения, которые мы указывали в классе BotClient в методе processIncomingMessage (дата, день, месяц, год, время, час, минуты, секунды).
Можно научить бота отвечать на любые другие наши сообщения, но потребуется немного изменить метод processIncomingMessage.
 */
public class Server
{
    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (Connection connection : connectionMap.values())
        {
            try
            {
                connection.send(message);
            } catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение" + connection.getRemoteSocketAddress());
            } catch (ClassNotFoundException e)
            {

            }
        }
    }

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Чат сервер запущен.");

            while (true)
            {
                // Ожидаем входящее соединение и запускаем отдельный поток при его принятии
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e)
        {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("Установлено новое соединение с " + socket.getRemoteSocketAddress());

            String userName = null;

            try (Connection connection = new Connection(socket))
            {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с " + socket.getRemoteSocketAddress());
            }
            if (userName != null)
            {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            Message response = null;
            String name = "";
            do
            {
                do
                {
                    Message query = new Message(MessageType.NAME_REQUEST);
                    connection.send(query);

                    response = connection.receive();

                    if (response.getType() != MessageType.USER_NAME)
                        ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                }
                while (MessageType.USER_NAME != response.getType());

                name = response.getData();

                if (name.isEmpty())
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " + socket.getRemoteSocketAddress());

                if (connectionMap.containsKey(name))
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем от " + socket.getRemoteSocketAddress());
            }
            while (0 == name.length() || null == name || connectionMap.containsKey(name));

            connectionMap.put(name, connection);
            Message acceptedName = new Message(MessageType.NAME_ACCEPTED, "имя было принято");
            connection.send(acceptedName);

            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException
        {
            for (String name : connectionMap.keySet())
            {
                if (name.equals(userName))
                    continue;

                try
                {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                } catch (ClassNotFoundException e)
                {

                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                String newText = "";
                Message message = connection.receive();

                if (MessageType.TEXT == message.getType())
                {
                    newText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, newText));
                } else
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
            }
        }
    }
}
