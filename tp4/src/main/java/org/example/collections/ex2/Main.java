package org.example.collections.ex2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> studentsNotes = new HashMap<>();

        // Insérer des notes des étudiants.
        studentsNotes.put("Ahmed", 10.00);
        studentsNotes.put("Otmane", 6.50);
        studentsNotes.put("Hakim", 1.75);
        studentsNotes.put("Yassir", 17.77);
        studentsNotes.put("Akram", 13.25);
        System.out.println("#".repeat(20));
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));

        // Augmenter la note d’un étudiant.
        Double prevValue = studentsNotes.replace("Ahmed", 20.00);
        // studentsNotes.put("Ahmed" , 19.00);
        System.out.println("#".repeat(20));
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));

        // Supprimer la note d’un étudiant.
        studentsNotes.remove("Ahmed");
        System.out.println("#".repeat(20));
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));

        // Afficher la taille du map.
        System.out.println(studentsNotes.size());
        System.out.println("#".repeat(20));
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        for (double note : studentsNotes.values()) {
            if (note < min) {
                min = note;
            }
            if (note > max) {
                max = note;
            }
            sum += note;
        }
        double avg = sum / studentsNotes.size();

        // Afficher la note moyenne, max et min.
        System.out.println("#".repeat(20));
        System.out.println("Min : " + min);
        System.out.println("Max : " + max);
        System.out.println("Moyenne : " + avg);
        System.out.println("#".repeat(20));
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));


        // Vérifier s’il y a une note égale à 20.
        System.out.println("#".repeat(20));
        if (studentsNotes.containsValue(20.00)){
            System.out.println("il y a une note égale à 20.");
        }
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
