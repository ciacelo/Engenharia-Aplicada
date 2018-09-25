package casiaplication.controller;


/**
 * Sample Skeleton for 'FXMLEvent.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import casiaplication.model.database.EventCSVService;
import casiaplication.model.database.EventService;
import casiaplication.model.domain.Evento;
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


public class FXMLEventController implements Initializable{





		@FXML
		private TableView<Evento> tblEventos;
		@FXML
		private TableColumn<Evento, String> clNome;
		@FXML
		private TableColumn<Evento, String> clDesc;
		@FXML
		private TableColumn<Evento, Date> clData;
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

		private EventCSVService service;

//		 Esse método é chamado ao inicializar a aplicação, igual um construtor. Ele vem da interface Initializable
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			service = new EventCSVService();
			configuraColunas();
			configuraBindings();
			atualizaDadosTabela();
		}

		// métodos públicos chamados quando o botão é clicado
		
		@FXML
		public void salvar() {
			Evento e = new Evento();
			pegaValores(e);
			service.salvar(e);
			atualizaDadosTabela();
		}

		@FXML
		public void atualizar() {
			Evento e = tblEventos.getSelectionModel().getSelectedItem();
			pegaValores(e);
			service.atualizar(e);
			atualizaDadosTabela();
		}

		@FXML
		public void apagar() {
			Evento e = tblEventos.getSelectionModel().getSelectedItem();
			service.apagar(e.getId());
			atualizaDadosTabela();
		}

		@FXML
		public void limpar() {
			tblEventos.getSelectionModel().select(null);
			txtNome.setText("");
			txtDesc.setText("");
			dpData.setValue(null);
		}
		
		// métodos privados do controller

		// pega os valores entrados pelo usuário e adiciona no objeto conta
		private void pegaValores(Evento e) {
			e.setNome(txtNome.getText());
			e.setDescricao(txtDesc.getText());
			e.setData(dataSelecionada());
		}

		// método utilitário para pega a data que foi selecionada (que usa o tipo novo do java 8 LocalDateTime)
		private Date dataSelecionada() {
			LocalDateTime time = dpData.getValue().atStartOfDay();
			return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		}

		// chamado quando acontece alguma operação de atualização dos dados
		private void atualizaDadosTabela() {
			tblEventos.getItems().setAll(service.buscarTodas());
			limpar();
		}

		// configura as colunas para mostrar as propriedades da classe Evento
		private void configuraColunas() {
			clNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			clDesc.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
			clData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		}

		// configura a lógica da tela
		private void configuraBindings() {
			// esse binding só e false quando os campos da tela estão preenchidos
			BooleanBinding camposPreenchidos = txtNome.textProperty().isEmpty().or(txtDesc.textProperty().isEmpty())
					.or(dpData.valueProperty().isNull());
			// indica se há algo selecionado na tabela
			BooleanBinding algoSelecionado = tblEventos.getSelectionModel().selectedItemProperty().isNull();
			// alguns botões só são habilitados se algo foi selecionado na tabela
			btnApagar.disableProperty().bind(algoSelecionado);
			btnAtualizar.disableProperty().bind(algoSelecionado);
			btnLimpart.disableProperty().bind(algoSelecionado);
			// o botão salvar só é habilitado se as informações foram preenchidas e não tem nada na tela
			btnSalvar.disableProperty().bind(algoSelecionado.not().or(camposPreenchidos));
			// quando algo é selecionado na tabela, preenchemos os campos de entrada com os valores para o 
			// usuário editar
			tblEventos.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
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
	
    
   /* 
    @FXML
    private void newEvent(ActionEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLNewEvent", getClass());
    	
    }
    
    @FXML
    private void editEvent(ActionEvent event) {
    	LoadRoot.loadScene("/casiaplication/view/FXMLEditEvent", getClass());
    }

    @FXML // This method is called by the FXLLoader when initialization is complete
    void initialize() {
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'FXMLEvent.fxml'.";
        assert btnListEvent != null : "fx:id=\"btnListEvent\" was not injected: check your FXML file 'FXMLEvent.fxml'.";

    }
    */


