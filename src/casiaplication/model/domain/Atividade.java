package casiaplication.model.domain;

public class Atividade {
	
	private String titulo;
	private String descricao;
	private String decorrencia;
	private String responsavel;
	private int id;
	

	public Atividade(String titulo, String descricao, String decorrencia, String responsavel, int id) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.decorrencia = decorrencia;
		this.responsavel = responsavel;
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDecorrencia() {
		return decorrencia;
	}

	public void setDecorrencia(String decorrencia) {
		this.decorrencia = decorrencia;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
}
