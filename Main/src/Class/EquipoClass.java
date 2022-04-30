package Class;

public class EquipoClass {
	
	public String numSerie;
	public String nombre;
	public int facultad;
	
//Constructor empty
	public EquipoClass() {
	
	}
//Constructor with parameters
	public EquipoClass(String numSerie, String nombre, int facultad) {
		
		this.numSerie = numSerie;
		this.nombre = nombre;
		this.facultad = facultad;
	}
//Getters and setters
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFacultad() {
		return facultad;
	}
	public void setFacultad(int facultad) {
		this.facultad = facultad;
	}
	
	

}
