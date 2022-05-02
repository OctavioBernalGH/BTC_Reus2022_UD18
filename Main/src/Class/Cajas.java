package Class;

public class Cajas {
	public int numReferencia;
	public String contenido;
	public int valor;
	public int almacen;
	
	public Cajas() {
		
	}
	
	public Cajas(int numReferencia, String contenido, int valor, int almacen) {
		super();
		this.numReferencia = numReferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}


	public int getNumReferencia() {
		return numReferencia;
	}


	public void setNumReferencia(int numReferencia) {
		this.numReferencia = numReferencia;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getAlmacen() {
		return almacen;
	}


	public void setAlmacen(int almacen) {
		this.almacen = almacen;
	}
	
	
}
	
