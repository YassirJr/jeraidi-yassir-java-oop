# TP 2 , Exercice 3 Overview

This project (TP) is a Java application that manages computer products (`Ordinateur`), clients (`Client`), and orders (
`Commande`). The application is structured into several classes, each encapsulating specific functionalities and
attributes.

## Class: `Ordinateur`

The `Ordinateur` class represents a computer with various attributes and methods to manipulate and retrieve its data.
The class has six private fields: `nom`, `marque`, `prix`, `description`, `stock`, and `categorie`. These fields store
the name, brand, price, description, stock quantity, and category of the computer, respectively.

```java
private String nom;
private String marque;
private double prix;
private String description;
private int stock;
private Categorie categorie;
```

The class also has a constructor that initializes the computer's attributes and a `toString` method that returns a
string representation of the computer's data.

```java
public Ordinateur(String nom, String marque, double prix, String description, int stock, Categorie categorie) {
    this.nom = nom;
    this.marque = marque;
    this.prix = prix;
    this.description = description;
    this.stock = stock;
    this.categorie = categorie;
}
```

The `Ordinateur` class provides methods to get and set the computer's attributes, such as `getNom`, `getMarque`,
`getPrix`, `getDescription`, `getStock`, `getCategorie`, `setNom`, `setMarque`, `setPrix`, `setDescription`, `setStock`,
and `setCategorie`.

```java
public String getNom() {
    return nom;
}
```

### Method: prixForQuantity

Additionally, the class includes a method prixForQuantity that calculates the total price for a given quantity of
computers. This method multiplies the prix field by the provided quantity and returns the result as an integer

```java
public int prixForQuantity(int quantity) {
    return (int) (prix * quantity);
}
```

Overall, the Ordinateur class encapsulates the properties and behaviors of a computer, providing a structured way to
manage and manipulate computer data within the application.

## Class: `Client`

The `Client` class represents a client with various attributes and methods to manage and retrieve client information.
The class has four private fields: `nom`, `prenom`, `adresse`, and `telephone`. These fields store the client's last
name, first name, address, and phone number, respectively.

```java
private String nom;
private String prenom;
private String email;
private String adresse;
private String ville;
private String telephone;
private final List<Commande> commandes = new ArrayList<>();
```

The class also has a constructor that initializes the client's attributes and a `toString` method that returns a string
representation of the client's data.

```java
public Client(String nom, String prenom, String email, String adresse, String ville, String telephone) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.adresse = adresse;
    this.ville = ville;
    this.telephone = telephone;
}
```

The `Client` class provides methods to get and set the client's attributes, such as `getNom`, `getPrenom`, `getEmail`,
`getAdresse`, `getVille`, `getTelephone`, `setNom`, `setPrenom`, `setEmail`, `setAdresse`, `setVille`, and
`setTelephone`.

```java
public String getNom() {
    return nom;
}
```

The class also includes a method `ajouterCommande` to add a new order to the client's list of orders.

```java
public void ajouteCommande(Commande commande) {
    if (!commandes.contains(commande)) {
        commandes.add(commande);
    }
}
```

### Method: getCommandes

Additionally, the class includes a method getCommandes that returns the list of orders associated with the client. This
method retrieves the commandes field, which stores the list of orders, and returns it as a collection.

```java
public List<Commande> getCommandes() {
    return commandes;
}
```

### Method : supprimerCommande

The class also includes a method supprimerCommande that removes a specific order from the client's list of orders. This
method takes an order as a parameter and removes it from the commandes list if it exists.

```java
public void supprimerCommande(Commande commande) {
    commandes.remove(commande);
}
```

Overall, the `Client` class encapsulates the properties and behaviors of a client, providing a structured way to manage
and manipulate client information within the application.

## Class: `Commande`

The `Commande` class represents an order with various attributes and methods to manage and retrieve order information.
The class has three private fields: `client`, `ordinateurs`, and `quantites`. These fields store the client associated
with the order, the list of computers in the order, and the quantities of each computer, respectively.

