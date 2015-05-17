package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import concesionario.Coche;
import concesionario.CocheNoExisteException;
import concesionario.General;
import concesionario.Gestion;
import concesionario.MatriculaNoValidaException;

/**
 * Borra un coche del concesionario.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Baja extends VentanaPadre {
	
	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 702037198030801059L;
	
	// ----------------------------------- NUESTRA APLICACI�N ----------------------------------- \\

	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Baja dialog = new Baja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public Baja() {
		super();
		marcaComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		colorRojo.setEnabled(false);
		colorPlata.setEnabled(false);
		colorAzul.setEnabled(false);
		setResizable(false);
		setModal(true);
		setTitle("Baja"); // Se modifica el t�tulo de la ventana
		botonOK.setText("Eliminar"); // Se modifica el texto del bot�n OK
		
		// Acci�n cuando se est� dentro del campo de la matr�cula
		
		matriculaCampo.addFocusListener(new FocusAdapter() {
			// Mientras se escriba en el campo de matr�cula, la letra ser� de color negro
			@Override
			public void focusGained(FocusEvent arg0) {
				matriculaCampo.setForeground(java.awt.Color.BLACK);
			}
			// Si al salir del campo de matr�cula �sta es inv�lida, se pone la letra de color rojo
			@Override
			public void focusLost(FocusEvent e) {
				if(!Coche.matriculaEsValida(matriculaCampo.getText()))
					matriculaCampo.setForeground(java.awt.Color.RED);
			}
		});
		
		
		// A�ade una acci�n al bot�n A�adir
		
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();  
			}
		});
	}
	
	/**
	 * Elimina un coches del concesionario.
	 */
	private void baja() {
		
		try {
			General.concesionario.eliminar(matriculaCampo.getText());
			Gestion.setModificado(true);
			JOptionPane.showMessageDialog(panelContenedor, "Coche eliminado con �xito.", "Acci�n realizada", JOptionPane.INFORMATION_MESSAGE);
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}

