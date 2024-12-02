package com.tp6.ex2;

import java.util.List;

public class Menu {
    public static void menu() {
        List<String> services = List.of("Find contact", "Add contact", "Delete contact", "Update contact", "Exit");
        services.forEach(service -> {
            System.out.println(services.indexOf(service) + 1 + " - " + service);
        });
        System.out.println("*".repeat(50));
    }
}
