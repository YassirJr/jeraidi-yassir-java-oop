package com.tp6.ex3.metier.impl;

import com.tp6.ex3.models.Produit;
import com.tp6.ex3.metier.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private final List<Produit> produits = new ArrayList<>();
    private final String produitsFile = "./ex3_data/produits.dat";

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        produits.clear();
        try (FileInputStream file = new FileInputStream(produitsFile);
             ObjectInputStream in = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Produit produit = (Produit) in.readObject();
                    produits.add(produit);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream().filter(p -> p.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try {
            for (Produit p : produits) {
                FileOutputStream file = new FileOutputStream(produitsFile);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(p);
                out.close();
                file.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
