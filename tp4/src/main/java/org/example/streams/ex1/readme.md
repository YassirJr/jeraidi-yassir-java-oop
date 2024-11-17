# Stream Operations with Java Collections

This project demonstrates various stream operations on a list of names using Java streams.

### Class : Main

This file defines a class Main which manages a list of names and performs various stream operations on them.

```java
package org.example.streams.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> noms = new ArrayList<>();
        noms.add("Akram");
        noms.add("Adam");
        noms.add("Amine");
        noms.add("Hakim");
        noms.add("Yassir");

        // Filter names containing 'a'.
        List<String> nomsContientA = noms.stream().filter(nom -> nom.contains("a")).toList();
        System.out.println("#".repeat(20));
        nomsContientA.forEach(System.out::println);

        // Filter names longer than 3 characters and reverse them.
        List<String> motLong3WithInverse = noms.stream()
                .filter(nom -> nom.length() > 3)
                .map(nom -> new StringBuilder(nom).reverse().toString())
                .toList();
        System.out.println("#".repeat(20));
        motLong3WithInverse.forEach(System.out::println);

        // Filter names containing 'e' and split them into sublists.
        List<String[]> motWithEWithSubList = noms.stream()
                .filter(nom -> nom.contains("e"))
                .map(nom -> nom.split(""))
                .toList();
        System.out.println("#".repeat(20));
        motWithEWithSubList.forEach(nom -> Arrays.stream(nom).toList().forEach(System.out::println));

        // Convert names to uppercase.
        List<String> nomsAsMajuscules = noms.stream().map(String::toUpperCase).toList();
        System.out.println("#".repeat(20));
        nomsAsMajuscules.forEach(System.out::println);

        // Create a map of names and their lengths.
        Map<String, Integer> nomWithLongueur = noms.stream()
                .collect(Collectors.toMap(nom -> nom, String::length));
        System.out.println("#".repeat(20));
        nomWithLongueur.forEach((k, v) -> System.out.println(k + " : " + v));

        // Flatten the list of names into a list of characters.
        List<Character> listChars = noms.stream()
                .flatMap(nom -> nom.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("#".repeat(20));
        listChars.forEach(System.out::println);

        // Append index to each name.
        List<String> nomWithIndex = IntStream.range(0, noms.size())  // Generate indices
                .mapToObj(i -> noms.get(i) + "-" + i)  // Map element and index
                .toList();
        System.out.println("#".repeat(20));
        nomWithIndex.forEach(System.out::println);
    }
}
```

### Initialization of List:

```java
List<String> noms = new ArrayList<>();
noms.add("Akram");
noms.add("Adam");
noms.add("Amine");
noms.add("Hakim");
noms.add("Yassir");
```

### Filter Names Containing 'a':

```java
List<String> nomsContientA = noms.stream().filter(nom -> nom.contains("a")).toList();
System.out.println("#".repeat(20));
nomsContientA.forEach(System.out::println);
```

- Purpose: To filter names containing the letter 'a'.
- Steps:
    - The stream is filtered to keep only names containing the letter 'a'.
    - The resulting list contains: Akram, Adam, and Hakim.
    - The forEach method prints each name.
    - The repeat method repeats the '#' character 20 times.

    
### Filter Names Longer Than 3 Characters and Reverse Them:

```java
List<String> motLong3WithInverse = noms.stream()
        .filter(nom -> nom.length() > 3)
        .map(nom -> new StringBuilder(nom).reverse().toString())
        .toList();
System.out.println("#".repeat(20));
motLong3WithInverse.forEach(System.out::println);
```

- Purpose: To filter names longer than 3 characters and reverse them.
- Steps:
    - The stream is filtered to keep only names longer than 3 characters.
    - The map method reverses each name.
    - The resulting list contains: markA, madA, and mikah.
    - The forEach method prints each name.
    - The repeat method repeats the '#' character 20 times.

  
### Filter Names Containing 'e' and Split Them into Sublists:

```java
List<String[]> motWithEWithSubList = noms.stream()
        .filter(nom -> nom.contains("e"))
        .map(nom -> nom.split(""))
        .toList();
System.out.println("#".repeat(20));
motWithEWithSubList.forEach(nom -> Arrays.stream(nom).toList().forEach(System.out::println));
```

- Purpose: To filter names containing the letter 'e' and split them into sublists.
- Steps:
    - The stream is filtered to keep only names containing the letter 'e'.
    - The map method splits each name into an array of characters.
    - The resulting list contains: [A, m, i, n, e] and [H, a, k, i, m].
    - The forEach method prints each character.
    - The repeat method repeats the '#' character 20 times.
  
### Convert Names to Uppercase:

```java
List<String> nomsAsMajuscules = noms.stream().map(String::toUpperCase).toList();
System.out.println("#".repeat(20));
nomsAsMajuscules.forEach(System.out::println);
```

- Purpose: To convert names to uppercase.
- Steps:
    - The map method converts each name to uppercase.
    - The resulting list contains: AKRAM, ADAM, AMINE, HAKIM, and YASSIR.
    - The forEach method prints each name.
    - The repeat method repeats the '#' character 20 times.
  

### Create a Map of Names and Their Lengths:

```java
Map<String, Integer> nomWithLongueur = noms.stream()
        .collect(Collectors.toMap(nom -> nom, String::length));
System.out.println("#".repeat(20));
nomWithLongueur.forEach((k, v) -> System.out.println(k + " : " + v));
```

- Purpose: To create a map of names and their lengths.
- Steps:
    - The collect method creates a map with names as keys and their lengths as values.
    - The resulting map contains: Akram: 5, Adam: 4, Amine: 5, Hakim: 5, and Yassir: 6.
    - The forEach method prints each name and its length.
    - The repeat method repeats the '#' character 20 times.
  

### Flatten the List of Names into a List of Characters:

```java
List<Character> listChars = noms.stream()
        .flatMap(nom -> nom.chars().mapToObj(c -> (char) c))
        .toList();
System.out.println("#".repeat(20));
listChars.forEach(System.out::println);
```

- Purpose: To flatten the list of names into a list of characters.
- Steps:
    - The flatMap method converts each name into a stream of characters.
    - The resulting list contains: A, k, r, a, m, A, d, a, m, A, m, i, n, e, H, a, k, i, m, Y, a, s, s, i, r.
    - The forEach method prints each character.
    - The repeat method repeats the '#' character 20 times.
  

### Append Index to Each Name:

```java
List<String> nomWithIndex = IntStream.range(0, noms.size())  // Generate indices
        .mapToObj(i -> noms.get(i) + "-" + i)  // Map element and index
        .toList();
System.out.println("#".repeat(20));
nomWithIndex.forEach(System.out::println);
```

- Purpose: To append the index to each name.
- Steps:
    - The range method generates indices from 0 to the size of the list.
    - The mapToObj method appends the index to each name.
    - The resulting list contains: Akram-0, Adam-1, Amine-2, Hakim-3, and Yassir-4.
    - The forEach method prints each name with its index.
    - The repeat method repeats the '#' character 20 times.
