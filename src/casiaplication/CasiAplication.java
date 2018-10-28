/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casiaplication;


import java.io.IOException;


import com.sun.javafx.scene.control.behavior.ButtonBehavior;
import com.sun.javafx.scene.control.behavior.KeyBinding;
import casiaplication.componentes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;
import javafx.stage.Modality;
import javafx.util.Duration;


/**
 *
 * @author ciacelo
 */
public class CasiAplication extends Application {
    
    public static Stage stage = null;

    public BorderPane root;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	stage = primaryStage;
        
    	// Inicialização necessária para pressionar o botão ao teclar ENTER
        new EnableButtonEnterKey();
    	
        root = new FXMLLoader(getClass().getResource("/casiaplication/view/FXMLMain.fxml")).load();
        root.setEffect(new BoxBlur()); // Aplicando o efeito de desfoque na principal

        Scene scene = new Scene(root);

        primaryStage.setTitle("CASI Aplication");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
 

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
    }
    
    public static void changeScreen(String scr, String root) {
    	switch (scr){
    		case "evento":
    			
    			break;
    		case "detalhes":
    			break;
    	}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public class EnableButtonEnterKey extends ButtonBehavior<Button> {

        public EnableButtonEnterKey() {
            super(new Button());
            BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_PRESSED, "Press"));
            BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_RELEASED, "Release"));
        }
    
    }
    
}

