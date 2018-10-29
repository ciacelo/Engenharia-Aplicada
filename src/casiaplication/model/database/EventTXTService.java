package casiaplication.model.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import casiaplication.model.domain.Evento;


public class EventTXTService implements EventService{
 
		
		// divisor de colunas no arquivo
		private static final String SEPARADOR = ";";

		// o caminho para o arquivo deve ser selecionado aqui
		
		private static final Path ARQUIVO_SAIDA = Paths.get("src/documento.txt");

		// os dados do arquivo
		private List<Evento> events;

		// formato de data usado no arquivo
		final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		public EventTXTService() {
			carregaDados();
		}

		@Override
		public void salvar(Evento event) {
			event.setId(ultimoId() + 1);
			events.add(event);
			salvaDados();
		}


		@Override
		public void atualizar(Evento event) {
			Evento eventoAntiga = buscaPorId(event.getId());
			eventoAntiga.setNome(event.getNome());
			eventoAntiga.setDescricao(event.getDescricao());
			eventoAntiga.setLocal(event.getLocal());
			salvaDados();
		}

		@Override
		public List<Evento> buscarTodas() {
			return events;
		}

		@Override
		public void apagar(int id) {
			Evento event = buscaPorId(id);
			events.remove(event);
			salvaDados();
		}

		public Evento buscaPorId(int id) {
			return events.stream().filter(e -> e.getId() == id).findFirst()
					.orElseThrow(() -> new Error("Evento não encontrado"));
		}

		// salva a lista de dados no arquivo, gerando um novo TXT e escrevendo o arquivo completamente
		private void salvaDados() {
			
			FileInputStream input;
		    String result = null;
		    try {
		        input = new FileInputStream(new File("src/documento.txt"));
		        CharsetDecoder decoder = Charset.forName("Cp1252").newDecoder();
		        decoder.onMalformedInput(CodingErrorAction.IGNORE);
		        InputStreamReader reader = new InputStreamReader(input, decoder);
		        BufferedReader bufferedReader = new BufferedReader( reader );
		        StringBuilder sb = new StringBuilder();
		        String line = bufferedReader.readLine();
		        
		        /*while( line != null ) {
		            sb.append( line );
		            line = bufferedReader.readLine();
		        }*/
		        bufferedReader.close();
		        result = sb.toString();
				for (Evento e : events) {
					String linha = criaLinha(e);
					sb.append(linha);
					sb.append(System.getProperty("line.separator"));
				}
				
				try {
					//Files.delete(ARQUIVO_SAIDA);
					//Files.(ARQUIVO_SAIDA, attrs);
					System.out.println(sb.toString());
					Files.write(ARQUIVO_SAIDA, sb.toString().getBytes());
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch( IOException e ) {
		        e.printStackTrace();
		    }
			
		}
		
		// o ID mais alto é retornado aqui para continuarmos contando os IDs
		private int ultimoId() {
			return events.stream().mapToInt(Evento::getId).max().orElse(0);
		}

		// carrega os dados do arquivo para a lista eventos
		private void carregaDados() {
			try {
				if(!Files.exists(ARQUIVO_SAIDA)) {
					Files.createFile(ARQUIVO_SAIDA);
				}
	
				events = Files.lines(ARQUIVO_SAIDA, Charset.forName("Cp1252")).map(this::leLinha).collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		// transforma uma linha do TXT para o tipo Evento
		private Evento leLinha(String linha) {
			String colunas[] = linha.split(SEPARADOR);
			int id = Integer.parseInt(colunas[0]);
			Date data = null;
			try {
				data = formatoData.parse(colunas[3]);
			} catch (ParseException e) {
				e.printStackTrace();
				System.exit(0);
			}
			Evento event = new Evento();
			event.setId(id);
			event.setNome(colunas[1]);
			event.setDescricao(colunas[2]);
			event.setData(data);
			return event;
		}
		
		// transforma um objeto conta em um arquivo TXT
		private String criaLinha(Evento e) {
			String dataStr = formatoData.format(e.getData());
			String idStr = String.valueOf(e.getId());
			String linha = String.join(SEPARADOR, idStr, e.getNome(),e.getDescricao(),
					dataStr);
			return linha;
		}
		
		

}


