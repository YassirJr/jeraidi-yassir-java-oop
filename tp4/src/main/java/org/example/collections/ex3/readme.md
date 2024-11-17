# Set Operations with Java Collections

This project demonstrates basic set operations (intersection and union) on two HashSet objects using Java collections.

### Class : Main

This file defines a class Main which manages two HashSet objects and performs intersection and union operations on them.

```java
package org.example.collections.ex3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();

        // Ajouter des éléments aux groupes A et B.
        groupeA.add("Ahmed");
        groupeA.add("Karim");
        groupeA.add("Adam");

        groupeB.add("Yassir");
        groupeB.add("Hakim");
        groupeB.add("Adam");

        // Intersection des deux groupes.
        HashSet<String> interSection = new HashSet<>(groupeA);
        interSection.retainAll(groupeB);
        System.out.println("Intersection:");
        interSection.forEach(System.out::println);

        System.out.println("#".repeat(20));

        // Union des deux groupes.
        HashSet<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Union:");
        union.forEach(System.out::println);
    }
}
```

### Initialization of HashSets:

```java
HashSet<String> groupeA = new HashSet<>();
HashSet<String> groupeB = new HashSet<>();
```

### Adding Elements to Sets:

```java
groupeA.add("Ahmed");
groupeA.add("Karim");
groupeA.add("Adam");

groupeB.add("Yassir");
groupeB.add("Hakim");
groupeB.add("Adam");
```

- Elements are added to each set using the add method.
- Group A contains: Ahmed, Karim, and Adam.
- Group B contains: Yassir, Hakim, and Adam.

### Intersection of Sets:

```java
HashSet<String> interSection = new HashSet<>(groupeA);
interSection.retainAll(groupeB);
System.out.println("Intersection:");
interSection.forEach(System.out::println);
```

- Purpose: To find common elements between Group A and Group B.
- Steps:
    - A new HashSet (interSection) is initialized with the elements of groupeA. 
    - The retainAll method keeps only elements that are present in both groupeA and groupeB. 
    - The resulting set contains only the common element: Adam.

### Union of Sets:

```java
HashSet<String> union = new HashSet<>(groupeA);
union.addAll(groupeB);
System.out.println("Union:");
union.forEach(System.out::println);
```

- Purpose: To combine all elements from Group A and Group B into one set.
- Steps:
  - A new HashSet (union) is initialized with the elements of groupeA.
  - The addAll method adds all elements from groupeB to union.
  - The resulting set contains all unique elements from both sets.