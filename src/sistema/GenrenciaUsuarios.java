package sistema;


import java.util.ArrayList;
import java.util.List;

public class GenrenciaUsuarios {
	
	private static ArrayList<Usuario> usuarios;
	
	private GenrenciaUsuarios() {
		this.usuarios = new ArrayList<>();
		
	}
	
	public List<Usuario> getInstance() {
		if (usuarios == null)
			new GenrenciaUsuarios();
		return usuarios;
	}
	
	private void listaUsuarios() {
		String saida = "";
		for (Usuario usuario : usuarios) {
			saida += usuario.toString() + "\n - - - \n";
		}

	}
	
	private void cadastraUsuario(String nome, String email, String senha) throws UsuarioJaExisteException {
		Usuario novoUsuario = new Usuario(nome, email, senha);
		for (Usuario usuario : usuarios) {
			if (novoUsuario.getEmail().equals(email)) {
				throw new UsuarioJaExisteException();
			}
		}
		usuarios.add(novoUsuario);
	}
	
	private Usuario procuraUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome)) {
				return usuario;
			}
		}
		return null;
	}

	private boolean apagaUsuario(String nome) {
		Usuario usuario = procuraUsuario(nome);
		if (usuario != null) {
			return usuarios.remove(usuario);
		}
		return false;
	}
	
}
