package co.edu.uniquindio.exceptions;

/**
 * Excepcion para validar si los campos en la interfaz de usuario estan llenos
 * @author Esteban Peña
 */
public class EmptyFieldsException extends Exception {

    public EmptyFieldsException (String message){
        super(message);
    }
}
