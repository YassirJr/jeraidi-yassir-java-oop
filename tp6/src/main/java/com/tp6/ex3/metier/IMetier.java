package com.tp6.ex3.metier;

import java.io.IOException;
import java.util.List;

public interface IMetier<T> {
    T add(T t);

    List<T> getAll() throws IOException;

    T findByNom(String nom);

    void delete(String nom);

    void saveAll();
}
