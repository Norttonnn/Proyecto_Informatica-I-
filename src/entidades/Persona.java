package entidades;



public class Persona {
	
	public String correo;
	public int id;
	public String nombre;
	public String apellidos;
	public String pass;
	public int edad;
	
	public Persona(String correo, int id, String nombre, String apellidos, String pass, int edad) {
		
		this.correo = correo;
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pass = pass;
		this.edad = edad;
	}
	

	
	public Persona() {} // CONSTRUCTOR VACIO
	
	// GETTERS
	public String getCorreo() {
		return correo;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getPass() {
		return pass;
	}
	
	public int getEdad() {
		return edad;
	}

	
	// MÉTODO TOSTRING PARA LA LECTURA DE LOS DATOS
	public String toString() {
		String salida = 
				"Correo: " + correo +
				"ID: " + id +
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos +
				"\nEdad: " + edad;
		
		return salida;
		
	}
	
	
	

}
