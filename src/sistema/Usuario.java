package sistema;

public class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	
	public Usuario (String nome, String email, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return (
				"Nome: " + getNome() +
				"\nEmail: " + getEmail()
				);
	}
	
	// GETS E SETS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
