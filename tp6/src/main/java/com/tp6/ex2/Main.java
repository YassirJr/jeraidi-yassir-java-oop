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

