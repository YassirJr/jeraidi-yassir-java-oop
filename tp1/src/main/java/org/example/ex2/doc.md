# Conjugation System

This project is a simple Conjugation System written in Java. It consists of two main classes: `Main` and `Conjugaison`.

## Features

- **Conjugate Verbs**: The system allows for the conjugation of French verbs ending in "er".

## Classes

### Main

The `Main` class is responsible for interacting with the user. It takes a French verb as input and then creates an instance of the `Conjugaison` class to conjugate the verb.

```java
package org.example.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un verbe : ");
        String verb = scanner.nextLine();
        Conjugaison conjugaison = new Conjugaison(verb);
        conjugaison.conjuge();
        scanner.close();
    }
}
```

### Conjugaison

The `Conjugaison` class handles the core functionality of conjugating French verbs ending in "er". It takes a verb as input, processes it, and prints its conjugations in the present tense.

```java
package org.example.ex2;

public class Conjugaison {
    private String verb;

    public Conjugaison(String verb){
        this.verb = verb.trim().toLowerCase();
    }

    public void conjuge() {
        if (verb.endsWith("er") && verb.length() > 2) {
            String verbWithoutER = verb.substring(0, verb.length() - 2);
            System.out.println("je " + verbWithoutER + "e");
            System.out.println("tu " + verbWithoutER + "es");
            System.out.println("il " + verbWithoutER + "e");
            System.out.println("nous " + verbWithoutER + "ons");
            System.out.println("vous " + verbWithoutER + "ez");
            System.out.println("ils " + verbWithoutER + "ent");
        } else {
            System.out.println("Le verbe ne pas valide.");
        }
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
3. Compile and run the `Main` class.
4. Follow the prompt to enter a French verb ending in "er".

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.