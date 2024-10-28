package org.example.ex4;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit {
    private final List<Produit> produits = new ArrayList<>();

    @Override
    public Produit add(Produit p) {
        if (!produits.contains(p)) {
            produits.add(p);
        }
        return p;
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> getAllByNom(String nom) {
        return produits.stream().filter(produit -> produit.getNom().contains(nom))
                .toList();
    }

    @Override
    public Produit getById(int id) {
        return produits.stream().filter(produit -> produit.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(Produit p) {
        produits.remove(p);
    }
}
