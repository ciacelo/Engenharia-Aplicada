/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casiaplication;

<<<<<<< HEAD
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
=======
import java.io.IOException;

import javax.swing.JOptionPane;

import com.sun.javafx.scene.control.behavior.ButtonBehavior;
import com.sun.javafx.scene.control.behavior.KeyBinding;
import casiaplication.componentes.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
>>>>>>> origin/master

/**
 *
 * @author ciacelo
 */
public class CasiAplication extends Application {
    
    public static Stage stage = null;
<<<<<<< HEAD
  
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/casiaplication/view/FXMLLogin.fxml"));
=======
    public BorderPane root;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
    	// Inicialização necessária para pressionar o botão ao teclar ENTER
        new EnableButtonEnterKey();
    	
        root = new FXMLLoader(getClass().getResource("/casiaplication/view/FXMLMain.fxml")).load();
        root.setEffect(new BoxBlur()); // Aplicando o efeito de desfoque na principal

        Scene scene = new Scene(root);

        primaryStage.setTitle("CASI Aplication");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        primaryStage.setMaximized(true);

        // Carregando a tela de login
        AnchorPane rootLogin = new FXMLLoader(getClass().getResource("/casiaplication/view/FXMLLogin.fxml")).load();
        Scene sceneLogin = new Scene(rootLogin);

        Stage stageLogin = new Stage(StageStyle.TRANSPARENT);
        stageLogin.initModality(Modality.APPLICATION_MODAL);

        stageLogin.initOwner(primaryStage);
        stageLogin.setScene(sceneLogin);

        // Deixando o painel transparente para a sombra ficar visível
        stageLogin.getScene().getRoot().setStyle("-fx-background-color: transparent;");
        stageLogin.getScene().setFill(null);

        // Definindo a ação para quando o login fechar: remover o desfoque da principal
        stageLogin.setOnHiding((e) -> root.setEffect(null));

        stageLogin.show();

        // Definindo opacidade para zero inicilmente para dar o  efeito de entrada
        rootLogin.setOpacity(0);

        new FadeInUpTransition(rootLogin)
        .setDelayTime(Duration.millis(200))
        .setDuration(Duration.millis(500))
        .play();
        /*Parent root = new FXMLLoader(getClass().getResource("/casiaplication/view/FXMLMain.fxml")).load();
        root.setEffect(new BoxBlur());
>>>>>>> origin/master
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        this.stage = stage;
<<<<<<< HEAD
        stage.show();
       
        
    }
=======
        
        
        
        initMain();
       */
        
    }
    /*public void initMain() throws IOException{
    	
    	AnchorPane loginParent = FXMLLoader.load(getClass().getResource("/casiaplication/view/FXMLLogin.fxml"));
        Scene loginScene = new Scene(loginParent);
        //Stage app_stage = (Stage) ((Node)enterLogin.getSource()).getScene().getWindow();
        stage.setScene(loginScene);
        stage.show();
			           
		                
		
    }
>>>>>>> origin/master
    
   /* public static void changeScreen(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
               
                break;
            case "enter":
                stage.setScene(mainScene);
        }
    }
    */
<<<<<<< HEAD
=======
    
>>>>>>> origin/master
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
<<<<<<< HEAD
}
 
=======
    public class EnableButtonEnterKey extends ButtonBehavior<Button> {

        public EnableButtonEnterKey() {
            super(new Button());
            BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_PRESSED, "Press"));
            BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_RELEASED, "Release"));
        }
    
    }
}
>>>>>>> origin/master
