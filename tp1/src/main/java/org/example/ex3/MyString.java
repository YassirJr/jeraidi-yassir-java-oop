package org.example.ex3;

public class MyString {
    private static String string;

    public static void saisir(String s){
        string = s;
    }

    public static void afficher(){
        System.out.println(string);
    }

    public static String inverser(){
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        string = sb.toString();
        return string;
    }

    public static int nombreDeMots(){
        return string.split(" ").length;
    }



}
