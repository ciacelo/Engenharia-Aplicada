package casiaplication.model.database;

import java.util.List;

import casiaplication.model.domain.Tarefa;

public interface TarefaService {
	
	// CREATE
		public void salvar(Tarefa tarefa);
		
		// RETRIEVE
		public List<Tarefa> buscarTodas();

		public Tarefa buscaPorId(int id);
		
		// DELETE
		public void apagar(int id);
		
		// UPDATE
		public void atualizar(Tarefa tarefa);
		
		
		
		//public static tarefaService getNewInstance() {
			//return new tarefaCSVService();
		//}

}


