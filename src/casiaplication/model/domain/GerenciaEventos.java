
package casiaplication.model.domain;

import java.util.ArrayList;

public class GerenciaEventos {
	
	private static ArrayList<Evento> eventos;
	private static GerenciaEventos instance = null;
	
	protected GerenciaEventos() {
		eventos = new ArrayList<Evento>();
	}
	
	private void editaEvento() {
		// TODO Auto-generated method stub

	}
	
	//Ao inves de dar num new GerenciaEventos, chamar esse método
	public static GerenciaEventos getInstance() {
		if (instance == null)
			instance = new GerenciaEventos();
		return instance;
	}
	
	
	private void cadastraEvento(Evento novoEvento) throws EventoJaExisteException {
		if (procuraEvento(novoEvento.getNome()) != null) {
			throw new EventoJaExisteException();
		}
		eventos.add(novoEvento);
	}
	
	private Evento procuraEvento(String nome) {
		
		if (eventos != null) {
			for (Evento evento : eventos) {
				if (evento.getNome().equals(nome)) {
					return evento;
				}
			}
		}
		return null;
	}
	
	private boolean removeEvento(String nome) {
		Evento evento = procuraEvento(nome);
		if (evento != null)
			return eventos.remove(evento);
		return false;
	}
	
}

