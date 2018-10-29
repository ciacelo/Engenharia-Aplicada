package casiaplication.controller;



import java.net.URL;
import java.util.ResourceBundle;

import casiaplication.model.database.AtividadeTXTService;
import casiaplication.model.domain.Atividade;
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
public class FXMLAtividadesController implements Initializable{





		@FXML
		private TableView<Atividade> tblAtividades;
		@FXML
		private TableColumn<Atividade, String> clTitulo;
		@FXML
		private TableColumn<Atividade, String> clDesc;
		@FXML
		private TableColumn<Atividade, String> clResp;
		@FXML
		private TableColumn<Atividade, Date> clData;
		@FXML
		private TableColumn<Atividade, String> clDecor;
		@FXML
		private TextField txtTitulo;
		@FXML
		private TextField txtResp;
		@FXML
		private TextField txtDesc;
		@FXML
		private DatePicker dpData;
		@FXML
		private TextField txtDecor;
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

		private AtividadeTXTService service;

//		 Esse m�todo � chamado ao inicializar a aplica��o, igual um construtor. Ele vem da interface Initializable
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			service = new AtividadeTXTService();
			configuraColunas();
			configuraBindings();
			atualizaDadosTabela();
		}

		// m�todos p�blicos chamados quando o bot�o � clicado
		
		@FXML
		public void salvar() {
			Atividade a = new Atividade();
			pegaValores(a);
			service.salvar(a);
			atualizaDadosTabela();
		}

		@FXML
		public void atualizar() {
			Atividade a = tblAtividades.getSelectionModel().getSelectedItem();
			pegaValores(a);
			service.atualizar(a);
			atualizaDadosTabela();
		}

		@FXML
		public void apagar() {
			Atividade a = tblAtividades.getSelectionModel().getSelectedItem();
			service.apagar(a.getId());
			atualizaDadosTabela();
		}

		@FXML
		public void limpar() {
			tblAtividades.getSelectionModel().select(null);
			txtTitulo.setText("");
			txtDesc.setText("");
			txtResp.setText("");
			dpData.setValue(null);
			txtDecor.setText("");
		}
		
		// m�todos privados do controller

		// pega os valores entrados pelo usu�rio e adiciona no objeto atividade
		private void pegaValores(Atividade a) {
			a.setTitulo(txtTitulo.getText());
			a.setDescricao(txtDesc.getText());
			a.setResponsavel(txtResp.getText());
			a.setData(dataSelecionada());
			a.setDecorrencia(txtDecor.getText());
		}

		// m�todo utilit�rio para pega a data que foi selecionada (que usa o tipo novo do java 8 LocalDateTime)
		private Date dataSelecionada() {
			LocalDateTime time = dpData.getValue().atStartOfDay();
			return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		}

		// chamado quando acontece alguma opera��o de atualiza��o dos dados
		private void atualizaDadosTabela() {
			tblAtividades.getItems().setAll(service.buscarTodas());
			limpar();
		}

		// configura as colunas para mostrar as propriedades da classe Atividade
		private void configuraColunas() {
			clTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
			clDesc.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
			clResp.setCellValueFactory(new PropertyValueFactory<>("Responsavel"));
			clData.setCellValueFactory(new PropertyValueFactory<>("Data"));
			clDecor.setCellValueFactory(new PropertyValueFactory<>("Decorrencia"));
		}

		// configura a l�gica da tela
		private void configuraBindings() {
			// esse binding s� e false quando os campos da tela est�o preenchidos
			BooleanBinding camposPreenchidos = txtTitulo.textProperty().isEmpty().or(txtDesc.textProperty().isEmpty())
					.or(txtResp.textProperty().isEmpty()).or(dpData.valueProperty().isNull()).or(txtDecor.textProperty().isEmpty());
			// indica se h� algo selecionado na tabela
			BooleanBinding algoSelecionado = tblAtividades.getSelectionModel().selectedItemProperty().isNull();
			// alguns bot�es s� s�o habilitados se algo foi selecionado na tabela
			btnApagar.disableProperty().bind(algoSelecionado);
			btnAtualizar.disableProperty().bind(algoSelecionado);
			btnLimpart.disableProperty().bind(algoSelecionado);
			// o bot�o salvar s� � habilitado se as informa��es foram preenchidas e n�o tem nada na tela
			btnSalvar.disableProperty().bind(algoSelecionado.not().or(camposPreenchidos));
			// quando algo � selecionado na tabela, preenchemos os campos de entrada com os valores para o 
			// usu�rio editar
			tblAtividades.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
				if (n != null) {
					LocalDate data = null;
					data = n.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					txtTitulo.setText(n.getTitulo());
					txtDesc.setText(n.getDescricao());
					txtResp.setText(n.getResponsavel());
					dpData.setValue(data);
					txtDecor.setText(n.getDecorrencia());
				}
			});
		}

}


