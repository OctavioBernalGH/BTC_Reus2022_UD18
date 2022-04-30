package Class;

import java.util.Date;

public class ReservaClass {
	
	public String dni;
	public String numSerie;
	public Date comienzo;
	public Date fin;
	
//Empty constructor
	public ReservaClass() {
		
	}
//Constructor with parameters
	public ReservaClass(String dni, String numSerie, Date comienzo, Date fin) {
	
		this.dni = dni;
		this.numSerie = numSerie;
		this.comienzo = comienzo;
		this.fin = fin;
	}
	
//Getters and setters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public Date getComienzo() {
		return comienzo;
	}
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	
	

}
