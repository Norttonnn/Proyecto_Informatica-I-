package entidades;

public class Entrenador extends Persona{
	
	public String especialidad;
	
	public Entrenador() {
		super();
	}
	
	public Entrenador(String correo,int id, String nombre, String apellidos, String pass, int edad, String especialidad ) {
		super(correo, id,nombre,apellidos,pass,edad);
		this.especialidad = especialidad;
	}
	
	// GETTERS
	public String getCorreo() {return correo;}
	public int getId() {return id;}
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getPass() {return pass;}
	public int getEdad() {return edad;}
	public String getEspecialidad() {return especialidad;}
	
	
	// MÉTODO TOSTRING PARA LA LECTURA DE LOS DATOS
	public String toString() {
		String salida = 
				"Correo: " + correo +
				"ID: " + id +
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos +
				"\nEdad: " + edad +
				"\nEspecialidad: " + especialidad;
		return salida;
	}
	

}
