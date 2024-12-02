package com.tp6.ex3.metier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetier<T> {
    public T add(T t); // qui permet d’ajouter un objet à la liste.
    public List<T> getAll() throws IOException; // qui charge la liste des objets à partir d’un fichier et les retournent sous forme d’une liste.
    public T findByNom(String nom);
    public void delete(String nom);
    public void saveAll(); // qui permet de sauvegarder tous les objets dans le fichier.
}
