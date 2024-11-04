package org.example.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args  , Scanner scanner) {
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
    }
}


