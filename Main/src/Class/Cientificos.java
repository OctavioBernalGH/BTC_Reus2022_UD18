package Class;

public class Cientificos {
	public String dni;
	public String NomApels;
	
	public Cientificos() {
		
	}
	
	public Cientificos(String dni, String nomApels) {
		super();
		this.dni = dni;
		NomApels = nomApels;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return NomApels;
	}

	public void setNomApels(String nomApels) {
		NomApels = nomApels;
	}
	
	
}
