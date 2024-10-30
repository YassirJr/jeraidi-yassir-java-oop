# TP 2 , Exercice 4 Overview

### Class : Produit

The Produit class in the org.example.ex4 package represents a product with various attributes such as ID, name, brand,
price, description, and stock. This class encapsulates these attributes and provides methods to manipulate and retrieve
their values.

The class has six private fields: id, nom, marque, prix, description, and stock. These fields store the
product's ID, name, brand, price, description, and stock quantity, respectively.

```java
private int id;
private String nom;
private String marque;
private double prix;
private String description;
private int stock;
```

A constructor is provided to initialize these fields when a new Produit object is created. The constructor takes six
parameters corresponding to the fields and assigns them to the respective attributes.

```java
public Produit(int id, String nom, String marque, double prix, String description, int stock) {
    this.id = id;
    this.nom = nom;
    this.marque = marque;
    this.prix = prix;
    this.description = description;
    this.stock = stock;
}
```

The class includes getter and setter methods for each field, allowing other parts of the program to access and modify
the values of these attributes. For example, the getId and setId methods are used to retrieve and set the value of the
id field.

```java
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}
```

Similarly, there are getter and setter methods for the nom, marque, prix, description, and stock fields, enabling the
manipulation of these attributes.

Overall, the Produit class provides a structured way to manage product information,
encapsulating their attributes and behaviors while allowing for easy access and modification through getter and setter
methods.

### Interface : IMetierProduit

The IMetierProduit interface in the org.example.ex4 package defines a contract for managing Produit objects. This
interface outlines several methods that any implementing class must provide, ensuring a consistent way to handle
product-related operations.

The add method is intended to add a new Produit to the system. It takes a Produit object as
a parameter and returns the added Produit.

```java
public Produit add(Produit p);
```

The getAll method retrieves a list of all Produit objects. This method does not take any parameters and returns a
List<Produit>.

```java
public List<Produit> getAll();  
```

The getAllByNom method fetches a list of Produit objects that match a given name. It takes a String parameter
representing the product name and returns a List<Produit>.

```java
public List<Produit> getAllByNom(String nom);
```

The getById method retrieves a Produit by its unique identifier. It takes an int parameter representing the product ID
and returns the corresponding Produit.

```java
public Produit getById(int id);
```

The delete method removes a specified Produit from the system. It takes a Produit object as a parameter and does not
return any value.

```java
public void delete(Produit p);
```

Overall, the IMetierProduit interface provides a structured way to manage products, defining essential operations such
as adding, retrieving, and deleting Produit objects. This ensures that any class implementing this interface will
provide these fundamental functionalities.

### Class : MetierProduitImpl

The MetierProduitImpl class in the org.example.ex4 package implements the IMetierProduit interface, providing concrete
implementations for managing Produit objects. This class uses an ArrayList to store the products. 

The class has a private field produits, which is an ArrayList that holds Produit objects.

```java
private final List<Produit> produits = new ArrayList<>();
```

The add method adds a new Produit to the list if it is not already present. It checks if the list does not contain the product before adding it.

```java
public Produit add(Produit p) {
    if (!produits.contains(p)) {
        produits.add(p);
    }
    return p;
}
```

The getAll method returns the list of all Produit objects stored in the produits list.

```java
public List<Produit> getAll() {
    return produits;
}
```

The getAllByNom method filters the list of products by their name. It uses a stream to filter products whose names contain the specified string.

```java
public List<Produit> getAllByNom(String nom) {
    return produits.stream().filter(produit -> produit.getNom().contains(nom))
            .toList();
}
```

The getById method retrieves a Produit by its unique identifier. It uses a stream to find the first product with the matching ID or returns null if no match is found.

```java
public Produit getById(int id) {
    return produits.stream().filter(produit -> produit.getId() == id).findFirst().orElse(null);
}
```

The delete method removes a specified Produit from the list.

```java
public void delete(Produit p) {
    produits.remove(p);
}
```

Overall, the MetierProduitImpl class provides a concrete implementation for managing products, including adding, retrieving, filtering, and deleting Produit objects, ensuring that these operations are performed consistently.




### Class : Application

The Application class in the org.example.ex4 package serves as the main entry point for the application, providing a menu-driven interface for managing Produit objects. It uses a Scanner for user input and an instance of MetierProduitImpl to perform operations on products.  

The menu method displays a list of options to the user, such as displaying all products, searching for products by keyword, adding a new product, retrieving a product by ID, deleting a product by ID, and exiting the program. The menu items are stored in a List and printed to the console.

```java
public static void menu() {
    List<String> menuItems = List.of(
            "1 - Afficher la liste des produits.",
            "2 - Rechercher des produits par mot clé.",
            "3 - Ajouter un nouveau produit dans la liste.",
            "4 - Récupérer et afficher un produit par ID.",
            "5 - Supprimer un produit par id.",
            "6 - Quitter ce programme."
    );
    menuItems.forEach(System.out::println);
}
```

The addNewProduct method prompts the user to enter details for a new product, such as name, brand, price, description, and stock quantity. It then creates and returns a new Produit object with these details.

```java
public static Produit addNewProduct(int id) {
    System.out.println("Veuillez saisir le nom de produit :");
    String nom = scanner.next();
    System.out.println("Veuillez saisir la marque de produit :");
    String marque = scanner.next();
    System.out.println("Veuillez saisir le prix de produit :");
    double prix = scanner.nextDouble();
    System.out.println("Veuillez saisir la description de produit :");
    scanner.nextLine();
    String description = scanner.nextLine();
    System.out.println("Veuillez saisir le nombre de stock de produit :");
    int stock = scanner.nextInt();
    return new Produit(id, nom, marque, prix, description, stock);
}
```

In the main method, a MetierProduitImpl instance is created to manage the products. The method enters a loop where it displays the menu and processes the user's choice. Depending on the user's input, it performs various operations such as displaying all products, searching for products by name, adding a new product, retrieving a product by ID, and deleting a product by ID.  For example, to display all products, the getAll method of MetierProduitImpl is called, and the products are printed to the console.

```java
List<Produit> produits = metierProduitImpl.getAll();
if (!produits.isEmpty()) {
    produits.forEach(System.out::println);
} else {
    System.out.println("Aucun produit maintent");
}
```

To add a new product, the addNewProduct method is called to gather product details from the user, and the add method of MetierProduitImpl is used to add the product to the list.

```java
int id = metierProduitImpl.getAll().stream().mapToInt(Produit::getId).sum() | 1;
metierProduitImpl.add(addNewProduct(id));
System.out.println("Le produit ajoute avec success");
```

Overall, the Application class provides a user-friendly interface for managing products, leveraging the MetierProduitImpl class to perform CRUD operations on Produit objects .

