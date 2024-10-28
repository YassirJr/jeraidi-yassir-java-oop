package org.example.ex1;

public class Livre {

    private int ISBN;
    private String titre;
    private Personne auteur;

    public Livre(int ISBN, String titre, Personne auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String afficher() {
        return String.format("ISBN: %d, titre: %s , nom autheur : %s , prenom autheur : %s , email autheur : %s",
                getISBN(), getTitre(), auteur.getNom(), auteur.getPrenom(), auteur.getEmail());
    }
}
