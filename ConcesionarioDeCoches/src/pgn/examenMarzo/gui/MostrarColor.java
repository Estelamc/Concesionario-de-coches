package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import concesionario.Coche;
import concesionario.Color;
import concesionario.Concesionario;
import concesionario.General;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * Muestra todos los coches del concesionario de un mismo color.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class MostrarColor extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 2435359341555777067L;
	
	/**
	 * Bot&oacute;n Anterior.
	 */
	private JButton botonAnterior = new JButton("<");
	
	/**
	 * Bot&oacute;n Siguiente.
	 */
	private JButton botonSiguiente = new JButton(">");
	
	/**
	 * Bot&oacute;n Buscar.
	 */
	private JButton botonBuscar = new JButton("Buscar");

	/**
	 * Lista de coches de un mismo color.
	 */
	private Concesionario cochesMismoColor = new Concesionario();
	
	/**
	 * &Iacute;ndice identificador del coche para 
	 * tener una referencia para saber si podemos
	 * seguir adelante o para atrás o ya no hay m&aacute;s
	 * coches que mostrar. 
	 * (hace referencia a la posici&oacute;n del coche en la lista de coches de un mismo color)
	 */
	private int indiceCoche = 0;

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			MostrarColor dialog = new MostrarColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public MostrarColor() {
		super();
		setTitle("Buscar por color");
		botonOK.setEnabled(false);
		setModal(true);
		setResizable(false);
		
		// Ponemos todos los campos no editables
		matriculaCampo.setEnabled(false);
		modeloComboBox.setEnabled(false);
		marcaComboBox.setEnabled(false);
		botonOK.setVisible(false);
		botonSiguiente.setEnabled(false);
		botonAnterior.setEnabled(false);
		
		// Añadir acción del botón buscar
		
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				buscar();
			}
		});
		botonesPanel.add(botonBuscar);
		
		// Botón Anterior
		botonesPanel.add(botonAnterior);			
		botonAnterior.addActionListener(new ActionListener() {
			// Añade una acción al botón Anterior (<)
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
						
		botonSiguiente.addActionListener(new ActionListener() {
			// Añade una acción al botón Siguiente (>)
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
		
		// Botón Siguiente
		botonesPanel.add(botonSiguiente);		
		botonesPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{botonAnterior, 
				botonSiguiente, botonOK, botonSalir}));
	}
	
	/**
	 * Muestra el coche siguiente.
	 */
	private void mostrarSiguiente() {
		mostrarCoche(cochesMismoColor.get(++indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Muestra el coche anterior.
	 */
	private void mostrarAnterior() {
		mostrarCoche(cochesMismoColor.get(--indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Muestra el coche
	 * 
	 * @param coche Coche del color seleccionado 
	 * (de la lista de coches de un mismo color)
	 */
	private void mostrarCoche(Coche coche) {
		matriculaCampo.setText(coche.getMatricula());
		switch (coche.getColor()) {
			case PLATA:
				colorPlata.setSelected(true);
				break;
			case ROJO:
				colorRojo.setSelected(true);
				break;
			case AZUL:
				colorAzul.setSelected(true);
		}
		marcaComboBox.addItem(coche.getModelo().getMarca());
		marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
		modeloComboBox.addItem(coche.getModelo());
		modeloComboBox.setSelectedItem(coche.getModelo());
		panelContenedor.setLayout(null);
				
	}
	
	/**
	 * Vuelve a empezar desde cero.
	 */
	void actualizar() {
		if (cochesMismoColor.size() == 0) {
			return;
		}
		indiceCoche = 0;
		mostrarCoche(cochesMismoColor.get(indiceCoche));
		comprobarBotones();		
	}
	
	/**
	 * Comprueba que los botones han de estar activos
	 * (si se ha llegado al final o al principio, no sigue)
	 */
	private void comprobarBotones() {
		if (cochesMismoColor.get(indiceCoche + 1) == null)
			botonSiguiente.setEnabled(false);
		else
			botonSiguiente.setEnabled(true);

		if (cochesMismoColor.get(indiceCoche - 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonAnterior.setEnabled(true);
	}
	
	/**
	 * Devuelve el color seleccionado.
	 * 
	 * @return Color elegido.
	 */
	private Color getColor() { // Con un switch también hubiera funcionado
		if (colorAzul.isSelected())
			return concesionario.Color.AZUL;
		else if (colorPlata.isSelected())
			return concesionario.Color.PLATA;
		else if (colorRojo.isSelected())
			return concesionario.Color.ROJO;
		else
			return null;
	}
	
	/**
	 * Busca los coches de un mismo color.
	 */
	private void buscar() {
		cochesMismoColor.setConcesionario(General.concesionario.getCochesColor(getColor()));
		mostrarCoche(cochesMismoColor.get(indiceCoche));
		comprobarBotones();
	}

}