package com.tp6.ex3.metier.impl;

import com.tp6.ex3.models.Client;
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
    public List<Produit> getAll() throws IOException {
        produits.clear();
        File file = new File(produitsFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(";");
            Produit produit = new Produit(values[0], values[1], Double.parseDouble(values[2]), values[3], Integer.parseInt(values[4]));
            produits.add(produit);
        }
        bufferedReader.close();
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
            FileWriter fileWriter = new FileWriter(produitsFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Produit p : produits) {
                bufferedWriter.write(p.getNom() + ";" + p.getMarque() + ";" + p.getPrix() + ";" + p.getDescription() + ";" + p.getNombreEnStock());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
