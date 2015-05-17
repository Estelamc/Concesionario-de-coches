package concesionario;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Crea y controla un coche.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Coche implements Serializable {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 4634929412608767221L;
	
	/**
	 * Matr&iacute;cula del coche, que es un identificador inequ&iacute;voco de
	 * &eacute;ste. 
	 * 
	 * Es &uacute;nica para cada coche creado, de modo que no puede haber 
	 * m&aacute; de un coche con la misma matr&iacute;cula.
	 */
	private String matricula;
	
	/**
	 * Color del coche.
	 */
	private Color color;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	
	/**
	 * Patr&oacute;n para comprobar que la matr&iacute;cula es v&aacute;lida.
	 * 
	 * Para que sea v&aacute;lida tendr&aacute; cuatro n&uacute;meros, 
	 * seguidos de un &quot;-&quot; o no y a continuaci&oacute;n contendr&aacute;
	 * tres letras de la B a la Z, quedando exclu&iacute;das las letras A, Q, E, I, O, U.
	 * No permite letras min&uacute;sculas, ni tildes, ni caracteres especiales a parte del
	 * &quot;-&quot.
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");


	// ----------------------------------- NUESTROS MÉTODOS ----------------------------------- \\
	
	/**
	 * Constructor para crear un coche.
	 *
	 * @param matricula Matr&iacute;cula del coche.
	 * @param color Color del coche.
	 * @param modelo Modelo del coche.
	 * 
	 * @throws MatriculaNoValidaException Error por matr&iacute;cula incorrecta.
	 * @throws ColorNoValidoException Error por color incorrecto.
	 * @throws ModeloNoValidoException Error por modelo incorrecto.
	 */
	public Coche(String matricula, Color color, Modelo modelo) 
			throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Constructor que crea un coche s&oacute;lo con la matr&iacute;cula.
	 * 
	 * @param matricula Matr&iacute;cula del coche.
	 * 
	 * @throws MatriculaNoValidaException Error por matr&iacute;cula incorrecta.
	 */
	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Devuelve la matr&iacute;cula del coche.
	 * 
	 * @return Matr&iacute;cula del coche.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Modifica la matr&iacute;cula del coche. 
	 *  
	 * @param matricula Matr&iacute;cula del coche.
	 * @throws MatriculaNoValidaException Error por matr&iacute;cula incorrecta.
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (matriculaEsValida(matricula))
			this.matricula = matricula;
		else // Si la matrícula no coincide con el patrón especificado
			throw new MatriculaNoValidaException("La matrícula no es válida.");
	}
	
	/**
	 * Comprueba si la matr&iacute;cula es v&aacute;lida.
	 * 
	 * @param matricula Matr&iacute;cula del coche.
	 * 
	 * @return True si la matr&iacute;cula es v&aacute;lida o false sino.
	 */
	public static boolean matriculaEsValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}	

	/**
	 * Devuelve el color del coche.
	 * 
	 * @return Color del coche.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Modifica el color del coche.
	 * 
	 * @param color Color del coche.
	 * 
	 * @throws ColorNoValidoException Error por color incorrecto.
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color != null)
			this.color = color;
		else // Si el color es nulo
			throw new ColorNoValidoException("El color no es válido");
	}
	
	/**
	 * Devuelve el modelo del coche.
	 *  
	 * @return Modelo del coche.
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * Modifica el modelo del coche.
	 * 
	 * @param modelo Modelo del coche.
	 * 
	 * @throws ModeloNoValidoException Error por modelo incorrecto.
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo != null)
			this.modelo = modelo;
		else // Si el modelo es nulo
			throw new ModeloNoValidoException("El modelo no es válido");
	}

	/**
	 * Calcula un valor num&eacute;rico &uacute;nico que definie a un coche 
	 * en base a su matr&iacute;cula.
	 * 
	 * @return Valor n&uacute;merico &uacute;nico para un coche 
	 * de matr&iacute;cula concreta.
	 */
	@Override
	public int hashCode() { // Se usa en el remove() de forma automática --> En el contains()
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara si dos coches tienen la misma matr&iacute;cula.
	 * 
	 * @param obj Objeto a comparar.
	 * 
	 * @return True si los coches coinciden en la matr&iacute;cula o false sino.
	 */
	@Override
	public boolean equals(Object obj) { // Se usa en el contains() de forma --> En el remove()
										// automática
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Muestra el coche.
	 * 
	 * @return El coche.
	 */
	@Override
	public String toString() {
		return "\nCoche de matricula " + matricula + ", color " + color
				+ ", modelo " + modelo + " y marca " +modelo.getMarca()+".";
	}

}
