package com.kreitek.files;

import com.kreitek.files.error.InvalidFileFormatException;

import java.util.List;

public  class File extends FileSystemItemBase implements FileSystemItem,FileSystemItemOpenAndClose {

    /**
     * TO DO: Falta dividir esta clase ya que creo que se puede dividir ya que se encarga de todos los metros abstractos y metodos de las interfaces y ademas
     * porque tienes los metodos de conversion. Pero no he conseguido implementarlo. Seria un error en los principios de responsabilidad unica
     */

    private int size = 0;
    private boolean isOpen = false;
    private int position = 0;

    public File(FileSystemItem parent, String name) {
        super(parent, name);
    }


    @Override
    public String getExtension() {
        String extension = "";
        int indexOfLastDot = getName().lastIndexOf(".");
        if (indexOfLastDot > 0) {
            extension = getName().substring(indexOfLastDot + 1);
        }
        return extension;
    }

    @Override
    public List<FileSystemItem> listFiles() {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }



    @Override
    public void addFile(FileSystemItem file) {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }

    @Override
    public void removeFile(FileSystemItem file) {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void open() {
        isOpen = true;
        // Aquí vendría código que actualizaría también this.size
    }

    /**
     * Eliminamos los dos metodos : setPosition y read por no uso
     */


    @Override
    public void write(byte[] buffer) {
        // Aquí habría lógica que escribiría en el fichero
        size += buffer.length;
        position += buffer.length;
    }

    @Override
    public void close() {
        isOpen = false;
    }

    public FileSystemItemOpenAndClose convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItemOpenAndClose result = new File(parent, newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    public FileSystemItemOpenAndClose convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItemOpenAndClose result = new File(parent, newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

}
