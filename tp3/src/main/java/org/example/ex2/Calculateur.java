package org.example.ex2;

public class Calculateur {
    public void testRacineCarree(int number) throws RacineCarreeException {
        if(number < 0){
            throw new RacineCarreeException(number);
        }
        System.out.println("La racine carrée de " + number + " est " + Math.sqrt(number));
    }

    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();
        try {
            calculateur.testRacineCarree(25);
            calculateur.testRacineCarree(-1);
        } catch (RacineCarreeException e) {
            System.out.println(e.getMessage());
        }
    }
}
