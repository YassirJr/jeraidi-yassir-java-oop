# Files management with sockets and threads

This project demonstrates a simple client-server communication using Java sockets. The server listens for incoming client connections and allows clients to request files stored on the server. The client can request a file by name, and the server will send the contents of the file back to the client.

## Key Features

- Multithreaded server architecture
- Concurrent client connection handling
- Simple file transfer protocol
- Basic error handling


## Project Structure

- `src/main/java/com/sockets/ex2/Client1.java`: Entry point for the first client.
- `src/main/java/com/sockets/ex2/Client2.java`: Entry point for the second client.
- `src/main/java/com/sockets/ex2/ClientService.java`: Contains the logic for the client to connect to the server, request a file, and display the file contents.
- `src/main/java/com/sockets/ex2/Server.java`: Contains the logic for the server to accept client connections, handle file requests, and send file contents to the client.
- `src/main/java/com/sockets/ex2/server_files/`: Directory containing the files that can be requested by the clients.


### Server

The `Server` class is responsible for handling client connections and file requests. It performs the following steps:

## How It Works

### Server Initialization

1. The server starts on port 1234
2. Continuously listens for incoming client connections
3. For each new client connection, creates a new thread to handle the request

### File Transfer Process

1. Client connects to the server
2. Server prompts the client to enter a filename
3. Server checks if the file exists in the `server_files` directory
4. If file exists:
    - Sends file contents line by line
    - Marks end of file with "EOF"
5. If file does not exist:
    - Sends an error message

## Code Components

### Main Method
- Creates a `ServerSocket` on port 1234
- Accepts client connections
- Spawns a new thread for each client using `Server` class

```java

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                Server server = new Server(clientSocket);
                server.start();
            }
        } catch (IOException e) {
            System.err.println("Error in the server: " + e.getMessage());
        }
    }
```

### `run()` Method
- Handles individual client file transfer requests
- Reads client input
- Locates and transfers requested file
- Manages input/output streams
- Closes client socket after transfer

```java

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
```

## Error Handling

- Catches and logs server initialization errors
- Handles file not found scenarios
- Ensures socket closure in case of exceptions


# File Transfer Client

## Overview

This Java client provides a simple interface for connecting to the file transfer server and reading files.

## Key Features

- Connects to localhost on port 1234
- Interactive file read process
- Reads server prompts and file contents
- Simple error handling

## Connection Flow

1. Establishes a socket connection to the server
2. Reads server's initial prompt
3. Allows user to input filename
4. Receives and displays file contents
5. Terminates on "EOF" marker

## Code Components

### Connection Setup
- Uses `Socket` to connect to `localhost:1234`
- Creates input and output streams
- Uses `BufferedReader` for reading
- Uses `PrintWriter` for writing

```java
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
```

### File read Process
- Reads server's initial prompt
- Prompts user for filename
- Sends filename to server
- Receives and prints file contents
- Stops when "EOF" is received

## Error Handling

- Catches and displays connection errors
- Gracefully closes all streams
- Provides basic error messaging


# Multi-Client File Transfer Application

## Client Classes Overview

### Purpose
The `Client1` and `Client2` classes demonstrate the ability to run multiple simultaneous client instances using the same `ClientService`.

## Key Characteristics

- Both clients use the exact same `ClientService.run()` method
- Allows concurrent file read requests
- Supports multiple client connections to the server

## Implementation Details

### Client1
- Simple main method that calls `ClientService.run()`
- Represents first potential client instance

### Client2
- Identical to Client1
- Represents second potential client instance

## Usage Scenario

1. Start the server
2. Run `Client1`
    - Prompts for filename
    - get requested file content
3. Run `Client2`
    - Can simultaneously request a different file
    - Demonstrates server's multi-client handling capability

## Example Workflow

```
Server Running
│
├─ Client1 Connects
│  └─ Requests "me"
│
└─ Client2 Connects
   └─ Requests "you"
```


