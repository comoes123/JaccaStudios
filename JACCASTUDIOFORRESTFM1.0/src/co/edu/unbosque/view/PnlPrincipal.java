package co.edu.unbosque.view;

import java.awt.*;


import javax.swing.*;

public class PnlPrincipal extends JPanel{
	
	private JButton btnIniciar;
	private JLabel fondo;
	public final String INICIAR= "INICIAR";
	
	public PnlPrincipal() {
		
		fondo = new JLabel();
        fondo.setSize(1024, 768);
        ImageIcon x = new ImageIcon("img/1.png");
        ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
        fondo.setIcon(y);
		
		setLayout(null);
		
		btnIniciar = new JButton();

	    btnIniciar.setPreferredSize(new Dimension(300, 300)); // Configurar el tamaño preferido del botón
	    btnIniciar.setOpaque(false); // Hacer el botón transparente
	    btnIniciar.setContentAreaFilled(false); // No pintar el área del contenido
	    btnIniciar.setBorderPainted(false); // No pintar el borde
	    btnIniciar.setBounds((fondo.getWidth() - btnIniciar.getPreferredSize().width) / 2, (fondo.getHeight() - btnIniciar.getPreferredSize().height) / 2, btnIniciar.getPreferredSize().width, btnIniciar.getPreferredSize().height);
	    btnIniciar.setActionCommand(INICIAR);
	    
	    add(btnIniciar);
	    add(fondo);
		
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}

	
	

}
