package com.tp6.ex1;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the folder: ");
        String path = scanner.nextLine();
        scanner.close();
        File file = new File(path);
        FolderManagement folderManagement = new FolderManagement();
        folderManagement.loadFolderContent(file);
        folderManagement
                .getFiles().
                forEach(f ->
                        System.out.println(f.get("path") + " " + f.get("type") + " " + f.get("permissions"))
                );
    }
}
