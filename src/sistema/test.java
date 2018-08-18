package sistema;

public class test {
	
	public static void main(String[] args) {
		
		GenrenciaUsuarios banco = GenrenciaUsuarios.getInstance();
		
		try {
			banco.cadastraUsuario(new Usuario("Roberval", "eu.mesmo@gmail.com", "senha"));
		} catch (UsuarioJaExisteException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(banco.listaUsuarios());
		
		
		
		
	}

}
