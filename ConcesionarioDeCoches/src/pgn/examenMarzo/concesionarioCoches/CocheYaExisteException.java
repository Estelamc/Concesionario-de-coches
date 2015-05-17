package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error 
 * que se produce cuando el coche ya existe.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class CocheYaExisteException extends Exception {

	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 3432698558289400146L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque el coche ya existe.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public CocheYaExisteException(String mensaje) {
		super(mensaje);
	}
}
