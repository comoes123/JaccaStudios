package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PnlAmFm extends JPanel {

	private JLabel fondo;
	private JButton btnFm;
	private JButton btnAm;
	private JButton btnStreaming;
	public final String AM = "AM";
	public final String FM = "FM";
	public final String STREAMING = "STREAMING";

	public PnlAmFm() {
		setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

		// Configuramos el fondo
		fondo = new JLabel();
		fondo.setSize(1024, 768);
		ImageIcon x = new ImageIcon("img/3.png");
		ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
		fondo.setIcon(y);

		btnFm = new JButton("");

		btnFm.setPreferredSize(new Dimension(300, 300));
		btnFm.setOpaque(false); // Hacer el botón transparente
		btnFm.setContentAreaFilled(false); // No pintar el área del contenido
		btnFm.setBorderPainted(false);
		btnFm.setBounds(195, 345, 100, 100);
		btnFm.setActionCommand(FM);
		
		btnAm = new JButton("");

		btnAm.setPreferredSize(new Dimension(300, 300));
		btnAm.setOpaque(false); // Hacer el botón transparente
		btnAm.setContentAreaFilled(false); // No pintar el área del contenido
		btnAm.setBorderPainted(false); // No pintar el borde
		btnAm.setBounds(710, 345, 100, 100);
		btnAm.setActionCommand(AM);

		btnStreaming = new JButton("");

		btnStreaming.setPreferredSize(new Dimension(300, 300));
		btnStreaming.setOpaque(false); // Hacer el botón transparente
		btnStreaming.setContentAreaFilled(false); // No pintar el área del contenido
		btnStreaming.setBorderPainted(false); // No pintar el borde
		btnStreaming.setBounds(450, 345, 100, 100);
		btnStreaming.setActionCommand(STREAMING);

		add(btnStreaming);
		add(btnAm);
		add(btnFm);
		add(fondo);

		setVisible(true); // Hacemos visible el panel
	}
	

	public JButton getBtnStreaming() {
		return btnStreaming;
	}


	public void setBtnStreaming(JButton btnStreaming) {
		this.btnStreaming = btnStreaming;
	}


	public JButton getBtnFm() {
		return btnFm;
	}

	public void setBtnFm(JButton btnFm) {
		this.btnFm = btnFm;
	}

	public JButton getBtnAm() {
		return btnAm;
	}

	public void setBtnAm(JButton btnAm) {
		this.btnAm = btnAm;
	}

}
