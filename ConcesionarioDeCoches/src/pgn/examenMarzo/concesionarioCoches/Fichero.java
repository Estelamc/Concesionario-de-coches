package concesionario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Clase para crear y usar ficheros.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Fichero {
		
	// Nota: aquí abrir() y guardar() se limitan a leer y escribir fichero, a secas
	// En abrir() se crea la excepción FicheroCorruptoException
	
	 /**
     * Abre el concesionario desde un archivo (lo lee).
     *
     * @param archivo Fichero que contiene el concesionario
     * 
     * @return El concesionario contenido en el archivo.
     * 
     * @throws FileNotFoundException Error al no encontrar el archivo.
     * @throws ClassNotFoundException Error al no encontrarse la clase.
     * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
     * @throws FicheroCorruptoException Error por archivo da&ntilde;ado.
     */
    public static Concesionario abrir(File archivo) throws FileNotFoundException, ClassNotFoundException, IOException, FicheroCorruptoException {
    	// Añadimos la extensión al archivo, por si acaso, antes de hacer nada
    	archivo = annadirExtension(archivo);
    	// Abrimos el archivo
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
            return (Concesionario) objetoEntrada.readObject();
        // Si no puede abrirlo (por fallos de consistencia interna del archivo)
        } catch (StreamCorruptedException e) { // Crea la excepción
            throw new FicheroCorruptoException("Fichero corrupto.");
        }
    }
	
    /**
     * Guarda el concesionario dentro de un archivo.
     *
     * @param archivo Fichero donde se guarda el concesionario.
     * @param concesionario Concesionario que se quiere guardar.
     * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
     */
    public static void guardar(File archivo, Concesionario concesionario) throws IOException {
        // Añadimos la extensión al archivo, por si acaso, antes de hacer nada
    	archivo = annadirExtension(archivo);
    	// Guardamos el archivo
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        		new BufferedOutputStream(new FileOutputStream(archivo, false)))) { 
            objectOutputStream.writeObject(concesionario); // Sobreescribe el archivo
        }
    }
	
	/**
	 * A&ntilde;ade una extensi&oacute;n espec&iacute;fica al archivo.
	 * 
	 * @param archivo Fichero al que se le a&ntilde;ade la extensi&oacute;n.
	 * 
	 * @return Archivo con la extensi&oacute;n a&ntilde;adida.
	 */
	private static File annadirExtension(File archivo) {
		String extension = archivo.getPath(); 
		if (!extension.endsWith(".obj")) // Si no termina con .obj, lo añade
			return new File(archivo + ".obj");
		return archivo;
	}
	
	/**
	 * Comprueba si el archivo existe ya o no.
	 * 
	 * @param archivo Fichero a comprobar.
	 * 
	 * @return True si el archivo existe o False sino.
	 */
	public static boolean siArchivoExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}

}
