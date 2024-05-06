package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

import javax.swing.plaf.FontUIResource;

import java.awt.*;

public class PnlCanciones extends JPanel {
    
    private JLabel fondo;
    private JTextField nombre;
    private JTextField artista;
    private JButton btnMenu, btnAgregarCancion, btnEliminarCancion;
    private JComboBox<String> cbCanciones;
    private JScrollPane scroll;
    private JTextArea artxtCanciones;
    
    public final String NOMBRE = "NOMBRE";
    public final String ARTISTA = "ARTISTA";
    public final String AGREGAR = "AGREGAR";
    public final String VOLVER = "VOLVER";
    public final String ELIMINAR = "ELIMINAR";
    
    
    
    public PnlCanciones() {
        setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes
        Color colorVerde = new Color(0x34, 0x44, 0x2C);
        // Configuramos el fondo
        fondo = new JLabel();
        fondo.setSize(1024, 768);
        ImageIcon x = new ImageIcon("img/6.png");
        ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
        fondo.setIcon(y);
        
        nombre = new JTextField();
        nombre.setBackground(Color.decode("#EA995A"));
        nombre.setBorder(null);
        nombre.setOpaque(true); // Hacemos el fondo transparente
        nombre.setBounds(265, 113, 510, 50); // Establecemos las coordenadas y tamaño
        nombre.setFont(new Font("Arial", Font.BOLD, 40)); // Ajustamos el tamaño de la fuente
        nombre.setForeground(colorVerde);
        nombre.setActionCommand(NOMBRE);
        
        artista = new JTextField();
        artista.setBackground(Color.decode("#EA995A"));
        artista.setBorder(null);
        artista.setOpaque(true); // Hacemos el fondo transparente
        artista.setBounds(265, 225, 510, 50); // Establecemos las coordenadas y tamaño
        artista.setFont(new Font("Arial", Font.BOLD, 40)); // Ajustamos el tamaño de la fuente
        artista.setForeground(colorVerde);
        artista.setActionCommand(ARTISTA);
        
        btnMenu = new JButton("");
        
        btnMenu.setPreferredSize(new Dimension(300, 300));
        btnMenu.setOpaque(false); // Hacer el botón transparente
        btnMenu.setContentAreaFilled(false); // No pintar el área del contenido
        btnMenu.setBorderPainted(false); // No pintar el borde
        btnMenu.setBounds(472, 670, 80, 80);
        btnMenu.setActionCommand(VOLVER);
        
        
       
        
        btnAgregarCancion = new JButton("");
        
        btnAgregarCancion.setPreferredSize(new Dimension(300, 300));
        btnAgregarCancion.setOpaque(false); // Hacer el botón transparente
        btnAgregarCancion.setContentAreaFilled(false); // No pintar el área del contenido
        btnAgregarCancion.setBorderPainted(false); // No pintar el borde
        btnAgregarCancion.setBounds(245, 610, 80, 80);
        btnAgregarCancion.setActionCommand(AGREGAR);
        
        btnEliminarCancion = new JButton("");
        
        btnEliminarCancion.setPreferredSize(new Dimension(300, 300));
        btnEliminarCancion.setOpaque(false); // Hacer el botón transparente
        btnEliminarCancion.setContentAreaFilled(false); // No pintar el área del contenido
        btnEliminarCancion.setBorderPainted(false); // No pintar el borde
        btnEliminarCancion.setBounds(705, 610, 80, 80);
        btnEliminarCancion.setActionCommand(ELIMINAR);
        

        
        artxtCanciones = new JTextArea(10, 60);
        artxtCanciones.setForeground(colorVerde); // Cambia el color de la fuente a verde
        artxtCanciones.setOpaque(false); // Mantiene el fondo transparente
        artxtCanciones.setFont(new Font("Arial", Font.ITALIC, 15)); // Cambia la fuente a Arial, estilo itálico, tamaño 15
        artxtCanciones.setEditable(false); // Hace que el área de texto no sea editable
        artxtCanciones.setMargin(new Insets(10, 10, 10, 10)); // Establece márgenes internos de 10 píxeles en todos los lados

		
		cbCanciones = new JComboBox<String>();
		cbCanciones.setOpaque(false);
	
		
		scroll = new JScrollPane(artxtCanciones);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
	        // Ajustar las coordenadas y el margen vertical del scroll y el combo box
	    int margenVertical = 20;
        cbCanciones.setBounds(165, 325 - margenVertical, 710, 30); // Colocar cbCanciones arriba
        scroll.setBounds(165, 340, 710, 240);
        
        add(scroll);
        add(cbCanciones);
        add(btnMenu);
        add(btnAgregarCancion);
        add(btnEliminarCancion);
        add(artista);
        add(nombre);
        add(fondo);

    }
    
   
    public String escogerArchivo() {
    	
    	
    	
    	 String rutaInicial = "C:\\Users\\sebas\\eclipse-workspace\\v6ProyectoEmisora.zip_expanded\\prueb\\Canciones";

         // Crear un nuevo objeto JFileChooser con la ruta inicial
         JFileChooser fileChooser = new JFileChooser(rutaInicial);

         // Filtrar solo archivos .mp3
         FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos MP3", "mp3");
         fileChooser.setFileFilter(filtro);

         // Mostrar el diálogo para elegir archivos y capturar el resultado en una variable
         int result = fileChooser.showDialog(null, "Elegir");
        
         
    	// Crear un nuevo objeto JFileChooser
    /*    JFileChooser vent = new JFileChooser("Elegir MP3");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos MP3", "mp3"); // Filtra solo archivos .mp3
        vent.setFileFilter(filtro);
        // Mostrar el diálogo para elegir archivos y capturar el resultado en una variable
       
        
        int result = vent.showDialog(null, "Elegir");
*/
        // Verificar el resultado del diálogo
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();  // Obtener el archivo seleccionado
            if (selectedFile != null) {  // Verificar si se ha seleccionado un archivo
                return selectedFile.toString();  // Devolver la ruta del archivo seleccionado
            }
        }
        return null;  // Devolver null si el usuario no selecciona un archivo o cancela el diálogo
    }
    
    
	public JComboBox<String> getCbCanciones() {
		return cbCanciones;
	}



	public void setCbCanciones(JComboBox<String> cbCanciones) {
		this.cbCanciones = cbCanciones;
	}



	public JScrollPane getScroll() {
		return scroll;
	}



	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}



	public JTextArea getArtxtCanciones() {
		return artxtCanciones;
	}



	public void setArtxtCanciones(JTextArea artxtCanciones) {
		this.artxtCanciones = artxtCanciones;
	}



	public JButton getBtnAgregarCancion() {
		return btnAgregarCancion;
	}


	public void setBtnAgregarCancion(JButton btnAgregarCancion) {
		this.btnAgregarCancion = btnAgregarCancion;
	}


	public JButton getBtnEliminarCancion() {
		return btnEliminarCancion;
	}


	public void setBtnEliminarCancion(JButton btnEliminarCancion) {
		this.btnEliminarCancion = btnEliminarCancion;
	}

	public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getArtista() {
        return artista;
    }

    public void setArtista(JTextField artista) {
        this.artista = artista;
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public void setBtnMenu(JButton btnMenu) {
        this.btnMenu = btnMenu;
    }

    
}