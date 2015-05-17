package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concesionario.Coche;
import concesionario.CocheYaExisteException;
import concesionario.Color;
import concesionario.ColorNoValidoException;
import concesionario.General;
import concesionario.Gestion;
import concesionario.MatriculaNoValidaException;
import concesionario.Modelo;
import concesionario.ModeloNoValidoException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * A&ntilde;ade un coche al concesionario.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Alta extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 1481094341191054859L;

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Alta dialog = new Alta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public Alta() {
		super();
		setModal(true);
		setResizable(false);
		setTitle("Alta"); // Se modifica el título de la ventana
		botonOK.setText("A\u00F1adir"); // Se modifica el texto del botón OK
		
		// Acción cuando se está dentro del campo de la matrícula
		
		matriculaCampo.addFocusListener(new FocusAdapter() {
			// Mientras se escriba en el campo de matrícula, la letra será de color negro
			@Override
			public void focusGained(FocusEvent arg0) {
				matriculaCampo.setForeground(java.awt.Color.BLACK);
			}
			// Si al salir del campo de matrícula ésta es inválida, se pone la letra de color rojo
			@Override
			public void focusLost(FocusEvent e) {
				if(!Coche.matriculaEsValida(matriculaCampo.getText()))
					matriculaCampo.setForeground(java.awt.Color.RED);
			}
		});
		
		// Añade una acción al botón Añadir
		
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir();
			}
		});
	}

	/**
	 * Devuelve el color seleccionado.
	 * 
	 * @return Color elegido.
	 */
	private Color getColor() {
		if (colorAzul.isSelected())
			return Color.AZUL;
		else if (colorPlata.isSelected())
			return Color.PLATA;
		else if (colorRojo.isSelected())
			return Color.ROJO;
		else
			return null;
	}
	
	/**
	 * A&ntilde;ade un coche al concesionario.
	 */
	private void annadir() {
		try {
			General.concesionario.annadir(matriculaCampo.getText(), getColor(), (Modelo) modeloComboBox.getSelectedItem());
			Gestion.setModificado(true);
			JOptionPane.showMessageDialog(panelContenedor, "Coche añadido con éxito.", "Acción realizada", 
					JOptionPane.INFORMATION_MESSAGE);
		} catch (MatriculaNoValidaException | ColorNoValidoException | ModeloNoValidoException | CocheYaExisteException e1) {
			JOptionPane.showMessageDialog(panelContenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
