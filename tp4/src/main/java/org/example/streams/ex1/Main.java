package org.example.streams.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> noms = new ArrayList<>();
        noms.add("Akram");
        noms.add("Adam");
        noms.add("Amine");
        noms.add("Hakim");
        noms.add("Yassir");

        List<String> nomsContientA = noms.stream().filter(nom -> nom.contains("a")).toList();
        System.out.println("#".repeat(20));
        nomsContientA.forEach(System.out::println);

        List<String> motLong3WithInverse = noms.stream()
                .filter(nom -> nom.length() > 3)
                .map(nom -> new StringBuilder(nom).reverse().toString())
                .toList();
        System.out.println("#".repeat(20));
        motLong3WithInverse.forEach(System.out::println);

        List<String[]> motWithEWithSubList = noms.stream()
                .filter(nom -> nom.contains("e"))
                .map(nom -> nom.split(""))
                .toList();
        System.out.println("#".repeat(20));
        motWithEWithSubList.forEach(nom -> Arrays.stream(nom).toList().forEach(System.out::println));

        List<String> nomsAsMajuscules = noms.stream().map(String::toUpperCase).toList();
        System.out.println("#".repeat(20));
        nomsAsMajuscules.forEach(System.out::println);

        Map<String, Integer> nomWithLongueur = noms.stream()
                .collect(Collectors.toMap(nom -> nom, String::length));
        System.out.println("#".repeat(20));
        nomWithLongueur.forEach((k, v) -> System.out.println(k + " : " + v));

        List<Character> listChars = noms.stream()
                .flatMap(nom -> nom.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("#".repeat(20));
        listChars.forEach(System.out::println);

        List<String> nomWithIndex = IntStream.range(0, noms.size())  // Generate indices
                .mapToObj(i -> noms.get(i) + "-" + i)  // Map element and index
                .toList();
        System.out.println("#".repeat(20));
        nomWithIndex.forEach(System.out::println);
    }
}
