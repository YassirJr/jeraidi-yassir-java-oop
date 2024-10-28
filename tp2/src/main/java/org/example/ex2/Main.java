package org.example.ex2;

public class Main {
    public static void main(String[] args) {
        Ingenieur ingenieur = new Ingenieur("Yassir" , "Jeraidi" , "yassir@g.com" , "0600000000" , 10000 );
        Manager manager = new Manager("Yacer" , "Jr" , "y@g.c" , "0600000000" , 12000);

        System.out.println("Ingenieur :");
        System.out.printf("nom : %s , prenom : %s , email : %s , telephone : %s , salaire : %f%n",
                ingenieur.getNom() , ingenieur.getPrenom() , ingenieur.getEmail() , ingenieur.getTelephone() , ingenieur.getSalaire());

        System.out.println("Manager :");
        System.out.printf("nom : %s , prenom : %s , email : %s , telephone : %s , salaire : %f%n",
                manager.getNom() , manager.getPrenom() , manager.getEmail() , manager.getTelephone() , manager.getSalaire());


    }
}
