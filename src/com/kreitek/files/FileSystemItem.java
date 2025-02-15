package com.kreitek.files;

import java.io.File;
import java.util.List;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);
    String getFullPath();
    String getExtension(); //
    List<FileSystemItem> listFiles(); //
    void addFile(FileSystemItem file); //
    void removeFile(FileSystemItem file); //
    long getSize(); //
}
