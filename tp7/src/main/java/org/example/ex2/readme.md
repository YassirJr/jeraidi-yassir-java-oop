# Exercise 2 : Sommeur

This exercise involves creating a multi-threaded Java application to calculate the sum of elements in a list of integers. The application uses the Sommeur class to perform the summation in parallel, improving performance for large lists.

## Class Sommeur 

The Sommeur class has several fields: integers, debut, fin, and somme. The integers field is a list of integers that the class will sum over. The debut and fin fields define the range of indices within the list that will be summed. The somme field stores the result of the summation.

```java
private List<Integer> integers = new ArrayList<>();
private int debut = 0;
private int fin = 0;
private int somme = 0;
```

The constructor of the Sommeur class initializes these fields with the provided values.

```java
public Sommeur(List<Integer> integers, int debut, int fin) {
    this.integers = integers;
    this.debut = debut;
    this.fin = fin;
}
```

The run method performs the summation. It iterates over the specified range of indices in the integers list and adds each element to the somme field.

```java
@Override
public void run() {
    somme = 0;
    for (int i = debut; i < fin; i++) {
        somme += integers.get(i);
    }
}
```

The getSomme method returns the calculated sum.

```java
public int getSomme() {
    return somme;
}
```

This class is designed to be used in a multi-threaded environment where multiple instances of Sommeur can run concurrently to sum different parts of a list, thereby improving performance for large lists.


## Class Main

The Main class contains the main method, which sets up the integer list and creates instances of the Sommeur class to process different parts of the list concurrently. Three Sommeur instances are created, each responsible for summing different parts of the list.

```java
List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
Sommeur sommeur1 = new Sommeur(integers, 0, 5);
Sommeur sommeur2 = new Sommeur(integers, 5, 10);
Sommeur sommeur3 = new Sommeur(integers, 0, 10);
```

Each Sommeur instance is wrapped in a Thread object, and all threads are started.

```java
Thread t1 = new Thread(sommeur1);
Thread t2 = new Thread(sommeur2);
Thread t3 = new Thread(sommeur3);

t1.start();
t2.start();
t3.start();
```

The main method waits for all threads to complete using the join method. Once all threads have finished, the total sum is calculated by summing the results from each Sommeur instance.

```java
try {
    t1.join();
    t2.join();
    t3.join();
} catch (InterruptedException e) {
    System.out.println(e.getMessage());
}

System.out.println("La somme totale est : " + (sommeur1.getSomme() + sommeur2.getSomme() + sommeur3.getSomme()));
```

This approach ensures that the summation of the list elements is performed in parallel, potentially improving performance for large lists.
