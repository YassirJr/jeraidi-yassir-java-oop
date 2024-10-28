package org.example.ex3;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    private List<Ordinateur> ordinateurs = new ArrayList<>();

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        if (!ordinateurs.contains(ordinateur)) {
            ordinateurs.add(ordinateur);
        }
    }

    public void supprimerOrdinateur(Ordinateur ordinateur) {
        ordinateurs.remove(ordinateur);
    }

    public List<Ordinateur> rechercherParPrix(double prix) {
        return ordinateurs.stream()
                .filter(ordinateur -> ordinateur.getPrix() == prix)
                .toList();
    }

}

