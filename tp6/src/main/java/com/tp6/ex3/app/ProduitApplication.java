package com.tp6.ex3.app;

import com.tp6.ex3.helpers.Menu;
import com.tp6.ex3.models.Produit;
import com.tp6.ex3.metier.IMetier;
import com.tp6.ex3.metier.impl.MetierProduitImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProduitApplication {
    public static void main(String[] args) throws IOException {
        Menu.menu("produit");
        IMetier<Produit> produitsMetier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice != 6) {
            switch (choice) {
                case 1:
                    List<Produit> produits = produitsMetier.getAll();
                    if (!produits.isEmpty()) produits
                            .forEach(produit ->
                                    System.out.println("Nom : " + produit.getNom() + " Marque : " + produit.getMarque() +
                                            " Prix : " + produit.getPrix() + " Description : " + produit.getDescription() +
                                            " Nombre en stock : " + produit.getNombreEnStock()));
                    break;
                case 2:
                    System.out.println("Enter the name of the product: ");
                    String name = scanner.next();
                    Produit produit = produitsMetier.findByNom(name);
                    if (produit != null) {
                        System.out.println("Nom : " + produit.getNom() + " Marque : " + produit.getMarque() + " Prix : " + produit.getPrix() + " Description : " + produit.getDescription() + " Nombre en stock : " + produit.getNombreEnStock());
                    } else System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.println("Enter the name of the product: ");
                    String nom = scanner.next();
                    System.out.println("Enter the marque of the product: ");
                    String marque = scanner.next();
                    System.out.println("Enter the price of the product: ");
                    double prix = scanner.nextDouble();
                    System.out.println("Enter the description of the product: ");
                    String description = scanner.next();
                    System.out.println("Enter the number of the product in stock: ");
                    int nombreEnStock = scanner.nextInt();
                    Produit p = new Produit(nom, marque, prix, description, nombreEnStock);
                    produitsMetier.add(p);
                    break;
                case 4:
                    System.out.println("Enter the name of the product: ");
                    String productToDelete = scanner.next();
                    produitsMetier.delete(productToDelete);
                    System.out.println("Product deleted.");
                    break;
                case 5:
                    produitsMetier.saveAll();
                    System.out.println("Products saved.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            Menu.menu("produit");
            choice = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
