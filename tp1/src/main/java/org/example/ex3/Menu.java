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
