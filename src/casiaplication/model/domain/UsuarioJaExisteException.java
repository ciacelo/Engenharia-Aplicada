package casiaplication.model.domain;

public class UsuarioJaExisteException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERRO>Usu�rio com esse email j� t� cadastrado.";
	}
}
