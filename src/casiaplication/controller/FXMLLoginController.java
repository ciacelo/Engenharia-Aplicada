/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casiaplication.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.events.WindowEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


/**
 *
 * @author ciacelo
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogar;

    @FXML
    private JFXButton btnClose;
    
    @FXML
    private JFXButton btnMinimize;
    
    @FXML
    public void enterLogin(ActionEvent enterLogin){
        try {
            String user = txtUserName.getText();
            String pass = txtPassword.getText();
            if(user.equals("c")&& pass.equals("c")){
                JOptionPane.showMessageDialog(null, "Seja Bem-vindo.");
                
                Parent mainParent = FXMLLoader.load(getClass().getResource("/casiaplication/view/FXMLMain.fxml"));
                Scene mainScene = new Scene(mainParent);
                Stage app_stage = (Stage) ((Node)enterLogin.getSource()).getScene().getWindow();
                app_stage.setScene(mainScene);
                app_stage.show();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha, incorretos");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
            
    @FXML
    public void handlerActionMinimize(ActionEvent event){
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setIconified(true);

    }
    
    @FXML
    public void handlerActionClosed(ActionEvent event){
        System.exit(0);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
