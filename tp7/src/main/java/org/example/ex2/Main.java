package org.example.ex2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Sommeur sommeur1 = new Sommeur(integers, 0, 5);
        Sommeur sommeur2 = new Sommeur(integers, 5, 10);
        Sommeur sommeur3 = new Sommeur(integers, 0, 10);

        Thread t1 = new Thread(sommeur1);
        Thread t2 = new Thread(sommeur2);
        Thread t3 = new Thread(sommeur3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("La somme totale est : " + (sommeur1.getSomme() + sommeur2.getSomme() + sommeur3.getSomme()));
    }
}
