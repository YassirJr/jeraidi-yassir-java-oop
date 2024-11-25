package com.javafx.javafx.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String email;
    private String telephone;
    private Date dateRecrutement;
    private int departementId;
}