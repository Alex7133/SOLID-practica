package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;
import com.kreitek.files.FileSystemItemOpenAndClose;

public class FileSystemBuilder {

    private final FileSystemItem root;
    private FileSystemItem currentDirectory;
    private FileSystemItemOpenAndClose openAndCloseDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileSystemItemOpenAndClose file = new File(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile((FileSystemItem) file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        FileSystemItem directory = new Directory(currentDirectory, name);
        currentDirectory.addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
