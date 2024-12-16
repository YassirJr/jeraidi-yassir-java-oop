package com.sockets.ex1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 100");
        int guessedNumber = scanner.nextInt();
        socket.getOutputStream().write(guessedNumber);
        int response = socket.getInputStream().read();
        while (response != 0) {
            if (response == 1) {
                System.out.println("The number is smaller");
            } else {
                System.out.println("The number is bigger");
            }
            guessedNumber = scanner.nextInt();
            socket.getOutputStream().write(guessedNumber);
            response = socket.getInputStream().read();
        }
        System.out.println("You guessed the number!");
    }
}
