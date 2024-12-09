# Unified Java Exercises

This project is a collection of various Java exercises unified under a single entry point. It consists of a main Main class that orchestrates the execution of exercises from different packages.

## Table of Contents

- [Exercises](#exercises)
- [Main Entry Point](#main-entry-point)
- [Main Code Results](#main-code-results)
- [Exercises link](#exercises-link)
- [Prerequisites](#prerequisites)



## Exercises

- **Exercise 1**:

## Main Entry Point

### Main

The central `Main` class is responsible for running all the exercises sequentially. It invokes the `main` method of each exercise.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Exrcise 1");
        Talkative.main(args);
        System.out.println("Exercise 2");
        org.example.ex2.Main.main(args);
    }
}
```

### Main Code Results

# Exercise 1:
![Exercise 1 Result](screenshots/ex1-result.png)
# Exercise 2:
![Exercise 2 Result](screenshots/ex2-result.png)

The message Process finished with exit code 0 indicates that the program terminated successfully without any unhandled exceptions.


## Exercises link

- [Exercise 1](src/main/java/org/example/ex1/readme.md)
- [Exercise 2](src/main/java/org/example/ex2/readme.md)

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- IDE such as IntelliJ IDEA.

### Running the Program

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the central `Main` class.
4. The program will sequentially execute each exercise: Notes Management System, Conjugation System, String Manipulation System, and Letter Occurrences System.
