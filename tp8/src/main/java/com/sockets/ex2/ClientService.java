package com.sockets.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientService {
    public static void run() {
        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(reader.readLine());

            String fileName = consoleReader.readLine();
            writer.println(fileName);

            String response;
            while ((response = reader.readLine()) != null) {
                if (response.equals("EOF")) {
                    break;
                }
                System.out.println(response);
            }

        } catch (IOException e) {
            System.out.println("Error in the client : " + e.getMessage());
        }
    }
}
