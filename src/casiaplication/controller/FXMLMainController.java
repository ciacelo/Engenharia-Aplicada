package casiaplication.controller;

import casiaplication.CasiAplication;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
=======

import javafx.event.ActionEvent;
>>>>>>> origin/master
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
<<<<<<< HEAD
    @FXML
    private ImageView btnClose;
=======
    
    @FXML
    private ImageView btnClose;
    
>>>>>>> origin/master
    @FXML
    private ImageView btnMax;

    private Double x,y;
    private boolean maximize = true;
    
    
    @FXML 
    private void eventos(MouseEvent event) {
       loadEvent("/casiaplication/view/FXMLEvent"); 
       
    }
    
<<<<<<< HEAD
    private void loadEvent(String event){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(event+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, e);
        }
        borderPane.setCenter(root);
=======
    protected void loadEvent(String event){
        BorderPane mainRoot = null; 
        
        try {
            mainRoot = FXMLLoader.load(getClass().getResource(event+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, e);
        }
        borderPane.setCenter(mainRoot);
>>>>>>> origin/master
    }

    @FXML
    public void handlerMouseMin(MouseEvent event) {
<<<<<<< HEAD
        CasiAplication.stage.setIconified(true);
=======
    	Stage stage = (Stage)borderPane.getScene().getWindow();
    	stage.setIconified(true);
>>>>>>> origin/master
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
