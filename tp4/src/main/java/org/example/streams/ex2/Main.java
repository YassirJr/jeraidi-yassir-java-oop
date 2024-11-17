package org.example.streams.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employe> employes = new ArrayList<>(List.of(
                new Employe("Yassir", "info", 10000),
                new Employe("Hakim", "info", 8000)
        ));

        double sum = employes.stream().mapToDouble(Employe::getSalaire).sum();
        System.out.println("La somme des salaires = " + sum);

        ArrayList<Employe> sortedEmployes = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .collect(Collectors.toCollection(ArrayList::new));
        sortedEmployes.forEach(employe -> System.out.println(employe.getNom()));

        Employe employeWithMinSalaire = employes.stream().min(Comparator.comparing(Employe::getSalaire)).get();
        System.out.println("nom de l'employe : " + employeWithMinSalaire.getNom());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le salaire : ");
        double salaireInput = scanner.nextDouble();
        List<Employe> listEmployesWithEnteredSalaire = employes.stream().filter(employe -> employe.getSalaire() > salaireInput).toList();
        listEmployesWithEnteredSalaire.forEach(employe -> System.out.println(employe.getNom()));

        Employe employeHasMaxSalaire = employes.stream()
                .reduce((employe1, employe2) -> employe1.getSalaire() > employe2.getSalaire() ? employe1 : employe2)
                .get();
        System.out.println(employeHasMaxSalaire.getNom());

        String nomsEmployes = employes.stream()
                .map(Employe::getNom)
                .reduce("", ((employe1, employe2) -> employe1 + " " + employe2));
        System.out.println(nomsEmployes);
    }
}
