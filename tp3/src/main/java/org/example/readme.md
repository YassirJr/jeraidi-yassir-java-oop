# Unified Java Exercises

This project is a collection of various Java exercises unified under a single entry point. It consists of a main Main class that orchestrates the execution of exercises from different packages.

## Table of Contents

- [Exercises](#exercises)
- [Main Entry Point](#main-entry-point)
- [Exercises link](#exercises-link)
- [Prerequisites](#prerequisites)

## Exercises

- **Exercise 1**: Vehicle Speed Test
- **Exercise 2**: Square Root Calculator
- **Exercise 3**: Grade Evaluator

## Main Entry Point

### Main

The central `Main` class is responsible for running all the exercises sequentially. It invokes the `main` method of each exercise.

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        org.example.ex1.Vehicule.main(args);
        org.example.ex2.Calculateur.main(args);
        org.example.ex3.Evaluateur.main(args);
    }
}
```

## Exercises link

- [Exercise 1](ex1/readme.md)
- [Exercise 2](ex2/readme.md)
- [Exercise 3](ex3/readme.md)


### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- IDE such as IntelliJ IDEA.

### Running the Program

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the central `Main` class.
4. The program will sequentially execute each exercise: Notes Management System, Conjugation System, String Manipulation System, and Letter Occurrences System.
