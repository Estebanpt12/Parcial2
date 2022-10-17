package co.edu.uniquindio.model;

import java.io.Serializable;

/**
 * Clase del programa
 * @author Esteban Peña
 */
public class Programa implements Serializable {

    /**
     * Codigo del programa
     */
    private String codigo;

    /**
     * Nombre del programa
     */
    private String nombre;

    /**
     * Modalidad del programa
     */
    private String modalidad;

    /**
     * Constructor vacio de la clase
     */
    public Programa(){}

    /**
     * Tomar el codigo del programa
     * @return codigo del programa
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Asignar el codigo del programa
     * @param codigo codigo del programa
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Tomar el nombre del programa
     * @return nombre del programa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar el nombre del programa
     * @param nombre nombre del programa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Tomar la modalidad del programa
     * @return modalidad del programa
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Asignar la modalidad del programa
     * @param modalidad modalidad del programa
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
