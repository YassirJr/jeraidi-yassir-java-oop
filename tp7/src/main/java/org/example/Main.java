package org.example;

import org.example.ex1.Talkative;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Exrcise 1");
        Talkative.main(args);
        System.out.println("Exercise 2");
        org.example.ex2.Main.main(args);
    }
}