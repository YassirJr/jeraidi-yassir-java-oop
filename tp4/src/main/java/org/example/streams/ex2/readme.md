# Stream Operations 

This project demonstrates various stream operations on a list of Employe objects using Java streams.

### Class : Employee

```java
package org.example.streams.ex2;

public class Employe {
    private String nom;
    private String departement;
    private double salaire;

    public Employe(String nom, String departement, double salaire) {
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
```

- The constructor takes three parameters: nom, departement, and salaire, and initializes the corresponding attributes.
- Getters and setters are provided for each attribute to allow access and modification.


### Class : Main

This file defines a class Main which performs several stream operations on a list of Employe objects.

```java
package org.example.streams.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employe> employes = new ArrayList<>(List.of(
                new Employe("Yassir", "info", 10000),
                new Employe("Hakim", "info", 8000)
        ));

        // Calculate the sum of salaries.
        double sum = employes.stream().mapToDouble(Employe::getSalaire).sum();
        System.out.println("La somme des salaires = " + sum);

        // Sort employees by name.
        ArrayList<Employe> sortedEmployes = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .collect(Collectors.toCollection(ArrayList::new));
        sortedEmployes.forEach(employe -> System.out.println(employe.getNom()));

        // Find the employee with the minimum salary.
        Employe employeWithMinSalaire = employes.stream().min(Comparator.comparing(Employe::getSalaire)).get();
        System.out.println("nom de l'employe : " + employeWithMinSalaire.getNom());

        // Filter employees with salary greater than the entered value.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le salaire : ");
        double salaireInput = scanner.nextDouble();
        List<Employe> listEmployesWithEnteredSalaire = employes.stream().filter(employe -> employe.getSalaire() > salaireInput).toList();
        listEmployesWithEnteredSalaire.forEach(employe -> System.out.println(employe.getNom()));

        // Find the employee with the maximum salary.
        Employe employeHasMaxSalaire = employes.stream()
                .reduce((employe1, employe2) -> employe1.getSalaire() > employe2.getSalaire() ? employe1 : employe2)
                .get();
        System.out.println(employeHasMaxSalaire.getNom());

        // Concatenate the names of all employees.
        String nomsEmployes = employes.stream()
                .map(Employe::getNom)
                .reduce("", ((employe1, employe2) -> employe1 + " " + employe2));
        System.out.println(nomsEmployes);
    }
}
```

### Initialization of the list of employees

```java
ArrayList<Employe> employes = new ArrayList<>(List.of(
        new Employe("Yassir", "info", 10000),
        new Employe("Hakim", "info", 8000)
));
```

- The list of employees is initialized with two Employe objects.
- The first employee has the name "Yassir", belongs to the department "info", and has a salary of 10000.
- The second employee has the name "Hakim", belongs to the department "info", and has a salary of 8000.

### Calculate the sum of salaries

```java
double sum = employes.stream().mapToDouble(Employe::getSalaire).sum();
System.out.println("La somme des salaires = " + sum);
```

- Purpose: To calculate the sum of salaries of all employees.
- Steps:
    - The salaries of all employees are extracted using the mapToDouble method.
    - The sum of salaries is calculated using the sum method.
  
### Sort employees by name

```java
ArrayList<Employe> sortedEmployes = employes.stream()
        .sorted(Comparator.comparing(Employe::getNom))
        .collect(Collectors.toCollection(ArrayList::new));
sortedEmployes.forEach(employe -> System.out.println(employe.getNom()));
```

- Purpose: To sort employees by name.
- Steps:
    - The employees are sorted based on their names using the sorted method.
    - The sorted employees are collected into a new ArrayList using the collect method.
    - The names of the sorted employees are printed using the forEach method.

### Find the employee with the minimum salary

```java
Employe employeWithMinSalaire = employes.stream().min(Comparator.comparing(Employe::getSalaire)).get();
System.out.println("nom de l'employe : " + employeWithMinSalaire.getNom());
```

- Purpose: To find the employee with the minimum salary.
- Steps:
    - The employee with the minimum salary is found using the min method.
    - The name of the employee with the minimum salary is printed.
    - In this case, the employee with the minimum salary is "Hakim".

### Filter employees with salary greater than the entered value

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Entrez le salaire : ");
double salaireInput = scanner.nextDouble();
List<Employe> listEmployesWithEnteredSalaire = employes.stream().filter(employe -> employe.getSalaire() > salaireInput).toList();
listEmployesWithEnteredSalaire.forEach(employe -> System.out.println(employe.getNom()));
```

- Purpose: To filter employees with a salary greater than the entered value.
- Steps:
    - The user is prompted to enter a salary value.
    - Employees with a salary greater than the entered value are filtered using the filter method.
    - The names of the filtered employees are printed.
  
### Find the employee with the maximum salary

```java
Employe employeHasMaxSalaire = employes.stream()
        .reduce((employe1, employe2) -> employe1.getSalaire() > employe2.getSalaire() ? employe1 : employe2)
        .get();
System.out.println(employeHasMaxSalaire.getNom());
```

- Purpose: To find the employee with the maximum salary.
- Steps:
    - The employee with the maximum salary is found using the reduce method.
    - The name of the employee with the maximum salary is printed.
    - In this case, the employee with the maximum salary is "Yassir".
  
### Concatenate the names of all employees

```java
String nomsEmployes = employes.stream()
        .map(Employe::getNom)
        .reduce("", ((employe1, employe2) -> employe1 + " " + employe2));
System.out.println(nomsEmployes);
```

- Purpose: To concatenate the names of all employees.
- Steps:
    - The names of all employees are extracted using the map method.
    - The names are concatenated using the reduce method.
    - The concatenated names are printed.
  


