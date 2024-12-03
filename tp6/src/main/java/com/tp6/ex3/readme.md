# Exercise 3: Client and Product Management

This exercise is part of a unified Java exercises project. The `Client and Product Management` system allows users to
manage clients and products by adding, deleting, updating, and retrieving their information.

## Class : Product

This file defines the Produit class, which represents a product with attributes such as name, brand, price, description,
and stock quantity.

```java
package com.tp6.ex3.models;

public class Produit implements Serializable {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public Produit(String nom, String marque, double prix, String description, int nombreEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    // Getters and Setters
}
```

## Class : Client

This file defines the Client class, which represents a client with attributes such as first name, last name, email, and
phone number.

```java
package com.tp6.ex3.models;

import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;

    public Client(String nom, String prenom, String adresse, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    // Getters and Setters
}
```

## Interface : IMetier

The `IMetier` interface is generic and defines the main methods to manage a collection of objects:

- **`add(T t)`**: Adds an object to the collection.
- **`getAll()`**: Retrieves all objects from the collection.
- **`findByNom(String nom)`**: Finds an object by its name.
- **`delete(String nom)`**: Deletes an object by its name.
- **`saveAll()`**: Saves all objects to a file.

#### Code

```java
public interface IMetier<T> {
    T add(T t);

    List<T> getAll() throws IOException;

    T findByNom(String nom);

    void delete(String nom);

    void saveAll();
}
```

## Class : MetierProduitImpl

This class manages products. It uses a file (produits.dat) to persist data and provides implementations for the IMetier
methods.

## Key methods :

- **`add(Produit produit)`**: Adds a product to the collection.
- **`getAll()`**: Reads all products from the produits.dat file and loads them into memory.
- **`findByNom(String nom)`**: Finds a product by its name.
- **`delete(String nom)`**: Deletes a product by its name.
- **`saveAll()`**: Saves all products to the produits.dat file.

```java
package com.tp6.ex3.metier.impl;

import com.tp6.ex3.models.Produit;
import com.tp6.ex3.metier.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private final List<Produit> produits = new ArrayList<>();
    private final String produitsFile = "./ex3_data/produits.dat";

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        produits.clear();
        try (FileInputStream file = new FileInputStream(produitsFile);
             ObjectInputStream in = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Produit produit = (Produit) in.readObject();
                    produits.add(produit);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream().filter(p -> p.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try {
            for (Produit p : produits) {
                FileOutputStream file = new FileOutputStream(produitsFile);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(p);
                out.close();
                file.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

## How it works step by step :

1. **`add(Produit produit)`**: Adds a product to the collection.
   - The `produit` object is added to the `produits` list.
   - The added product is returned.
   - The method signature is implemented from the `IMetier` interface.
   - The method does not persist the product to the file.
   - The product is only added to the in-memory collection.
   
2. **`getAll()`**: Reads all products from the produits.dat file and loads them into memory.
   - The `produits` list is cleared to avoid duplicates.
   - A `FileInputStream` is created to read from the `produits.dat` file.
   - An `ObjectInputStream` is created to read objects from the file.
   - A `while` loop reads objects from the file until an `EOFException` is thrown.
   - Each object read is cast to a `Produit` and added to the `produits` list.
   - The method returns the list of products.

3. **`findByNom(String nom)`**: Finds a product by its name.
    - The `produits` list is filtered to find a product with a matching name.
    - The first matching product is returned, or `null` if not found.

4. **`delete(String nom)`**: Deletes a product by its name.
    - The `produits` list is modified to remove the product with the specified name.
    - The product is removed if its name matches the input `nom`.
    - The method does not persist the changes to the file.
    - The product is only removed from the in-memory collection.

5. **`saveAll()`**: Saves all products to the produits.dat file.
    - A `for` loop iterates over each product in the `produits` list.
    - A `FileOutputStream` is created to write to the `produits.dat` file.
    - An `ObjectOutputStream` is created to write objects to the file.
    - The current product is written to the file.
    - The output streams are closed after writing the product.
    - The method does not handle exceptions or errors during writing.


## Class : MetierClientImpl

This class manages clients. It uses a file (clients.dat) to persist data and provides implementations for the IMetier
methods.

## Key methods :

- **`add(Client client)`**: Adds a client to the collection.
- **`getAll()`**: Reads all clients from the clients.dat file and loads them into memory.
- **`findByNom(String nom)`**: Finds a client by their name.
- **`delete(String nom)`**: Deletes a client by their name.
- **`saveAll()`**: Saves all clients to the clients.dat file.

```java
package com.tp6.ex3.metier.impl;

