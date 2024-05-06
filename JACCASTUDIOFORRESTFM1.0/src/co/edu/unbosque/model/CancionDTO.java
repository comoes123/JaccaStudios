package co.edu.unbosque.model;

import java.io.Serializable;


public class CancionDTO implements Serializable{

    
	// entero el cual identifia a la cancion en cuestion
	
	private int iD;

	private String genero;

	private String nombre;

	private String artista;

	private String archivo;

	public CancionDTO(int iD, String genero, String nombre, String artista, String archivo){
		this.iD = iD;
		this.genero = genero;
		this.nombre = nombre;
		this.artista = artista;
		this.archivo = archivo;
	}

	
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
}
