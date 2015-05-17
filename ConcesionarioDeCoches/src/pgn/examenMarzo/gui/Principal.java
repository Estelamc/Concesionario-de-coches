package gui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import concesionario.Fichero;
import concesionario.FicheroCorruptoException;
import concesionario.General;
import concesionario.Gestion;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

/**
 * Ventana principal que gestiona el programa.
 * 
 * @author Estela Mu&ntilde;oz Cord&oacute;n
 * @version 1.0
 *
 */

public class Principal {

	// ----------------------------------- NUESTROS CAMPOS ----------------------------------- \\
	
	/**
	 * Marco principal que contiene todos los elementos de la ventana.
	 */
	private JFrame ventanaPrincipal = new JFrame();
		
	/**
	 * Panel para contener elementos.
	 */
	private JPanel panelContenedor;
	
	/**
	 * Barra de men&uacute;.
	 */
	private JMenuBar menuBarra = new JMenuBar();
	
	/**
	 * Men&uacute; Ficheros.
	 */
	private JMenu menuFicheros = new JMenu("Ficheros");
	
	/**
	 * Submen&uacute; Abrir.
	 */
	private JMenuItem menuAbrir = new JMenuItem("Abrir");
	
	/**
	 * Submen&uacute; Nuevo.
	 */
	private JMenuItem menuNuevo = new JMenuItem("Nuevo");
	
	/**
	 * Subme&uacute; Guardar.
	 */
	private JMenuItem menuGuardar = new JMenuItem("Guardar");
	
	/**
	 * Submen&uacute; Guardar como.
	 */
	private JMenuItem menuGuardarComo = new JMenuItem("Guardar como...");
	
	/**
	 * L&iacute;nea que separa el submen&uacute; Salir del resto.
	 */
	private JSeparator separador = new JSeparator();
	
	/**
	 * Submen&uacute; Salir.
	 */
	private JMenuItem menuSalir = new JMenuItem("Salir");
	
	/**
	 * Men&uacute; Coche.
	 */
	private JMenu menuCoche = new JMenu("Coche");
	
	/**
	 * Submen&uacute; Alta.
	 */
	private JMenuItem menuAlta = new JMenuItem("Alta");
	
	/**
	 * Submen&uacute; Baja.
	 */
	private JMenuItem menuBaja = new JMenuItem("Baja");
	
	/**
	 * Submen&uacute; Buscar.
	 */
	private JMenuItem menuBuscar = new JMenuItem("Buscar por la matr\u00EDcula");
	
	/**
	 * Submen&uacute; Buscar por color.
	 */
	private JMenuItem menuBuscarColor = new JMenuItem("Buscar por el color");
	
	/**
	 * Submen&uacute; Mostrar Stock.
	 */
	private JMenuItem menuMostrar = new JMenuItem("Mostrar Stock");
	
	/**
	 * Submen&uacute; Stock Total.
	 */
	private JMenuItem menuStock = new JMenuItem("Stock Total");
	
	/**
	 * Men&uacute; Ayuda.
	 */
	JMenu menuAyuda = new JMenu("Ayuda");

	/**
	 * Submen&uacute; Ver Ayuda.
	 */
	JMenuItem menuVerAyuda = new JMenuItem("Ver Ayuda");

	/**
	 * Submen&uacute; Acerca de.
	 */
	JMenuItem menuAcercaDe = new JMenuItem("Acerca de...");
	
	/**
	 * Ventana para gestionar archivos.
	 */
	private JFileChooser ventanaSeleccion = new JFileChooser();
	
	/**
	 * Filtro para seleccionar archivos de tipo objeto.
	 */
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos OBJ", "obj");
	
	/**
	 * Imagen para el fondo de la ventana.
	 */
	private ImageIcon icon = crearImagen("imagenes/coche.png","Concesionario de coches");
	
	/**
	 * Etiqueta que contiene la imagen.
	 */
	private JLabel imagen = new JLabel("", icon, JLabel.CENTER);
		
	
	// ----------------------------------- NUESTRA APLICACIÓN ----------------------------------- \\
	
