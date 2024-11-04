package org.example.ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args , Scanner scanner) {
        System.out.println("Entrez le text :");
        OccurrencesLettres occurrencesLettres = new OccurrencesLettres(scanner.nextLine());
        occurrencesLettres.calc();
    }
}
