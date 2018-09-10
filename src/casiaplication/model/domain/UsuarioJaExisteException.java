package casiaplication.model.domain;

public class UsuarioJaExisteException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERRO>Usuário com esse email já tá cadastrado.";
	}
}
