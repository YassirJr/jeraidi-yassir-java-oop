package com.tp6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Exercice 1:");
        com.tp6.ex1.Main.main(args);
        System.out.println("Exercice 2:");
        com.tp6.ex2.Main.main(args);
        System.out.println("Exercice 3:");
        System.out.println("Products Management :");
        com.tp6.ex3.app.ProduitApplication.main(args);
        System.out.println("Clients Management :");
        com.tp6.ex3.app.ClientApplication.main(args);
    }
}