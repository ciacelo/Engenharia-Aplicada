package casiaplication.controller;

import casiaplication.CasiAplication;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXMLMainController {

    @FXML
    private JFXButton btnEvents;

    @FXML
    private JFXButton btnAtividade;

    @FXML
    private JFXButton btnMain;

    @FXML
    private ImageView btnMin;
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnMax;

    private Double x,y;
    private boolean maximize = true;
    
    
    @FXML 
    private void eventos(MouseEvent event) {
       loadEvent("/casiaplication/view/FXMLEvent"); 
       
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

    @FXML
    public void handlerMouseMin(MouseEvent event) {
        CasiAplication.stage.setIconified(true);
    }
    
    @FXML
    private void handlerMouseClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void handlerMouseMax(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(maximize){
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
            maximize = false;
        } else {
            stage.setFullScreen(false);
            maximize = true;
        }
    }

    @FXML
    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

}