	/**
	 * Carga la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la apliaci&oacute;n.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos del marco principal.
	 */
	private void initialize() {
		
		// Quitamos todos los filtros del JFileChooser y añadimos el filtro para "obj"
		ventanaSeleccion.setAcceptAllFileFilterUsed(false);
		ventanaSeleccion.setFileFilter(filtro);
		ventanaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/gui/imagenes/cocheVentana.png")));
		
		// ----------------------------------- Ventana Principal ----------------------------------- \\
		
		ventanaPrincipal.setResizable(false); // No se le puede cambiar el tamaño
		ventanaPrincipal.setTitle(General.concesionario.getName() + " - "); // Le ponemos título a la ventana
		ventanaPrincipal.setBounds(100, 100, 450, 300); // Dimesiones y ubicación de la ventana
		ventanaPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Botón x que no haga nada por defecto
		
		// Añadimos una acción al cerrar con la x, que es que pregunte si queremos guardar en caso de haber cambios
		
		WindowListener cerrarConX = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(Gestion.getModificado()==true) { 		
					if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", 
							"Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
						guardar();	// SI - GUARDA / CANCEL - NADA= Sale
				}
				System.exit(0);
			}
		};
		ventanaPrincipal.addWindowListener(cerrarConX);
		
		ventanaPrincipal.setJMenuBar(menuBarra); // Añadimos la barra de menú
		ventanaPrincipal.getContentPane().setLayout(null); 
	
		// PARA AÑADIR UNA IMAGEN a la ventana		
		imagen.setBounds(10, 11, 424, 227);
		ventanaPrincipal.getContentPane().add(imagen);
		
	
		// ----------------------------------- Menú Ficheros ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuBarra.add(menuFicheros); // Añadimos Ficheros a la barra de menús
		menuNuevo.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/file_obj.gif")));
		menuFicheros.add(menuNuevo);
		menuAbrir.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/open.gif")));
		menuFicheros.add(menuAbrir);
		menuGuardar.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/guardar.png")));
		menuFicheros.add(menuGuardar);
		menuGuardarComo.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/guardar.png")));
		menuFicheros.add(menuGuardarComo);
		menuFicheros.add(separador); // ---- Añadir Separador ---- \\
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/salir.gif")));
		menuFicheros.add(menuSalir);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuFicheros.setMnemonic('F'); // Le ponemos una tecla de acceso rápido
		menuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); 
		menuNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		menuGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		// ---- Añadir Acciones ---- \\
				
		menuAbrir.addActionListener(new ActionListener() { // Abrir archivo
			public void actionPerformed(ActionEvent e) {
					abrir();
				}
		});
		menuNuevo.addActionListener(new ActionListener() { // Crear archivo nuevo
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		menuGuardar.addActionListener(new ActionListener() { // Guardar archivo
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		menuGuardarComo.addActionListener(new ActionListener() { // Guardar como
			public void actionPerformed(ActionEvent e) { // NOTA: AÑADIR EL CASO DE QUE EXISTA !!!!
					guardarComo();
			}
		});		
		menuSalir.addActionListener(new ActionListener() { // Salir
			// Sale de la aplicaci&oacute;n
			public void actionPerformed(ActionEvent e) {
				if(Gestion.getModificado()==true) { 		
					if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", 
							"Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
						guardar();	// SI - GUARDA / CANCEL - NADA=ABRE Y EL NUEVO MACHACA
				}
				System.exit(0);
			}
		});
		
		
		// ----------------------------------- Menú Coche ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\

		menuBarra.add(menuCoche);
		menuAlta.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/alta.gif")));
		menuCoche.add(menuAlta);
		menuBaja.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/baja.gif")));
		menuCoche.add(menuBaja);
		menuBuscar.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/buscar.gif")));
		menuCoche.add(menuBuscar);
		menuBuscarColor.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/buscar.gif")));
		menuCoche.add(menuBuscarColor);
		menuMostrar.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/mostrar.gif")));
		menuCoche.add(menuMostrar);
		menuStock.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/total.gif")));
		menuCoche.add(menuStock);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuCoche.setMnemonic('C');
		menuAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		menuBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBuscarColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menuMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuStock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		// ---- Añadir Acciones ---- \\		
		
		menuAlta.addActionListener(new ActionListener() { // Abre la ventana de Alta
			public void actionPerformed(ActionEvent e) {
				Alta alta = new Alta();
				alta.setVisible(true);
			}
		});
		menuBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana de Baja
				if(General.concesionario.size() != 0) {
					Baja baja = new Baja();
					baja.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El concesionario está vacío. \nAñade coches para poder eliminarlos.",
							"Concesionario vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		menuBuscar.addActionListener(new ActionListener() { // Abre la ventana de Buscar por Matrícula
			public void actionPerformed(ActionEvent e) {
				if(General.concesionario.size() != 0) {
					BuscarPorMatricula buscar = new BuscarPorMatricula();
					buscar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El concesionario está vacío. \nAñade coches para poder buscarlos.",
							"Concesionario vacío", JOptionPane.ERROR_MESSAGE);
			}
		});		
		menuBuscarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana de Buscar coche por el color
				if(General.concesionario.size() != 0) {
					MostrarColor buscarColor = new MostrarColor();
					buscarColor.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El concesionario está vacío. \nAñade coches para poder buscarlos.",
							"Concesionario vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		menuMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Mostrar Concesionario
				if(General.concesionario.size() != 0) {
					MostrarStock mostrar = new MostrarStock();
					mostrar.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"El concesionario está vacío. \nAñade coches para poder verlos.",
							"Concesionario vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		menuStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana de Stock total disponible
				if(General.concesionario.size() != 0) {
					StockTotal stock = new StockTotal();
					stock.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(panelContenedor, 
							"No hay coches en el concesionario. \nAñade coches para poder saber cuántos hay.",
							"Concesionario vacío", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		// ----------------------------------- Menú Ayuda ----------------------------------- \\
		
		// ---- Añadir Menús ---- \\
		
		menuBarra.add(menuAyuda);
		menuVerAyuda.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/ayuda.gif")));
		menuAyuda.add(menuVerAyuda);
		menuAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/gui/imagenes/producto.gif")));
		menuAyuda.add(menuAcercaDe);
		
		// ---- Añadir Teclas de Acceso Rápido ---- \\
		
		menuAyuda.setMnemonic('A');
		menuVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		
		// ---- Añadir Acciones ---- \\
			
		menuVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Ayuda
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		menuAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Abre la ventana Acerca de
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		
	}

	/**
	 * Abre un archivo.
	 */
	private void abrir() {
		if(Gestion.getModificado()==true) { 		
			if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", "Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
				guardar();	// SI - GUARDA / CANCEL - NADA=ABRE Y EL NUEVO MACHACA
		}
		
		if (ventanaSeleccion.showOpenDialog(panelContenedor) == JFileChooser.APPROVE_OPTION) {
			Gestion.setArchivo(ventanaSeleccion.getSelectedFile());
			try {
				General.concesionario = Gestion.abrir(Gestion.getArchivo());
				ventanaPrincipal.setTitle(General.concesionario.getName()+ " - " + Gestion.getArchivo().getName());
				JOptionPane.showMessageDialog(panelContenedor, "Archivo abierto con éxito.", "Abierto", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException | IOException | FicheroCorruptoException e) {
				JOptionPane.showMessageDialog(panelContenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Guarda el concesionario en un archivo con un nombre especificado 
	 * y en el lugar del ordenador indicado.
	 */
	private void guardarComo() {
		if (ventanaSeleccion.showSaveDialog(panelContenedor) == JFileChooser.APPROVE_OPTION) {
			Gestion.setArchivo(ventanaSeleccion.getSelectedFile());
			if(Fichero.siArchivoExiste(Gestion.getArchivo())) { // Si existe, pregunto qué hacer
				if(JOptionPane.showConfirmDialog(panelContenedor, "El archivo ya existe. ¿Desea reemplazarlo?", "Confirmar Guardar como", JOptionPane.OK_CANCEL_OPTION)==0)
					guardar();	// SI - GUARDA / NO o CANCEL - NADA
			}
			else { // Si no existe, me lo sobreescribe
				guardar();
			}	
		}
	}
	
	/**
	 * Sobreescribe el archivo que tiene el concesionario.
	 */
	protected void guardar() {
		if(Gestion.getArchivo()==null | Gestion.getArchivo().getName()=="Sin_titulo.obj") { 		
			guardarComo();
		}
		
		else {
			try {
				Gestion.guardar(Gestion.getArchivo(), General.concesionario);
				ventanaPrincipal.setTitle(General.concesionario.getName() + " - " + Gestion.getArchivo().getName());
				JOptionPane.showMessageDialog(panelContenedor, "Archivo guardado con éxito.", "Guardado", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(panelContenedor, "No se pudo guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void nuevo() {
		if(Gestion.getModificado()==true) { 		
			if(JOptionPane.showConfirmDialog(panelContenedor, "¿Desea guardar los cambios realizados?", "Hay cambios sin guardar", JOptionPane.OK_CANCEL_OPTION)==0)
				guardar();	// SI - GUARDA / CANCEL - NADA=ABRE Y EL NUEVO MACHACA
		}
		
		try {
			Gestion.nuevo(); 
			ventanaPrincipal.setTitle(General.concesionario.getName() + " - " + Gestion.getArchivo().getName()); 
			JOptionPane.showMessageDialog(panelContenedor, "Archivo creado con éxito.", "Creado", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(panelContenedor, "No se pudo crear un archivo nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Pone una imagen en la ventana.
	 * 
	 * @param url Ruta de la Imagen.
	 * @param descripcion Texto explicativo de la imagen.
	 * @return La imagen.
	 */
	private ImageIcon crearImagen(String url, String descripcion) {
        java.net.URL imagenUrl = getClass().getResource(url);
        if (imagenUrl != null) {
            return new ImageIcon(imagenUrl, descripcion);
        } else {
            return null;
        }
    }
}
