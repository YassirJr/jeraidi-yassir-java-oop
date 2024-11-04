# Square Root Calculator

This exercise demonstrates how to create a custom exception class in Java. The program simulates the calculation of the square root of a number and throws a custom exception if the number is negative.

### Class : NoteInvalideException

This file defines a custom exception class NoteInvalideException which extends the Exception class. This exception is
used to signal that a grade is invalid.

```java
package org.example.ex3;

public class NoteInvalideException extends Exception {
    public NoteInvalideException(int note) {
        super(
                "C'est une exception de type NoteInvalideException. Note invalide : " + note
        );
    }
}
```

- The constructor takes an integer note as a parameter, which represents the invalid grade.
- The constructor calls the superclass (Exception) constructor with a custom error message that includes the invalid
  grade.

### Class : Calculateur

This file defines a class Evaluateur which contains a method to verify the validity of a grade and throws a
NoteInvalideException if the grade is outside the valid range.

```java
package org.example.ex3;

public class Evaluateur {
    public void verifierNote(int note) throws NoteInvalideException {
        if (note < 0 || note > 20) {
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
```

- The verifierNote method takes an integer note as a parameter and checks if it is between 0 and 20.
- If the grade is outside this range, it throws a NoteInvalideException with the grade as the argument.
- If the grade is within the valid range, it prints the grade.
- The main method creates an instance of Evaluateur and tests two grades: 15 and 25.
- If a NoteInvalideException is thrown, it catches the exception and prints the error message.