import com.tp6.ex3.models.Client;
import com.tp6.ex3.metier.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private final List<Client> clients = new ArrayList<>();
    private final String clientsFile = "./ex3_data/clients.dat";

    @Override
    public Client add(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        clients.clear();
        try (FileInputStream file = new FileInputStream(clientsFile);
             ObjectInputStream in = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Client client = (Client) in.readObject();
                    clients.add(client);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream().filter(c -> c.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try {
            for (Client c : clients) {
                FileOutputStream file = new FileOutputStream(clientsFile);
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(c);

                out.close();
                file.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

## How it works step by step :

1. **`add(Client client)`**: Adds a client to the collection.
   - The `client` object is added to the `clients` list.
   - The added client is returned.
   - The method signature is implemented from the `IMetier` interface.
   - The method does not persist the client to the file.
   - The client is only added to the in-memory collection.

2. **`getAll()`**: Reads all clients from the clients.dat file and loads them into memory.
    - The `clients` list is cleared to avoid duplicates.
    - A `FileInputStream` is created to read from the `clients.dat` file.
    - An `ObjectInputStream` is created to read objects from the file.
    - A `while` loop reads objects from the file until an `EOFException` is thrown.
    - Each object read is cast to a `Client` and added to the `clients` list.
    - The method returns the list of clients.
   
3. **`findByNom(String nom)`**: Finds a client by their name.
    - The `clients` list is filtered to find a client with a matching name.
    - The first matching client is returned, or `null` if not found.
   
4. **`delete(String nom)`**: Deletes a client by their name.
    - The `clients` list is modified to remove the client with the specified name.
    - The client is removed if their name matches the input `nom`.
    - The method does not persist the changes to the file.
    - The client is only removed from the in-memory collection.

5. **`saveAll()`**: Saves all clients to the clients.dat file.
    - A `for` loop iterates over each client in the `clients` list.
    - A `FileOutputStream` is created to write to the `clients.dat` file.
    - An `ObjectOutputStream` is created to write objects to the file.
    - The current client is written to the file.
    - The output streams are closed after writing the client.
    - The method does not handle exceptions or errors during writing.


## Class : Menu

This class provides a static method to display a menu with options to manage clients or products.

```java
package com.tp6.ex3.helpers;

import java.util.List;

public class Menu {
    public static void menu(String app) {
        List<String> services = List.of(
                "Afficher la liste des " + app + "s",
                "Rechercher un " + app + " par son nom",
                "Ajouter un nouveau " + app + " dans la liste",
                "Supprimer un " + app + " par nom",
                "Sauvegarder les " + app + "s",
                "Quitter ce programme");

        services.forEach(s -> {
            System.out.println(services.indexOf(s) + 1 + ". " + s);
        });
        System.out.println("*".repeat(10));
    }
}
```

## Class : ProduitApplication

This class is the main class of the Products application. It provides a menu to manage only the products .

```java
package com.tp6.ex3.app;

import com.tp6.ex3.helpers.Menu;
import com.tp6.ex3.models.Produit;
import com.tp6.ex3.metier.IMetier;
import com.tp6.ex3.metier.impl.MetierProduitImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProduitApplication {
    public static void main(String[] args) throws IOException {
        Menu.menu("produit");
        IMetier<Produit> produitsMetier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice != 6) {
            switch (choice) {
                case 1:
                    List<Produit> produits = produitsMetier.getAll();
                    if (!produits.isEmpty()) produits
                            .forEach(produit ->
                                    System.out.println("Nom : " + produit.getNom() + " Marque : " + produit.getMarque() +
                                            " Prix : " + produit.getPrix() + " Description : " + produit.getDescription() +
                                            " Nombre en stock : " + produit.getNombreEnStock()));
                    break;
                case 2:
                    System.out.println("Enter the name of the product: ");
                    String name = scanner.next();
                    Produit produit = produitsMetier.findByNom(name);
                    if (produit != null) {
                        System.out.println("Nom : " + produit.getNom() + " Marque : " + produit.getMarque() + " Prix : " + produit.getPrix() + " Description : " + produit.getDescription() + " Nombre en stock : " + produit.getNombreEnStock());
                    } else System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.println("Enter the name of the product: ");
                    String nom = scanner.next();
                    System.out.println("Enter the marque of the product: ");
                    String marque = scanner.next();
                    System.out.println("Enter the price of the product: ");
                    double prix = scanner.nextDouble();
                    System.out.println("Enter the description of the product: ");
                    String description = scanner.next();
                    System.out.println("Enter the number of the product in stock: ");
                    int nombreEnStock = scanner.nextInt();
                    Produit p = new Produit(nom, marque, prix, description, nombreEnStock);
                    produitsMetier.add(p);
                    break;
                case 4:
                    System.out.println("Enter the name of the product: ");
                    String productToDelete = scanner.next();
                    produitsMetier.delete(productToDelete);
                    System.out.println("Product deleted.");
                    break;
                case 5:
                    produitsMetier.saveAll();
                    System.out.println("Products saved.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            Menu.menu("produit");
            choice = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
```

---

## `ProduitApplication` - Main Application

The `ProduitApplication` class serves as the entry point for managing products in the application. It provides a
user-friendly console-based interface to perform CRUD operations on products.

---

## Features of the `ProduitApplication`

1. **Menu Integration**:
    - Uses the `Menu.menu()` helper method to display a menu specific to product management.

2. **Interactive User Interface**:
    - Accepts user inputs via the console to perform actions such as listing, adding, finding, deleting, and saving
      products.

3. **CRUD Operations**:
    - **View Products**: List all products available in the storage file.
    - **Find Product by Name**: Search and display details of a specific product.
    - **Add Product**: Add a new product with details like name, brand, price, description, and stock quantity.
    - **Delete Product**: Remove a product by its name.
    - **Save Products**: Persist the current state of products to the storage file.

4. **Graceful Termination**:
    - Exits the application when the user selects the "Exit" option.

---

## Code Flow

### 1. Menu Display

The application begins by displaying a menu of options using the `Menu.menu()` method. This menu guides the user through
available actions.

### 2. User Input

The application waits for the user to enter a choice (an integer). Based on the input, a corresponding action is
performed.

### 3. Switch Statement for Actions

The `choice` variable determines which operation is executed:

- **Option 1**: List all products (`getAll`)
- **Option 2**: Find a product by its name (`findByNom`)
- **Option 3**: Add a new product (`add`)
- **Option 4**: Delete a product by its name (`delete`)
- **Option 5**: Save all products to file (`saveAll`)
- **Option 6**: Exit the application

### 4. Validation

- Handles invalid inputs with a default case to display an error message.

### 5. Continuous Execution

The menu reappears after each operation, allowing the user to perform multiple actions without restarting the program.

### 6. Application Exit

The application terminates when the user selects the "Exit" option (choice `6`).

---

## Sample Usage

### 1. Starting the Application

Run the `ProduitApplication` class. The console will display the following menu:

```plaintext
Product Management Menu:
1. View all products
2. Find a product by name
3. Add a new product
4. Delete a product
5. Save products to file
6. Exit
Enter your choice:
```

### 2. Performing Actions

Adding a Product: Input the product details as prompted:

```plaintext
Enter the name of the product: Laptop
Enter the marque of the product: Dell
Enter the price of the product: 899.99
Enter the description of the product: High-performance laptop
Enter the number of the product in stock: 50
Product added.
```

Viewing All Products:

```plaintext
Nom : Laptop Marque : Dell Prix : 899.99 Description : High-performance laptop Nombre en stock : 50
```

For more actions, refer to the `ProduitApplication` class.


---

## `ClientApplication` - Main Application

The `ClientApplication` class provides an entry point for managing clients. It offers a console-based interface for CRUD operations on client data.

---

## Features of the `ClientApplication`

1. **Menu Integration**:
   - Displays a menu using the `Menu.menu()` helper method tailored for client management.

2. **Interactive Console Interface**:
   - Allows users to perform actions such as listing, adding, finding, deleting, and saving client information.

3. **CRUD Operations**:
   - **View Clients**: List all clients stored in the file.
   - **Find Client by Name**: Search and display details of a specific client.
   - **Add Client**: Add a new client with details such as name, address, phone number, and email.
   - **Delete Client**: Remove a client by their name.
   - **Save Clients**: Persist all client information to the storage file.

4. **User-Friendly Workflow**:
   - Accepts user input in a loop to perform multiple operations without restarting the program.

5. **Application Exit**:
   - Provides an "Exit" option to terminate the application.

---

## Code Flow

### 1. Menu Display
The application starts by displaying a client management menu using the `Menu.menu()` method.

### 2. User Input
- Accepts an integer input (`choice`) from the user to select an action.

### 3. Action Execution
- A `switch` statement determines the action based on the `choice` value:
   - **Option 1**: List all clients (`getAll`)
   - **Option 2**: Find a client by name (`findByNom`)
   - **Option 3**: Add a new client (`add`)
   - **Option 4**: Delete a client by name (`delete`)
   - **Option 5**: Save all clients to file (`saveAll`)
   - **Option 6**: Exit the application

### 4. Validation
- Handles invalid choices with an appropriate error message.

### 5. Continuous Execution
- After each operation, the menu is displayed again, allowing for multiple actions during a single run.

### 6. Termination
- The application exits gracefully when the user selects "Exit" (choice `6`).

---

## Sample Usage

### 1. Starting the Application
Run the `ClientApplication` class. The console displays the following menu:

```plaintext
Client Management Menu:
1. View all clients
2. Find a client by name
3. Add a new client
4. Delete a client
5. Save clients to file
6. Exit
Enter your choice:
```

### 2. Performing Actions

Adding a Client: Enter the client details as prompted:

```plaintext
Enter the first name of the client: Doe
Enter the last name of the client: John
Enter the address of the client: 123 Elm Street
Enter the phone number of the client: 555-1234
Enter the email of the client: john.doe@example.com
```

for more actions please refer to the `ClientApplication` class.