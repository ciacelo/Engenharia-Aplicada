package casiaplication.model.domain;

import java.util.Date;

public class Financie {
	
	private Date data; //  dia/mes/ano
	private String descricao;
	private String gastou;
	private String entrou;
	private int id;
	
	public Financie(Date data, String descricao, String gastou, String entrou) {
		this.data = data;
		this.descricao = descricao;
		this.gastou = gastou;
		this.entrou = entrou;
	}
	
	public Financie() {
		this.data = null;
		this.descricao = "";
		this.entrou = "";
		this.gastou = "";
	}
	
	@Override
	public String toString() {
		return "Data: "+ getData()+
				"\n Descricao: "+ getDescricao()+
				"\n Gastou: " +getGastou()+
				"\n Entrou: "+getEntrou();
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getGastou() {
		return gastou;
	}
	public void setGastou(String gastou) {
		this.gastou = gastou;
	}
	public String getEntrou() {
		return entrou;
	}
	public void setEntrou(String entrou) {
		this.entrou = entrou;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
		
	}
	

}
