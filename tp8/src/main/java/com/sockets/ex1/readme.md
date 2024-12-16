# Number Guessing Game - Socket Implementation

## Overview

A simple client-server socket-based number guessing game where the server generates a random number, and the client tries to guess it.

## Game Mechanics

- Server generates a random number between 1 and 100
- Client attempts to guess the number
- Server provides feedback:
    - If guess is too high: Returns 1
    - If guess is too low: Returns -1
    - If guess is correct: Returns 0

## Server 

### Functionality
- Listens on port 1234
- Generates a random number between 1 and 100
- Receives client guesses
- Provides feedback on each guess
- Ends game when correct number is guessed

### Key Methods
- Generates random number using `Math.random()`
- Compares client guess with generated number
- Sends feedback through socket output stream

# Code :

```java
package com.sockets.ex1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");
        Socket server = socket.accept();
        int number = (int) (Math.random() * 100 + 1);
        int guessedNumber = server.getInputStream().read();
        while (guessedNumber != number) {
            if (guessedNumber > number) {
                server.getOutputStream().write(1);
            } else {
                server.getOutputStream().write(-1);
            }
            guessedNumber = server.getInputStream().read();
        }
        server.getOutputStream().write(0);
        socket.close();
    }
}
```

## Client 

### Functionality
- Connects to server on localhost:1234
- Prompts user to input guesses
- Sends guesses to server
- Receives and displays feedback
- Continues until correct number is guessed

### Game Loop
1. Initial number input
2. Send guess to server
3. Receive server response
4. Display hint (too high/too low)
5. Repeat until correct guess

## Technical Details

### Communication Protocol
- Uses raw byte stream for communication
- Single byte responses:
    - `1`: Guess too high
    - `-1`: Guess too low
    - `0`: Correct guess


### Socket Configuration
- Port: 1234
- Localhost connection
- Direct byte stream communication

# Code :

```java
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
```


