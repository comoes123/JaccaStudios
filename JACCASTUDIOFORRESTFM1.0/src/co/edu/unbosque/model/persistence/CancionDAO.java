package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

import co.edu.unbosque.model.CancionDTO;

import javazoom.jl.player.Player;

public class CancionDAO {

  
	private ArrayList<CancionDTO> listCancion;
	private CancionDTO dto;
	//sonar cancion paula
	
	private int currentIndex = 0;// Índice de la canción actual
	
    private String ruta  = "./Datos/canciones.dat";
	public CancionDAO() {
		listCancion = new ArrayList<CancionDTO>();
		leerArchivo();
		dto = new CancionDTO(0, null, null, null, null);
	}

    
	@SuppressWarnings("unchecked")
	public int leerArchivo() {
		try {
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta));
	        listCancion = (ArrayList<CancionDTO>) in.readObject();
	        in.close();
	        
	        return 1;
	    } catch (EOFException e) {
	        System.out.println("Fin de archivo alcanzado: " + e.getMessage());
	        return -1;
	    } catch (IOException | ClassNotFoundException e) {
	       
	        e.printStackTrace();
	        return -2;
	    }
	}

	public int escribirArchivo() {
		try {
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
	        out.writeObject(listCancion);
	        out.close();
	        System.out.println("Archivo guardado correctamente.");
	        return 1;
	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado: " + e.getMessage());
	        return -1;
	    } catch (IOException e) {
	        System.out.println("Error al escribir en el archivo: " + e.getMessage());
	        e.printStackTrace();
	        return -1;
	    }
	}

 
	public CancionDTO crearCancion(int Id, String nombre, String genero, String artista, String archivo) {
		dto= new CancionDTO( Id, genero, nombre, artista, archivo);
		return dto;
	}

	public int buscarCancion(int iD) {
		int resp = -1;
		int i = 0;
		if(listCancion.size() > 0) {
			while(i < listCancion.size() && resp ==-1){
				if(iD == listCancion.get(i).getiD()){
					resp = i;
				}
				i++;
			}
		}else {
			resp = -1;
		}

		return resp;
	}


	public int agregarCancion(CancionDTO song) {
		int resp = 0;
		if(buscarCancion(song.getiD()) == -1) {
			listCancion.add(song);
			escribirArchivo();
			resp = 1;
		}else {
			resp = -1;
		}
		return resp;
	}
	
	public boolean eliminarArchivo() {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return archivo.delete(); // Intenta eliminar el archivo y retorna el resultado
        }
        return false; // Retorna false si el archivo no existe
    }

	public int eliminarCancion(int Id) {
		int i = buscarCancion(Id);
	    if (i != -1) {
	        listCancion.remove(i);
	        escribirArchivo(); // Guarda cambios inmediatamente
	        return 1;
	    } else {
	        return -1;
	    }
	}


	public int modificarCancion(int pos, CancionDTO song) {
		if (pos >= 0 && pos < listCancion.size()) {
	        listCancion.set(pos, song);
	        escribirArchivo(); // Guarda cambios inmediatamente
	        return 1;
	    }
	    return -1;
	}

	public String mostrarCanciones() {
		String resp = "Lista de Canciones \n";
		for(int i = 0; i<listCancion.size(); i++) {
			resp +=  "Cancion N."+(i+1)+" Id /"+listCancion.get(i).getiD()+"/" + "\n";
			resp +=  listCancion.get(i).getNombre() + "\n";
			resp +=  listCancion.get(i).getGenero() + "\n";
			resp +=  listCancion.get(i).getArtista( )+ "\n";
			resp +=  listCancion.get(i).getArchivo() + "\n";
			resp +=  "-----------------------------" + "\n";
		}
		return resp;
	}
	
	
	
	//esto es añadido paula lista circular

	public CancionDTO getAnteriorCancion() {
	    if (listCancion.isEmpty()) return null; // Si no hay canciones, retorna null

	    currentIndex = (currentIndex - 1 + listCancion.size()) % listCancion.size(); // Decrementa y envuelve alrededor de la lista
	    return listCancion.get(currentIndex);
	}
	
	public boolean existenArchivos() {
        File archivo = new File(ruta);
        return archivo.exists(); // Retorna true si el archivo existe
    }
	
	//
	
	public CancionDTO getSiguienteCancion() {
	    if (listCancion.isEmpty()) return null; // Si no hay canciones, retorna null

	    currentIndex = (currentIndex + 1) % listCancion.size(); // Incrementa y envuelve alrededor de la lista
	    return listCancion.get(currentIndex);
	}

///
	
	
   
	public ArrayList<CancionDTO> getListCancion() {
		return listCancion;
	}

	public void setListCancion(ArrayList<CancionDTO> listCancion) {
		this.listCancion = listCancion;
	}


	public CancionDTO getDto() {
		return dto;
	}


	public void setDto(CancionDTO dto) {
		this.dto = dto;
	}
}
