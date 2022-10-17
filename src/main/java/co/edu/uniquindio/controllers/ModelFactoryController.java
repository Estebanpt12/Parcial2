package co.edu.uniquindio.controllers;

import co.edu.uniquindio.exceptions.ExistingProgramException;
import co.edu.uniquindio.exceptions.ProgramNotFoundException;
import co.edu.uniquindio.model.Programa;
import co.edu.uniquindio.model.UniversidadQuindio;
import co.edu.uniquindio.persistencia.Persistencia;

import java.util.ArrayList;

/**
 * Clase singleton
 * @author Esteban Peña
 */
public class ModelFactoryController{

    /**
     * Objeto tipo universidad
     */
    UniversidadQuindio universidadQuindio;

    /**
     * Atribut singleton
     */
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    /**
     * Metodo para returnar la instancia de la clase
     * @return
     */
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    /**
     * Constructor de la clase
     */
    public ModelFactoryController() {
        cargarResourceXML();
    }

    /**
     * Metodo para cargar el modelo
     */
    public void cargarResourceXML() {
        universidadQuindio = Persistencia.cargarRecursoUniversidadXML();
    }

    /**
     * Metodo para guardar el modelo serializado
     */
    public void guardarResourceXML() {
        Persistencia.guardarRecursoBancoXML(universidadQuindio);
    }

    /**
     * Tomar el atributo del modelo
     * @return universidad del Quindio
     */
    public UniversidadQuindio getUniversidadQuindio() {
        return universidadQuindio;
    }

    /**
     * Asignar el atributo del modelo
     * @param universidadQuindio universidad del Quindio
     */
    public void setUniversidadQuindio(UniversidadQuindio universidadQuindio) {
        this.universidadQuindio = universidadQuindio;
    }

    /**
     * Metodo para validar si un codigo de programa existe
     * @param codigoPrograma Codigo de programa a evaluar
     * @throws ExistingProgramException Excepcion si el codigo de programa ya existe
     */
    public void validateExistingProgram(String codigoPrograma) throws ExistingProgramException{
        if(universidadQuindio.validarCodigoPrograma(codigoPrograma)){
            throw new ExistingProgramException("El codigo de programa ya existe");
        }
    }

    /**
     * Metodo para retornar el programa buscado
     * @param codigoPrograma codigo de programa con el que se realiza la busqueda
     * @return programa encontrado
     * @throws ProgramNotFoundException Se valida si el programa no se encuentra
     */
    public Programa validarProgramaBuscado(String codigoPrograma) throws ProgramNotFoundException {
        return universidadQuindio.validarPrograma(codigoPrograma);
    }

    /**
     * Metodo para crear programa
     * @param codigo codigo del programa
     * @param nombre nombre del program
     * @param modalidad modalidad del programa
     */
    public void crearPrograma(String codigo, String nombre, String modalidad) {
        universidadQuindio.crearPrograma(codigo, nombre, modalidad);
        guardarResourceXML();
    }

    /**
     * Metodo para tomar las modalidades
     * @return modalidades cargadas
     */
    public ArrayList<String> cargarModalidades(){
        return Persistencia.tomarModalidadesProperties();
    }

}
