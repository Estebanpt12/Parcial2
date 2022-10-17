package co.edu.uniquindio.controllers;


import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class ModelFactoryControllerCopia{

    //Banco banco;


    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryControllerCopia() {


        //1. inicializar datos y luego guardarlo en archivos
//		iniciarSalvarDatosPrueba();

        //2. Cargar los datos de los archivos
//		cargarDatosDesdeArchivos();


        //3. Guardar y Cargar el recurso serializable binario
//		guardarResourceBinario();
//		cargarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
//		guardarResourceXML();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null
        /*if(banco == null)
        {
            System.out.println("es null");
            inicializarDatos();
//			guardarResourceSerializable();
            guardarResourceXML();
        }

        //Registrar la accion de incio de sesión
        Persistencia.guardaRegistroLog("Inicio de sesión del usuario:pedro", 1, "inicioSesion");*/


    }



    private void iniciarSalvarDatosPrueba() {

        /*inicializarDatos();

        try {

            Persistencia.guardarEmpleados(getBanco().getListaEmpleados());
            Persistencia.guardarClientes(getBanco().getListaClientes());

            //Persistencia.cargarDatosArchivos(getBanco());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }


    private void cargarDatosDesdeArchivos() {

        /*banco = new Banco();

        try {

            //Persistencia.cargarDatosArchivos(getBanco());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    public void cargarResourceBinario() {

        //banco = Persistencia.cargarRecursoBancoBinario();
    }


    public void guardarResourceBinario() {

        //Persistencia.guardarRecursoBancoBinario(banco);
    }


    public void cargarResourceXML() {

        //banco = Persistencia.cargarRecursoBancoXML();
    }


    public void guardarResourceXML() {

        //Persistencia.guardarRecursoBancoXML(banco);
    }



    /*private void inicializarDatos() {

        banco = new Banco();


        Cliente cliente = new Cliente();
        cliente.setNombre("juan");
        cliente.setApellido("arias");
        cliente.setCedula("125454");
        cliente.setDireccion("Armenia");
        cliente.setCorreo("uni1@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Pedro");
        cliente.setApellido("Perez");
        cliente.setCedula("77787");
        cliente.setDireccion("Pererira");
        cliente.setCorreo("uni2@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Alberto");
        cliente.setApellido("Arias");
        cliente.setCedula("12555");
        cliente.setDireccion("Pererira");
        cliente.setCorreo("uni3@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);


        Empleado empleado = new Empleado();
        empleado.setNombre("juan");
        empleado.setApellido("arias");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);


        empleado = new Empleado();
        empleado.setNombre("Ana");
        empleado.setApellido("alzate");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Pedro");
        empleado.setApellido("perez");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);

        System.out.println("Banco inicializado "+banco );

    }*/

    /*public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }*/

}
