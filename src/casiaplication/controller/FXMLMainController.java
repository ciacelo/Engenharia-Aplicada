package casiaplication.controller;


import casiaplication.componentes.LoadRoot;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
    private ImageView iconMenu;
    
    @FXML
    private ImageView iconTaref;
    
    @FXML
    private ImageView iconEvents;
    
    @FXML
    private ImageView iconDoc;
    
    @FXML
    private BorderPane borderPane;
    
    
    
    @FXML
    private void retornaMenu(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLMainReturn", getClass());
    }
    
    
    @FXML
    private void documents(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLDocuments", getClass());
    }
    
    @FXML 
    private void openDoc(MouseEvent event) {
       LoadRoot.loadScene("/casiaplication/view/FXMLDocuments", getClass()); 
       
    }
    
    @FXML 
    private void eventos(MouseEvent event) {
       LoadRoot.loadScene("/casiaplication/view/FXMLEventos", getClass()); 
       
    }
    
    @FXML 
    private void openEvents(MouseEvent event) {
       LoadRoot.loadScene("/casiaplication/view/FXMLEventos", getClass()); 
       
    }
    
    @FXML
    private void tarefas(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLTarefas", getClass());
    }
    
    @FXML
    private void openTaref(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLTarefas", getClass());
    }
    
    @FXML
    private void financas(MouseEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLFinancie", getClass());
    }
    
}
