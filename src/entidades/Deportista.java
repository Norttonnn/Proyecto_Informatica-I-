package entidades;

public class Deportista extends Persona{
	
	public Deportista() {} // CONSTRUCTOR VACIO
	
	public String dispo;
	public String entrenamiento;
	//	public Entrenamientos e;
	// public Marcas m;
	
	public  Deportista(String correo, int id, String nombre,String apellidos, String pass ,int edad, String dispo) {
		super(correo,id,nombre, apellidos, pass, edad);
		this.dispo = dispo;
	}
	
//	public Deportista(String dispo , String correo, int id, String nombre,String apellidos, String pass ,int edad) {
//		super(correo,id,nombre, apellidos, pass, edad);
//		this.dispo = dispo;
//		
//		
//	}

	public String getCorreo() {return correo;}
	public int getId() {return id;}
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getPass() {return pass;}
	public int getEdad() {return edad;}
	public String getDispo() {return dispo;}
	
	public String getEntrenamiento() {
		return entrenamiento;
	}

	
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