package com.sockets.ex2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final String SERVER_FILES_DIRECTORY = "src/main/java/com/sockets/ex2/server_files/";
    private final Socket clientSocket;

    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is running  " + 1234);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected : " + clientSocket.getInetAddress());
                new Thread(new Server(clientSocket)).start();
            }

        } catch (IOException e) {
            System.err.println("Server error : " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try (
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            writer.println("Please enter the name of the file you want to read:");

            String fileName = reader.readLine();
            File file = new File(SERVER_FILES_DIRECTORY + fileName);

            if (file.exists() && file.isFile()) {
                writer.println("File found. Sending file...");
                try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        writer.println(line);
                    }
                }
                writer.println("EOF"); // end of file
            } else {
                writer.println("Error: File not found");
            }
        } catch (IOException e) {
            System.err.println("Error in the client : " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing the client socket : " + e.getMessage());
            }
        }
    }
}
