package control;

import java.util.Vector;

import entidades.Deportista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorPantallaVerDatosEntrenador {

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelCorreo;

    @FXML
    private Button botonListaDeportistas;

    @FXML
    private Button botonVerEntreno;

    @FXML
    private Label labelistaUsuarios;

    @FXML
    private Button botonAsignarEntreno;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textNombre1;
    
    @FXML
    private Label mostrar;
    
    

    @FXML
    void asignarEntreno(ActionEvent event) { // ESTO PETA
    
    	ControladorArchivosEntrenador cae = new ControladorArchivosEntrenador();
    	ControladorJSON c = new ControladorJSON();
    	Vector<Deportista> d = new Vector<Deportista>();
    	String n = textNombre.getText();
    	d = cae.asignaEntreno(n);
    	c.vectorDeportistaAJSON(d, "deportistasEntreno.json");
    	
    	
    	

    }

    @FXML
    void verEntreno(ActionEvent event) {
    	ControladorArchivosEntrenador cae = new ControladorArchivosEntrenador();
    	String listaE;	listaE = cae.listaEntrenamientos();
    	mostrar.setText(listaE);
    }

    @FXML
    void verListaDeportistas(ActionEvent event) {
    	ControladorArchivosEntrenador cae = new ControladorArchivosEntrenador();
    	String listaD = cae.listaDeportistas();
    	mostrar.setText(listaD);
    	
    	

    }

}

