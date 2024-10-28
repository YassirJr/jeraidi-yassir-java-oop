package org.example.ex4;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        List<String> menuItems = List.of(
                "1 - Afficher la liste des produits.",
                "2 - Rechercher des produits par mot clé.",
                "3 - Ajouter un nouveau produit dans la liste.",
                "4 - Récupérer et afficher un produit par ID.",
                "5 - Supprimer un produit par id.",
                "6 - Quitter ce programme."
        );
        menuItems.forEach(System.out::println);
    }

    public static Produit addNewProduct(int id) {
        System.out.println("Veuillez saisir le nom de produit :");
        String nom = scanner.next();
        System.out.println("Veuillez saisir la marque de produit :");
        String marque = scanner.next();
        System.out.println("Veuillez saisir le prix de produit :");
        double prix = scanner.nextDouble();
        System.out.println("Veuillez saisir la description de produit :");
        scanner.nextLine();
        String description = scanner.nextLine();
        System.out.println("Veuillez saisir le nombre de stock de produit :");
        int stock = scanner.nextInt();
        return new Produit(id, nom, marque, prix, description, stock);
    }

    public static void main(String[] args) {
        MetierProduitImpl metierProduitImpl = new MetierProduitImpl();
        int choix;
        do {
            menu();
            System.out.println("Entrez votre choix :");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    List<Produit> produits = metierProduitImpl.getAll();
                    if (!produits.isEmpty()) {
                        produits.forEach(System.out::println);
                    } else {
                        System.out.println("Aucun produit maintent");
                    }
                    break;
                case 2:
                    System.out.println("Entrez le mot clé : ");
                    String mot = scanner.next();
                    List<Produit> produitsByName = metierProduitImpl.getAllByNom(mot);
                    if (!produitsByName.isEmpty()) {
                        produitsByName.forEach(System.out::println);
                    } else System.out.println("Aucun produit");
                    break;
                case 3:
                    int id = metierProduitImpl.getAll().stream().mapToInt(Produit::getId).sum() | 1;
                    metierProduitImpl.add(addNewProduct(id));
                    System.out.println("Le produit ajoute avec success");
                    break;
                case 4:
                    System.out.println("Entrez l'index de produit :");
                    int index = scanner.nextInt();
                    Produit produit = metierProduitImpl.getAll().get(index);
                    System.out.printf("nom : %s , prix : %f", produit.getNom(), produit.getPrix());
                    break;
                case 5:
                    System.out.println("Veuillez saisir l'id de produit :");
                    int idProduit = scanner.nextInt();
                    metierProduitImpl.delete(metierProduitImpl.getById(idProduit));
                    System.out.println("le produit supprimer avec success");
                    break;
                case 6:
                    System.out.println("fin de programme");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choix);
            }

        } while (choix != 6);
    }
}
