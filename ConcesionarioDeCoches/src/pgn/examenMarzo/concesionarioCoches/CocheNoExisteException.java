package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error 
 * que se produce cuando el coche no existe.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class CocheNoExisteException extends Exception {

	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 5985048955636425205L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque el coche no exista.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public CocheNoExisteException(String mensaje) {
		super(mensaje);
	}
}
