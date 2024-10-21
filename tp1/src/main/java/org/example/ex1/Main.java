package org.example.ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien d'etudiants ? : ");
        float[] notesFromInput = new float[scanner.nextInt()];
        for (int i = 0; i < notesFromInput.length; i++) {
            System.out.printf("Note %d : ", (i + 1));
            notesFromInput[i] = scanner.nextFloat();
        }
        Notes notes = new Notes(notesFromInput);
        notes.sortAndShow();
        System.out.println("Moyenne : " + notes.getAverage());
        System.out.println("Min : " + notes.getMin());
        System.out.println("Max : " + notes.getMax());
        System.out.println("Entrez une note : ");
        int note = scanner.nextInt();
        System.out.println("Nombre d'etudiants ayant la note " + note + " : " + notes.getRepeatedNote(note));
        scanner.close();
    }
}
