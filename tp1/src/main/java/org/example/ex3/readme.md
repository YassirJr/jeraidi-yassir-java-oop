# String Manipulation System

This project is a simple String Manipulation System written in Java. It consists of three main classes: `Main`, `Menu`, and `MyString`.

## Features

- **Input String**: Allows the user to input a string.
- **Display String**: Displays the currently stored string.
- **Reverse String**: Reverses the currently stored string.
- **Count Words**: Counts the number of words in the currently stored string.

## Classes

### Main

The `Main` class is responsible for interacting with the user. It displays a menu, takes user input to select options, and performs actions based on the selection using the functionality provided by the `Menu` and `MyString` classes.

```java
package org.example.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            Menu.afficherMenu();
            System.out.println("Entrez votre choix :");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.print("Saisir : ");
                    String s = scanner.nextLine();
                    System.out.println(s);
                    MyString.saisir(s);
                    break;
                case 2:
                    MyString.afficher();
                    break;
                case 3:
                    System.out.println("Inverse : " + MyString.inverser());
                    break;
                case 4:
                    System.out.println("Nombre de mots : " + MyString.nombreDeMots());
                    break;
                case 5:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Choix incorrect");
                    break;
            }

            if (choix != 5) {
                System.out.println("\nFrappez une touche pour revenir au menu...");
                scanner.nextLine();
            }

        } while (choix != 5);

        scanner.close();
    }
}
```

### Menu

The `Menu` class is responsible for displaying the menu options to the user. It provides a list of operations that the user can choose from.

```java
package org.example.ex3;

public class Menu {
    public static void afficherMenu() {
        System.out.println("************** Menu *************");
        String[] operations = {"saisir", "afficher", "inverser", "nombre de mots" , "Fin"};
        for (int i = 0; i < operations.length; i++) {
            System.out.printf("%d : %s%n", i + 1, operations[i]);
        }
    }
}
```

### MyString

The `MyString` class handles the core functionalities related to string manipulation, such as inputting, displaying, reversing, and counting the words in a string.

```java
package org.example.ex3;

public class MyString {
    private static String string;

    public static void saisir(String s){
        string = s;
    }

    public static void afficher(){
        System.out.println(string);
    }

    public static String inverser(){
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        string = sb.toString();
        return string;
    }

    public static int nombreDeMots(){
        return string.split(" ").length;
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
4. Follow the menu to perform various string manipulation operations.
