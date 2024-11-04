package org.example.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args , Scanner scanner) {
        System.out.println("Entrer un verbe : ");
        String verb = scanner.next();
        Conjugaison conjugaison = new Conjugaison(verb);
        conjugaison.conjuge();
    }
}
