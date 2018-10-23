package casiaplication.model.domain;

import java.util.ArrayList;

public class GerenciaAtividades {
	
	private static ArrayList<Atividade> atividades;
	private static GerenciaAtividades instance = null;
	
	protected GerenciaAtividades () {
		atividades = new ArrayList<Atividade>();
	}
	
	//Ao inves de dar num new GerenciaEventos, chamar esse método
		public static GerenciaAtividades getInstance() {
			if (instance == null)
				instance = new GerenciaAtividades();
			return instance;
		}
		
		public void cadastraAtividade(Atividade novaAtividade) throws EventoJaExisteException {
			if (procuraAtividade(novaAtividade.getTitulo()) != null) {
				throw new EventoJaExisteException();
			}
			atividades.add(novaAtividade);
		}
		
		public Atividade procuraAtividade(String titulo) {
			
			if (atividades != null) {
				for (Atividade atividade : atividades) {
					if (atividade.getTitulo().equals(titulo)) {
						return atividade;
					}
				}
			}
			return null;
		}
		
		public boolean removeAtividade(String titulo) {
			Atividade atividade = procuraAtividade(titulo);
			if (atividade != null)
				return atividades.remove(atividade);
			return false;
		}
	
}
