package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import co.edu.unbosque.view.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Model;
import co.edu.unbosque.model.excepcion.Excepcion;
import co.edu.unbosque.model.persistence.CancionDAO;

import co.edu.unbosque.view.View;

import java.util.logging.Logger;

public class Controller implements ActionListener {

	private View v;
	private Model model;
	private Excepcion excepcion;
	private CancionDAO cancionDao;

	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

	public Controller() {
		v = new View(this);
		model = new Model();
		refreshPanels();
		excepcion = new Excepcion(model, v);
		cancionDao = new CancionDAO();

	}

	public void refreshPanels() {

		String resp = "";
		if (model.getcDAO().leerArchivo() == 1) {

			v.getPanelVI().getNombre().setText("");
			v.getPanelVI().getArtista().setText("");

			v.getPanelVI().getCbCanciones().removeAllItems();
			v.getPanelVII().getCbCanciones().removeAllItems();
			v.getPanelVII().getCbCancionesEmi().removeAllItems();

			for (int i = 0; i < model.getcDAO().getListCancion().size(); i++) {

				v.getPanelVI().getCbCanciones().addItem("" + model.getcDAO().getListCancion().get(i).getiD());
				v.getPanelVII().getCbCanciones().addItem("" + model.getcDAO().getListCancion().get(i).getiD());
			}
			v.getPanelVI().getArtxtCanciones().setText(model.getcDAO().mostrarCanciones());
			v.getPanelVII().getArtxtCanciones().setText(model.getcDAO().mostrarCanciones());

			resp = "Lista de Canciones" + "\n";
			if (model.getEmi().getListIdCancion().size() > 0) {
				for (int i = 0; i < model.getEmi().getListIdCancion().size(); i++) {
					v.getPanelVII().getCbCancionesEmi()
							.addItem("" + model.getEmi().getListIdCancion().get(i).toString());
					resp += "N." + (1 + i) + " "
							+ model.getcDAO().getListCancion()
									.get(model.getcDAO().buscarCancion(model.getEmi().getListIdCancion().get(i)))
									.getNombre().toString()
							+ "\n";
				}
			}
			v.getPanelVII().getArtxtCancionesEmi().setText(resp);

		} else {
			v.getPanelVI().getArtxtCanciones().setText("No hay canciones almacenadas.");
			v.getPanelVII().getArtxtCanciones().setText("No hay canciones almacenadas.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// LOGGER.log(Level.INFO, "Processing event: {0}", e.getActionCommand());

		Object source = e.getSource();

		// manejo entre menus

		if (e.getActionCommand().equals(v.getPanelI().INICIAR)) {
			v.getCardLayout().show(v.getContentPane(), "panelII");
			v.getPanelI().setVisible(false);
			v.getPanelII().setVisible(true);
		}

		if (e.getActionCommand().equals(PnlNombreE.ENTER)) {
			String name = v.getPanelII().getTextField().getText().trim();
			if (!name.isEmpty()) {
				excepcion.handleEnterName(name); // Asumiendo que 'excepcion' es una instancia de Excepcion que también
													// necesita ser manejada
			} else {
				v.mostrarInfo("Error", "Debe ingresar un nombre antes de continuar.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getActionCommand().equals(v.getPanelIII().AM)) {
			v.getCardLayout().show(v.getContentPane(), "panelIV");
			v.getPanelIII().setVisible(false);
			v.getPanelIV().setVisible(true);

		}
		if (e.getActionCommand().equals(v.getPanelIII().FM)) {
			v.getCardLayout().show(v.getContentPane(), "panelIV");

			v.getPanelIII().setVisible(false);
			v.getPanelIV().setVisible(true);

		}
		if (e.getActionCommand().equals(v.getPanelIII().STREAMING)) {
			v.getCardLayout().show(v.getContentPane(), "panelIV");
			v.getPanelIII().setVisible(false);
			v.getPanelIV().setVisible(true);

		}

		if (e.getActionCommand().equals(v.getPanelIV().CANCION)) {
			v.getCardLayout().show(v.getContentPane(), "panelVI");
			v.getPanelV().setVisible(false);
			v.getPanelVI().setVisible(true);

		}

		if (e.getActionCommand().equals(v.getPanelIV().ADMIN)) {
			v.getCardLayout().show(v.getContentPane(), "panelVII");
			v.getPanelV().setVisible(false);
			v.getPanelVII().setVisible(true);

			v.getPanelVII().getNombre().setText(model.getEmi().getNombre());
			v.getPanelVII().getTipo().setText(model.getEmi().getTrasmision());
			v.getPanelVII().getGenero().setText(model.getEmi().getGenero());
			refreshPanels();
		}
		// PANEL AL AIRE

		if (e.getActionCommand().equals(v.getPanelIV().REPRODUCIR)) {
			v.getCardLayout().show(v.getContentPane(), "panelVIII");
			v.getPanelV().setVisible(false);
			v.getPanelVIII().setVisible(true);

		}

		if (e.getActionCommand().equals(v.getPanelVII().REGRESAR)) {
			v.getCardLayout().show(v.getContentPane(), "panelIV");
			v.getPanelVII().setVisible(false);
			v.getPanelIV().setVisible(true);

		}

		if (e.getActionCommand().equals(v.getPanelV().BOLEROS)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);
		}
		if (e.getActionCommand().equals(v.getPanelV().CORRIDOS)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);
		}

		if (e.getActionCommand().equals(v.getPanelV().ELECTRONICA)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);
		}
		if (e.getActionCommand().equals(v.getPanelV().REGUETON)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);
		}
		if (e.getActionCommand().equals(v.getPanelV().ROCK)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);

		}
		if (e.getActionCommand().equals(v.getPanelV().SALSA)) {
			v.getCardLayout().show(v.getContentPane(), "paneIII");

			v.getPanelV().setVisible(false);
			v.getPanelIII().setVisible(true);

		}
		if (e.getActionCommand().equals(v.getPanelVI().VOLVER)) {
			v.getCardLayout().show(v.getContentPane(), "panelIV");

			v.getPanelVI().setVisible(false);
			v.getPanelIV().setVisible(true);
			refreshPanels();
		}

