package Class;

public class Venta {
	public int cajero;
	public int maquina;
	public int producto;
	
	public Venta() {
		
	}
	
	public Venta(int cajero, int maquina, int producto) {
		super();
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}

	public int getCajero() {
		return cajero;
	}

	public void setCajero(int cajero) {
		this.cajero = cajero;
	}

	public int getMaquina() {
		return maquina;
	}

	public void setMaquina(int maquina) {
		this.maquina = maquina;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}
	
	
}
