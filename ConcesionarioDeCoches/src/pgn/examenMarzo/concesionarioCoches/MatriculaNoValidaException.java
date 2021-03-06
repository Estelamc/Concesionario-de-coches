package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error que se produce 
 * cuando la matr&iacute;cula no es v&aacute;lida.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class MatriculaNoValidaException extends Exception {

	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = 7848665807550894307L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque la matr&iacute;cula es incorrecta.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public MatriculaNoValidaException(String mensaje) {
		super(mensaje);
	}

}
