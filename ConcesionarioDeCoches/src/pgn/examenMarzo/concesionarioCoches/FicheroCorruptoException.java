package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error que se produce 
 * cuando el fichero est&aacute; da&ntilde;ado.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class FicheroCorruptoException extends Exception {
	
	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -7200408258119267483L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque el archivo est&aacute; da&ntilde;ado.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public FicheroCorruptoException (String mensaje) {
		super(mensaje);
	}
	
}
