package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error 
 * que se produce cuando el color no es v&aacute;lido.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ColorNoValidoException extends Exception {

	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 2124839698275682650L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque el color es incorrecto.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public ColorNoValidoException(String mensaje) {
		super(mensaje);
	}

}
