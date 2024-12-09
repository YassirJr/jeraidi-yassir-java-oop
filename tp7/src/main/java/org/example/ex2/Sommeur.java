package org.example.ex2;

import java.util.ArrayList;
import java.util.List;

public class Sommeur  implements Runnable{

    private List<Integer> integers = new ArrayList<>();
    private int debut = 0;
    private int fin = 0;
    private int somme = 0;

    public Sommeur(List<Integer> integers , int debut , int fin) {
        this.integers = integers;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        somme = 0;
        for (int i = debut; i < fin; i++) {
            somme += integers.get(i);
        }
    }

    public int getSomme() {
        return somme;
    }
}
