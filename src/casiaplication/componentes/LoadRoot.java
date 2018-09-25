package casiaplication.componentes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import casiaplication.CasiAplication;
import casiaplication.controller.FXMLMainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoadRoot {
	
	public static void loadScene(String event, Object clas){
		  
        AnchorPane mainRoot = null; 
        
        try {
            mainRoot = FXMLLoader.load(clas.getClass().getResource(event+".fxml"));
            mainRoot.setPrefSize(735, 577);
        } catch (IOException e) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, e);
        }
        BorderPane pane = (BorderPane) CasiAplication.stage.getScene().getRoot();
        pane.setCenter(mainRoot);
    
	}
}