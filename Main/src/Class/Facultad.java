package Class;

public class Facultad {
	
	public int codigo;
	public String nombre;
	
//Empty constructor
	public Facultad() {
		
	}
//Constructor with params
	public Facultad(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
//Getters and setters
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
}
