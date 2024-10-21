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
