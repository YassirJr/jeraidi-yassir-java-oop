package com.tp6.ex3.helpers;

import java.util.List;

public class Menu {
    public static void menu(String app) {
        List<String> services = List.of(
                "Afficher la liste des " + app + "s",
                "Rechercher un " + app + " par son nom",
                "Ajouter un nouveau " + app + " dans la liste",
                "Supprimer un " + app + " par nom",
                "Sauvegarder les " + app + "s",
                "Quitter ce programme");

        services.forEach(s -> {
            System.out.println(services.indexOf(s) + 1 + ". " + s);
        });
        System.out.println("*".repeat(10));
    }
}
