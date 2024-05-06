package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import co.edu.unbosque.model.persistence.CancionDAO;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Model implements Reproductor{
	
	private CancionDAO cDAO;
	private Emisora emi;

	
	public Model(){
		cDAO = new CancionDAO();
		emi = new Emisora(null,null,null);
	}
	
	//Funcion para verificar la direccion del mp3 en un String

	public int verificarDirec(String ruta) {
		int resp = 0;
		String ext = "";
		int i = ruta.lastIndexOf('.');
		if(i > 0) {
			ext = ruta.substring(i + 1);
		}
		if(ext.equals("mp3")) {
			resp = 1;
		}else {
			resp = -1;
		}
		return resp;
	}
	
	 //Funcion para reproducir la musica
	
	
	
	public int reproducirMusica(int Id) {
		int resp = 0;
		int pos = cDAO.buscarCancion(Id);
		if(pos != -1) {
			try {
				FileInputStream a = new FileInputStream(cDAO.getListCancion().get(pos).getArchivo());
				Player play = new Player(a);
				resp = 1;
				play.play();
			}catch (JavaLayerException e) {
				resp = -1;
			}
			catch (FileNotFoundException e) {
				resp = -2;
			}
		}
		return resp;
	}
	
	 //Conseguir la clase importada de CancionDAO 

	
	public CancionDAO getcDAO() {
		return cDAO;
	}
	

	
	public void setcDAO(CancionDAO cDAO) {
		this.cDAO = cDAO;
	}
	
	 //Conseguir la clase importada de Emisora
	 
	 
	public Emisora getEmi() {
		return emi;
	}
	
	 //Remplazar las caracteristicas la clase importada de la Emisora
	 
	public void setEmi(Emisora emi) {
		this.emi = emi;
	}

}
