package casiaplication.model.domain;

public class Endereco {
	
	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;

	public Endereco(String logradouro, String numero, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
