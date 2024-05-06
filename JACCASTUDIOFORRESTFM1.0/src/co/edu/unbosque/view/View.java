package co.edu.unbosque.view;

import java.awt.*;
import co.edu.unbosque.view.*; 
import javax.swing.*;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.persistence.CancionDAO;


public class View extends JFrame {

	/**
	 * 
	 */
	private String lastSelectedGenre;  // Atributo para almacenar el último género seleccionado
	private static final long serialVersionUID = 1L;
	private PnlPrincipal panelI;
	private PnlNombreE panelII;
	private PnlAmFm panelIII;
	private PnlMenu panelIV;
	private PnlGenero panelV;
	private PnlCanciones panelVI;
	private CardLayout cardLayout;
	private PnlAdmin panelVII;
	private PnlAire panelVIII;

	public View(Controller controller) {

		cardLayout = new CardLayout();
		setLayout(cardLayout);

		setSize(1024, 800);
		setTitle("Forrest FM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// panel 1 SOLO ES EL INICIO
		panelI = new PnlPrincipal();
		panelI.getBtnIniciar().addActionListener(controller);
		add(panelI, "PanelI");

		// panel 2 PANEL NOMBRE DE LA EMISORA
		panelII = new PnlNombreE();
        panelII.getTextField().addActionListener(controller);
        add(panelII, "PanelII");

		// panel 3 PANEL DONDE SE SELECCIONA AM O FM
		panelIII = new PnlAmFm();
		panelIII.getBtnAm().addActionListener(controller);
		panelIII.getBtnFm().addActionListener(controller);
		panelIII.getBtnStreaming().addActionListener(controller);
		add(panelIII, "panelIII");

		// panel 4 PANEL MENU
		panelIV = new PnlMenu();
		panelIV.getBtnAdmin().addActionListener(controller);
		panelIV.getBtnCancion().addActionListener(controller);
		panelIV.getBtnReproducir().addActionListener(controller);
		add(panelIV, "panelIV");

		// panel 5 PANEL GENERO
		panelV = new PnlGenero();
		panelV.getBtnBoleros().addActionListener(controller);
		panelV.getBtnCorridos().addActionListener(controller);
		panelV.getBtnElectronica().addActionListener(controller);
		panelV.getBtnReggeton().addActionListener(controller);
		panelV.getBtnRock().addActionListener(controller);
		panelV.getBtnSalsa().addActionListener(controller);
		add(panelV, "panelV");

		// panel 6 PANEL CANCIONES
		panelVI = new PnlCanciones();


		panelVI.getBtnAgregarCancion().addActionListener(controller);
	
		panelVI.getBtnEliminarCancion().addActionListener(controller);
		panelVI.getBtnMenu().addActionListener(controller);
		panelVI.getNombre().addActionListener(controller);
		panelVI.getArtista().addActionListener(controller);

		add(panelVI, "panelVI");
		
		//PANEL 7 PANEL ADMININ
		panelVII = new PnlAdmin();
		
		panelVII.getBtnAdd().addActionListener(controller);
		panelVII.getBtnEliminar().addActionListener(controller);
		panelVII.getBtnRegresar().addActionListener(controller);
		add(panelVII, "panelVII");
		
		
		//PANEL 8 PANEL IR AL AIRE
		panelVIII= new PnlAire();
		panelVIII.getBtnReproducir().addActionListener(controller);
		panelVIII.getBtnRegresar().addActionListener(controller);
		add(panelVIII, "panelVIII");

	}
	

	public void mostrarConsola(String string) {
		System.out.println(string);

	}

	public void mostrarInfo(String title, String mesg, int type) {
		JOptionPane.showMessageDialog(null, mesg, title, type);
	}
	
	public String introducirInfo(String title, String mesg, int type) {
		return JOptionPane.showInputDialog(null, mesg, title, type);
	}
	// excepcion
	public void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
	public String getLastSelectedGenre() {
	    return lastSelectedGenre;
	}

	public void setLastSelectedGenre(String genre) {
	    this.lastSelectedGenre = genre;
	}

	public PnlPrincipal getPanelI() {
		return panelI;
	}

	public void setPanelI(PnlPrincipal panelI) {
		this.panelI = panelI;
	}

	public PnlNombreE getPanelII() {
		return panelII;
	}

	public void setPanelII(PnlNombreE panelII) {
		this.panelII = panelII;
	}

	public PnlAmFm getPanelIII() {
		return panelIII;
	}

	public void setPanelIII(PnlAmFm panelIII) {
		this.panelIII = panelIII;
	}

	public PnlMenu getPanelIV() {
		return panelIV;
	}

	public void setPanelIV(PnlMenu panelIV) {
		this.panelIV = panelIV;
	}

	public PnlGenero getPanelV() {
		return panelV;
	}

	public void setPanelV(PnlGenero panelV) {
		this.panelV = panelV;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public PnlCanciones getPanelVI() {
		return panelVI;
	}

	public void setPanelVI(PnlCanciones panelVI) {
		this.panelVI = panelVI;
	}


	public PnlAdmin getPanelVII() {
		return panelVII;
	}
	
	
	public PnlAire getPanelVIII() {
		return panelVIII;
	}

	public void setPanelVII(PnlAdmin panelVII) {
		this.panelVII = panelVII;
	}


	

	


	

}
