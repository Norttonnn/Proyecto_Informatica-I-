package entidades;

public class Marcas {
	
	//Deportista d;
	String ritmo;
	String aceleracion;
	int pulsaciones;
	String distancia;
	
	public Marcas(  String ritmo , String aceleracion , int pulsaciones , String distancia) {
		//this.d				= d;
		this.ritmo 			= ritmo;
		this.aceleracion 	= aceleracion;
		this.pulsaciones 	= pulsaciones;
		this.distancia 		= distancia;
	}
	
	// GETTERS
	// public Deportista getDepor() {return d;}
	public String getRitmo() {return ritmo;}
	public String getAceleracion() {return aceleracion;}
	public int getPulsaciones(){return pulsaciones;}
	public String getDistancia() {return distancia;}
	
	public String toString() {
		String salida = // "Deportista: " 				+ d.nombre 		+
						"\nRitmo medio: " 			+ ritmo 		+
						"\nAceleracion media: " 	+ aceleracion 	+
						"\nMedia de pulsaciones: " 	+ pulsaciones 	+
						"Distancia media: " 		+ distancia;
		return salida;
	}

}
