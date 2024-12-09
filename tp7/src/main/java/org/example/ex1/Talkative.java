package org.example.ex1;

public class Talkative implements Runnable {
    private static int nombre;

    public Talkative(int nbr) {
        nombre = nbr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {
        // 10 instances
        Thread t1 = new Thread(new Talkative(10));
        Thread t2 = new Thread(new Talkative(11));
        Thread t3 = new Thread(new Talkative(12));
        Thread t4 = new Thread(new Talkative(13));
        Thread t5 = new Thread(new Talkative(14));
        Thread t6 = new Thread(new Talkative(15));
        Thread t7 = new Thread(new Talkative(16));
        Thread t8 = new Thread(new Talkative(17));
        Thread t9 = new Thread(new Talkative(18));
        Thread t10 = new Thread(new Talkative(19));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
