# Vehicle Speed Test

This exercise demonstrates how to create a custom exception class in Java. The program simulates a vehicle speed test and throws a custom exception if the speed exceeds a certain limit.

### Class : TropViteException

This file defines a custom exception class TropViteException which extends the Exception class. This exception is used to signal that a vehicle is going too fast.

```java
package org.example.ex1;

public class TropViteException extends Exception {
    public TropViteException(int number) {
        super(
                "C'est une exception de type TropViteException. Vitesse en cause : " + number
        );
    }
}
```

- The constructor takes an integer number as a parameter, which represents the speed that caused the exception.
- The constructor calls the superclass (Exception) constructor with a custom error message that includes the speed.




### Class : Vehicule

This file defines a class Vehicule which contains a method to test the speed of the vehicle and throws a TropViteException if the speed exceeds a certain limit.

```java
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
```

- The testVitesse method takes an integer vitesse as a parameter and checks if it exceeds 90.
- If the speed is greater than 90, it throws a TropViteException with the speed as the argument.
- If the speed is within the limit, it prints the speed.
- The main method creates an instance of Vehicule and tests two speeds: 80 and 100.
- If a TropViteException is thrown, it catches the exception and prints the error message.