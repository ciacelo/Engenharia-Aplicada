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

import casiaplication.model.domain.Financie;

public class FinancieXlsxService implements FinancieService{

	// divisor de colunas no arquivo
	private static final String SEPARADOR = ";";

	// o caminho para o arquivo deve ser selecionado aqui
	
	private static final Path ARQUIVO_SAIDA = Paths.get("src/Planilha.xlsx");

	// os dados do arquivo
	private List<Financie> financies;

	// formato de data usado no arquivo
	final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	//Configurando o caracter usado na leitura do arquivo.
	private Charset charset = Charset.forName("Cp1252");
	
	public FinancieXlsxService() {
		carregaDados();
	}

	@Override
	public void salvar(Financie financie) {
		financie.setId(ultimoId() + 1);
		financies.add(financie);
		salvaDados();
	}


	@Override
	public void atualizar(Financie financie) {
		Financie FinancieAntiga = buscaPorId(financie.getId());
		FinancieAntiga.setData(financie.getData());
		FinancieAntiga.setDescricao(financie.getDescricao());
		FinancieAntiga.setEntrou(financie.getEntrou());
		FinancieAntiga.setGastou(financie.getGastou());
		salvaDados();
	}

	@Override
	public List<Financie> buscarTodas() {
		return financies;
	}

	@Override
	public void apagar(int id) {
		Financie financie = buscaPorId(id);
		financies.remove(financie);
		salvaDados();
	}

	public Financie buscaPorId(int id) {
		return financies.stream().filter(e -> e.getId() == id).findFirst()
				.orElseThrow(() -> new Error("Financie não encontrado"));
	}

	// salva a lista de dados no arquivo, gerando um novo XLSX e escrevendo o arquivo completamente
	private void salvaDados() {
		
		FileInputStream input;
	    String result = null;
	    try {
	        input = new FileInputStream(new File("src/Planilha.xlsx"));
	        CharsetDecoder decoder = Charset.forName("Cp1252").newDecoder();
	        decoder.onMalformedInput(CodingErrorAction.IGNORE);
	        InputStreamReader reader = new InputStreamReader(input, decoder);
	        BufferedReader bufferedReader = new BufferedReader( reader );
	        StringBuilder sb = new StringBuilder();
	        //String line = bufferedReader.readLine();
	        
	        /*while( line != null ) {
	            sb.append( line );
	            line = bufferedReader.readLine();
	        }
	        */
	        bufferedReader.close();
	        result = sb.toString();
			for (Financie f : financies) {
				String linha = criaLinha(f);
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
		return financies.stream().mapToInt(Financie::getId).max().orElse(0);
	}

	// carrega os dados do arquivo para a lista Financies
	private void carregaDados() {
		try {
			if(!Files.exists(ARQUIVO_SAIDA)) {
				Files.createFile(ARQUIVO_SAIDA);
			}
			
			System.out.println(ARQUIVO_SAIDA);
			financies = Files.lines(ARQUIVO_SAIDA, charset)
					.map(this::leLinha)
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	// transforma uma linha do XLSX para o tipo Financie
	private Financie leLinha(String linha) {
		String colunas[] = linha.split(SEPARADOR);
		int id = Integer.parseInt(colunas[0]);
		Date data = null;
		try {
			data = formatoData.parse(colunas[1]);
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(0);
		}
		Financie financie = new Financie();
		financie.setId(id);
		financie.setData(data);
		financie.setDescricao(colunas[2]);
		financie.setGastou(colunas[3]);
		financie.setEntrou(colunas[4]);
		return financie;
	}
	
	// transforma um objeto conta em um arquivo Xlsx
	private String criaLinha(Financie e) {
		String dataStr = formatoData.format(e.getData());
		String idStr = String.valueOf(e.getId());
		String linha = String.join(SEPARADOR, idStr, dataStr,e.getDescricao(), e.getGastou()
				, e.getEntrou());
		return linha;
	}
	
	

}