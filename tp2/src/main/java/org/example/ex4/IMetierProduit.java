package org.example.ex4;

import java.util.List;

public interface IMetierProduit {
    public Produit add(Produit p);
    public List<Produit> getAll();
    public List<Produit> getAllByNom(String nom);
    public Produit getById(int id);
    public void delete(Produit p);
}
