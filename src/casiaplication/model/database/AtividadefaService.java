package casiaplication.model.database;

import java.util.List;

import casiaplication.model.domain.Atividade;

public interface AtividadefaService {
	
	// CREATE
		public void salvar(Atividade atividade);
		
		// RETRIEVE
		public List<Atividade> buscarTodas();

		public Atividade buscaPorId(int id);
		
		// DELETE
		public void apagar(int id);
		
		// UPDATE
		public void atualizar(Atividade atividade);
		
		
		
		//public static AtividadeService getNewInstance() {
			//return new AtividadeCSVService();
		//}

}


