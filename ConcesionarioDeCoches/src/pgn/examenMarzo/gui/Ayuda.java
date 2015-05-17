package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Contiene informaci&oacute;n que puede servir de ayuda para el manejo del programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Ayuda extends JDialog {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Identificador de versi&oacute;n.
	 */
	private static final long serialVersionUID = 7496760684131528000L;
	
	/**
	 * Panel contenedor que contiene los elementos de la ventana.
	 */
	private final JPanel panelContenedor = new JPanel();
	
	/**
	 * Etiqueta para la Alta.
	 */
	JLabel etiquetaAlta = new JLabel("Alta");
	
	/**
	 * Etiqueta para la Baja.
	 */
	JLabel etiquetaBaja = new JLabel("Baja");
	
	/**
	 * Etiqueta para Buscar por matr&iacute;cula.
	 */
	JLabel etiquetaBuscar = new JLabel("Buscar por matr\u00EDcula");
	
	/**
	 * Etiqueta para Buscar po color.
	 */
	JLabel etiquetaBuscarColor = new JLabel("Buscar por color");
	
	/**
	 * Etiqueta para Mostrar.
	 */
	JLabel etiquetaMostrar = new JLabel("Mostrar stock");
	
	/**
	 * Etiqueta para el Stock.
	 */
	JLabel etiquetaStock = new JLabel("Stock total");
	
	/**
	 * Panel de texto para A&ntilde;adir un coche.
	 */
	JTextPane textoAlta = new JTextPane();
	
	/**
	 * Panel de texto para Eliminar un coche.
	 */
	JTextPane textoBaja = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un coche.
	 */
	JTextPane textoBuscar = new JTextPane();
	
	/**
	 * Panel de texto para Buscar un coche por color.
	 */
	JTextPane textoBuscarColor = new JTextPane();
	
	/**
	 * Panel de texto para mostrar el concesionario.
	 */
	JTextPane textoMostrar = new JTextPane();	
	
	/**
	 * Panel de texto para la cantidad de coches.
	 */
	JTextPane textoStock = new JTextPane();
		
	/**
	 * Bot&oacute;n OK.
	 */
	private JButton okButton = new JButton("OK");

	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el di&aacute;logo.
	 */
	public Ayuda() {
		
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 533, 570);
		getContentPane().setLayout(new BorderLayout());
		panelContenedor.setBackground(SystemColor.control);
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(null);
		
		// Etiqueta Alta
		
		etiquetaAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaAlta.setForeground(new Color(102, 51, 102));
		etiquetaAlta.setBounds(39, 26, 70, 20);
		panelContenedor.add(etiquetaAlta);
		
		// Etiqueta Baja
				
		etiquetaBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaBaja.setForeground(new Color(102, 51, 102));
		etiquetaBaja.setBounds(39, 156, 46, 14);
		panelContenedor.add(etiquetaBaja);
		
		// Etiqueta Buscar por matrícula
				
		etiquetaBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaBuscar.setForeground(new Color(102, 51, 102));
		etiquetaBuscar.setBounds(39, 231, 165, 14);
		panelContenedor.add(etiquetaBuscar);
		
		// Etiqueta Buscar por color
				
		etiquetaBuscarColor.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaBuscarColor.setForeground(new Color(102, 51, 102));
		etiquetaBuscarColor.setBounds(39, 294, 141, 14);
		panelContenedor.add(etiquetaBuscarColor);
		
		// Etiqueta Mostrar Stock
				
		etiquetaMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaMostrar.setForeground(new Color(102, 51, 102));
		etiquetaMostrar.setBounds(39, 349, 200, 14);
		panelContenedor.add(etiquetaMostrar);
		
		// Etiqueta Stock Total
				
		etiquetaStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		etiquetaStock.setForeground(new Color(102, 51, 102));
		etiquetaStock.setBounds(39, 405, 121, 14);
		panelContenedor.add(etiquetaStock);
		
		// Panel de texto para Añadir Coche
				
		textoAlta.setBackground(SystemColor.control);
		textoAlta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoAlta.setText("A\u00F1ade un coche al concesionario, seleccionando cu\u00E1l ser\u00E1 su color, su modelo, \r\nsu marca y su matr\u00EDcula. Para poder a\u00F1adirlo la matr\u00EDcula deber ser v\u00E1lida.\r\n\r\nLa matr\u00EDcula ser\u00E1 \u00FAnica, por lo que no podr\u00E1 haber otro coche con la misma matr\u00EDcula. \r\nPara que sea v\u00E1lida deber\u00E1 constar de cuatro d\u00EDgitos, seguidos de tres letras de la A a la Z. Entre los d\u00EDgitos y las letr\u00E1s podr\u00E1 haber un gui\u00F3n.");
		textoAlta.setBounds(39, 58, 452, 88);
		panelContenedor.add(textoAlta);
		
		// Panel de texto para Eliminar Coche
				
		textoBaja.setBackground(SystemColor.control);
		textoBaja.setForeground(Color.BLACK);
		textoBaja.setText("Elimina un coche del concesionario cuando coincide la matr\u00EDcula introducida con uno existente.");
		textoBaja.setBounds(39, 182, 452, 34);
		panelContenedor.add(textoBaja);
		
		// Panel de texto para Buscar un coche
				
		textoBuscar.setBackground(SystemColor.control);
		textoBuscar.setForeground(Color.BLACK);
		textoBuscar.setText("Busca un coche cuya matr\u00EDcula coincida con la introducida y lo muestra.");
		textoBuscar.setBounds(39, 257, 452, 27);
		panelContenedor.add(textoBuscar);
		
		// Panel de texto para Buscar coches de un color
		
		textoBuscarColor.setBackground(SystemColor.control);
		textoBuscarColor.setForeground(Color.BLACK);
		textoBuscarColor.setText("Busca todos los coches que tengan el color elegido y los muestra.");
		textoBuscarColor.setBounds(39, 319, 452, 20);
		panelContenedor.add(textoBuscarColor);
		
		// Panel de texto para Mostrar todos los coches
		
		textoMostrar.setBackground(SystemColor.control);
		textoMostrar.setForeground(Color.BLACK);
		textoMostrar.setText("Muestra todos los coches existentes en el concesionario.");
		textoMostrar.setBounds(39, 368, 452, 27);
		panelContenedor.add(textoMostrar);
		
		// Panel de texto para Mostrar cantidad de coches
		
		textoStock.setBackground(SystemColor.control);
		textoStock.setForeground(Color.BLACK);
		textoStock.setText("Muestra la cantidad total de coches que hay en el concesionario.");
		textoStock.setBounds(39, 429, 452, 27);
		panelContenedor.add(textoStock);
		{
			// Botón OK
			
			okButton.addActionListener(new ActionListener() {
				// Se sale de la ventana
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			okButton.setBounds(223, 483, 70, 27);
			panelContenedor.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
}
