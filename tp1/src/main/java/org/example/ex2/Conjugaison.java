package org.example.ex2;

public class Conjugaison {
    private final String verb;

    public Conjugaison(String verb){
        this.verb = verb.trim().toLowerCase();
    }

    public void conjuge() {
        if (verb.endsWith("er") && verb.length() > 2) {
            String verbWithoutER = verb.substring(0, verb.length() - 2);
            System.out.println("je " + verbWithoutER + "e");
            System.out.println("tu " + verbWithoutER + "es");
            System.out.println("il " + verbWithoutER + "e");
            System.out.println("nous " + verbWithoutER + "ons");
            System.out.println("vous " + verbWithoutER + "ez");
            System.out.println("ils " + verbWithoutER + "ent");
        } else {
            System.out.println("Le verbe ne pas valide.");
        }

    }

}
