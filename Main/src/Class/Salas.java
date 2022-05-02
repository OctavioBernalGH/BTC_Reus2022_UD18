package Class;

public class Salas {
	public int codigo;
	public String nombre;
	public int pelicula;
	
	public Salas() {
		
	}
	
	public Salas(int codigo, String nombre, int pelicula) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pelicula = pelicula;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getPelicula() {
		return pelicula;
	}



	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}
	
}
