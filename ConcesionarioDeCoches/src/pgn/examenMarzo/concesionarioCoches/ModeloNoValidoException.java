package concesionario;

/**
 * Crea la excepci&oacute;n que controla el error 
 * que se produce cuando el modelo no es v&aacute;lido.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class ModeloNoValidoException extends Exception {

	/**
	 * Identificador de versi&oacute;n de serie.
	 */
	private static final long serialVersionUID = -2554304430107361975L;

	/**
	 * Constructor que crea la excepci&oacute;n 
	 * causada porque el modelo es incorrecto.
	 * 
	 * @param mensaje Texto informativo sobre la excepci&oacute;n.
	 */
	public ModeloNoValidoException(String mensaje) {
		super(mensaje);
	}

}
