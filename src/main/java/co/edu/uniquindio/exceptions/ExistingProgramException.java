package co.edu.uniquindio.exceptions;

/**
 * Excepcion para validar si el programa ya existe
 * @author Esteban Peña
 */
public class ExistingProgramException extends Exception{

    public ExistingProgramException(String message){
        super(message);
    }
}
