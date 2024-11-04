package org.example.ex3;

public class Evaluateur {
    public void verifierNote(int note) throws NoteInvalideException {
        if(note < 0 || note > 20){
            throw new NoteInvalideException(note);
        }
        System.out.println("La note est de " + note);
    }

    public static void main(String[] args) {
        Evaluateur evaluateur = new Evaluateur();
        try {
            evaluateur.verifierNote(15);
            evaluateur.verifierNote(25);
        } catch (NoteInvalideException e) {
            System.out.println(e.getMessage());
        }
    }
}
