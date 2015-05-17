package concesionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Gestiona el uso de los ficheros.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Gestion {
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Indica si el concesionado ha sido modificado o no. 
	 */
	private static boolean modificado;
	
	/**
	 * Archivo que contendr&aacute; el concesionario.
	 */
	private static File archivo = new File("Sin_Titulo");
	
	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	/**
	 * Devuelve si el concesionario ha sido modificado o no.
	 * 
	 * @return Si el concesionario ha sido modificado o no.
	 */
	public static boolean getModificado() { // Corresponde a isModificado()
		return modificado; 
	}

	/**
	 * Modifica si el concesionario est&aacute; modificado o no.
	 * 
	 * @param modificado Indica si el concesionario ha sido modificado o no.
	 */
	public static void setModificado(boolean modificado) {
		Gestion.modificado = modificado; 
	}
	
	/**
	 * Devuelve el archivo.
	 * 
	 * @return El archivo.
	 */
	public static File getArchivo() {
		return archivo;
	}
	
	/**
	 * Modifica el archivo.
	 * 
	 * @param archivo Fichero donde se guarda un objeto (concesionario).
	 */
	public static void setArchivo(File archivo) {
		Gestion.archivo = archivo;
		
	}
	
	/**
	 * Crea un archivo nuevo vac&iacute;o.
	 * @throws IOException 
	 * 
	 */
	public static void nuevo() throws IOException {
		setArchivo(null); // Un archivo nuevo no contiene nada, es nulo
		Gestion.setArchivo(new File ("Sin_titulo.obj")); // Nuevo archivo
		General.concesionario = new Concesionario(); // Nuevo Concesionario
		setModificado(false); // Cambiamos su estado a no modificado
	}
	
	/**
	 * Abre un archivo, 
	 * cambia su estado a no modificado y
	 * reemplaza el archivo actual por el abierto.
	 * 
	 * @return El archivo abierto.
	 * 
	 * @throws FileNotFoundException Error al no encontrar el archivo.
	 * @throws ClassNotFoundException Error al no encontrar la clase.
	 * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
	 * @throws FicheroCorruptoException Error al estar el archivo da&ntilde;ado.
	 */
	public static Concesionario abrir(File archivo) 
			throws FileNotFoundException, ClassNotFoundException, IOException, FicheroCorruptoException {
		setModificado(false); // Cambiamos su estado a no modificado
		setArchivo(archivo);
		return Fichero.abrir(archivo);
	}
	
	/**
	 * Guarda un archivo, 
	 * cambia su estado a no modificado y 
	 * reemplaza el archivo actual por el guardado.
	 * 
	 * @param archivo Fichero donde se guarda.
	 * 
	 * @throws IOException Error por fallo o interrupci&oacute;n de entrada o salida de datos.
	 */
	public static void guardar(File archivo, Concesionario concesionario) throws IOException {
		Fichero.guardar(archivo, General.concesionario);
		setModificado(false); // Cambiamos su estado a no modificado
		//setArchivo(archivo);
	}

	

}
