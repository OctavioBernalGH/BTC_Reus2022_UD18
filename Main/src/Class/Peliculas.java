package Class;

public class Peliculas {
	public int codigo;
	public String nombre;
	public int calificacionEdad;
	
	public Peliculas() {
		
	}
	
	public Peliculas(int codigo, String nombre, int calificacionEdad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;
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

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionEdad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}
	
	
	
}
