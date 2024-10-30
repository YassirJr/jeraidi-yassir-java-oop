# TP 2 , Exercice 2 Overview

### Class : Employe

The Employe class in the org.example.ex2 package is an abstract class that represents an employee with attributes such
as name, surname , email, phone number, and salary. This class encapsulates these attributes and provides methods to
manipulate and retrieve their values.

The class has five private fields: nom, prenom, email, telephone, and salaire.
These fields store the employee's name, surname, email address, phone number, and salary, respectively.

```java
private String nom;
private String prenom;
private String email;
private String telephone;
private double salaire;
```

A constructor is provided to initialize these fields when a new Employe object is created. The constructor takes five
parameters corresponding to the fields and assigns them to the respective attributes.

```java
public Employe(String nom, String prenom, String email, String telephone, double salaire) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.telephone = telephone;
    this.salaire = salaire;
}
```

The class includes getter and setter methods for each field, allowing other parts of the program to access and modify
the values of these attributes. For example, the getNom and setNom methods are used to retrieve and set the value of the
nom field.

```java
public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}
```

Similarly, there are getter and setter methods for the prenom, email, telephone, and salaire fields.

Additionally, the Employe class declares an abstract method calculerSalaire, which must be implemented by any subclass.
This method is intended to calculate the salary of the employee, but the specific implementation is left to the
subclasses.

```java
public abstract double calculerSalaire();
```

Overall, the Employe class provides a structured way to manage employee information, encapsulating their attributes and
behaviors while allowing for specific salary calculation logic to be defined in subclasses.

### Class : Ingenieur

The Ingenieur class in the org.example.ex2 package extends the abstract Employe class, representing an engineer with an
additional attribute for their specialty. This class inherits the attributes and methods from Employe and adds specific
functionality related to engineers.

The class has a private field specialite to store the engineer's specialty. This field is unique to the Ingenieur class
and is not present in the Employe class.

```java
private String specialite;
```

The constructor of the Ingenieur class calls the constructor of the superclass Employe to initialize the inherited
fields: nom, prenom, email, telephone, and salaire. This ensures that all the common attributes of an employee are
properly initialized.

```java
public Ingenieur(String nom, String prenom, String email, String telephone, double salaire) {
    super(nom, prenom, email, telephone, salaire);
}
```

The class includes getter and setter methods for the specialite field, allowing other parts of the program to access and
modify the engineer's specialty.

```java
public String getSpecialite() {
    return specialite;
}

public void setSpecialite(String specialite) {
    this.specialite = specialite;
}
```

The Ingenieur class overrides the abstract method calculerSalaire from the Employe class. This method calculates the
engineer's salary by adding a 15% bonus to the base salary. The specific implementation of this method is unique to the
Ingenieur class and demonstrates polymorphism.

```java

@Override
public double calculerSalaire() {
    return getSalaire() + getSalaire() * 0.15;
}
```

Overall, the Ingenieur class extends the functionality of the Employe class by adding a specialty attribute and
providing a specific implementation for calculating the salary, encapsulating the properties and behaviors of an
engineer within the application.

### Class : Manager

The Manager class in the org.example.ex2 package extends the abstract Employe class, representing a manager with an
additional attribute for their service. This class inherits the attributes and methods from Employe and adds specific
functionality related to managers.

The class has a private field service to store the manager's service. This field is
unique to the Manager class and is not present in the Employe class.

```java
private String service;
```

The constructor of the Manager class calls the constructor of the superclass Employe to initialize the inherited fields:
nom, prenom, email, telephone, and salaire. This ensures that all the common attributes of an employee are properly
initialized.

```java
public Manager(String nom, String prenom, String email, String telephone, double salaire) {
    super(nom, prenom, email, telephone, salaire);
}
```

The class includes getter and setter methods for the service field, allowing other parts of the program to access and
modify the manager's service.

```java
public String getService() {
    return service;
}

public void setService(String service) {
    this.service = service;
}
```

The Manager class overrides the abstract method calculerSalaire from the Employe class. This method calculates the
manager's salary by adding a 20% bonus to the base salary. The specific implementation of this method is unique to the
Manager class and demonstrates polymorphism.

```java

@Override
public double calculerSalaire() {
    return getSalaire() + getSalaire() * 0.2;
}
```

Overall, the Manager class extends the functionality of the Employe class by adding a service attribute and providing a
specific implementation for calculating the salary, encapsulating the properties and behaviors of a manager within the
application.

### Class : Main

The Main class in the org.example.ex2 package serves as the entry point for the application. It demonstrates the
creation and manipulation of Ingenieur and Manager objects, which are subclasses of the abstract Employe class. 

In the main method, an Ingenieur object is instantiated with specific details such as name, surname, email, phone number, and
salary. This is done using the Ingenieur constructor:

```java
Ingenieur ingenieur = new Ingenieur("Yassir", "Jeraidi", "yassir@g.com", "0600000000", 10000);
```

Similarly, a Manager object is created with its own set of details:

```java
Manager manager = new Manager("Yacer", "Jr", "y@g.c", "0600000000", 12000);
```

The program then prints the details of the Ingenieur object using the System.out.printf method. This method formats the output to include the engineer's name, surname, email, phone number, and salary:

```java
System.out.printf("nom: %s, prenom: %s, email: %s, telephone: %s, salaire: %f%n",
    ingenieur.getNom(), ingenieur.getPrenom(), ingenieur.getEmail(), ingenieur.getTelephone(), ingenieur.getSalaire());
```

The same approach is used to print the details of the Manager object:

```java
System.out.printf("nom: %s, prenom: %s, email: %s, telephone: %s, salaire: %f%n",
    manager.getNom(), manager.getPrenom(), manager.getEmail(), manager.getTelephone(), manager.getSalaire());
```

Overall, the Main class demonstrates how to instantiate and interact with objects of the Ingenieur and Manager classes, showcasing the use of inheritance and polymorphism in Java.
