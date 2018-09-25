package casiaplication.controller;


import casiaplication.componentes.LoadRoot;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class FXMLMainController {

    @FXML
    private JFXButton btnEvents;
    
    @FXML
    private JFXButton btnTaref;

    @FXML
    private JFXButton btnDoc;

    @FXML
    private JFXButton btnPlan;

    @FXML
    private JFXButton btnFin;

    @FXML
    private JFXButton btnOther;

    @FXML
    private JFXButton btnAtividade;

    @FXML
    private JFXButton btnMain;
    
    @FXML
    private BorderPane borderPane;
    
    
    @FXML 
    private void eventos(MouseEvent event) {
       LoadRoot.loadScene("/casiaplication/view/FXMLEventos", getClass()); 
       
    }
    

}
