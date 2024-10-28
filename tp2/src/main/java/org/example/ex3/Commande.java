package org.example.ex3;

import java.time.LocalDateTime;

public class Commande {
    private String reference;
    private Client client;
    private LocalDateTime dateCommande;
    private CommandeEtat etat;

    public Commande(String reference, Client client, LocalDateTime dateCommande, CommandeEtat etat) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etat = etat;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public CommandeEtat getEtat() {
        return etat;
    }

    public void setEtat(CommandeEtat etat) {
        this.etat = etat;
    }


}
