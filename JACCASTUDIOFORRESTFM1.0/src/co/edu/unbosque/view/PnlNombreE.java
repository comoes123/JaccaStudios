package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PnlNombreE extends JPanel {
    private JTextField textField;
    private JLabel fondo;
    public static final String ENTER = "ENTER";
   

    public PnlNombreE() {
        setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

        // Configuramos el fondo
        fondo = new JLabel();
        fondo.setSize(1024, 768);
        ImageIcon x = new ImageIcon("img/2.png");
        ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
        fondo.setIcon(y);
        
        // Agregamos la etiqueta de fondo al panel
        add(fondo);

        // Configuramos el TextField
        textField = new JTextField();
        textField.setBackground(Color.decode("#EA995A"));
        textField.setForeground(Color.decode("#33462f"));
        textField.setBorder(null);
        textField.setOpaque(true); // Hacemos el fondo transparente
        textField.setBounds(190, 305, 620, 150); // Establecemos las coordenadas y tamaño
        textField.setFont(new Font("Arial", Font.BOLD, 80)); // Ajustamos el tamaño de la fuente
        textField.setActionCommand(ENTER);
        
        // Agregamos un ActionListener para detectar cuando se presiona "Enter"
      
         
        // Agregamos el textField al panel
        add(textField);
        
    
    }

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public void addActionListenerToTextField(ActionListener listener) {
	    textField.addActionListener(listener);
	}

    
    
}