package co.edu.unbosque.model;

public interface Reproductor {

/**
* Funcion para verificar la direccion del mp3 en un String
* @param ruta se le introduce la direccion de la cancion que hay en el sistema
* @return verifica si es un archivo mp3 o no 
*/
	public int verificarDirec(String ruta);
	
	/**
	 *Funcion para reproducir la musica
	 * @param Id se le ingresa el identificador de la cancion
     * @return especifica si se reproduce o no. si devuelve 1 se reproduce, si devuelve otro numer no se reproduce
	 */
	public int reproducirMusica(int Id);
}