```java
private String reference;
private Client client;
private LocalDateTime dateCommande;
private CommandeEtat etat;
```

The class also has a constructor that initializes the order's attributes and a `toString` method that returns a string
representation of the order's data.

```java
public Commande(String reference, Client client, LocalDateTime dateCommande, CommandeEtat etat) {
    this.reference = reference;
    this.client = client;
    this.dateCommande = dateCommande;
    this.etat = etat;
}
```

The `Commande` class provides methods to get and set the order's attributes, such as `getReference`, `getClient`,
`getDateCommande`, `getEtat`, `setReference`, `setClient`, `setDateCommande`, and `setEtat`.

```java
public String getReference() {
    return reference;
}
```

```java
public void setReference(String reference) {
    this.reference = reference;
}
```

Similarly, the getClient and setClient methods manage the client field, the getDateCommande and setDateCommande methods
manage the dateCommande field, and the getEtat and setEtat methods manage the etat field.

Overall, the Commande class encapsulates the properties and behaviors of an order, providing a structured way to manage
and manipulate order data within the application.

## Enum: `CommandeEtat`

The CommandeEtat enum in the org.example.ex3 package defines the possible states of an order. Enums in Java are a
special type of class that represents a group of constants (unchangeable variables). This enum has three constants: OK,
PENDING, and REFUSED.

```java
public enum CommandeEtat {
    OK,
    PENDING,
    REFUSED
}
```

Each constant in the CommandeEtat enum represents a specific state an order can be in. The OK state indicates that the
order has been successfully processed. The PENDING state signifies that the order is still being processed and has not
yet been completed. The REFUSED state means that the order has been rejected. Enums are useful for representing a fixed
set of related constants, making the code more readable and less error-prone. By using the CommandeEtat enum, the code
can clearly and consistently refer to the different states of an order throughout the application.

## Class: `Categorie`

The `Categorie` class represents a category of computers with various attributes and methods to manage and retrieve
category information. The class has two private fields: `nom` and `description`. These fields store the name and
description of the category, respectively.

```java
private String nom;
private String description;
private List<Ordinateur> ordinateurs = new ArrayList<>();
```

The class also has a constructor that initializes the category's attributes and a `toString` method that returns a
string
representation of the category's data.

```java
public Categorie(String nom, String description) {
    this.nom = nom;
    this.description = description;
}
```

The `Categorie` class provides methods to get and set the category's attributes, such as `getNom`, `getDescription`,
`setNom`, and `setDescription`.

```java
public String getNom() {
    return nom;
}
```

```java
public String setNom(String nom) {
    this.nom = nom;
}
```

The class also includes a method `ajouterOrdinateur` to add a computer to the category's list of computers.

```java
public void ajouterOrdinateur(Ordinateur ordinateur) {
    if (!ordinateurs.contains(ordinateur)) {
        ordinateurs.add(ordinateur);
    }
}
```

### Method: getOrdinateurs

Additionally, the class includes a method getOrdinateurs that returns the list of computers associated with the
category.
This method retrieves the ordinateurs field, which stores the list of computers, and returns it as a collection.

```java
public List<Ordinateur> getOrdinateurs() {
    return ordinateurs;
}
```

### Method: supprimerOrdinateur

The class also includes a method supprimerOrdinateur that removes a specific computer from the category's list of
computers. This method takes a computer as a parameter and removes it from the ordinateurs list if it exists.

```java
public void supprimerOrdinateur(Ordinateur ordinateur) {
    ordinateurs.remove(ordinateur);
}
```

### Method: rechercherParPrix(double prix)

The class includes a method rechercherParPrix that searches for computers within the category that have a price equal to
the specified value. This method takes a price as a parameter and returns a list of computers that match the given
price.

```java
public List<Ordinateur> rechercherParPrix(double prix) {
    return ordinateurs.stream()
            .filter(ordinateur -> ordinateur.getPrix() == prix)
            .toList();
}
```

Overall, the `Categorie` class encapsulates the properties and behaviors of a category, providing a structured way to
manage and manipulate category information within the application.

