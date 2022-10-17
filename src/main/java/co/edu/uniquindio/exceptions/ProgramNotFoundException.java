package co.edu.uniquindio.exceptions;

/**
 * Excepcion si el programa no fue encontrado
 * @author Esteban Peña
 */
public class ProgramNotFoundException extends Exception{
    public ProgramNotFoundException(String message){
        super(message);
    }
}
