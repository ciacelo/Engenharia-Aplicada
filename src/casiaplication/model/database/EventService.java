package casiaplication.model.database;

import casiaplication.model.domain.Evento;
import casiaplication.model.database.EventCSVService;
import java.util.List;

public interface EventService {
	

	// CREATE
	public void salvar(Evento event);
	
	// RETRIEVE
	public List<Evento> buscarTodas();

	public Evento buscaPorId(int id);
	
	// DELETE
	public void apagar(int id);
	
	// UPDATE
	public void atualizar(Evento event);
	
	
	
	//public static EventService getNewInstance() {
		//return new EventCSVService();
	//}

}


