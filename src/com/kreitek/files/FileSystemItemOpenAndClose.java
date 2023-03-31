package com.kreitek.files;

public interface FileSystemItemOpenAndClose {

    /**
     *  Hemos Dividido la interfaz FileSystemItem por los principios de solis exactamente con el de
     *  responsabilidad unica ya que esta interfaz aparte de tener metodos como manejar la estructura del
     * sistema de archivos y las operaciones de entrada y salida de datos
     */

    /**
     * Hemos detectado que en eta interfaz hay dos metodos que no se llegan a usar en el producto final osea que sera un fallo en el principio de segregación
     * de la interfaz, es verdad que estan implantados pero no se llegan a usar lo que significa que es un fallo.
     */

    void open();

    void close();

    void write(byte[] buffer);
}
