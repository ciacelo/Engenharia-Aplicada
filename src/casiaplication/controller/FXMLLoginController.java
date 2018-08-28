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
import javafx.fxml.Initializable;
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
            if(user.equals("casi@ufpb")&& pass.equals("casi2016.1")){
                JOptionPane.showMessageDialog(null, "Seja Bem-vindo.");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha, incorretos");
            }
        } catch (Exception e) {
            System.out.println("Erro de exeção!");
        }
    }
            
    @FXML
    public void handlerActionMinimize(ActionEvent mouseEvent){
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setIconified(true);

    }
    
    @FXML
    public void handlerMouseClicked(ActionEvent event){
        System.exit(0);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
