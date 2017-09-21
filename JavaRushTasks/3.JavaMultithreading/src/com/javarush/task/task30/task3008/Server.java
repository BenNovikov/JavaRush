package com.javarush.task.task30.task3008;

import com.javarush.task.task29.task2909.user.Address;

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

            //test
            ConsoleHelper.writeMessage(
                    "Address: " + serverSocket.getInetAddress() +
                    " Port: " + serverSocket.getLocalPort());

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
                ConsoleHelper.writeMessage("Sending message Error!");
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
            ConsoleHelper.writeMessage("New connection established to: " + socket.getRemoteSocketAddress());
            String client = "";
            try (Connection connection = new Connection(socket)) {
                client = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, client));
                sendListOfUsers(connection, client);
                serverMainLoop(connection, client);
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage() + " @ address: " + socket.getRemoteSocketAddress());
            }
            finally {
                if (!client.isEmpty()) {
                    connectionMap.remove(client);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, client));
                }
            }
            ConsoleHelper.writeMessage("Connection " + socket.getRemoteSocketAddress() + " closed");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = new Message(MessageType.NAME_REQUEST);
                connection.send(message);
                message = connection.receive();
                String name = message.getData();
                if (message.getType() == MessageType.USER_NAME) {
                    if (!name.isEmpty()) {
                        if (!connectionMap.containsKey(name)) {
                            connectionMap.put(name, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return name;
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (name != userName) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message sendMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(sendMessage);
                }
                else {
                    ConsoleHelper.writeMessage("Invalid message received!");
                }
            }
        }
    }
}
