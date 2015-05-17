package concesionario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Gestiona el concesionario de coches.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Concesionario implements Serializable{
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -5042099624350455082L;
	
	/**
	 * Lista de coches almacenados en el concesionario (almac&eacute;n).
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	
	/**
	 * Nombre del concesionario.
	 */
	private final String nombre = "IES Gran Capit�n";
	
	
	// ----------------------------------- NUESTROS M�TODOS ----------------------------------- \\

	/**
	 * A&ntilde;ade un coche al almac&eacute;n del concesionario.
	 * 
	 * @param matricula Matr&iacute;cula del coche.
	 * @param color Color del coche.
	 * @param modelo Modelo del coche.
	 * 
	 * @return True si a&ntilde;ade el coche o false si es nulo o ya existe.
	 * 
	 * @throws ModeloNoValidoException Error por modelo incorrecto.
	 * @throws ColorNoValidoException Error por color incorrecto.
	 * @throws CocheYaExisteException Error porque el coche ya existe.
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException, CocheYaExisteException {
		Coche coche = new Coche(matricula, color, modelo); // Se crea un coche
		if (almacen.contains(coche)) // Si ya lo contiene, crea la excepci�n
			throw new CocheYaExisteException("El coche ya existe en el concesionario");
		else{ // Si no lo contiene
			return almacen.add(coche); // Devuelve el coche a�adido al concesionario
		}	
	}

	/**
	 * Elimina un coche del almac&eacute;n del concesionario.
	 * 
	 * @param matricula Matr&iacute;cula del coche.
	 * 
	 * @return True si lo elimina y false sino.
	 * 
	 * @throws MatriculaNoValidaException Error por matr&iacute;cula inv&aacute;lida.
	 * @throws CocheNoExisteException Error al no existir el coche.
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula); // Crea un coche con s�lo la matr�cula
		return almacen.remove(coche); // Borra el coche
	}

	/**
	 * Cantidad de coches que hay en el almac&eacute;n del concesionario.
	 * 
	 * @return Cantidad de coches del concesionario.
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve un coche del almac&eacute;n 
	 * busc&aacute;ndolo por su matr&iacute;cula
	 * (cuando coincida con la indicada).
	 * 
	 * @param matricula Matr&iacute;cula del coche a buscar.
	 * 
	 * @return Coche encontrado o null si no existe
	 * 
	 * @throws CocheNoExisteException Error porque el coche no existe.
	 * @throws MatriculaNoValidaException Error por matr&iacute;cula incorrecta.
	 */
	public Coche get(String matricula) throws CocheNoExisteException, MatriculaNoValidaException {
		Coche coche = new Coche(matricula); // Crea un coche s�lo con la matr�cula
		int index = almacen.indexOf(coche); // Posici�n del coche en el almac�n
		if (index != -1) // Cuando no es -1, desvuelve el coche que corresponde a esa posici�n del almac�n
			return almacen.get(index);
		else // Cuando el �ndice es igual a -1 (no existe), crea la excepci�n
			throw new CocheNoExisteException("El coche no existe.");
	}

	/**
	 * Devuelve los coches de un solo color concreto.
	 * 
	 * @param color Color del coche.
	 * 
	 * @return Coches del mismo color.
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		// Creamos nuestra lista de coches del mismo color
		ArrayList<Coche> cochesMismoColor = new ArrayList<Coche>(); 
		for (Coche coche : almacen) {
			if (coche.getColor() == color) // Cuando el color coincide, lo agrega a la lista
				cochesMismoColor.add(coche);
		}
		return cochesMismoColor;
	}
	
	/**
	 * Devuelve el coche de acuerdo a un &iacute;ndice.
	 * Concreamente, se refiere a la posici�n que ocupa
	 * en el almac&eacute;n.
	 * 
	 * @param indice &Iacute;ndice de posici&oacute;n.
	 * 
	 * @return El coche.
	 */
	public Coche get(int indice) {
		// Si el almac�n est� vac�o 
		if(almacen.isEmpty()) 
			return null;
		// Si es menor que 0 (-1 es que no lo contiene) o mayor que el tama�o del almac�n
		if(indice < 0 | indice > almacen.size()-1) 
			return null;
		return almacen.get(indice); // Si no ocurre nada de lo anterior, devuelve el coche
	}	
	
	/**
	 * Muestra el concesionario de coches.
	 * 
	 * @return El concesionario de coches.
	 */
	@Override
	public String toString() {
		return "El concesionario " + nombre + " dispone del almacen " + almacen;
	}

	/**
	 * Devuelve el nombre del concesionario.
	 * 
	 * @return El nombre del concesionario.
	 */
	public String getName() {
		return nombre;
	}

	/**
	 * Modifica el almac&eacute;n del concesionario.
	 * 
	 * @param concesionario El concesionario.
	 */
	public void setConcesionario(ArrayList<Coche> concesionario) {
		this.almacen = concesionario;
	}

}
