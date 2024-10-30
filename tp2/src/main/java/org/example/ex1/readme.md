# TP 2 , Exercice 1 Overview

### Class : Personne

The Personne class in the org.example.ex1 package represents a person with attributes such as name, surname, email,
phone number, and age. This class encapsulates these attributes and provides methods to manipulate and retrieve their
values. The class has five private fields: nom, prenom, email, telephone, and age. These fields store the person's name,
surname, email address, phone number, and age, respectively.

The class has five private fields: nom, prenom, email, telephone, and age. These fields store the person's name,
surname, email address, phone number, and age, respectively.

```java
private String nom;
private String prenom;
private String email;
private String telephone;
private int age;
```

A constructor is provided to initialize these fields when a new Personne object is created. The constructor takes five
parameters corresponding to the fields and assigns them to the respective attributes.

```java
public Personne(String nom, String prenom, String email, String telephone, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.telephone = telephone;
    this.age = age;
}
```

The class includes getter and setter methods for each field, allowing other parts of the program to access and modify
the values of these attributes. For example, the getNom and setNom methods are used to retrieve and set the value of the
nom field.

```java
    public String getNom() {
    return nom;
}
```

```java
public void setNom(String nom) {
    this.nom = nom;
}
```

Similarly, there are getter and setter methods for the prenom, email, telephone, and age fields.

Additionally, the afficher method provides a formatted string representation of the Personne object, including all its attributes. This method uses the String.format method to create a string that includes the person's name, surname, email, age, and phone number.

```java
public void afficher() {
    System.out.println(String.format("Nom: %s, Prenom: %s, Email: %s, Age: %d, Telephone: %s",
            nom, prenom, email, age, telephone));
}
```

Overall, the Personne class encapsulates the properties and behaviors of a person, providing a structured way to manage and manipulate personal information within the application.




### Class : Adherent

The Adherent class in the org.example.ex1 package extends the Personne class, inheriting its attributes and methods. This class represents a member with an additional attribute, numAdherent, which is a static integer that keeps track of the number of Adherent instances created.

The class has a constructor that takes five parameters: nom, prenom, email, telephone, and age. These parameters are passed to the superclass constructor to initialize the inherited fields. Additionally, the constructor increments the numAdherent static field each time a new Adherent object is created .

```java
public Adherent(String nom, String prenom, String email, String telephone, int age) {
    super(nom, prenom, email, telephone, age);
    numAdherent++;
}
```

The getNumAdherent method is a getter for the numAdherent field, allowing other parts of the program to access the current number of Adherent instances.

```java
public static int getNumAdherent() {
    return numAdherent;
}
```

The afficher method is overridden from the Personne class to include the numAdherent in the string representation of the Adherent object. This method calls the superclass afficher method and appends the numAdherent value to the resulting string.

```java
@Override
public String afficher() {
    return super.afficher() + String.format(" , Adherent : %d", getNumAdherent());
}
```

Overall, the Adherent class extends the functionality of the Personne class by adding a static counter for the number of members and including this information in the string representation of the object.




### Class : Auteur 

The Auteur class in the org.example.ex1 package extends the Personne class, inheriting its attributes and methods. This class represents an author with an additional attribute, numAuteur, which is an integer that uniquely identifies the author.

The class has a constructor that takes five parameters: nom, prenom, email, telephone, and age. These parameters are passed to the superclass constructor to initialize the inherited fields.

```java
public Auteur(String nom, String prenom, String email, String telephone, int age) {
    super(nom, prenom, email, telephone, age);
}
```

The getNumAuteur method is a getter for the numAuteur field, allowing other parts of the program to access the author's unique number.

```java
public int getNumAuteur() {
    return numAuteur;
}
```

The setNumAuteur method is a setter for the numAuteur field, allowing other parts of the program to modify the author's unique number.

```java
public void setNumAuteur(int numAuteur) {
    this.numAuteur = numAuteur;
}
```

The afficher method is overridden from the Personne class to provide a string representation of the Auteur object. This method returns a formatted string that includes the author's unique number.

```java
@Override
public String afficher() {
    return String.format("Auteur %d", getNumAuteur());
}
```

Overall, the Auteur class extends the functionality of the Personne class by adding a unique identifier for authors and including this information in the string representation of the object.




### Class : Livre

The Livre class in the org.example.ex1 package represents a book with attributes such as ISBN, title, and author. This class encapsulates these attributes and provides methods to manipulate and retrieve their values.  The class has three private fields: ISBN, titre, and auteur. These fields store the book's ISBN number, title, and author, respectively. The author is represented by a Personne object.

The class has three private fields: ISBN, titre, and auteur. These fields store the book's ISBN number, title, and author, respectively. The author is represented by a Personne object.

```java
private int ISBN;
private String titre;
private Personne auteur;
```

A constructor is provided to initialize these fields when a new Livre object is created. The constructor takes three parameters corresponding to the fields and assigns them to the respective attributes.

```java
public Livre(int ISBN, String titre, Personne auteur) {
    this.ISBN = ISBN;
    this.titre = titre;
    this.auteur = auteur;
}
```

The class includes getter and setter methods for each field, allowing other parts of the program to access and modify the values of these attributes. For example, the getISBN and setISBN methods are used to retrieve and set the value of the ISBN field.

```java
public int getISBN() {
    return ISBN;
}
```

```java
public void setISBN(int ISBN) {
    this.ISBN = ISBN;
}
```

Similarly, there are getter and setter methods for the titre and auteur fields.

Additionally, the afficher method provides a formatted string representation of the Livre object, including all its attributes. This method uses the String.format method to create a string that includes the book's ISBN, title, and the author's name, surname, and email.

```java
public String afficher() {
    return String.format("ISBN: %d, titre: %s , nom autheur : %s , prenom autheur : %s , email autheur : %s",
            getISBN(), getTitre(), auteur.getNom(), auteur.getPrenom(), auteur.getEmail());
}
```

Overall, the Livre class encapsulates the properties and behaviors of a book, providing a structured way to manage and manipulate book information within the application.




### Class : Main

The Main class in the org.example.ex1 package serves as the entry point for the application. It demonstrates the creation and manipulation of Adherent and Livre objects.

In the main method, an Adherent object is instantiated with details such as name, surname, email, phone number, and age. This is done using the Adherent constructor:

```java
Adherent adherent = new Adherent("Yassir", "Jeraidi", "yassir.jeraidi@gmail.com", "0600000000", 21);
```

Next, a Livre object is created, representing a book. The book is initialized with an ISBN, title, and the previously created Adherent object as the author:

```java
Livre livre = new Livre(1, "Livre 1", adherent);
```

The afficher method is then called on both the Adherent and Livre objects to print their string representations to the console. The afficher method in the Adherent class includes the member's details, while the afficher method in the Livre class includes the book's details along with the author's information:

```java
System.out.println(adherent.afficher());
System.out.println(livre.afficher());
```

The Main class demonstrates the use of inheritance and composition in object-oriented programming by creating objects of different classes and interacting with them to achieve the desired functionality.