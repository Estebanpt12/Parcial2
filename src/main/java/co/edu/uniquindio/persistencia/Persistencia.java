package co.edu.uniquindio.persistencia;

import co.edu.uniquindio.model.UniversidadQuindio;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * Clase persistencia
 * @author Esteban Peña
 */
public class Persistencia {

    /**
     * Ruta del archivo donde se guarda la universidad
     */
    public static final String RUTA_ARCHIVO_UNIVERSIDAD_SERIALIZABLE_XML = "src/main/resources/model.xml";

    /**
     * Ruta del archivo donde se guarda las propiedades de la aplicacion
     */
    public static final String RUTA_ARCHIVO_PROPERTIES = "src/main/resources/application.properties";

    /**
     * Metodo para cargar la universidad
     * @return universidad del archivo serializado
     */
    public static UniversidadQuindio cargarRecursoUniversidadXML() {
        UniversidadQuindio universidadQuindio = null;
        try {
            universidadQuindio = (UniversidadQuindio)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_UNIVERSIDAD_SERIALIZABLE_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universidadQuindio;
    }

    /**
     * Metodo para guardar la universidad en XML
     * @param universidadQuindio universidadQuindio a guardar
     */
    public static void guardarRecursoBancoXML(UniversidadQuindio universidadQuindio) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_UNIVERSIDAD_SERIALIZABLE_XML, universidadQuindio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para tomar las modalidades del archivo properties
     * @return lista con las modalidades disponibles
     */
    public static ArrayList<String> tomarModalidadesProperties(){
        Properties properties = new Properties();
        ArrayList<String> listaModalidades = new ArrayList<>();
        try {
            properties.load(new FileReader(RUTA_ARCHIVO_PROPERTIES));
            String contenido = properties.getProperty("tipos_modalidad");
            Scanner scanner = new Scanner(contenido);
            scanner.useDelimiter(",");
            while (scanner.hasNext()){
                listaModalidades.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaModalidades;
    }

}
