# Exercise 1 : Talkative

The Talkative class is a simple Java program that demonstrates the use of threads. Each instance of the Talkative class
prints a specified number to the console 100 times. The program creates and starts 10 threads, each printing a different
number.

### Class Talkative

The Talkative class implements the Runnable interface, which allows instances of the class to be executed by a thread.
The class has a single field, `number`, which stores the number that the instance will print. The class has a single
constructor that initializes the `number` field. The class also has a single method, `run`, which prints the number to
the console 100 times.

```java
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
```

The main method creates 10 instances of the Talkative class, each with a different number. Each instance is wrapped in a
Thread object, and all threads are started.

### Running the Program

When the program is executed, each thread will print its assigned number 100 times. Due to the static nature of the
nombre field, all threads will print the same number, which will be the last number assigned (19). This is a key point
to note and may not be the intended behavior. To fix this, the nombre field should not be static.