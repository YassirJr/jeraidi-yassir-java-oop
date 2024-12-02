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
    public List<Client> getAll() throws IOException {
        clients.clear();
        File newFile = new File(clientsFile);
        FileReader fileReader = new FileReader(newFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(";");
            Client client = new Client(values[0], values[1], values[2], values[3], values[4]);
            clients.add(client);
        }
        bufferedReader.close();
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
            File newFile = new File(clientsFile);
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Client c : clients) {
                bufferedWriter.write(c.getNom() + ";" + c.getPrenom() + ";" + c.getAdresse() + ";" + c.getTel() + ";" + c.getEmail());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
