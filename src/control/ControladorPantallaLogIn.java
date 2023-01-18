package control;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPantallaLogIn {

    @FXML
    private TextField mailRegistro;

    @FXML
    private TextField surnameRegistro;

    @FXML
    private TextField nameRegistro;

    @FXML
    private Button botonRegistro;

    @FXML
    private Label miLabel;

    @FXML
    private DatePicker fechaRegistro;

    @FXML
    private PasswordField passRegistro;

    @FXML
    private PasswordField pass2Registro;
    
    @FXML
    private TextField especialityRegistro;

    @FXML
    private CheckBox checkDepor;

    @FXML
    private CheckBox checkMedico;

    @FXML
    private CheckBox checkEntrenador;
    
    @FXML
    private Label labelName;

    @FXML
    private Label labelSurname;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelCompletado;
    
    @FXML
    private Button backButton;
    
    @FXML
    void volver(ActionEvent event) {
    	try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/view/PantallaPrincipal.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaPrincipal control = new ControladorPantallaPrincipal(); // IMPORTANTE CAMBIAR ESTO
			loader3.setController(control);
			Parent root2 = loader3.load();
			
			
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    

    @FXML
    void registraEsto(ActionEvent event) {
    	
    	// MIS VARIABLES PARA EL TRABAJO DE REGISTRO
        ControladorJSON c = new ControladorJSON();
        String dirFileDeportista 	= "deportistas.json";
    	String dirFilePersonas 		= "personas.json"; 
    	String dirFileMedicos 		= "medicos.json";
    	String dirFileEntrenadores 	= "entrenadores.json";
    	
    	
    	c.vectorPersonas 		= c.JsonA_Personas(dirFilePersonas);
    	c.vectorDeportistas 	= c.JsonA_Deportista(dirFileDeportista);
    	c.vectorEntrenadores 	= c.JsonA_Entrenadores(dirFileEntrenadores);
    	c.vectorMedicos 		= c.JsonA_Medicos(dirFileMedicos);
    	

    	String correo 		= mailRegistro.getText();
    	int id 				= c.vectorPersonas.size()+1;
    	String nombre 		= nameRegistro.getText();
    	String apellidos 	= surnameRegistro.getText();
    	String pass 		= passRegistro.getText();
    	String pass2 		= pass2Registro.getText();
    	int edad 			= 21;
    	String especialidad = especialityRegistro.getText();
    	
    	int x = c.vectorMedicos.size();
    	String numeroColegiado = "MED" + (x+1);
    	
    	Boolean accesoDeportista = false; Boolean accesoMedico = false; Boolean accesoEntrenador = false;
    	
    	if(checkDepor.isSelected()) {accesoDeportista = true;}
    	if(checkMedico.isSelected()) {accesoMedico = true;}
    	if(checkEntrenador.isSelected()) {accesoEntrenador = true;}
    	
    	if(pass.equals(pass2)) {
//    		Persona p = new Persona(correo, id , nombre , apellidos , pass , edad);
//    		c.meterPersonaaEnJSON(p);
    		
    		if(accesoDeportista == true && accesoMedico == false && accesoEntrenador == false) {
    			
    			Deportista d = new Deportista(correo, c.vectorPersonas.size()+1 , nombre , apellidos , pass , edad, "miercoles");
        		c.meterDeportistaEnJSON(d);
        		
        	} else if(accesoMedico == true && accesoEntrenador == false && accesoDeportista == false) {
        		
        		Medico m = new Medico(correo, c.vectorPersonas.size()+1 , nombre , apellidos , pass , edad, especialidad, numeroColegiado);
        		c.meterMedicoaEnJSON(m);
        		c.meterPersonaaEnJSON(m);
        		
        	} else if(accesoEntrenador == true && accesoMedico == false &&  accesoDeportista == false) {
        		
        		Entrenador e = new Entrenador(correo, c.vectorPersonas.size()+1 , nombre , apellidos , pass , edad, especialidad);
        		c.meterEntrenadoraEnJSON(e);
        		c.meterPersonaaEnJSON(e);
        		
        	} else {
        		labelCompletado.setText("SOLO PUEDES COGER UN TIPO DE PERSONA");
        	}
    		
    		
    	} else {
    		labelPassword.setText("CONTRASEÑAS NO COINCIDEN");
    	}
    	
    	labelName.setText("Name: " + nombre);
    	labelSurname.setText("Apellidos: " + apellidos);
    	labelPassword.setText("Contraseña: " + pass);
    	labelCompletado.setText("Registro completado! Gracias por contar con Perfort");
    	
    }

}

