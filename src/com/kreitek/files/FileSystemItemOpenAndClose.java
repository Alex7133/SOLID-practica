package com.kreitek.files;

public interface FileSystemItemOpenAndClose {

    /**
     *  Hemos Dividido la interfaz FileSystemItem por los principios de solis exactamente con el de
     *  responsabilidad unica ya que esta interfaz aparte de tener metodos como manejar la estructura del
     * sistema de archivos y las operaciones de entrada y salida de datos
     */

    void open(); //

    void close(); //

    void setPosition(int numberOfBytesFromBeginning); //

    byte[] read(int numberOfBytesToRead); //

    void write(byte[] buffer); //
}
