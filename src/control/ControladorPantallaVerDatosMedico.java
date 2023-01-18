package control;
import java.util.Vector;

import entidades.Deportista;
import entidades.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPantallaVerDatosMedico {

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelCorreo;

    @FXML
    private Button botonCitas;

    @FXML
    private Button botonHistorial;

    @FXML
    private Label labelistaUsuarios;

    @FXML
    private Label listaUsuarios;

    @FXML
    private Label labelhorasDispo;

    @FXML
    private Label horasDispo;

    @FXML
    private TextField cajaNombre; 

    @FXML
    private TextField cajaDia;
    
    
    static ControladorArchivosMedico cam = new ControladorArchivosMedico();
    static ControladorJSON c = new ControladorJSON();
	static String dirFile = "deportistas.json";
	static Vector	<Deportista> 	vectorDeportistasDispos 		= new Vector<Deportista>();
    
    @FXML
    void asignarCita(ActionEvent event) { // Ó RESERVA 
    	 	
    	String n = cajaNombre.getText();	String d = cajaDia.getText();
    	Boolean citar = cam.dameCita(n);
    	
    	if(citar == false) {
    		horasDispo.setText("No puedes tener una cita con este usuario.");
    	} else {	
    		vectorDeportistasDispos = cam.quitarDispo(n, d);
    		c.vectorDeportistaAJSON(vectorDeportistasDispos, dirFile);
    		horasDispo.setText("CITA ASIGNADA CON EXITO!");	
    	}	
    }
    
    

    @FXML
    void verHistorial(ActionEvent event) { // LLAMEMOSLO MEJOR VER PERSONAS Y HORARIOS
	
	String nombres = cam.dameNombres();		String dispos = cam.dameDispos();	String combo = cam.dameNombreYDispo();	
	listaUsuarios.setText(combo);
    }

}
