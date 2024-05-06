package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PnlMenu extends JPanel {

	private JLabel fondo;
	private JButton btnCancion;
	private JButton btnAdmin;
	private JButton btnReproducir, btnquestion;
	public final String CANCION = "CANCION";
	public final String ADMIN = "ADMIN";
	public final String REPRODUCIR = "REPRODUCIR";

	public PnlMenu() {
		setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

		// Configuramos el fondo
		fondo = new JLabel();
		fondo.setSize(1024, 768);
		ImageIcon x = new ImageIcon("img/4.png");
		ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
		fondo.setIcon(y);
		Color colorNaranja = new Color(0xEB, 0x99, 0x5B);
		Color colorVerde = new Color(0x34, 0x44, 0x2C);

		btnCancion = new JButton("");

		btnCancion.setPreferredSize(new Dimension(300, 300));
		btnCancion.setOpaque(false); // Hacer el botón transparente
		btnCancion.setContentAreaFilled(false); // No pintar el área del contenido
		btnCancion.setBorderPainted(false); // No pintar el borde
		btnCancion.setBounds(30, 270, 300, 250);
		btnCancion.setActionCommand(CANCION);

		btnAdmin = new JButton("");

		btnAdmin.setPreferredSize(new Dimension(300, 300));
		btnAdmin.setOpaque(false); // Hacer el botón transparente
		btnAdmin.setContentAreaFilled(false); // No pintar el área del contenido
		btnAdmin.setBorderPainted(false); // No pintar el borde
		btnAdmin.setBounds(360, 270, 300, 250);
		btnAdmin.setActionCommand(ADMIN);

		btnReproducir = new JButton("");

		btnReproducir.setPreferredSize(new Dimension(300, 300));
		btnReproducir.setOpaque(false); // Hacer el botón transparente
		btnReproducir.setContentAreaFilled(false); // No pintar el área del contenido
		btnReproducir.setBorderPainted(false); // No pintar el borde
		btnReproducir.setBounds(690, 270, 300, 250);
		btnReproducir.setActionCommand(REPRODUCIR);

		btnquestion = new JButton("");
		// btnquestion.setPreferredSize(new Dimension(300, 300));
		btnquestion.setBackground(colorNaranja);
		btnquestion.setForeground(colorVerde);
		btnquestion.setContentAreaFilled(true);
		btnquestion.setOpaque(true); // Hacer el botón transparente
		btnquestion.setContentAreaFilled(false); // No pintar el área del contenido
		btnquestion.setBorderPainted(false);

		btnquestion.setBounds(467, 640, 90, 30);
		btnquestion.setToolTipText("<html><body style='background-color: #b4d3ae; color: #222b20; font-size: 11px; padding: 5px;'>Si presiona:<br> - AGREGAR CANCIÓN: podrá añadir una canción nueva<br> - ADMINISTRAR EMISIÓN: ver y programar las canciones anteriormente guardadas<br> - TRANSMISIONES ANTERIORES: podrá ver las canciones que ha programadO e ir al aire</body></html>");


		add(btnquestion);
		add(btnReproducir);
		add(btnCancion);
		add(btnAdmin);
		add(fondo);

		setVisible(true); // Hacemos visible el panel
	}

	public JButton getBtnCancion() {
		return btnCancion;
	}

	public void setBtnCancion(JButton btnCancion) {
		this.btnCancion = btnCancion;
	}

	public JButton getBtnAdmin() {
		return btnAdmin;
	}
	public void setBtnAdmin(JButton btnAdmin) {
		this.btnAdmin = btnAdmin;
	}

	public JButton getBtnReproducir() {
		return btnReproducir;
	}

	public void setBtnReproducir(JButton btnReproducir) {
		this.btnReproducir = btnReproducir;
	}

	public JButton getBtnquestion() {
		return btnquestion;
	}

	public void setBtnquestion(JButton btnquestion) {
		this.btnquestion = btnquestion;
	}

}
