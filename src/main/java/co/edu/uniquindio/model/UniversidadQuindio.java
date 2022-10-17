package co.edu.uniquindio.model;

import co.edu.uniquindio.exceptions.ProgramNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase base del modelo de negocio
 * @author Esteban Peña
 */
public class UniversidadQuindio implements Serializable {

    /**
     * Lista de programas
     */
    private ArrayList<Programa> listaProgramas = new ArrayList<>();

    /**
     * Constructor vacio de la clase
     */
    public UniversidadQuindio(){}

    /**
     * Tomar la lista de programas
     * @return Lista de programas
     */
    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * Asignar la lista de programas
     * @param listaProgramas Lista de programas
     */
    public void setListaProgramas(ArrayList<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    /**
     * Metodo para validar si un codigo existe en los programas
     * @param codigoPrograma codigo a validar
     * @return si el codigo existe o no
     */
    public boolean validarCodigoPrograma(String codigoPrograma){
        boolean marca = false;
        for(Programa programa : listaProgramas){
            if(programa.getCodigo().equals(codigoPrograma)){
                marca = true;
                break;
            }
        }
        return marca;
    }

    /**
     * Metodo para crear un progrma
     * @param codigo codigo del programa
     * @param nombre nombre del programa
     * @param modalidad modalidad del programa
     */
    public void crearPrograma(String codigo, String nombre, String modalidad) {
        Programa programa = new Programa();
        programa.setCodigo(codigo);
        programa.setNombre(nombre);
        programa.setModalidad(modalidad);
        listaProgramas.add(programa);
    }

    /**
     * Metodo para validar si el programa bsucado existe
     * @param codigoPrograma codigo de programa a validar
     * @return Programa encontrado
     * @throws ProgramNotFoundException Se valida si el program existe
     */
    public Programa validarPrograma(String codigoPrograma) throws ProgramNotFoundException {
        for(Programa programa : listaProgramas){
            if(programa.getCodigo().equals(codigoPrograma)){
                return programa;
            }
        }
        throw new ProgramNotFoundException("El programa no fue encontrado");
    }
}
