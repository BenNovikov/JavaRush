package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ben on 2017-09-18.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Input server port number: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connection : connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            }
            catch (IOException e) {
                System.out.println("Sending message Error!");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = new Message(MessageType.NAME_REQUEST);
            connection.send(message);
            message = connection.receive();
            if (message.getType() == MessageType.USER_NAME) {
                String name = message.getData();
                if (!connectionMap.containsKey(name)) {
                    connectionMap.putIfAbsent(name, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return name;
                }
            }

            System.out.println("Server handshake failed! Resetting connection. ");
            serverHandshake(connection);

            return null;
        }
    }
}
