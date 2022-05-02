package Class;

public class EmpleadoClass {
	
	public String dni;
	public String nombre;
	public String apellidos;
	public int departamento;
	
//Empty constructor
	public EmpleadoClass() {
		
	}
//Constructor whit parameters
	public EmpleadoClass(String dni, String nombre, String apellidos, int departamento) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}
//Getters and setters
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	
	
	

}
