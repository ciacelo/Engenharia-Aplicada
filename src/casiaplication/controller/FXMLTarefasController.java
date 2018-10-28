package casiaplication.controller;



import java.net.URL;
import java.util.ResourceBundle;

import casiaplication.model.database.TarefaTXTService;
import casiaplication.model.domain.Tarefa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
*
* @author ciacelo
*/
public class FXMLTarefasController implements Initializable{





		@FXML
		private TableView<Tarefa> tblTarefas;
		@FXML
		private TableColumn<Tarefa, String> clNome;
		@FXML
		private TableColumn<Tarefa, String> clDesc;
		@FXML
		private TableColumn<Tarefa, Date> clData;
		@FXML
		private TextField txtNome;
		@FXML
		private TextField txtDesc;
		@FXML
		private DatePicker dpData;
		@FXML
		private Button btnSalvar;
		@FXML
		private Button btnAtualizar;
		@FXML
		private Button btnApagar;
		@FXML
		private Button btnLimpart;
	    
	    @FXML 
	    private AnchorPane anchorPane;

		private TarefaTXTService service;

//		 Esse m�todo � chamado ao inicializar a aplica��o, igual um construtor. Ele vem da interface Initializable
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			service = new TarefaTXTService();
			configuraColunas();
			configuraBindings();
			atualizaDadosTabela();
		}

		// m�todos p�blicos chamados quando o bot�o � clicado
		
		@FXML
		public void salvar() {
			Tarefa t = new Tarefa();
			pegaValores(t);
			service.salvar(t);
			atualizaDadosTabela();
		}

		@FXML
		public void atualizar() {
			Tarefa t = tblTarefas.getSelectionModel().getSelectedItem();
			pegaValores(t);
			service.atualizar(t);
			atualizaDadosTabela();
		}

		@FXML
		public void apagar() {
			Tarefa t = tblTarefas.getSelectionModel().getSelectedItem();
			service.apagar(t.getId());
			atualizaDadosTabela();
		}

		@FXML
		public void limpar() {
			tblTarefas.getSelectionModel().select(null);
			txtNome.setText("");
			txtDesc.setText("");
			dpData.setValue(null);
		}
		
		// m�todos privados do controller

		// pega os valores entrados pelo usu�rio e adiciona no objeto conta
		private void pegaValores(Tarefa t) {
			t.setNome(txtNome.getText());
			t.setDescricao(txtDesc.getText());
			t.setData(dataSelecionada());
		}

		// m�todo utilit�rio para pega a data que foi selecionada (que usa o tipo novo do java 8 LocalDateTime)
		private Date dataSelecionada() {
			LocalDateTime time = dpData.getValue().atStartOfDay();
			return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		}

		// chamado quando acontece alguma opera��o de atualiza��o dos dados
		private void atualizaDadosTabela() {
			tblTarefas.getItems().setAll(service.buscarTodas());
			limpar();
		}

		// configura as colunas para mostrar as propriedades da classe Tarefa
		private void configuraColunas() {
			clNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			clDesc.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
			clData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		}

		// configura a l�gica da tela
		private void configuraBindings() {
			// esse binding s� e false quando os campos da tela est�o preenchidos
			BooleanBinding camposPreenchidos = txtNome.textProperty().isEmpty().or(txtDesc.textProperty().isEmpty())
					.or(dpData.valueProperty().isNull());
			// indica se h� algo selecionado na tabela
			BooleanBinding algoSelecionado = tblTarefas.getSelectionModel().selectedItemProperty().isNull();
			// alguns bot�es s� s�o habilitados se algo foi selecionado na tabela
			btnApagar.disableProperty().bind(algoSelecionado);
			btnAtualizar.disableProperty().bind(algoSelecionado);
			btnLimpart.disableProperty().bind(algoSelecionado);
			// o bot�o salvar s� � habilitado se as informa��es foram preenchidas e n�o tem nada na tela
			btnSalvar.disableProperty().bind(algoSelecionado.not().or(camposPreenchidos));
			// quando algo � selecionado na tabela, preenchemos os campos de entrada com os valores para o 
			// usu�rio editar
			tblTarefas.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
				if (n != null) {
					LocalDate data = null;
					data = n.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					txtNome.setText(n.getNome());
					txtDesc.setText(n.getDescricao());
					dpData.setValue(data);
				}
			});
		}

}


