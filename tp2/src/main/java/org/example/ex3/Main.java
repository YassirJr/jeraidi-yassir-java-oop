package org.example.ex3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ordinateur> ordinateurs = getOrdinateurs();

        Client client = new Client("yacer", "jr", "y@g.c", "casa", "casa/maroc", "0600000000");

        Commande commande = new Commande("C1", client, LocalDateTime.now(), CommandeEtat.OK);

        List<LigneCommande> ligneCommandes = List.of(
                new LigneCommande(2, commande, ordinateurs.get(0)),
                new LigneCommande(5, commande, ordinateurs.get(1)),
                new LigneCommande(10, commande, ordinateurs.get(2))
        );

        ligneCommandes.forEach(ligneCommande -> {
            System.out.println("#".repeat(20));
            System.out.println("Client :" + ligneCommande.getCommande().getClient().getNom());
            System.out.println("Ordinateur :" + ligneCommande.getOrdinateur().getNom());
            System.out.println("Quantite :" + ligneCommande.getQuantite());
        });
    }

    private static List<Ordinateur> getOrdinateurs() {
        Categorie etudeCategorie = new Categorie("etude", "etude categorie");
        Categorie gamingCategorie = new Categorie("gaming", "gaming categorie");
        Categorie editingCategorie = new Categorie("editing", "editing categorie");

        return List.of(
                new Ordinateur("pc 1", "dell", 10000.00, "bon pc", 20, etudeCategorie),
                new Ordinateur("pc 2", "msi", 15000.00, "bon pc", 10, gamingCategorie),
                new Ordinateur("mac 2024", "apple", 30000.00, "bon pc", 5, editingCategorie)
        );
    }
}
