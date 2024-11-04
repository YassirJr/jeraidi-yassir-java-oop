package org.example.ex1;

public class Vehicule {

    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
        System.out.println("La vitesse est de " + vitesse + " km/h");
    }

    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();
        try {
            vehicule.testVitesse(80);
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            System.out.println(e.getMessage());
        }
    }
}
