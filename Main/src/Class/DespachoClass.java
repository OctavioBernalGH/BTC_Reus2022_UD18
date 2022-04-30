package Class;

public class DespachoClass {
	
	public int numero;
	public int capacidad;
	
//Constructor Empty
	public DespachoClass() {
		
	}
//Constructor with parameters
	public DespachoClass(int numero, int capacidad) {
		
		this.numero = numero;
		this.capacidad = capacidad;
	}
	
//Getters and setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
	

}