		// MANEJO DE CREAR AÑADIR CANCION

		if (e.getActionCommand().equals(v.getPanelVI().getBtnAgregarCancion().getActionCommand())) {
			if (!v.getPanelVI().getNombre().getText().isEmpty() && !v.getPanelVI().getArtista().getText().isEmpty()) {
				String path = v.getPanelVI().escogerArchivo();

				if (model.verificarDirec(path) == 1) {
					try {
						int iD = Integer.parseInt(
								v.introducirInfo("Identificador", "Usuario Introduzca el Identificador de la cancion"
										+ "\n" + "Recuerde que debe ser un numero", 1));

						int b = model.getcDAO()
								.agregarCancion(model.getcDAO().crearCancion(iD, v.getPanelVI().getNombre().getText(),
										v.getPanelV().getLastSelectedGenre(), v.getPanelVI().getArtista().getText(),
										path));
						if (b == 1) {
							v.mostrarInfo("Cancion", "Usuario, La Cancion fue guardada exitosamente.", 1);
							model.getcDAO().escribirArchivo();
							refreshPanels();
						} else {
							v.mostrarInfo("Cancion", "Usuario, debe utilizar otro Identificador para su cancion.", 0);
						}
					} catch (NumberFormatException e2) {
						v.mostrarInfo("Cancion",
								"Usuario, debe utilizar solamente numeros enteros para identificar su cancion.", 0);
					}
				}
			} else {
				v.mostrarInfo("Campos", "Usuario, recuerde que debe llenar todos los campos.", 0);
			}
		}

//***********************-------------------------

		// CONFIG ELIMINAR CANCION

		if (e.getActionCommand().equals(v.getPanelVI().getBtnEliminarCancion().getActionCommand())) {
			int a = model.getcDAO()
					.eliminarCancion(Integer.parseInt(v.getPanelVI().getCbCanciones().getSelectedItem().toString()));
			if (a == 1) {
				v.mostrarInfo("Cancion", "Usuario, La Cancion fue eliminada exitosamente del sistema.", 1);
				model.getcDAO().escribirArchivo();

				if (model.getEmi().getListIdCancion().size() > 0) {
					int i = 0;
					boolean b1 = false;
					while (i < model.getEmi().getListIdCancion().size() && b1 == false) {
						if (model.getEmi().getListIdCancion().get(i) == Integer
								.parseInt(v.getPanelVI().getCbCanciones().getSelectedItem().toString())) {
							model.getEmi().getListIdCancion().remove(i);
							v.mostrarInfo("Cancion",
									"Usuario, La cancion se elimino de la emisora por su modificacion.", 1);
							b1 = true;
						}
						i++;
					}
				}

				refreshPanels();
			} else {
				v.mostrarInfo("Error", "Error en la eliminacion de una cancion.", 0);
			}
			refreshPanels();
		}

		// manejo de emision-------------------------------

		if (e.getActionCommand().equals(v.getPanelVII().getBtnAdd().getActionCommand())) {
			int a = Integer.parseInt(v.getPanelVII().getCbCanciones().getSelectedItem().toString());
			int i = 0;
			boolean b = false;

			if (model.getEmi().getListIdCancion().size() > 0) {
				while (i < model.getEmi().getListIdCancion().size() && b == false) {
					if (model.getEmi().getListIdCancion().get(i) == a) {
						b = true;
					}
					i++;
				}
				if (b != false) {
					v.mostrarInfo("Repetida", "Usuario, La cancion escogida se encuentra repetida en la emisora", 0);
				} else {
					model.getEmi().getListIdCancion().add(a);
					refreshPanels();
				}
			} else {
				model.getEmi().getListIdCancion().add(a);
				refreshPanels();
			}
		}

