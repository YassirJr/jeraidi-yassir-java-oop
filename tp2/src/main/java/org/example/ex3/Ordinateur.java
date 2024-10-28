package org.example.ex3;

public class Ordinateur {

    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int stock;
    private Categorie categorie;

    public Ordinateur(String nom, String marque, double prix, String description, int stock , Categorie categorie) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int prixForQuantity(int quantity) {
        return (int) (prix * quantity);
    }
}
