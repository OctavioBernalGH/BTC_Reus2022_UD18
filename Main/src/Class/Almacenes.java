package Class;

public class Almacenes {
	public int codigo;
	public String lugar;
	public int capacidad;
	
	public Almacenes () {
		
	}
	
	public Almacenes(int codigo, String lugar, int capacidad) {
		super();
		this.codigo = codigo;
		this.lugar = lugar;
		this.capacidad = capacidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}	
}
