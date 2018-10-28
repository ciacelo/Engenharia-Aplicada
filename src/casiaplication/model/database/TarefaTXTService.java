package casiaplication.model.database;

import java.io.BufferedReader;
import java.io.File;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import casiaplication.model.domain.Tarefa;

public class TarefaTXTService implements TarefaService{

	// divisor de colunas no arquivo
			private static final String SEPARADOR = ";";

			// o caminho para o arquivo deve ser selecionado aqui
			
			private static final Path ARQUIVO_SAIDA = Paths.get("src/tarefas.txt");

			// os dados do arquivo
			private List<Tarefa> tarefas;

			// formato de data usado no arquivo
			final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

			public TarefaTXTService() {
				carregaDados();
			}

			@Override
			public void salvar(Tarefa tarefa) {
				tarefa.setId(ultimoId() + 1);
				tarefas.add(tarefa);
				salvaDados();
			}


			@Override
			public void atualizar(Tarefa tarefa) {
				Tarefa TarefaAntiga = buscaPorId(tarefa.getId());
				TarefaAntiga.setNome(tarefa.getNome());
				TarefaAntiga.setDescricao(tarefa.getDescricao());
				salvaDados();
			}

			@Override
			public List<Tarefa> buscarTodas() {
				return tarefas;
			}

			@Override
			public void apagar(int id) {
				Tarefa tarefa = buscaPorId(id);
				tarefas.remove(tarefa);
				salvaDados();
			}

			public Tarefa buscaPorId(int id) {
				return tarefas.stream().filter(e -> e.getId() == id).findFirst()
						.orElseThrow(() -> new Error("Tarefa não encontrado"));
			}

			// salva a lista de dados no arquivo, gerando um novo TXT e escrevendo o arquivo completamente
			private void salvaDados() {
				
				FileInputStream input;
			    String result = null;
			    try {
			        input = new FileInputStream(new File("src/tarefas.txt"));
			        CharsetDecoder decoder = Charset.forName("Cp1252").newDecoder();
			        decoder.onMalformedInput(CodingErrorAction.IGNORE);
			        InputStreamReader reader = new InputStreamReader(input, decoder);
			        BufferedReader bufferedReader = new BufferedReader( reader );
			        StringBuilder sb = new StringBuilder();
			        String line = bufferedReader.readLine();
			        
			        while( line != null ) {
			            sb.append( line );
			            line = bufferedReader.readLine();
			        }
			        bufferedReader.close();
			        result = sb.toString();
					for (Tarefa e : tarefas) {
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
				return tarefas.stream().mapToInt(Tarefa::getId).max().orElse(0);
			}

			// carrega os dados do arquivo para a lista Tarefas
			private void carregaDados() {
				try {
					if(!Files.exists(ARQUIVO_SAIDA)) {
						Files.createFile(ARQUIVO_SAIDA);
					}
		
					tarefas = Files.lines(ARQUIVO_SAIDA, Charset.forName("Cp1252")).map(this::leLinha).collect(Collectors.toList());
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			
			// transforma uma linha do TXT para o tipo Tarefa
			private Tarefa leLinha(String linha) {
				String colunas[] = linha.split(SEPARADOR);
				int id = Integer.parseInt(colunas[0]);
				Date data = null;
				try {
					data = formatoData.parse(colunas[3]);
				} catch (ParseException e) {
					e.printStackTrace();
					System.exit(0);
				}
				Tarefa tarefa = new Tarefa();
				tarefa.setId(id);
				tarefa.setNome(colunas[1]);
				tarefa.setDescricao(colunas[2]);
				tarefa.setData(data);
				return tarefa;
			}
			
			// transforma um objeto conta em um arquivo TXT
			private String criaLinha(Tarefa e) {
				String dataStr = formatoData.format(e.getData());
				String idStr = String.valueOf(e.getId());
				String linha = String.join(SEPARADOR, idStr, e.getNome(),e.getDescricao(),
						dataStr);
				return linha;
			}
			
			

	}
