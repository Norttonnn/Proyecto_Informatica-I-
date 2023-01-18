package entidades;

public class Medico extends Persona{
	
	public String especialidad;
	public String numeroColegiado;
	
	public Medico() {
		super();
	}
	
	public Medico(String correo, int id, String nombre, String apellidos, String pass, int edad, String especialidad, String numeroColegiado) {
		super(correo, id,nombre,apellidos,pass,edad);
		this.especialidad = especialidad;
		this.numeroColegiado = numeroColegiado;
	}
	
	// GETTERS
	public String getCorreo() {return correo;}
	public int getId() {return id;}
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getPass() {return pass;}
	public int getEdad() {return edad;}
	public String getEspecialidad() {return especialidad;}
	public String getNumeroColegiado() {return numeroColegiado;}
	
	
	// MÉTODO TOSTRING PARA LA LECTURA DE LOS DATOS
	public String toString() {
		String salida = 
				"ID: " + id +
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos +
				"\nEdad: " + edad +
				"\nEspecialidad: " + especialidad + 
				"\nNumero Colegiado: " + numeroColegiado;
		return salida;
		
	}

}
