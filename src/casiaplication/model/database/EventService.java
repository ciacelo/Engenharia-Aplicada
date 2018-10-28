package casiaplication.model.database;

import java.util.List;

import casiaplication.model.domain.Evento;

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
	
	
	

}


