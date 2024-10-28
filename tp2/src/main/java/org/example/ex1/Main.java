package org.example.ex1;

public class Main {
    public static void main(String[] args) {
        Adherent adherent = new Adherent
                ("Yassir" , "Jeraidi" , "yassir.jeraidi@gmail.com" , "0600000000" , 21);

        Livre livre = new Livre(1 , "Livre 1" , adherent);

        System.out.println(adherent.afficher());
        System.out.println(livre.afficher());
    }
}