package com.javafx.javafx.metier;

import com.javafx.javafx.models.Departement;
import com.javafx.javafx.models.Professeur;

import java.util.List;

public interface IMetier {
    // Professeur operations
    List<Professeur> getAllProfesseurs();
    List<Professeur> searchProfesseurs(String keyword);
    void addProfesseur(Professeur professeur);
    void deleteProfesseur(int idProf);
    void updateProfesseur(Professeur professeur);

    // Departement operations
    void addDepartement(Departement departement);
    List<Departement> getAllDepartements();
    void deleteDepartement(int idDepart);
    void updateDepartement(Departement departement);
    List<Professeur> getProfesseursByDepartement(int idDepart);
}