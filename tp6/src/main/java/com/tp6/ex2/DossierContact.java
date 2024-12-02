package com.tp6.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DossierContact {
    private final List<Map<String, String>> contacts = new ArrayList<>();
    private final String contactsPath = "./contacts/";

    public DossierContact() throws IOException {
        String contactsPath = "./contacts";
        File contactsFolder = new File(contactsPath);
        if (contactsFolder.exists() && contactsFolder.isDirectory()) {
            File[] files = contactsFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String contactNumber = bufferedReader.readLine();
                        String fileName = file.getName();
                        this.contacts.add(
                                Map.of(
                                        "nom", fileName.substring(0, fileName.lastIndexOf(".")),
                                        "numero", contactNumber
                                )
                        );
                    }
                }
            }
        } else {
            boolean isFolderCreated = contactsFolder.mkdir();
            if (isFolderCreated) {
                System.out.println("The contacts folder has been created.");
            } else {
                System.out.println("The contacts folder could not be created.");
            }
        }
    }

    public Map<String, String> getContact(String name) {
        return this.contacts.stream().filter(c -> c.get("nom").equals(name)).findFirst().orElse(null);
    }

    public void addContact(String name, String number) throws IOException {
        if (this.contacts.stream().anyMatch(c -> c.get("numero").equals(number))) {
            System.out.println("The contact number already exists.");
            return;
        }
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.createNewFile()) {
            FileWriter fileWriter = new FileWriter(contactFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(number);
            bufferedWriter.close();
            this.contacts.add(Map.of("nom", name, "numero", number));
        } else {
            System.out.println("The contact already exists.");
        }
    }

    public void deleteContact(String name) {
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.delete()) {
            this.contacts.removeIf(c -> c.get("nom").equals(name));
        } else {
            System.out.println("The contact does not exist.");
        }
    }

    public void updateContactNumber(String name, String newContactNumber) {
        File contactFile = new File(contactsPath + name + ".txt");
        if (contactFile.delete()) {
            try {
                addContact(name, newContactNumber);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        getContact(name);
    }
}
