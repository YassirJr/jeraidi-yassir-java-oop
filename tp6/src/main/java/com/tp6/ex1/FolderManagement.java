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
        }else {
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
