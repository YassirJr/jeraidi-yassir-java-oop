# Exercise 2: Contact Management

This exercise is part of a unified Java exercises project. The `Contact Management` system allows users to manage contacts by adding, deleting, updating, and retrieving contact information.

## Class: DossierContact

This file defines the `DossierContact` class, which provides functionality to manage contacts stored in text files within a specified folder.

```java
package com.tp6.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DossierContact {
    private final List<Map<String, String>> contacts = new ArrayList<>();
    private final String contactsPath = "./contacts/";

    public DossierContact() throws IOException {
        String contactsPath = "./contacts";
        File contactsFolder = new File(contactsPath);
        if (contactsFolder.exists() && contactsFolder.isDirectory()) {
            File[] files = contactsFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String contactNumber = bufferedReader.readLine();
                        String fileName = file.getName();
                        this.contacts.add(
                                Map.of(
                                        "nom", fileName.substring(0, fileName.lastIndexOf(".")),
                                        "numero", contactNumber
                                )
                        );
                    }
                }
            }
        } else {
            boolean isFolderCreated = contactsFolder.mkdir();
            if (isFolderCreated) {
                System.out.println("The contacts folder has been created.");
            } else {
                System.out.println("The contacts folder could not be created.");
            }
        }
    }

    public Map<String, String> getContact(String name) {
        return this.contacts.stream().filter(c -> c.get("nom").equals(name)).findFirst().orElse(null);
    }

    public void addContact(String name, String number) throws IOException {
        if (this.contacts.stream().anyMatch(c -> c.get("numero").equals(number))) {
            System.out.println("The contact number already exists.");
            return;
        }
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.createNewFile()) {
            FileWriter fileWriter = new FileWriter(contactFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(number);
            bufferedWriter.close();
            this.contacts.add(Map.of("nom", name, "numero", number));
        } else {
            System.out.println("The contact already exists.");
        }
    }

    public void deleteContact(String name) {
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.delete()) {
            this.contacts.removeIf(c -> c.get("nom").equals(name));
        } else {
            System.out.println("The contact does not exist.");
        }
    }

    public void updateContactNumber(String name, String newContactNumber) {
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.delete()) {
            try {
                addContact(name, newContactNumber);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        getContact(name);
    }
}
```

- The `DossierContact` class provides the following methods:
  - `DossierContact()`: Constructor that initializes the `contacts` list and the `contactsPath` variable. It reads the contacts from the contacts folder and adds them to the `contacts` list.
  - `getContact(String name)`: Returns the contact information for the specified contact name.
  - `addContact(String name, String number)`: Adds a new contact with the specified name and number to the contacts folder and the `contacts` list.
  - `deleteContact(String name)`: Deletes the contact with the specified name from the contacts folder and the `contacts` list.
  - `updateContactNumber(String name, String newContactNumber)`: Updates the contact number for the specified contact name.
  
## Class : Menu

This file defines the `Menu` class, which provides a simple text-based menu for interacting with the `DossierContact` class.

```java
package com.tp6.ex2;

import java.util.List;

public class Menu {
    public static void menu() {
        List<String> services = List.of("Find contact", "Add contact", "Delete contact", "Update contact", "Exit");
        services.forEach(service -> System.out.println(services.indexOf(service) + 1 + " - " + service));
        System.out.println("*".repeat(50));
    }
}
```

- The `Menu` class provides the following method:
  - `menu()`: Displays the menu options for interacting with the `DossierContact` class.
  - The menu options include:
    1. Find contact
    2. Add contact
    3. Delete contact
    4. Update contact
    5. Exit

## Class: Main

This file defines the `Main` class, which contains the main method to run the `Contact Management` system.

```java
package com.tp6.ex2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu.menu();
        DossierContact dossierContact = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the contact: ");
                    String name = scanner.next();
                    System.out.println(dossierContact.getContact(name));
                    break;
                case 2:
                    System.out.println("Enter the name of the contact: ");
                    String contactName = scanner.next();
                    System.out.println("Enter the number of the contact: ");
                    String contactNumber = scanner.next();
                    dossierContact.addContact(contactName, contactNumber);
                    break;
                case 3:
                    System.out.println("Enter the name of the contact: ");
                    String contactToDelete = scanner.next();
                    dossierContact.deleteContact(contactToDelete);
                    break;
                case 4:
                    System.out.println("Enter the name of the contact: ");
                    String contactToUpdate = scanner.next();
                    System.out.println("Enter the new number of the contact: ");
                    String newNumber = scanner.next();
                    dossierContact.updateContactNumber(contactToUpdate, newNumber);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            Menu.menu();
            choice = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
```

- The `Main` class provides the following functionality:
  - Displays the menu options using the `Menu` class.
  - Creates an instance of the `DossierContact` class to manage contacts.
  - Reads the user's choice from the console and performs the corresponding action based on the choice.
  - The user can find, add, delete, or update a contact, or exit the program.
  - The program continues to run until the user chooses to exit.
  - Displays a goodbye message when the user exits the program.
  - Closes the scanner after the program execution.
  