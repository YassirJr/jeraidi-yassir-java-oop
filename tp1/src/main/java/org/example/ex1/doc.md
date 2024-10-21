# Notes Management System

This project is a simple Notes Management System written in Java. It consists of two main classes: `Main` and `Notes`.

## Features

- **Sort Notes**: The system allows for the sorting of student notes.
- **Calculate Average**: It calculates the average of all notes entered.
- **Find Minimum Note**: It finds the minimum note from the list.
- **Find Maximum Note**: It finds the maximum note from the list.
- **Count Occurrences of a Note**: It counts how many times a specific note appears in the list.

## Classes

### Main

The `Main` class is responsible for interacting with the user. It takes input from the user for the number of students and their respective notes. It then creates an instance of the `Notes` class and uses its functionalities to display the sorted notes, average, minimum, and maximum notes, and the number of occurrences of a specific note.

```java
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
```

### Notes

The `Notes` class handles the core functionalities such as sorting the notes, calculating the average, finding the minimum and maximum notes, and counting the occurrences of a specific note.

```java
package org.example.ex1;

import java.util.Arrays;

public class Notes {
    private float[] notes;

    public Notes(float[] notes) {
        this.notes = notes;
    }

    public void sortAndShow() {
        Arrays.sort(notes);
        System.out.println("Le tri des notes : " + Arrays.toString(notes));
    }

    public float getAverage() {
        float sum = 0;
        for (float num : notes) {
            sum += num;
        }
        return sum / notes.length;
    }

    public float getMin() {
        float min = notes[0];
        for (float num : notes) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public float getMax() {
        float max = notes[0];
        for (float num : notes) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int getRepeatedNote(int note) {
        int count = 0;
        for (float num : notes) {
            if (num == (float) note) {
                count++;
            }
        }
        return count;
    }
}
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- IDE such as IntelliJ IDEA.

### Running the Program

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the `Main` class.
4. Follow the prompts to enter the number of students and their respective notes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.