package casiaplication.controller;

import casiaplication.componentes.LoadRoot;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLMainReturn {


    @FXML
    private ImageView iconTaref;

    @FXML
    private ImageView iconEvents;

    @FXML
    private ImageView iconDoc;

    @FXML
    void openDoc(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLDocuments", getClass());
    }

    @FXML
    void openEvents(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLEventos", getClass());
    }
    
    @FXML
    void openTaref(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLTarefas", getClass());
    }

}    
    