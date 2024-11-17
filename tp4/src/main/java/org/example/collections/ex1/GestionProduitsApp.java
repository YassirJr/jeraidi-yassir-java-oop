package org.example.collections.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        List<Produit> produits = new ArrayList<>();

        // Ajouter des produits.
        produits.add(
                new Produit(1, "prod1", 999.95)
        );

        produits.add(
                new Produit(2, "prod2", 1229.50)
        );

        produits.add(
                new Produit(3, "prod3", 1999.99)
        );

        // Supprimer un produit par indice.
        produits.remove(0);

        // Afficher la liste des produits.
        produits.forEach(produit -> System.out.println("\n nom de produit : " + produit.getNom()));

        // Modifier un produit par indice.
        produits.set(1, new Produit(4, "prod4", 4445.00));

        // Rechercher un produit dont le nom est tapé par l’utilisateur.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom recherché : ");
        String nom = scanner.next();
        Optional<Produit> produit = produits.stream().filter(prod -> prod.getNom().equals(nom)).findFirst();
        if (produit.isPresent()) {
            System.out.println("Le prix de produit : " + produit.get().getPrix());
        } else System.out.println("Le produit n'existe pas");

    }
}
