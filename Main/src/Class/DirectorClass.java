package Class;

public class DirectorClass {
	
	public String dni;
	public String nomApels;
	public String dniJefe;
	public int despacho;
	
//Empty constructor
	public DirectorClass() {
		
	}
//Constructor with params
	public DirectorClass(String dni, String nomApels, String dniJefe, int despacho) {
	
		this.dni = dni;
		this.nomApels = nomApels;
		this.dniJefe = dniJefe;
		this.despacho = despacho;
	}
//Getters and Setters
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

	public String getDniJefe() {
		return dniJefe;
	}

	public void setDniJefe(String dniJefe) {
		this.dniJefe = dniJefe;
	}

	public int getDespacho() {
		return despacho;
	}

	public void setDespacho(int despacho) {
		this.despacho = despacho;
	}
	
	

}
