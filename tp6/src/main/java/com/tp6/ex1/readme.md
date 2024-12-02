# Exercise 1: Folder Management

This exercise is part of a unified Java exercises project. The `FolderManagement` class is designed to manage and
retrieve information about files and directories within a specified folder.

## Class: FolderManagement

This file defines the `FolderManagement` class, which provides functionality to load the contents of a folder, including
files and subdirectories, and retrieve their details such as path, type, and permissions.

```java
package com.tp6.ex1;

import java.io.File;
import java.util.*;

public class FolderManagement {
    private final List<Map<String, Object>> folderFiles = new ArrayList<>();

    public List<Map<String, Object>> getFiles() {
        return this.folderFiles;
    }

    public void loadFolderContent(File folder) {
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                Arrays.stream(files).map(file -> {
                    Map<String, Object> fileInfo = new HashMap<>();
                    fileInfo.put("path", file.getAbsoluteFile());
                    fileInfo.put("type", file.isDirectory() ? "<DIR>" : "<FICH>");
                    fileInfo.put("permissions", loadPermissions(file));
                    return fileInfo;
                }).forEach(this.folderFiles::add);
            }
        } else {
            System.out.println("The folder does not exist or is not a directory.");
        }
    }

    private String loadPermissions(File file) {
        String permissions = "";
        permissions += file.canRead() ? "r" : "-";
        permissions += file.canWrite() ? "w" : "-";
        permissions += file.isHidden() ? "h" : "-";
        return permissions;
    }
}
```

The `FolderManagement` class provides the following methods:

- `getFiles()`: Returns the list of files and directories within the folder.
- `loadFolderContent(File folder)`: Loads the contents of the specified folder into the list of files.
- `loadPermissions(File file)`: Retrieves the permissions of the specified file.
- The `folderFiles` list stores the details of the files and directories within the folder.
- The `loadFolderContent` method populates the `folderFiles` list with the details of the files and directories within
  the specified folder.
- The `loadPermissions` method retrieves the permissions of the specified file and returns a string representation of
  the permissions.

## Main Class: Main

This file contains the main class that demonstrates the functionality of the `FolderManagement` class.

```java
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
```

The `Main` class provides the following functionality:

- Prompts the user to enter the path of the folder.
- Creates a `File` object with the specified folder path.
- Creates an instance of the `FolderManagement` class.
- Loads the contents of the specified folder using the `loadFolderContent` method.
- Retrieves the list of files and directories within the folder using the `getFiles` method.
- Prints the details of each file and directory, including the path, type, and permissions.
- The `main` method demonstrates the usage of the `FolderManagement` class by loading the contents of a folder and
  displaying the details of the files and directories within it.