### Class : LigneCommande

The `LigneCommande` class represents a line item in an order, containing information about a specific computer and the
quantity ordered. The class has two private fields: `ordinateur` and `quantite`. These fields store the computer being
ordered and the quantity of that computer, respectively.

```java
private int quantite;
private Commande commande;
private Ordinateur ordinateur;
```

The class also has a constructor that initializes the line item's attributes and a `toString` method that returns a
string representation of the line item's data.

```java
public LigneCommande(int quantite, Commande commande, Ordinateur ordinateur) {
    this.quantite = quantite;
    this.commande = commande;
    this.ordinateur = ordinateur;
}
```

The `LigneCommande` class provides methods to get and set the line item's attributes, such as `getQuantite`,
`getCommande`,
`getOrdinateur`, `setQuantite`, `setCommande`, and `setOrdinateur`.

```java
public int getQuantite() {
    return quantite;
}
```

```java
public void setQuantite(int quantite) {
    this.quantite = quantite;
}
```

Overall, the LigneCommande class encapsulates the properties and behaviors of an order line, providing a structured way
to manage and manipulate order line data within the application.



## Class: `Main`

The `Main` class is the entry point of the application, containing the main method that executes the program. The class
demonstrates the functionality of the application by creating instances of computers, clients, and orders, and
performing various operations on them.

In the main method, a list of Ordinateur objects is retrieved by calling the getOrdinateurs method. This method creates
and returns a list of Ordinateur instances, each initialized with specific attributes such as name, brand, price,
description, stock quantity, and category.

```java
List<Ordinateur> ordinateurs = getOrdinateurs();
```

A Client object is then instantiated with details such as name, surname, email, address, city, and phone number.

```java
Client client = new Client("yacer", "jr", "y@g.c", "casa", "casa/maroc", "0600000000");
```

Next, a Commande object is created, representing an order placed by the client. The order is initialized with a
reference, the client object, the current date and time, and an order state of OK.

```java
Commande commande = new Commande("C1", client, LocalDateTime.now(), CommandeEtat.OK);
```

A list of LigneCommande objects is then created, each representing an order line. These objects are initialized with a quantity, the order object, and an Ordinateur object from the list of computers.

```java
List<LigneCommande> ligneCommandes = List.of(
    new LigneCommande(2, commande, ordinateurs.get(0)),
    new LigneCommande(5, commande, ordinateurs.get(1)),
    new LigneCommande(10, commande, ordinateurs.get(2))
);
```

The forEach method is used to iterate over the list of LigneCommande objects, printing out details of each order line, including the client's name, the computer's name, and the quantity ordered.

```java
ligneCommandes.forEach(ligneCommande -> {
    System.out.println("#".repeat(20));
    System.out.println("Client :" + ligneCommande.getCommande().getClient().getNom());
    System.out.println("Ordinateur :" + ligneCommande.getOrdinateur().getNom());
    System.out.println("Quantite :" + ligneCommande.getQuantite());
});
```

The getOrdinateurs method is a helper method that creates and returns a list of Ordinateur objects. Each Ordinateur is initialized with attributes such as name, brand, price, description, stock quantity, and category.

```java
private static List<Ordinateur> getOrdinateurs() {
    Categorie etudeCategorie = new Categorie("etude", "etude categorie");
    Categorie gamingCategorie = new Categorie("gaming", "gaming categorie");
    Categorie editingCategorie = new Categorie("editing", "editing categorie");

    return List.of(
        new Ordinateur("pc 1", "dell", 10000.00, "bon pc", 20, etudeCategorie),
        new Ordinateur("pc 2", "msi", 15000.00, "bon pc", 10, gamingCategorie),
        new Ordinateur("mac 2024", "apple", 30000.00, "bon pc", 5, editingCategorie)
    );
}
```

The `Main` class creates instances of computers in different categories, a client, and an order. It then creates line
items for the order, associating each line item with a computer and a quantity. Finally, the class prints information
about each line item, including the client's name, the computer's name, and the quantity ordered.











