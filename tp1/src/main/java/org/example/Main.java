package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Exercice 1");
        org.example.ex1.Main.main(args , scanner);
        System.out.println("Exercice 2");
        org.example.ex2.Main.main(args , scanner);
        System.out.println("Exercice 3");
        org.example.ex3.Main.main(args , scanner);
        System.out.println("Exercice 4");
        org.example.ex4.Main.main(args , scanner);
        scanner.close();
    }
}