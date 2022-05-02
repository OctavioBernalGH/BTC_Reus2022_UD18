package Class;

public class Suministra {
	public int codigoPieza;
	public String idProveedor;
	public int Precio;
	
	public Suministra() {
		
	}
	
	public Suministra(int codigoPieza, String idProveedor, int precio) {
		super();
		this.codigoPieza = codigoPieza;
		this.idProveedor = idProveedor;
		Precio = precio;
	}

	public int getCodigoPieza() {
		return codigoPieza;
	}

	public void setCodigoPieza(int codigoPieza) {
		this.codigoPieza = codigoPieza;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}
	
	
}
