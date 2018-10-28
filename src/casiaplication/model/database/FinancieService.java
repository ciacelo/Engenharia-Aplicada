package casiaplication.model.database;

import java.util.List;

import casiaplication.model.domain.Financie;


public interface FinancieService {
	

	// CREATE
	public void salvar(Financie event);
	
	// RETRIEVE
	public List<Financie> buscarTodas();

	public Financie buscaPorId(int id);
	
	// DELETE
	public void apagar(int id);
	
	// UPDATE
	public void atualizar(Financie event);
	
	
	

}
