package casiaplication.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import casiaplication.model.dao.UsuarioDAO;
import casiaplication.model.database.DBSqlite;
import casiaplication.model.domain.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class FXMLUsuarioController implements Initializable {
	
	   @FXML
	    private TableView<Usuario> tableViewUsuarios;
	    @FXML
	    private TableColumn<Usuario, String> tableColumnUsuarioNome;
	    @FXML
	    private TableColumn<Usuario, String> tableColumnUsuarioEmail;
	    @FXML
	    private TableColumn<Usuario, String> tableColumnUsuarioSenha;
	    @FXML
	    private Button buttonInserir;
	    @FXML
	    private Button buttonAlterar;
	    @FXML
	    private Button buttonRemover;
	    @FXML
	    private Label labelUsuarioCodigo;
	    @FXML
	    private Label labelUsuarioNome;
	    @FXML
	    private Label labelUsuarioEmail;
	    @FXML
	    private Label labelUsuarioSenha;

	    private List<Usuario> listUsuarios;
	    private ObservableList<Usuario> observableListUsuarios;

	    //Atributos para manipulação de Banco de Dados
	    private final DBSqlite database = new DBSqlite();
	    private final Connection connection = database.conectar();
	    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        usuarioDAO.setConnection(connection);
	        carregarTableViewUsuario();

	        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
	        tableViewUsuarios.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> selecionarItemTableViewUsuarios(newValue));

	    }

	    public void carregarTableViewUsuario() {
	        tableColumnUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	        tableColumnUsuarioEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
	        tableColumnUsuarioSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));

	        listUsuarios = usuarioDAO.listar();

	        observableListUsuarios = FXCollections.observableArrayList(listUsuarios);
	        tableViewUsuarios.setItems(observableListUsuarios);
	    }
	    
	    public void selecionarItemTableViewUsuarios(Usuario usuario){
	        if (usuario != null) {
	            labelUsuarioCodigo.setText(String.valueOf(usuario.getIdUsuario()));
	            labelUsuarioNome.setText(usuario.getNome());
	            labelUsuarioEmail.setText(usuario.getEmail());
	            labelUsuarioSenha.setText(usuario.getSenha());
	        } else {
	            labelUsuarioCodigo.setText("");
	            labelUsuarioNome.setText("");
	            labelUsuarioEmail.setText("");
	            labelUsuarioSenha.setText("");
	        }

	    }
	    
	    @FXML
	    public void handleButtonInserir() throws IOException {
	        Usuario usuario = new Usuario();
	        usuarioDAO.inserir(usuario);
	        carregarTableViewUsuario();
	        
	    }

	    @FXML
	    public void handleButtonAlterar() throws IOException {
	        Usuario usuario = tableViewUsuarios.getSelectionModel().getSelectedItem();
	        if (usuario != null) {
	            usuarioDAO.alterar(usuario);
	            carregarTableViewUsuario();
	        
	        } else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText("Por favor, escolha um usuario na Tabela!");
	            alert.show();
	        }
	    }

	    @FXML
	    public void handleButtonRemover() throws IOException {
	        Usuario usuario = tableViewUsuarios.getSelectionModel().getSelectedItem();
	        if (usuario != null) {
	            usuarioDAO.remover(usuario);
	            carregarTableViewUsuario();
	        } else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText("Por favor, escolha um usuario na Tabela!");
	            alert.show();
	        }
	    }
	    
	    


}
