package co.edu.uniquindio.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.exceptions.EmptyFieldsException;
import co.edu.uniquindio.exceptions.ExistingProgramException;
import co.edu.uniquindio.exceptions.ProgramNotFoundException;
import co.edu.uniquindio.model.Programa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

/**
 * Controller de la vista principal
 * @author Esteban Peña
 */
public class PrincipalViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BotonAgregar;

    @FXML
    private Button BotonBuscar;

    @FXML
    private TableColumn<Programa, String> ColumnaCodigo;

    @FXML
    private TableColumn<Programa, String> ColumnaModalidad;

    @FXML
    private TableColumn<Programa, String> ColumnaNombre;

    @FXML
    private ComboBox<String> DropDownModalidad;

    @FXML
    private TableView<Programa> Tabla;

    @FXML
    private TextField TextBuscar;

    @FXML
    private TextField TextCodigo;

    @FXML
    private TextField TextNombre;

    /**
     * Variable que guarda la lista de programas que se insertan en el combo box
     */
    private ObservableList<Programa> programas = FXCollections.observableArrayList();

    @FXML
    void eventButtonAgregar(ActionEvent event) {
        try {
            validarFields();
            modelFactoryController.validateExistingProgram(TextCodigo.getText());
            modelFactoryController.crearPrograma(TextCodigo.getText(), TextNombre.getText(),
                    DropDownModalidad.getSelectionModel().getSelectedItem());
            TextCodigo.setText("");
            TextNombre.setText("");
            DropDownModalidad.getSelectionModel().selectFirst();
            JOptionPane.showMessageDialog(null, "Programa creado");
        } catch (EmptyFieldsException | ExistingProgramException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Validar campos de creacion de programa
     * @throws EmptyFieldsException Si algun field esta vacio
     */
    private void validarFields() throws EmptyFieldsException{
        if(TextNombre.getText().equals("") || TextCodigo.getText().equals("") ||
                DropDownModalidad.getSelectionModel().getSelectedIndex() == 0){
            throw new EmptyFieldsException("Algun campo esta vacio");
        }
    }

    @FXML
    void eventButtonBuscar(ActionEvent event) {
        try {
            validarField();
            Programa programa = modelFactoryController.validarProgramaBuscado(TextBuscar.getText());
            programas.clear();
            programas.add(programa);
            Tabla.setItems(programas);
        } catch (EmptyFieldsException | ProgramNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Metodo para validar el campo que busqueda
     * @throws EmptyFieldsException
     */
    private void validarField() throws  EmptyFieldsException{
        if(TextBuscar.getText().equals("")){
            throw new EmptyFieldsException("El parametro esta vacio");
        }
    }

    /**
     * Metodo para cargar las columnas de la tabla
     */
    private void loadTable(){
        ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ColumnaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        ColumnaModalidad.setCellValueFactory(new PropertyValueFactory<>("Modalidad"));
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        cargarOpcionesCombo();
        assert BotonAgregar != null : "fx:id=\"BotonAgregar\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert BotonBuscar != null : "fx:id=\"BotonBuscar\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert ColumnaCodigo != null : "fx:id=\"ColumnaCodigo\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert ColumnaModalidad != null : "fx:id=\"ColumnaModalidad\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert ColumnaNombre != null : "fx:id=\"ColumnaNombre\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert DropDownModalidad != null : "fx:id=\"DropDownModalidad\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert Tabla != null : "fx:id=\"TablaEstudiante\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert TextBuscar != null : "fx:id=\"TextBuscar\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert TextCodigo != null : "fx:id=\"TextCodigo\" was not injected: check your FXML file 'principal_view.fxml'.";
        assert TextNombre != null : "fx:id=\"TextNombre\" was not injected: check your FXML file 'principal_view.fxml'.";
        loadTable();
    }

    /**
     * Metodo para cargar las modalidades en el combo box
     */
    private void cargarOpcionesCombo(){
        ArrayList<String> listaModalidades = modelFactoryController.cargarModalidades();
        DropDownModalidad.getItems().add("Seleccionar");
        for(String modalidad : listaModalidades){
            DropDownModalidad.getItems().add(modalidad);
        }
        DropDownModalidad.getSelectionModel().selectFirst();
    }

}