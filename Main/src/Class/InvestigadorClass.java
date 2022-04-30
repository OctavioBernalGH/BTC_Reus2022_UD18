package Class;

public class InvestigadorClass {
	
	public String dni;
	public String nomApels;
	public int facultad;
	
//Constructor empty	
	public InvestigadorClass() {
	
	}
//Constructor with params
	public InvestigadorClass(String dni, String nomApels, int facultad) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.facultad = facultad;
	}
//Getters and setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public int getFacultad() {
		return facultad;
	}

	public void setFacultad(int facultad) {
		this.facultad = facultad;
	}
	
	

}
