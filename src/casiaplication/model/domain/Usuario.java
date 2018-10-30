
package casiaplication.model.domain;

public class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	private int id;
	
	public Usuario (String nome, String email, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Usuario() {
		this.email = "";
		this.nome = "";
		this.senha = "";
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

	public int getIdUsuario() {
		return id;
	}
	
	public void setIdUsuario(int id) {
		this.id = id;
	}

}

