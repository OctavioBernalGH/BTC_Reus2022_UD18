package Class;

public class DepartamentoClass {

	public int 		codigo;
	public String 	nombre;
	public int 		presupuesto;
	
	public DepartamentoClass() {
		
	}
/*Contructor 
 * @param: codigo Número de codigo del departamento
 * @param: nombre Nombre del departamento
 * @param: presupuesto Presupuesto del departamento
 */
	public DepartamentoClass(int codigo, String nombre, int presupuesto) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
//Getters ans setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
}
