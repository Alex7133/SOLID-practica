package com.kreitek.files;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements FileSystemItem {

    /**
     * TO DO :El metodo no esta del todo bien porque no consigo que funcione del todo porque si fuera directorios reales seria mucho mas facil
     * pero al ser asi realmente no se me ocurre nada, igualmente pienso que devolver un return size no es tan loco ya que tiene sinergia con los metodos de file manager
     * para que se calcule el tamaño de de los ficheros
     */

    /**
     * TO DO:Falta por hacer la division de esta clase ya que hace demasiadas cosas, estructuración, open and close, remove and add etc.
     * Son demasiados metodos para una clase
     */
    private static final String NO_ES_VALIDO_PARA_DIRECTORIOS = "No es válido para directorios";
    private final List<FileSystemItem> files;

    private long size;

    public Directory(FileSystemItem parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public String getExtension() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }

    @Override
    public long getSize() {
        return size;
    }


    @Override
    public void open() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }

    /**
     * Eliminamos los dos metodos : setPosition y read por no uso
     */

    @Override
    public void write(byte[] buffer) {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);

    }

    public void close() {
        throw new UnsupportedOperationException(NO_ES_VALIDO_PARA_DIRECTORIOS);
    }
}
