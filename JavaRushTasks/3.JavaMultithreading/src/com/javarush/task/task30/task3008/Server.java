package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ben on 2017-09-18.
 */
public class Server {
    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class Handler {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
