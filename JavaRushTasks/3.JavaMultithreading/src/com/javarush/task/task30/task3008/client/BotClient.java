package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;

/**
 * Created by Ben on 2017-09-20.
 */
public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage(
                    "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
            );
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] messageData = message.split(": ");
            switch (messageData[1]) {
                case "дата" :
                    break;
                case "день" :
                    break;
                case "месяц" :
                    break;
                case "год" :
                    break;
                case "время" :
                    break;
                case "час" :
                    break;
                case "минуты" :
                    break;
                case "секунды" :
                    break;
                default:

            }
        }
    }
}
