
package casiaplication.model.domain;

import java.util.Date;

public class Evento {
	
	private String nome;
	private String descricao;
	private String local;
	private String org;
	private Date data; // dia/mes/ano 
	private int id;
	
	public Evento(String nome, String descricao, String local, String org, Date data) {
		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
		this.org = org;
		this.data = data;
	}
	
	public Evento() {
		this.nome = "";
		this.descricao = "";
		this.local = "";
		this.org = "";
		this.data = null;
	}
	
	@Override
	public String toString() {
		return "Nome: "+ getNome()+
				"\n Descricao: "+ getDescricao()+
				"\n Local: " +getLocal()+
				"\n Organizacao: "+getOrg()+
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getOrg() {
		return org;
	}
	public void setOrganizacao(String organizacao) {
		this.org = organizacao;
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

