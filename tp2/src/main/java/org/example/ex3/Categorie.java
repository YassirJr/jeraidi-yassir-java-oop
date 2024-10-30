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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setOrdinateurs(List<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }
}

