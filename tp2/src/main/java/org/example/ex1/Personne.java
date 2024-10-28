package org.example.ex1;

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private int age;

    public Personne(String nom, String prenom, String email, String telephone, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String afficher() {
        return String.format(
                "nom : %s , prenom : %s , email : %s , age : %d , telephone : %s",
                getNom(), getPrenom(), getEmail(), getAge(), getTelephone());
    }
}

