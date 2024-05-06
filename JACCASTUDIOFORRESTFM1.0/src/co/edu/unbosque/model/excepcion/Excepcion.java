package co.edu.unbosque.model.excepcion;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.Model;
import co.edu.unbosque.view.View;

public class Excepcion {

    private Model model;
    private View v;

    public Excepcion(Model model, View v) {
        this.model = model;
        this.v = v;
    }

    public void handleDeleteSong(JComboBox<String> cbCanciones) {
        Object selectedItem = cbCanciones.getSelectedItem();
        if (selectedItem != null) {
            try {
                int songId = Integer.parseInt(selectedItem.toString());
                int result = model.getcDAO().eliminarCancion(songId);
                if (result == 1) {
                    v.mostrarInfo("Canción", "La canción fue eliminada exitosamente del sistema.", 1);
                    model.getcDAO().escribirArchivo();
                } else {
                    v.mostrarInfo("Error", "Error en la eliminación de la canción.", 0);
                }
            } catch (NumberFormatException e) {
                v.mostrarInfo("Error", "Identificador inválido. Por favor, seleccione una canción válida.", 0);
            }
        } else {
            v.mostrarInfo("Selección", "Por favor, seleccione una canción para eliminar.", 0);
        }
    }

    public boolean verifyTextField(JTextField textField) {
        if (textField.getText().trim().isEmpty()) {
            v.mostrarInfo("Validación de entrada", "Por favor, ingrese un nombre antes de continuar.", 0);
            return false; // Devuelve false si el campo está vacío
        } else {
            return true; // Devuelve true si el campo contiene algún texto
        }
    }
   

	public String escogerArchivo() {
	    JFileChooser fileChooser = new JFileChooser();
	    int returnValue = fileChooser.showOpenDialog(null); // Abre el cuadro de diálogo para seleccionar un archivo
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) { // Si el usuario selecciona un archivo
	        File selectedFile = fileChooser.getSelectedFile();
	        return selectedFile.getAbsolutePath(); // Devuelve la ruta del archivo seleccionado
	    } else {
	        return null;// El usuario canceló la selección, devuelve null
	    }
	}
	
	public void handleEnterName(String name) {
	    if (name.isEmpty()) {
	        v.mostrarInfo("Error", "Debe ingresar un nombre antes de continuar.", JOptionPane.ERROR_MESSAGE);
	    } else {

	        v.getCardLayout().show(v.getContentPane(), "panelV");
	        v.getPanelII().setVisible(false);
	        v.getPanelV().setVisible(true);

	    
	    }
	}





}
   
