package casiaplication.controller;



import java.net.URL;
import java.util.ResourceBundle;

import casiaplication.model.database.FinancieXlsxService;
import casiaplication.model.database.FinancieService;
import casiaplication.model.domain.Financie;
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
public class FXMLFinancieController implements Initializable{





		@FXML
		private TableView<Financie> tblFinancies;
		@FXML
		private TableColumn<Financie, String> clGastou;
		@FXML
		private TableColumn<Financie, String> clEntrou;
		@FXML
		private TableColumn<Financie, String> clDesc;
		@FXML
		private TableColumn<Financie, Date> clData;
		@FXML
		private TextField txtGastou;
		@FXML
		private TextField txtEntrou;
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

		private FinancieXlsxService service;

//		 Esse método é chamado ao inicializar a aplicação, igual um construtor. Ele vem da interface Initializable
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			service = new FinancieXlsxService();
			configuraColunas();
			configuraBindings();
			atualizaDadosTabela();
		}

		// métodos públicos chamados quando o botão é clicado
		
		@FXML
		public void salvar() {
			Financie f = new Financie();
			pegaValores(f);
			service.salvar(f);
			atualizaDadosTabela();
		}

		@FXML
		public void atualizar() {
			Financie f = tblFinancies.getSelectionModel().getSelectedItem();
			pegaValores(f);
			service.atualizar(f);
			atualizaDadosTabela();
		}

		@FXML
		public void apagar() {
			Financie f = tblFinancies.getSelectionModel().getSelectedItem();
			service.apagar(f.getId());
			atualizaDadosTabela();
		}

		@FXML
		public void limpar() {
			tblFinancies.getSelectionModel().select(null);
			dpData.setValue(null);
			txtDesc.setText("");
			txtGastou.setText("");
			txtEntrou.setText("");
		}
		
		// métodos privados do controller

		// pega os valores entrados pelo usuário eadiciona no objeto conta
		private void pegaValores(Financie f) {
			f.setData(dataSelecionada());
			f.setDescricao(txtDesc.getText());
			f.setEntrou(txtEntrou.getText());
			f.setGastou(txtGastou.getText());
		}

		// método utilitário para pega a data que eoi selecionada (que usa o tipo novo do java 8 LocalDateTime)
		private Date dataSelecionada() {
			LocalDateTime time = dpData.getValue().atStartOfDay();
			return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		}

		// chamado quando acontece alguma operação de atualização dos dados
		private void atualizaDadosTabela() {
			tblFinancies.getItems().setAll(service.buscarTodas());
			limpar();
		}

		// configura as colunas para mostrar as propriedades da classe einancie
		private void configuraColunas() {
			clData.setCellValueFactory(new PropertyValueFactory<>("Data"));
			clDesc.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
			clGastou.setCellValueFactory(new PropertyValueFactory<>("Gastou"));
			clEntrou.setCellValueFactory(new PropertyValueFactory<>("Entrou"));
			
		}

		// configura a lógica da tela
		private void configuraBindings() {
			// esse binding só efalse quando os campos da tela estão preenchidos
			BooleanBinding camposPreenchidos = dpData.valueProperty().isNull().or(txtDesc.textProperty().isEmpty()).
					or(txtGastou.textProperty().isNull()).or(txtEntrou.textProperty().isNull());
					
			// indica se há algo selecionado na tabela
			BooleanBinding algoSelecionado = tblFinancies.getSelectionModel().selectedItemProperty().isNull();
			// alguns botões só são habilitados se algo eoi selecionado na tabela
			btnApagar.disableProperty().bind(algoSelecionado);
			btnAtualizar.disableProperty().bind(algoSelecionado);
			btnLimpart.disableProperty().bind(algoSelecionado);
			// o botão salvar só é habilitado se as informações eoram preenchidas e não tem nada na tela
			btnSalvar.disableProperty().bind(algoSelecionado.not().or(camposPreenchidos));
			// quando algo é selecionado na tabela, preenchemos os campos de entrada com os valores para o 
			// usuário editar
			tblFinancies.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
				if (n != null) {
					LocalDate data = null;
					data = n.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					txtGastou.setText(n.getGastou());
					txtDesc.setText(n.getDescricao());
					dpData.setValue(data);
					txtEntrou.setText(n.getEntrou());
				}
			});
		}

}