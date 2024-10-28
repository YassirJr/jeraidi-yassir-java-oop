package org.example.ex1;

public class Adherent extends Personne{

    private static int numAdherent;

    public Adherent(String nom, String prenom, String email, String telephone, int age) {
        super(nom, prenom, email, telephone, age);
        numAdherent++;
    }

    public int getNumAdherent() {
        return numAdherent;
    }


    @Override
    public String afficher() {
        return super.afficher() + String.format(" , Adherent : %d", getNumAdherent());
    }
}
