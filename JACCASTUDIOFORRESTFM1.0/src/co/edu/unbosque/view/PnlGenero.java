package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PnlGenero extends JPanel {

	private JLabel fondo;
	private JButton btnSalsa, btnReggeton, btnCorridos, btnRock, btnElectronica, btnBoleros;
	public final String SALSA = "SALSA";
	public final String REGUETON = "REGUETON";
	public final String ROCK = "ROCK";
	public final String CORRIDOS = "CORRIDOS";
	public final String ELECTRONICA = "ELECTRONICA";
	public final String BOLEROS = "BOLEROS";
	public String lastSelectedGenre;

	public PnlGenero() {
		setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

		// Configuramos el fondo
		fondo = new JLabel();
		fondo.setSize(1024, 768);
		ImageIcon x = new ImageIcon("img/5.png");
		ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
		fondo.setIcon(y);

		btnSalsa = new JButton("");

		btnSalsa.setPreferredSize(new Dimension(300, 300));
		btnSalsa.setOpaque(false); // Hacer el botón transparente
		btnSalsa.setContentAreaFilled(false); // No pintar el área del contenido
		btnSalsa.setBorderPainted(false); // No pintar el borde
		btnSalsa.setBounds(215, 190, 160, 165);
		btnSalsa.setActionCommand(SALSA);
		btnSalsa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = SALSA; // Actualiza lastSelectedGenre con el género correspondiente
			}
		});

		btnReggeton = new JButton("");

		btnReggeton.setPreferredSize(new Dimension(300, 300));
		btnReggeton.setOpaque(false); // Hacer el botón transparente
		btnReggeton.setContentAreaFilled(false); // No pintar el área del contenido
		btnReggeton.setBorderPainted(false); // No pintar el borde
		btnReggeton.setBounds(425, 190, 160, 165);
		btnReggeton.setActionCommand(REGUETON);
		btnReggeton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = REGUETON; // Actualiza lastSelectedGenre con el género correspondiente
			}
		});

		btnCorridos = new JButton("");

		btnCorridos.setPreferredSize(new Dimension(300, 300));
		btnCorridos.setOpaque(false); // Hacer el botón transparente
		btnCorridos.setContentAreaFilled(false); // No pintar el área del contenido
		btnCorridos.setBorderPainted(false); // No pintar el borde
		btnCorridos.setBounds(640, 190, 160, 165);
		btnCorridos.setActionCommand(CORRIDOS);
		btnCorridos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = CORRIDOS; // Actualiza lastSelectedGenre con el género correspondiente
			}
		});

		btnRock = new JButton("");

		btnRock.setPreferredSize(new Dimension(300, 300));
		btnRock.setOpaque(false); // Hacer el botón transparente
		btnRock.setContentAreaFilled(false); // No pintar el área del contenido
		btnRock.setBorderPainted(false); // No pintar el borde
		btnRock.setBounds(220, 390, 160, 165);
		btnRock.setActionCommand(ROCK);
		btnRock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = ROCK;
				//genero = "ROCK";
			}
		});

		btnElectronica = new JButton("");

		btnElectronica.setPreferredSize(new Dimension(300, 300));
		btnElectronica.setOpaque(false); // Hacer el botón transparente
		btnElectronica.setContentAreaFilled(false); // No pintar el área del contenido
		btnElectronica.setBorderPainted(false); // No pintar el borde
		btnElectronica.setBounds(430, 390, 160, 165);
		btnElectronica.setActionCommand(ELECTRONICA);
		btnElectronica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = ELECTRONICA; // Actualiza lastSelectedGenre con el género correspondiente
			}
		});

		btnBoleros = new JButton("");

		btnBoleros.setPreferredSize(new Dimension(300, 300));
		btnBoleros.setOpaque(false); // Hacer el botón transparente
		btnBoleros.setContentAreaFilled(false); // No pintar el área del contenido
		btnBoleros.setBorderPainted(false); // No pintar el borde
		btnBoleros.setBounds(642, 390, 160, 165);
		btnBoleros.setActionCommand(BOLEROS);
		btnBoleros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastSelectedGenre = BOLEROS; // Actualiza lastSelectedGenre con el género correspondiente
			}
		});

		add(btnBoleros);
		add(btnElectronica);
		add(btnRock);
		add(btnCorridos);
		add(btnSalsa);
		add(btnReggeton);
		add(fondo);

	}
	

	public String getLastSelectedGenre() {
		return  lastSelectedGenre;
	}

	public void setLastSelectedGenre(String lastSelectedGenre) {
		this.lastSelectedGenre = lastSelectedGenre;
	}

	public JButton getBtnSalsa() {
		return btnSalsa;
	}

	public void setBtnSalsa(JButton btnSalsa) {
		this.btnSalsa = btnSalsa;
	}

	public JButton getBtnReggeton() {
		return btnReggeton;
	}

	public void setBtnReggeton(JButton btnReggeton) {
		this.btnReggeton = btnReggeton;
	}

	public JButton getBtnCorridos() {
		return btnCorridos;
	}

	public void setBtnCorridos(JButton btnCorridos) {
		this.btnCorridos = btnCorridos;
	}

	public JButton getBtnRock() {
		return btnRock;
	}

	public void setBtnRock(JButton btnRock) {
		this.btnRock = btnRock;
	}

	public JButton getBtnElectronica() {
		return btnElectronica;
	}

	public void setBtnElectronica(JButton btnElectronica) {
		this.btnElectronica = btnElectronica;
	}

	public JButton getBtnBoleros() {
		return btnBoleros;
	}

	public void setBtnBoleros(JButton btnBoleros) {
		this.btnBoleros = btnBoleros;
	}

}
