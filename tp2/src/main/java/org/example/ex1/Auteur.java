package org.example.ex1;

public class Auteur extends Personne {

    private int numAuteur;

    public Auteur(String nom, String prenom, String email, String telephone, int age) {
        super(nom, prenom, email, telephone, age);
    }

    public int getNumAuteur() {
        return numAuteur;
    }

    public void setNumAuteur(int numAuteur) {
        this.numAuteur = numAuteur;
    }

    @Override
    public String afficher() {
        return String.format("Auteur %d", getNumAuteur());
    }
}
