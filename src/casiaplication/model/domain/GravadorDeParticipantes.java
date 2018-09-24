package casiaplication.model.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GravadorDeParticipantes {
	
	Gravador gravador = new Gravador();
	
	public void gravaParticipantes(List<Participante> participantes) throws IOException{
		List<String> lista = new ArrayList<String>();
		for(Participante p: participantes){
			lista.add(p.getNome());
			lista.add(p.getEmail());
			lista.add(p.getinstituicao());
			lista.add(p.getEndereco().getLogradouro());
			lista.add(p.getEndereco().getNumero());
			lista.add(p.getEndereco().getCidade());
			lista.add(p.getEndereco().getEstado());
			
		}
		
		
		gravador.gravaTextoEmArquivo(lista, "SistemaCtrlE.txt");
	}
	
	public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader( new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); 
				if(texto != null){
					textoLido.add(texto);
				}
			}while(texto != null); 
		} finally{
			if(leitor!=null){
				leitor.close(); 
			}
		}
		return textoLido;
	}
	
	public List<Participante> recuperaParticipante()  {
		List<Participante> part = new ArrayList<Participante>();
		try{
			List<String> listaS = recuperaTextoDeArquivo("SistemaCtrlE.txt");
			if (listaS!=null){
				for (int k=0; k< listaS.size(); k++ ){
					String nome = listaS.get(k);
					k++;
					String email = listaS.get(k);
					k++;
					String instituicao = listaS.get(k);
					k++;
					String logradouro = listaS.get(k);
					k++;
					String cidade = listaS.get(k);
					k++;
					String estado = listaS.get(k);
					k++;
					String numero = listaS.get(k);
					Endereco ende = new Endereco (logradouro, numero, cidade, estado );
					Participante parte = new Participante(nome, email, instituicao,ende);
					part.add(parte);				
			      }
			}
		return part;
	} catch (IOException e){
		JOptionPane.showConfirmDialog(null, "Arquivo não recuperado");
		
	

		}
		return part;
	}

}
