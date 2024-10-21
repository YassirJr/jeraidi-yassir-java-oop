# Letter Occurrences System

This project is a simple Letter Occurrences System written in Java. It consists of two main classes: `Main` and `OccurrencesLettres`.

## Features

- **Calculate Letter Occurrences**: The system calculates and displays the number of occurrences of each letter in a given text.

## Classes

### Main

The `Main` class is responsible for interacting with the user. It takes a text input from the user and creates an instance of the `OccurrencesLettres` class to calculate the occurrences of each letter in the text.

```java
package org.example.ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le text :");
        OccurrencesLettres occurrencesLettres = new OccurrencesLettres(scanner.nextLine());
        occurrencesLettres.calc();
        scanner.close();
    }
}
```

### OccurrencesLettres

The `OccurrencesLettres` class handles the core functionality of calculating the number of occurrences of each letter in the provided text. It processes the text and prints the count of each letter that appears in the text.

```java
package org.example.ex4;

public class OccurrencesLettres {
    private String text;

    public OccurrencesLettres(String text) {
        this.text = text.toLowerCase();
    }

    public void calc() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int[] nb_occurrences = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (alphabets.contains(String.valueOf(c))) {
                nb_occurrences[alphabets.indexOf(String.valueOf(c))]++;
            }
        }

        for (int i = 0; i < nb_occurrences.length; i++) {
            if (nb_occurrences[i] > 0) {
                System.out.printf("%c : %d%n", alphabets.charAt(i), nb_occurrences[i]);
            }
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
4. Follow the prompt to enter a text.

