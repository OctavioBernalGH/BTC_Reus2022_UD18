package Class;

public class MaquinasRegistradoras {
	public int codigo;
	public int piso;
	
	public MaquinasRegistradoras() {
		
	}
	
	public MaquinasRegistradoras(int codigo, int piso) {
		super();
		this.codigo = codigo;
		this.piso = piso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}	
}
