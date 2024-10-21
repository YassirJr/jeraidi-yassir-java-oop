# Unified Java Exercises

This project is a collection of various Java exercises unified under a single entry point. It consists of a main `Main` class that orchestrates the execution of exercises from different packages.

## Features

- **Exercise 1**: Notes Management System
- **Exercise 2**: Conjugation System
- **Exercise 3**: String Manipulation System
- **Exercise 4**: Letter Occurrences System

## Main Entry Point

### Main

The central `Main` class is responsible for running all the exercises sequentially. It invokes the `main` method of each exercise.

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice 1");
        org.example.ex1.Main.main(args);
        System.out.println("Exercice 2");
        org.example.ex2.Main.main(args);
        System.out.println("Exercice 3");
        org.example.ex3.Main.main(args);
        System.out.println("Exercice 4");
        org.example.ex4.Main.main(args);
    }
}
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- IDE such as IntelliJ IDEA.

### Running the Program

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the central `Main` class.
4. The program will sequentially execute each exercise: Notes Management System, Conjugation System, String Manipulation System, and Letter Occurrences System.
