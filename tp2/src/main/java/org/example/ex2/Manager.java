package org.example.ex2;

public class Manager extends Employe{

    private String service;

    public Manager(String nom, String prenom, String email, String telephone, double salaire) {
        super(nom, prenom, email, telephone, salaire);
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        return getSalaire() + getSalaire() * 0.2;
    }
}
