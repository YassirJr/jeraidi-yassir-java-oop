package com.tp6.ex3.app;

import com.tp6.ex3.models.Client;
import com.tp6.ex3.helpers.Menu;
import com.tp6.ex3.metier.IMetier;
import com.tp6.ex3.metier.impl.MetierClientImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu.menu("client");
        IMetier<Client> clientIMetier = new MetierClientImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice != 6) {
            switch (choice) {
                case 1:
                    List<Client> clients = clientIMetier.getAll();
                    if (!clients.isEmpty()) clients
                            .forEach(client ->
                                    System.out.println("Nom : " + client.getNom() + " Prenom : " + client.getPrenom() +
                                            " Adresse : " + client.getAdresse() + " Tel : " + client.getTel() + " Email : " + client.getEmail()));
                    else System.out.println("No clients found.");
                    break;
                case 2:
                    System.out.println("Enter the name of the client: ");
                    String name = scanner.next();
                    Client client = clientIMetier.findByNom(name);
                    if (client != null) {
                        System.out.println("Nom : " + client.getNom() + " Prenom : " + client.getPrenom() +
                                " Adresse : " + client.getAdresse() + " Tel : " + client.getTel() + " Email : " + client.getEmail());
                    } else System.out.println("Client not found.");
                    break;
                case 3:
                    System.out.println("Enter the first name of the client: ");
                    String nom = scanner.next();
                    System.out.println("Enter the last name of the client: ");
                    String prenom = scanner.next();
                    System.out.println("Enter the address of the client: ");
                    String adresse = scanner.next();
                    System.out.println("Enter the phone number of the client: ");
                    String tel = scanner.next();
                    System.out.println("Enter the email of the client: ");
                    String email = scanner.next();
                    Client c = new Client(nom, prenom, adresse, tel, email);
                    clientIMetier.add(c);
                    System.out.println("Client added.");
                    break;
                case 4:
                    System.out.println("Enter the name of the client: ");
                    String clientToDelete = scanner.next();
                    clientIMetier.delete(clientToDelete);
                    System.out.println("Client deleted.");
                    break;
                case 5:
                    clientIMetier.saveAll();
                    System.out.println("Clients saved.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            Menu.menu("client");
            choice = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
