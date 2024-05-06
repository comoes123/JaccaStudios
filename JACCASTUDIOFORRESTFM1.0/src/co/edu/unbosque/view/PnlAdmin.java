package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class PnlAdmin extends JPanel {
	private JTextArea nombre;
	private JTextArea tipo;
	private JTextArea genero;
	
    private JLabel fondo;
    private JTextArea artxtCanciones;
	private JTextArea artxtCancionesEmi;
	private JComboBox<String> cbCanciones;
	private JComboBox<String> cbCancionesEmi;
	private JButton btnAdd;
	private JButton btnEliminar;
	private JButton btnRegresar;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	
	private PnlNombreE nombreE;
	private PnlGenero generop;
	
	
    public final String ADD = "ADD";
    public final String ELIMINAR_C = "ELIMINAR_C";
    public final String REGRESAR = "REGRESAR";
    public PnlAdmin() {
        setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

        // Configuramos el fondo
        fondo = new JLabel();
        fondo.setSize(1024, 768);
        ImageIcon x = new ImageIcon("img/7.png");
        ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
        fondo.setIcon(y);
        
        Color colorNaranja = new Color(0xEB, 0x99, 0x5B);
        Color colorVerde = new Color(0x34, 0x44, 0x2C);
        
        nombreE = new PnlNombreE();
        nombre = new JTextArea();
        nombre.setEditable(false);
        //nombre.setBackground(Color.decode("#EA995A"));
        nombre.setText(nombreE.getTextField().getText());
        nombre.setBorder(null);
        nombre.setOpaque(true); // Hacemos el fondo transparente
        nombre.setBounds(270, 90, 480, 70); // Establecemos las coordenadas y tamaño
        nombre.setFont(new Font("Arial", Font.BOLD, 50)); // Ajustamos el tamaño de la fuente
        // Crea el color a partir de valores hexadecimales
        nombre.setBackground(colorNaranja);
        nombre.setForeground(colorVerde);
        //nombre.setActionCommand(NOMBRE);
        
        tipo = new JTextArea();
        tipo.setEditable(false);
       // tipo.setBackground(Color.decode("#EA995A"));
        tipo.setBorder(null);
        tipo.setOpaque(true); // Hacemos el fondo transparente
        tipo.setBounds(420, 185, 200, 40); // Establecemos las coordenadas y tamaño
        tipo.setFont(new Font("Arial", Font.BOLD, 25));
        tipo.setBackground(colorNaranja);
        tipo.setForeground(colorVerde); // Ajustamos el tamaño de la fuente
        //artista.setActionCommand(ARTISTA);
        
        generop = new PnlGenero();
        genero = new JTextArea("");
        genero.setEditable(false);
        
       
       // tipo.setBackground(Color.decode("#EA995A"));
        genero.setBorder(null);
        genero.setOpaque(true); // Hacemos el fondo transparente
        genero.setBounds(350, 260, 220, 50); // Establecemos las coordenadas y tamaño
        genero.setFont(new Font("Arial", Font.BOLD, 30));
        genero.setBackground(colorNaranja);
        genero.setForeground(colorVerde); // Ajustamos el tamaño de la fuente
        
        
        btnRegresar = new JButton("");
        
        btnRegresar.setPreferredSize(new Dimension(300, 300));
        btnRegresar.setOpaque(false); // Hacer el botón transparente
        btnRegresar.setContentAreaFilled(false); // No pintar el área del contenido
        btnRegresar.setBorderPainted(false); // No pintar el borde
        btnRegresar.setBounds(475, 680, 70, 70);
        btnRegresar.setActionCommand(REGRESAR);
        
        
       
        
        btnAdd = new JButton("");
        
        btnAdd.setPreferredSize(new Dimension(300, 300));
        btnAdd.setOpaque(false); // Hacer el botón transparente
        btnAdd.setContentAreaFilled(false); // No pintar el área del contenido
        btnAdd.setBorderPainted(false); // No pintar el borde
        btnAdd.setBounds(270, 636, 70, 70);
        btnAdd.setActionCommand(ADD);
        
        btnEliminar = new JButton("");
        
        btnEliminar.setPreferredSize(new Dimension(300, 300));
        btnEliminar.setOpaque(false); // Hacer el botón transparente
        btnEliminar.setContentAreaFilled(false); // No pintar el área del contenido
        btnEliminar.setBorderPainted(false); // No pintar el borde
        btnEliminar.setBounds(675, 630, 70, 70);
        btnEliminar.setActionCommand(ELIMINAR_C);
        
        artxtCanciones = new JTextArea(10, 20);
        artxtCanciones.setForeground(colorVerde); // Un verde estándar
        artxtCanciones.setOpaque(false);
        artxtCanciones.setFont(new Font("Arial", Font.ITALIC, 15)); // Usar Arial en lugar de Dialog
        artxtCanciones.setEditable(false);
        artxtCanciones.setMargin(new Insets(10, 10, 10, 10));
       
        
		
		//artxtCancionesEmi.setBounds(500, 90, 400, 300);
		
        artxtCancionesEmi = new JTextArea(10, 20);
        artxtCancionesEmi.setForeground(colorVerde); // Aplicar el mismo color verde
        artxtCancionesEmi.setOpaque(false);
        artxtCancionesEmi.setFont(new Font("Arial", Font.ITALIC, 15)); // También Arial aquí
        artxtCancionesEmi.setEditable(false);
        artxtCancionesEmi.setMargin(new Insets(10, 10, 10, 10));
		
		cbCanciones = new JComboBox<String>();
		cbCanciones.setOpaque(false);
		
		cbCancionesEmi = new JComboBox<String>();
		cbCancionesEmi.setOpaque(false);
	
		
		scroll1 = new JScrollPane(artxtCanciones);
		scroll1.setOpaque(false);
		scroll1.getViewport().setOpaque(false);
	    scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    scroll2 = new JScrollPane(artxtCancionesEmi);
		scroll2.setOpaque(false);
		scroll2.getViewport().setOpaque(false);
	    scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
	        // Ajustar las coordenadas y el margen vertical del scroll y el combo box
	    int margenVertical = 20;
        cbCanciones.setBounds(84, 360 - margenVertical, 410, 30); // Colocar cbCanciones arriba
        scroll1.setBounds(84, 372, 410, 220);
        
     
        cbCancionesEmi.setBounds(520, 360 - margenVertical, 410, 30); // Colocar cbCanciones arriba
        scroll2.setBounds(520, 372, 410, 220);
        
        add(scroll1);
        add(scroll2);
        add(cbCancionesEmi);
        add(cbCanciones);
        add(btnRegresar);
        add(btnAdd);
        add(btnEliminar);
        add(tipo);
        add(nombre);
        add(genero);
        add(fondo);
        // Agregamos la etiqueta de fondo al panel
        add(fondo);
    }
    


	public JTextArea getArtxtCanciones() {
		return artxtCanciones;
	}



	public void setArtxtCanciones(JTextArea artxtCanciones) {
		this.artxtCanciones = artxtCanciones;
	}



	public JTextArea getNombre() {
		return nombre;
	}


	public void setNombre(JTextArea nombre) {
		this.nombre = nombre;
	}


	public JTextArea getTipo() {
		return tipo;
	}


	public void setTipo(JTextArea tipo) {
		this.tipo = tipo;
	}


	public JTextArea getGenero() {
		return genero;
	}


	public void setGenero(JTextArea genero) {
		this.genero = genero;
	}


	public JTextArea getArtxtCancionesEmi() {
		return artxtCancionesEmi;
	}


	public void setArtxtCancionesEmi(JTextArea artxtCancionesEmi) {
		this.artxtCancionesEmi = artxtCancionesEmi;
	}


	public JComboBox<String> getCbCanciones() {
		return cbCanciones;
	}


	public void setCbCanciones(JComboBox<String> cbCanciones) {
		this.cbCanciones = cbCanciones;
	}


	public JComboBox<String> getCbCancionesEmi() {
		return cbCancionesEmi;
	}


	public void setCbCancionesEmi(JComboBox<String> cbCancionesEmi) {
		this.cbCancionesEmi = cbCancionesEmi;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JButton getBtnRegresar() {
		return btnRegresar;
	}


	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}


	public JScrollPane getScroll1() {
		return scroll1;
	}


	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}


	public JScrollPane getScroll2() {
		return scroll2;
	}


	public void setScroll2(JScrollPane scroll2) {
		this.scroll2 = scroll2;
	}
    
    

	

}
