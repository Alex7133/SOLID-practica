package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;

import java.util.List;

public class FileManager {

    public static long calculateSize(FileSystemItem fileSystemItem) {
        long totalSize = 0;
        String ruta = fileSystemItem.toString();
        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemItem item : fileSystemItem.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;
        String ruta = null;
        for(FileSystemItem item : files) {
            if (item instanceof File) {
                ruta = item.toString();
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                totalSize += calculateSize(item.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
