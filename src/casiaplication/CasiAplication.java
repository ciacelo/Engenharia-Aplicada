/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casiaplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ciacelo
 */
public class CasiAplication extends Application {
    
    private static Stage stage;
    private static Stage mainStage;
    private static Scene mainScene;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage = primaryStage;
        
        primaryStage.setTitle("CASystem");
        
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLLogin.fxml"));
        Scene scene = new Scene(root);
        
        Parent mainRoot = FXMLLoader.load(getClass().getResource("view/FXMLMain.fxml"));
        mainScene = new Scene(mainRoot);
        
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        
    }
    
    public static void changeScreen(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                stage.initStyle(StageStyle.UTILITY);
                break;
            case "enter":
                stage.setScene(mainScene);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
