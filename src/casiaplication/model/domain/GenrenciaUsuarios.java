package casiaplication.model.domain;
<<<<<<< HEAD

import java.util.ArrayList;

public class GenrenciaUsuarios {
	
	private static GenrenciaUsuarios instance = null;
	private static ArrayList<Usuario> usuarios;
	
	protected GenrenciaUsuarios() {
		usuarios = new ArrayList<Usuario>();
=======

import java.util.ArrayList;

public class GenrenciaUsuarios {
	
	private static GenrenciaUsuarios instance = null;
	private static ArrayList<Usuario> usuarios;
	
	protected GenrenciaUsuarios() {
		usuarios = new ArrayList<Usuario>();
>>>>>>> origin/master
	}
	
	private void editaUsuario() {
		// TODO Auto-generated method stub

	}
	
	public static boolean autentica (String email, String senha) {
		Usuario usuario = procuraUsuario(email);
		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
<<<<<<< HEAD
	}
	
	//Ao inves de dar num new GerenciaUsuarios, chamar esse método
	public static GenrenciaUsuarios getInstance() {
		if (instance == null)
			instance = new GenrenciaUsuarios();
		return instance;
	}
	
	// toStrign temporário, dá pra mudar para um que fique melhor para a interface depois
	public static String listaUsuarios() { 
		String saida = "";
		if (!usuarios.isEmpty())
			for (Usuario usuario : usuarios) {
				saida += usuario.toString() + "\n - - - \n";
			}
		else
			return "não há usuarios cadastrados";
		return saida;
	}
	
	public static void cadastraUsuario(Usuario novoUsuario) throws UsuarioJaExisteException {
		
		if (procuraUsuario(novoUsuario.getEmail()) != null) {
			throw new UsuarioJaExisteException();
		}
		usuarios.add(novoUsuario);
	}
	
	public static Usuario procuraUsuario(String email) {
		if (usuarios != null) {
			for (Usuario usuario : usuarios) {
				if (usuario.getEmail().equals(email)) {
					return usuario;
				}
			}
		}
		return null;
	}

	public static boolean apagaUsuario(String email) {
		Usuario usuario = procuraUsuario(email);
		if (usuario != null) {
			return usuarios.remove(usuario);
		}
		return false;
=======
	}
	
	//Ao inves de dar num new GerenciaUsuarios, chamar esse método
	public static GenrenciaUsuarios getInstance() {
		if (instance == null)
			instance = new GenrenciaUsuarios();
		return instance;
	}
	
	// toStrign temporário, dá pra mudar para um que fique melhor para a interface depois
	public static String listaUsuarios() { 
		String saida = "";
		if (!usuarios.isEmpty())
			for (Usuario usuario : usuarios) {
				saida += usuario.toString() + "\n - - - \n";
			}
		else
			return "não há usuarios cadastrados";
		return saida;
	}
	
	public static void cadastraUsuario(Usuario novoUsuario) throws UsuarioJaExisteException {
		
		if (procuraUsuario(novoUsuario.getEmail()) != null) {
			throw new UsuarioJaExisteException();
		}
		usuarios.add(novoUsuario);
	}
	
	public static Usuario procuraUsuario(String email) {
		if (usuarios != null) {
			for (Usuario usuario : usuarios) {
				if (usuario.getEmail().equals(email)) {
					return usuario;
				}
			}
		}
		return null;
	}

	public static boolean apagaUsuario(String email) {
		Usuario usuario = procuraUsuario(email);
		if (usuario != null) {
			return usuarios.remove(usuario);
		}
		return false;
>>>>>>> origin/master
	}
	
	public void editarUsuario(String email, String nome, String senha) {
		Usuario usuario = procuraUsuario(email);
		if (usuario != null)
			usuario.setNome(nome);
			usuario.setSenha(senha);
<<<<<<< HEAD
	}
	
}
=======
	}
	
}
>>>>>>> origin/master
