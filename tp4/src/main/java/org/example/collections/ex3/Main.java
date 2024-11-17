package org.example.collections.ex3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();

        groupeA.add("Ahmed");
        groupeA.add("Karim");
        groupeA.add("Adam");

        groupeB.add("Yassir");
        groupeB.add("Hakim");
        groupeB.add("Adam");

        // intersection
        HashSet<String> interSection = new HashSet<>(groupeA);
        interSection.addAll(groupeB);
        interSection.forEach(System.out::println);

        System.out.println("#".repeat(20));

        // union
        HashSet<String> union = new HashSet<>(groupeA);
        union.retainAll(groupeB);
        union.forEach(System.out::println);

    }
}
