package com.javafx.javafx.app;

import com.javafx.javafx.metier.IMetier;
import com.javafx.javafx.metier.MetierImpl;
import com.javafx.javafx.models.Departement;
import com.javafx.javafx.models.Professeur;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ConsoleApp {
    private static final IMetier metier = new MetierImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gérer les professeurs");
            System.out.println("2. Gérer les départements");
            System.out.println("0. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gererProfesseurs();
                    break;
                case 2:
                    gererDepartements();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }

    private static void gererProfesseurs() {
        while (true) {
            System.out.println("\n=== Gestion des Professeurs ===");
            System.out.println("1. Afficher la liste des professeurs");
            System.out.println("2. Rechercher des professeurs");
            System.out.println("3. Ajouter un professeur");
            System.out.println("4. Modifier un professeur");
            System.out.println("5. Supprimer un professeur");
            System.out.println("6. Affecter un professeur à un département");
            System.out.println("0. Retour au menu principal");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    afficherProfesseurs();
                    break;
                case 2:
                    rechercherProfesseurs();
                    break;
                case 3:
                    ajouterProfesseur();
                    break;
                case 4:
                    modifierProfesseur();
                    break;
                case 5:
                    supprimerProfesseur();
                    break;
                case 6:
                    affecterProfesseurDepartement();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }

    private static void gererDepartements() {
        while (true) {
            System.out.println("\n=== Gestion des Départements ===");
            System.out.println("1. Afficher la liste des départements");
            System.out.println("2. Ajouter un département");
            System.out.println("3. Modifier un département");
            System.out.println("4. Supprimer un département");
            System.out.println("5. Afficher les professeurs d'un département");
            System.out.println("0. Retour au menu principal");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    afficherDepartements();
                    break;
                case 2:
                    ajouterDepartement();
                    break;
                case 3:
                    modifierDepartement();
                    break;
                case 4:
                    supprimerDepartement();
                    break;
                case 5:
                    afficherProfesseursDepartement();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }


    private static void afficherProfesseurs() {
        List<Professeur> professeurs = metier.getAllProfesseurs();
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur trouvé.");
            return;
        }

        System.out.println("\nListe des professeurs:");
        for (Professeur p : professeurs) {
            afficherProfesseur(p);
        }
    }

    private static void rechercherProfesseurs() {
        System.out.print("Entrez le mot clé de recherche: ");
        String keyword = scanner.nextLine();

        List<Professeur> professeurs = metier.searchProfesseurs(keyword);
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur trouvé.");
            return;
        }

        System.out.println("\nRésultats de la recherche:");
        for (Professeur p : professeurs) {
            afficherProfesseur(p);
        }
    }

    private static void ajouterProfesseur() {
        Professeur p = new Professeur();

        System.out.println("\nAjout d'un nouveau professeur:");
        System.out.print("Nom: ");
        p.setNom(scanner.nextLine());

        System.out.print("Prénom: ");
        p.setPrenom(scanner.nextLine());

        System.out.print("CIN: ");
        p.setCin(scanner.nextLine());

        System.out.print("Adresse: ");
        p.setAdresse(scanner.nextLine());

        System.out.print("Téléphone: ");
        p.setTelephone(scanner.nextLine());

        System.out.print("Email: ");
        p.setEmail(scanner.nextLine());

        System.out.print("Date de recrutement (YYYY-MM-DD): ");
        try {
            p.setDateRecrutement(dateFormat.parse(scanner.nextLine()));
            metier.addProfesseur(p);
            System.out.println("Professeur ajouté avec succès!");
        } catch (ParseException e) {
            System.out.println("Format de date invalide!");
        }
    }

    private static void modifierProfesseur() {
        System.out.print("Entrez l'ID du professeur à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Professeur> professeurs = metier.getAllProfesseurs();
        Professeur profToUpdate = null;
        for (Professeur p : professeurs) {
            if (p.getId() == id) {
                profToUpdate = p;
                break;
            }
        }

        if (profToUpdate == null) {
            System.out.println("Professeur non trouvé!");
            return;
        }

        System.out.println("\nModification du professeur:");
        System.out.print("Nouveau nom (" + profToUpdate.getNom() + "): ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setNom(input);

        System.out.print("Nouveau prénom (" + profToUpdate.getPrenom() + "): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setPrenom(input);

        System.out.print("Nouveau CIN (" + profToUpdate.getCin() + "): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setCin(input);

        System.out.print("Nouvelle adresse (" + profToUpdate.getAdresse() + "): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setAdresse(input);

        System.out.print("Nouveau téléphone (" + profToUpdate.getTelephone() + "): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setTelephone(input);

        System.out.print("Nouvel email (" + profToUpdate.getEmail() + "): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) profToUpdate.setEmail(input);

        metier.updateProfesseur(profToUpdate);
        System.out.println("Professeur modifié avec succès!");
    }

    private static void supprimerProfesseur() {
        System.out.print("Entrez l'ID du professeur à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        metier.deleteProfesseur(id);
        System.out.println("Professeur supprimé avec succès!");
    }

    private static void affecterProfesseurDepartement() {
        System.out.print("Entrez l'ID du professeur: ");
        int idProf = scanner.nextInt();

        System.out.print("Entrez l'ID du département: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();

        Optional<Professeur> professeur = metier.getAllProfesseurs()
                .stream()
                .filter(p -> p.getId() == idProf)
                .findFirst();

        if (professeur.isEmpty()) {
            System.out.println("Professeur non trouvé!");
            return;
        }
        professeur.get().setDepartementId(idDepart);
        metier.updateProfesseur(professeur.get());
        System.out.println("Professeur affecté au département avec succès!");

    }


    private static void afficherDepartements() {
        List<Departement> departements = metier.getAllDepartements();
        if (departements.isEmpty()) {
            System.out.println("Aucun département trouvé.");
            return;
        }

        System.out.println("\nListe des départements:");
        for (Departement d : departements) {
            System.out.println("ID: " + d.getId() + ", Nom: " + d.getNom());
        }
    }

    private static void ajouterDepartement() {
        System.out.print("Nom du département: ");
        String nom = scanner.nextLine();

        Departement d = new Departement();
        d.setNom(nom);
        metier.addDepartement(d);
        System.out.println("Département ajouté avec succès!");
    }

    private static void modifierDepartement() {
        System.out.print("Entrez l'ID du département à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouveau nom: ");
        String nom = scanner.nextLine();

        Departement d = new Departement();
        d.setNom(nom);
        d.setId(id);
        metier.updateDepartement(d);
        System.out.println("Département modifié avec succès!");
    }

    private static void supprimerDepartement() {
        System.out.print("Entrez l'ID du département à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        metier.deleteDepartement(id);
        System.out.println("Département supprimé avec succès!");
    }

    private static void afficherProfesseursDepartement() {
        System.out.print("Entrez l'ID du département: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Professeur> professeurs = metier.getProfesseursByDepartement(id);
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur trouvé dans ce département.");
            return;
        }

        System.out.println("\nProfesseurs du département:");
        for (Professeur p : professeurs) {
            afficherProfesseur(p);
        }
    }

    private static void afficherProfesseur(Professeur p) {
        System.out.println("\nID: " + p.getId());
        System.out.println("Nom: " + p.getNom());
        System.out.println("Prénom: " + p.getPrenom());
        System.out.println("CIN: " + p.getCin());
        System.out.println("Adresse: " + p.getAdresse());
        System.out.println("Téléphone: " + p.getTelephone());
        System.out.println("Email: " + p.getEmail());
        System.out.println("Date de recrutement: " + dateFormat.format(p.getDateRecrutement()));
            System.out.println("Département: " + metier.getAllDepartements()
                    .stream()
                    .filter(departement -> departement.getId() == p.getDepartementId())
                    .findFirst()
                    .get()
                    .getNom());

        System.out.println("------------------------");
    }
}