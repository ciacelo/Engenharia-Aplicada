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

import casiaplication.model.domain.Atividade;

public class AtividadeTXTService implements AtividadefaService{

	// divisor de colunas no arquivo
			private static final String SEPARADOR = ";";

			// o caminho para o arquivo deve ser selecionado aqui
			
			private static final Path ARQUIVO_SAIDA = Paths.get("src/Atividades.txt");

			// os dados do arquivo
			private List<Atividade> atividades;

			// formato de data usado no arquivo
			final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

			public AtividadeTXTService() {
				carregaDados();
			}

			@Override
			public void salvar(Atividade atividade) {
				atividade.setId(ultimoId() + 1);
				atividades.add(atividade);
				salvaDados();
			}


			@Override
			public void atualizar(Atividade atividade) {
				Atividade atividadeAntiga = buscaPorId(atividade.getId());
				atividadeAntiga.setTitulo(atividade.getTitulo());
				atividadeAntiga.setDescricao(atividade.getDescricao());
				atividadeAntiga.setResponsavel(atividade.getResponsavel());
				atividadeAntiga.setDecorrencia(atividade.getDecorrencia());
				atividadeAntiga.setData(atividade.getData());
				salvaDados();
			}

			@Override
			public List<Atividade> buscarTodas() {
				return atividades;
			}

			@Override
			public void apagar(int id) {
				Atividade atividade = buscaPorId(id);
				atividades.remove(atividade);
				salvaDados();
			}

			public Atividade buscaPorId(int id) {
				return atividades.stream().filter(e -> e.getId() == id).findFirst()
						.orElseThrow(() -> new Error("Atividade não encontrado"));
			}

			// salva a lista de dados no arquivo, gerando um novo TXT e escrevendo o arquivo completamente
			private void salvaDados() {
				
				FileInputStream input;
			    String result = null;
			    try {
			        input = new FileInputStream(new File("src/Atividades.txt"));
			        CharsetDecoder decoder = Charset.forName("Cp1252").newDecoder();
			        decoder.onMalformedInput(CodingErrorAction.IGNORE);
			        InputStreamReader reader = new InputStreamReader(input, decoder);
			        BufferedReader bufferedReader = new BufferedReader( reader );
			        StringBuilder sb = new StringBuilder();
			       //String line = bufferedReader.readLine();
			        
			        //while( line != null ) {
			          //  sb.append( line );
			           // line = bufferedReader.readLine();
			        //}
			        bufferedReader.close();
			        result = sb.toString();
					for (Atividade a : atividades) {
						String linha = criaLinha(a);
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
				return atividades.stream().mapToInt(Atividade::getId).max().orElse(0);
			}

			// carrega os dados do arquivo para a lista Atividades
			private void carregaDados() {
				try {
					if(!Files.exists(ARQUIVO_SAIDA)) {
						Files.createFile(ARQUIVO_SAIDA);
					}
		
					atividades = Files.lines(ARQUIVO_SAIDA, Charset.forName("Cp1252")).map(this::leLinha).collect(Collectors.toList());
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			
			// transforma uma linha do TXT para o tipo Atividade
			private Atividade leLinha(String linha) {
				String colunas[] = linha.split(SEPARADOR);
				int id = Integer.parseInt(colunas[0]);
				Date data = null;
				try {
					data = formatoData.parse(colunas[4]);
				} catch (ParseException e) {
					e.printStackTrace();
					System.exit(0);
				}
				Atividade atividade = new Atividade();
				atividade.setId(id);
				atividade.setTitulo(colunas[1]);
				atividade.setDescricao(colunas[2]);
				atividade.setResponsavel(colunas[3]);
				atividade.setData(data);
				atividade.setDecorrencia(colunas[5]);
				return atividade;
			}
			
			// transforma um objeto atividade em um arquivo TXT
			private String criaLinha(Atividade e) {
				String dataStr = formatoData.format(e.getData());
				String idStr = String.valueOf(e.getId());
				String linha = String.join(SEPARADOR, idStr, e.getTitulo(),e.getDescricao(),
						e.getResponsavel(),dataStr, e.getDecorrencia());
				return linha;
			}
			
			

	}
