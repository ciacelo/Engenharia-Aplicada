package casiaplication.controller;



import java.io.IOException;

/**
 * Sample Skeleton for 'FXMLEvent.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class FXMLEventController {

	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNew"
    private Button btnNew; // Value injected by FXMLLoader

    @FXML // fx:id="btnEdit"
    private Button btnEdit; // Value injected by FXMLLoader

    @FXML // fx:id="btnDelete"
    private Button btnDelete; // Value injected by FXMLLoader

    @FXML // fx:id="btnListEvent"
    private Button btnListEvent; // Value injected by FXMLLoader
    
    @FXML
    private BorderPane borderPane;
    
    @FXML 
    private AnchorPane anchorPane;
    
    @FXML
    private void newEvent(ActionEvent event) {
    	Pane newEventPane = null;
    	
    	try {
            // Carrega o person overview.
            //FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(getClass().getResource("/casiaplication/view/FXMLNewEvent.fxml"));
            //newEventPane = loader.load();
    		newEventPane = FXMLLoader.load(getClass().getResource("/casiaplication/view/FXMLNewEvent.fxml"));
            
        } catch (IOException e) {
        	Logger.getLogger(FXMLEventController.class.getName()).log(Level.SEVERE, null, e);
        }
    	
    	borderPane.setCenter(newEventPane);
    	
    	
    }
    
    private void loadEvent(String event){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(event+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, e);
        }
        borderPane.setCenter(root);
    }

    @FXML // This method is called by the FXLLoader when initialization is complete
    void initialize() {
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnListEvent != null : "fx:id=\"btnListEvent\" was not injected: check your FXML file 'FXMLEvent.fxml'.";

    }
}

