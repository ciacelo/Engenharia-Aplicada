package casiaplication.controller;

import java.net.URL;
import java.util.ResourceBundle;

import casiaplication.componentes.LoadRoot;
import casiaplication.model.domain.Evento;
import casiaplication.model.domain.EventoJaExisteException;
import casiaplication.model.domain.GerenciaEventos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FXMLEditEventController implements Initializable {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfLocal;

    @FXML
    private TextField tfOrganization;

    @FXML
    private DatePicker tfDate;
    
    String name, descricao, local, organizador, data;
    Evento evento1;
    GerenciaEventos gerenteEventos;
    

    @FXML
    void btCancel(ActionEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLEvent", getClass());
    }

   
   /* @FXML
    void btRegister(ActionEvent event) throws EventoJaExisteException {
    	name = tfName.getText(); 
    	descricao = tfDescription.getText();
    	local = tfLocal.getText();
    	organizador = tfOrganization.getText();
    	data = tfDate.getTypeSelector();
    	
    	evento1 = new Evento(name, descricao, local, organizador, data);
    	gerenteEventos = GerenciaEventos.getInstance();
    	gerenteEventos.cadastraEvento(evento1);
    	
    	

    }
*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//tfDate.setValue(data);
		
	}
    
    

}
