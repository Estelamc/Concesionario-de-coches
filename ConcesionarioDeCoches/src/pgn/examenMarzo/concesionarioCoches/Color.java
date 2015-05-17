package concesionario;

/**
 * Contiene los colores disponibles para un coche.
 *
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */
public enum Color {
	
	// ----------------------------------- NUESTRAS CONSTANTES/CAMPOS ----------------------------------- \\
	
	/**
	 * Color plateado.
	 */
	PLATA,
	/**
	 * Color rojo.
	 */
	ROJO,
	/**
	 * Color azul.
	 */
	AZUL;
	
	/**
	 * Array que contiene todos los colores.
	 */
	private static final Color[] VALUES = Color.values();


	// ----------------------------------- NUESTROS M�TODOS ----------------------------------- \\
	
	/**
	 * Devuelve las opciones del men&uacute;, 
	 * que contienen los colores disponibles para un coche.
	 * 
	 * @return Opciones del men&uacute;.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			// Cada color se va a�adiendo a una posici�n nueva del array de opcionesMenu
			opcionesMenu[i++] = color.name(); 
		}
		opcionesMenu[i] = "Salir"; // La posici�n 0 del array ser� para la opci�n de Salir
		return opcionesMenu;
	}

	/**
	 * Devuelve un array que contiene los colores.
	 * 
	 * @return Array de los colores.
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}
