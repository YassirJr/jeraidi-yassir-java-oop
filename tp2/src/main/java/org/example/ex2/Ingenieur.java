package org.example.ex2;

public class Ingenieur extends Employe{

    private String specialite;

    public Ingenieur(String nom, String prenom, String email, String telephone, double salaire) {
        super(nom, prenom, email, telephone, salaire);
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
         return getSalaire() + getSalaire() * 0.15;
    }


}
