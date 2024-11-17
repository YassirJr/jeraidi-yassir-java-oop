# Product Management with Java Collections

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations on a list of Produit objects using Java
collections .

### Class : Produit

This file defines a class Produit which represents a product with three attributes: id, nom (name), and prix (price).

```java
package org.example.collections.ex1;

public class Produit {
    private long id;
    private String nom;
    private double prix;

    public Produit(long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
```

- The constructor takes three parameters: id, nom, and prix, and initializes the corresponding attributes.
- Getters and setters are provided for each attribute to allow access and modification.

### Class : GestionProduitsApp

This file defines a class GestionProduitsApp which manages a list of Produit objects and performs various operations on
them.

```java
package org.example.collections.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        List<Produit> produits = new ArrayList<>();

        // Ajouter des produits.
        produits.add(new Produit(1, "prod1", 999.95));
        produits.add(new Produit(2, "prod2", 1229.50));
        produits.add(new Produit(3, "prod3", 1999.99));

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
        } else {
            System.out.println("Le produit n'existe pas");
        }
    }
}
```

- The main method initializes a list of Produit objects and performs the following operations:
    - Adds three products to the list.
    - Removes the first product by its index.
    - Displays the name of each remaining product.
    - Modifies the second product by replacing it with a new product.
    - Prompts the user to search for a product by name and displays its price if found, or a message if not found.