# Student Grades Management with Java Collections

This project demonstrates basic operations on a HashMap of student names and their grades using Java collections.

### Class : Main

This file defines a class Main which manages a HashMap of student names and their grades, and performs various
operations on them.

```java
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
        if (studentsNotes.containsValue(20.00)) {
            System.out.println("il y a une note égale à 20.");
        }
        studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
```

### HashMap Initialization:

```java
HashMap<String, Double> studentsNotes = new HashMap<>();
```

- A HashMap is created to store student names (String) as keys and their grades (Double) as values.

### Adding Student Grades:

```java
studentsNotes.put("Ahmed", 10.00);
studentsNotes.put("Otmane", 6.50);
studentsNotes.put("Hakim", 1.75);
studentsNotes.put("Yassir", 17.77);
studentsNotes.put("Akram", 13.25);
```

- Grades are added using the put method.
- If a key already exists, the value is updated with the new one.

### Display Grades:

```java
studentsNotes.forEach((key, value) -> System.out.println(key + " : " + value));
```

- The forEach method is used to iterate over the entries of the HashMap and print each student's name and grade.

### Updating a Grade:

```java
Double prevValue = studentsNotes.replace("Ahmed", 20.00);
```

- The replace method updates the grade of the specified student (Ahmed) to 20.00 and returns the previous value.

### Removing a Grade:

```java
studentsNotes.remove("Ahmed");
```

- The remove method deletes the entry of the specified student (Ahmed) from the HashMap.

### Displaying the Size of the HashMap:

```java
System.out.println(studentsNotes.size());
```

- The size method returns the number of entries in the HashMap.

### Calculating Min, Max, and Average Grades:

```java
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
```

- A loop iterates over the values (grades) in the HashMap to compute:
  - Minimum grade (min): The smallest value.
  - Maximum grade (max): The largest value.
  - Average grade (avg): The sum of all grades divided by the total count.

### Checking for a Specific Grade:

```java
if (studentsNotes.containsValue(20.00)) {
    System.out.println("il y a une note égale à 20.");
}
```

- The containsValue method checks if a grade of 20.00 exists in the HashMap.
