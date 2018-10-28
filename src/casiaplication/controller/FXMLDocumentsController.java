package casiaplication.controller;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class FXMLDocumentsController {

    @FXML
    private Button btnDiretorio = new Button();
    
    @FXML
    private ImageView iconDoc;

    @FXML
	void handlerDiretorio(ActionEvent event) throws IOException {
    	
    	
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Arquivo");

        File arq =  fileChooser.showOpenDialog(null);
        
        if(arq != null) {
        	Desktop desktop = Desktop.getDesktop();
        	desktop.open(arq);
        }
	 }



}
