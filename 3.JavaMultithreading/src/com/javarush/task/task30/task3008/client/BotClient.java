package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client
{
    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            // Выводим текст сообщения в консоль
            ConsoleHelper.writeMessage(message);

            // Отделяем отправителя от текста сообщения
            String userNameDelimiter = ": ";
            String[] split = message.split(userNameDelimiter);
            if (split.length != 2) return;

            String messageWithoutUserName = split[1];

            // Подготавливаем формат для отправки даты согласно запросу
            String format = null;
            switch (messageWithoutUserName) {
                case "дата":
                    format = "d.MM.YYYY";
                    break;
                case "день":
                    format = "d";
                    break;
                case "месяц":
                    format = "MMMM";
                    break;
                case "год":
                    format = "YYYY";
                    break;
                case "время":
                    format = "H:mm:ss";
                    break;
                case "час":
                    format = "H";
                    break;
                case "минуты":
                    format = "m";
                    break;
                case "секунды":
                    format = "s";
                    break;
            }

            if (format != null) {
                String answer = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
                BotClient.this.sendTextMessage("Информация для " + split[0] + ": " + answer);
            }
            /* ConsoleHelper.writeMessage(message);
            String[] nameText = message.split(": ");
            String name = nameText[0];
            String text = nameText[1];
            if (nameText.length != 2) return;
            
            SimpleDateFormat format = null;

            if (text.equalsIgnoreCase("дата"))
            {
                format = new SimpleDateFormat("d.MM.YYYY");
            } else if (text.equals("день"))
            {
                format = new SimpleDateFormat("d");
            } else if (text.equals("месяц"))
            {
                format = new SimpleDateFormat("MMMM");
            } else if (text.equals("год"))
            {
                format = new SimpleDateFormat("YYYY");
            } else if (text.equals("время"))
            {
                format = new SimpleDateFormat("H:mm:ss");
            } else if (text.equals("час"))
            {
                format = new SimpleDateFormat("H");
            } else if (text.equals("минуты"))
            {
                format = new SimpleDateFormat("m");
            } else if (text.equals("секунды"))
            {
                format = new SimpleDateFormat("s");
            } 

            Date now = Calendar.getInstance().getTime();

            String answer = "Информация для " + name + ": " + format.format(now);

            if (null != format)
                BotClient.this.sendTextMessage(answer);*/
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        String X = String.valueOf((int) (Math.random() * 100));
        return "date_bot_" + X;
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
