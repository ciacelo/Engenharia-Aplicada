package casiaplication.model.domain;

public class EventoJaExisteException extends Exception {
	
	@Override
	public String getMessage() {
		return "ERRO>Evento com esse nome já tá cadastrado.";
	}

}
