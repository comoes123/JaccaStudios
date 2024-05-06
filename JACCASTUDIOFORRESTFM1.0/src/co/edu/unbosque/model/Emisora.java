package co.edu.unbosque.model;

import java.util.ArrayList;

public class Emisora {

	private String nombre;
	private String trasmision;
	private String genero;

	private ArrayList<Integer> listIdCancion;



	public Emisora(String nombre, String trasmision, String genero) {
		this.nombre = nombre;
		this.trasmision = trasmision;
		this.genero= genero;
	
		listIdCancion = new ArrayList<Integer>();
	}
	



	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero  = genero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getTrasmision() {
		return trasmision;
	}

	
	public void setTrasmision(String trasmision) {
		this.trasmision = trasmision;
	}

	
	public ArrayList<Integer> getListIdCancion() {
		return listIdCancion;
	}


	
	public void setListIdCancion(ArrayList<Integer> listIdCancion) {
		this.listIdCancion = listIdCancion;
	}

	@Override
	public String toString() {
		return "Emisora = " + nombre + ""
				+"\n"+"Trasmision = " + trasmision+""
				+"\n"+"Genero = " + genero;
	}
	
	
}