		if (e.getActionCommand().equals(v.getPanelVII().getBtnEliminar().getActionCommand())) {
			int a = Integer.parseInt(v.getPanelVII().getCbCancionesEmi().getSelectedItem().toString());
			if (model.getEmi().getListIdCancion().size() > 0) {
				int i = 0;
				boolean b = false;
				while (i < model.getEmi().getListIdCancion().size() && b == false) {
					if (model.getEmi().getListIdCancion().get(i) == a) {
						model.getEmi().getListIdCancion().remove(i);
						v.mostrarInfo("Cancion", "Usuario, La cancion se elimino correctamente", 1);
						b = true;
						refreshPanels();
					}
					i++;
				}
			} else {
				v.mostrarInfo("Vacio", "Usuario, La emisora no posee canciones", 0);
			}
			refreshPanels();
		}

		// REPRODUCIR MUSIC

		if (e.getActionCommand().equals(v.getPanelVIII().getBtnReproducir().getActionCommand())) {

			if (model.getEmi().getListIdCancion().size() > 0) {
				v.mostrarInfo("Inicio", "Iniciando Emisora", 1);
				for (int i = 0; i < model.getEmi().getListIdCancion().size(); i++) {
					int a = Integer.parseInt(model.getEmi().getListIdCancion().get(i).toString());
					v.mostrarInfo("N." + (i + 1), "Cancion Sonando: " + "\n"
							+ model.getcDAO().getListCancion().get(model.getcDAO().buscarCancion(a)).getNombre(), 1);
					if (model.reproducirMusica(
							Integer.parseInt(model.getEmi().getListIdCancion().get(i).toString())) == 1) {
					} else if (model.reproducirMusica(
							Integer.parseInt(model.getEmi().getListIdCancion().get(i).toString())) == -1) {
						v.mostrarInfo("Error", "Error en la reproduccion de la cancion.", 0);
					} else {
						v.mostrarInfo("Error",
								"Archivo de la Cancion no encontrado, porfavor actualice la direccion del archivo de la cancion: "
										+ "\n" + model.getcDAO().getListCancion().get(model.getcDAO().buscarCancion(a))
												.getNombre(),
								0);
					}
				}
				v.mostrarInfo("Final", "Emision Finalizada.", 1);
				v.getPanelVII().getBtnAdd().setEnabled(false);
				v.getPanelVII().getBtnEliminar().setEnabled(false);
				model.getEmi().getListIdCancion().removeAll(model.getEmi().getListIdCancion());
				refreshPanels();
			} else {
				v.mostrarInfo("Vacio", "Usuario, La emisora no posee canciones", 0);
			}
		}

		// menejo de tipo y nombre emisora

		if ((e.getActionCommand().equals(v.getPanelIII().AM))) {
			model.getEmi().setNombre(v.getPanelII().getTextField().getText());
			model.getEmi().setTrasmision(v.getPanelIII().AM);
			model.getEmi().setGenero(v.getPanelV().getLastSelectedGenre());
			v.mostrarConsola(model.getEmi().toString());

		}
		if (e.getActionCommand().equals(v.getPanelIII().FM)) {
			model.getEmi().setNombre(v.getPanelII().getTextField().getText());
			model.getEmi().setTrasmision(v.getPanelIII().FM);
			model.getEmi().setGenero(v.getPanelV().getLastSelectedGenre());
			v.mostrarConsola(model.getEmi().toString());
		}
		if (e.getActionCommand().equals(v.getPanelIII().STREAMING)) {
			model.getEmi().setNombre(v.getPanelII().getTextField().getText());
			model.getEmi().setTrasmision(v.getPanelIII().STREAMING);
			model.getEmi().setGenero(v.getPanelV().getLastSelectedGenre());
			v.mostrarConsola(model.getEmi().toString());
		}
		if (e.getActionCommand().equals(v.getPanelIII().AM) || e.getActionCommand().equals(v.getPanelIII().FM)
				|| e.getActionCommand().equals(v.getPanelIII().STREAMING)) {
			model.getEmi().setNombre(v.getPanelII().getTextField().getText());
			model.getEmi().setTrasmision(e.getActionCommand());
			model.getEmi().setGenero(v.getPanelV().getLastSelectedGenre());
			v.mostrarConsola(model.getEmi().toString());
			refreshPanels(); // Actualizar paneles después de cambiar la configuración de la emisora
		}

	}

}
