package control;
import java.util.Vector;

import entidades.Deportista;
import entidades.Entrenamientos;
import entidades.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPantallaVerDatosDeportista {

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelCorreo;

    @FXML
    private Button botonMarcas;

    @FXML
    private Button botonEntreno;

    @FXML
    private Label labelDatos;  
    
    static ControladorJSON c = new ControladorJSON();
    
    Vector	<Deportista> 		vectorDeportistas 		= new Vector<Deportista>();
    Vector	<Entrenamientos> 	vectorEntrenamientos	= new Vector<Entrenamientos>();
    
    String dirFileDeportista 		= "deportistas.json";
    String dirFileEntrenamientos 	= "entrenamientos.json";

    

    @FXML
    void verEntreno(ActionEvent event) {
    	vectorDeportistas = c.JsonA_Deportista(dirFileDeportista);
    	for(int i = 0; i < vectorDeportistas.size(); i++) {
    		labelDatos.setText(vectorDeportistas.get(i).nombre + "\n" 
    				+ vectorDeportistas.get(i).correo + "\n"
    				+ vectorDeportistas.get(i).dispo) ;
    	}

    }

    @FXML
    void verMarcas(ActionEvent event) {
    	
    	ControladorJSON c = new ControladorJSON();

    	
    	Deportista dep = new Deportista();
    	dep = c.JsonA_DeportistaUnico("temportal.json"); // CUIDAT QUE PONE TEMPORTAL NO TEMPORAL BOBO
    	
    	labelNombre.setText(dep.nombre);
    	labelCorreo.setText(dep.correo);
    	
    	
    	

    }

}
