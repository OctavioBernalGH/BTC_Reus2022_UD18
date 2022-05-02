package Class;

public class Cajeros {
	public int codigo;
	public String nomApels;
	
	public Cajeros() {
		
	}
	
	public Cajeros(int codigo, String nomApels) {
		super();
		this.codigo = codigo;
		this.nomApels = nomApels;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
	
	
}
