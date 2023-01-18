package control;

import java.util.Vector;

import entidades.Deportista;
import entidades.Entrenador;
import entidades.Medico;
import entidades.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPantallaPrincipal {

    @FXML
    private TextField miUsuario;

    @FXML
    private Button miBotonLogin;

    @FXML
    private Label miLabel1;

    @FXML
    private TextField miPass;

    @FXML
    private Label miLabel2;

    @FXML
    private Button miBotonRegister;
    
    String dirFileDeportista 	= "deportistas.json";
	String dirFilePersonas 		= "personas.json"; 
	String dirFileMedicos 		= "medicos.json";
	String dirFileEntrenadores 	= "entrenadores.json";
	String dirFileTemportal		= "temportal.json";
	
    
    
    Vector	<Deportista> 	vectorDeportistas 		= new Vector<Deportista>();
	Vector	<Persona> 		vectorPersonas 			= new Vector<Persona>();
	Vector	<Medico> 		vectorMedicos 			= new Vector<Medico>();
	Vector	<Entrenador> 	vectorEntrenadores 		= new Vector<Entrenador>();
	
	


    @FXML
    void accedeLogIn(ActionEvent event) { // VERIFICA LAS CREDENCIALES DEL USUARIO
    	
    	// CONTROLADOR DE LA CLASE JSON PARA LUEGO LLAMAR A LOS MÉTODOS DE DICHA CLASE QUE ES DONDE SE ENCUENTRAN LAS FUNCIONES PARA SACAR LOS DATOS DEL JSON Y METERLOS
    	ControladorJSON c = new ControladorJSON();
    	
    	// CREAMOS ENTIDADES VACÍAS PARA LUEGO RELLENARLAS
    	Entrenador entrenador 	= null;		Medico medico 			= null;		Deportista deportista 	= null;
    	
    	// SACAMOS LA INFORMACIÓN DE LOS JSON Y LO METEMOS EN VECTORES
    	vectorPersonas 		= c.JsonA_Personas(dirFilePersonas);
    	vectorDeportistas 	= c.JsonA_Deportista(dirFileDeportista);
    	vectorEntrenadores 	= c.JsonA_Entrenadores(dirFileEntrenadores);
    	vectorMedicos 		= c.JsonA_Medicos(dirFileMedicos);
    	   	
    	
		// ALMACENAMOS LO OBTENIDOS POR LOS TEXTFIELDS EN LAS SIGUIENTES VARIABLES PARA REALIZAR LA COMPROBACIÓN
		String correo = miUsuario.getText();		String pass = miPass.getText();
		
		// VARIABLES QUE PERMITIÁN IR A UNA PANTALLA DIFERENTE DEPENDIENDO DEL TIPO DE PERSONA QUE SEAMOS
		Boolean accesoDeportista = false; Boolean accesoMedico = false; Boolean accesoEntrenador = false;
		
		
		// COMPROBADOR DE DATOS Y DIRECCIONADOR PARA LOS MÉDICOS
		for(int i = 0; i < vectorMedicos.size(); i++) {
			if(correo.equals(vectorMedicos.get(i).correo) && pass.equals(vectorMedicos.get(i).pass)) {
				accesoMedico = true; // PERMITIRÁ EL ACCESO POSTERIORMENTE
				
				// CREAMOS UN MÉDICO TEMPORAL PARA METERLO LUEGO EN UN JSON TEMPORAL PARA JUGAR CON SUS DATOS A POSTERIORI
				
				medico = new Medico(vectorMedicos.get(i).correo , vectorMedicos.get(i).id , vectorMedicos.get(i).nombre ,
						vectorMedicos.get(i).apellidos , vectorMedicos.get(i).pass , vectorMedicos.get(i).edad 
						, vectorMedicos.get(i).especialidad ,vectorMedicos.get(i).numeroColegiado);
				
				i = vectorMedicos.size()+1;		// UNA VEZ TENEMOS LO QUE QUEREMOS SALIMOS DEL BUCLE	
			}
		}
		
		
		// COMPROBADOR DE DATOS Y DIRECCIONADOR PARA LOS ENTRENADORES
		for(int i = 0; i < vectorEntrenadores.size(); i++) {
			if(correo.equals(vectorEntrenadores.get(i).correo) && pass.equals(vectorEntrenadores.get(i).pass)) {
				accesoEntrenador = true;	// PERMITIRÁ EL ACCESO POSTERIORMENTE
				
				// CREAMOS UN ENTRENADOR TEMPORAL PARA METERLO LUEGO EN UN JSON TEMPORAL PARA JUGAR CON SUS DATOS A POSTERIOR
				
				entrenador = new Entrenador(vectorEntrenadores.get(i).correo , vectorEntrenadores.get(i).id , vectorEntrenadores.get(i).nombre ,
						vectorEntrenadores.get(i).apellidos , vectorEntrenadores.get(i).pass , vectorEntrenadores.get(i).edad 
						, vectorEntrenadores.get(i).especialidad);
				
				i = vectorEntrenadores.size()+1;	// UNA VEZ TENEMOS LO QUE QUEREMOS SALIMOS DEL BUCLE
			}
		}
		
		
		// COMPROBADOR DE DATOS Y DIRECCIONADOR PARA LOS DE0PORTISTAS
		for(int i = 0; i < vectorDeportistas.size(); i++) {
			if(correo.equals(vectorDeportistas.get(i).correo) && pass.equals(vectorDeportistas.get(i).pass)) {
				accesoDeportista = true;	// PERMITIRÁ EL ACCESO POSTERIORMENTE
				
				// CREAMOS UN DEPORTISTA TEMPORAL PARA METERLO LUEGO EN UN JSON TEMPORAL PARA JUGAR CON SUS DATOS A POSTERIOR
				
				deportista = new Deportista(vectorDeportistas.get(i).correo , vectorDeportistas.get(i).id , vectorDeportistas.get(i).nombre ,
						vectorDeportistas.get(i).apellidos , vectorDeportistas.get(i).pass, vectorDeportistas.get(i).edad, vectorDeportistas.get(i).dispo);
				
				i = vectorDeportistas.size()+1;	// UNA VEZ TENEMOS LO QUE QUEREMOS SALIMOS DEL BUCLE
				
			}
		}
		
		// SI LOS DATOS NO COINCIDEN MANDAR MENSAJE POR PANTALLA
		if(accesoDeportista == accesoEntrenador == accesoMedico == false) {
			System.out.println("Las credenciales no coindicen con los registros de la base de datos. Por favor, pruebe otra vez");
		}
		
		
		
		//ESTO NOS LLEVA A LAS PANTALLAS CORRESPONDIENTES ALMACENANDO EN UN ARCHIVO TEMPORAL LOS DATOS PARA PODER MANEJARNOS A POSTERIORI CON ELLOS
		if(accesoDeportista == true) {
			c.deportistaEnJson(deportista, dirFileTemportal);
			try {
				FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosDeportista.fxml")); // NOS LLEVA A LA NUEVA VENTANA
				ControladorPantallaVerDatosDeportista control4 = new ControladorPantallaVerDatosDeportista(); // IMPORTANTE CAMBIAR ESTO
				loader4.setController(control4);
				Parent root4 = loader4.load();
	
				Stage stage = new Stage();
				stage.setScene(new Scene(root4));
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}		
		
	} else if(accesoMedico == true) {
		c.MedicoEnJson(medico, dirFileTemportal);
		try {
			FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosMedico.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaVerDatosMedico control4 = new ControladorPantallaVerDatosMedico(); // IMPORTANTE CAMBIAR ESTO
			loader4.setController(control4);
			Parent root4 = loader4.load();
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root4));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	} else if(accesoEntrenador == true) {
		
		c.EntrenadorEnJson(entrenador, dirFileTemportal);
		try {
			FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosEntrenador.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaVerDatosEntrenador control4 = new ControladorPantallaVerDatosEntrenador(); // IMPORTANTE CAMBIAR ESTO
			loader4.setController(control4);
			Parent root4 = loader4.load();  
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root4));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
    
    
    
    @FXML
    void registraUsuario(ActionEvent event) { // PERMITE ACCEDER AL MENÚ DE REGISTRACIÓN
    	
    	try {
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/PantallaRegistro.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaLogIn control = new ControladorPantallaLogIn(); // IMPORTANTE CAMBIAR ESTO
			loader2.setController(control);
			Parent root2 = loader2.load();
				
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	

    }

}
