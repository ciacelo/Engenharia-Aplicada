
package casiaplication.model.domain;

import java.util.Date;

public class Tarefa {
	
	private String nome;
	private String descricao;
	private Date data; // dia/mes/ano 
	private int id;
	
	public Tarefa(String nome, String descricao, Date data) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
	}
	
	public Tarefa() {
		this.nome = "";
		this.descricao = "";
		this.data = null;
	}
	
	@Override
	public String toString() {
		return "Nome: "+ getNome()+
				"\n Descricao: "+ getDescricao()+
				"\n Data: "+getData();
	}
	
	//GETS E SETS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		this.id = i;
		
	}
	

}
