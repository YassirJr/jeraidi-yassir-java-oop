package com.tp6.ex3.metier.impl;

import com.tp6.ex3.models.Client;
import com.tp6.ex3.metier.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private final List<Client> clients = new ArrayList<>();
    private final String clientsFile = "./ex3_data/clients.dat";

    @Override
    public Client add(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        clients.clear();
        try (FileInputStream file = new FileInputStream(clientsFile);
             ObjectInputStream in = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Client client = (Client) in.readObject();
                    clients.add(client);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream().filter(c -> c.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equals(nom));
    }

    @Override
    public void saveAll() {
        try {
            for (Client c : clients) {
                FileOutputStream file = new FileOutputStream(clientsFile);
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(c);

                out.close();
                file.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
