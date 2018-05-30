package br.com.minhatabela.beans;

public class campeonato {
	private int id;
	private String descricao;
	
	
	
	public campeonato() {
		
	}
	
	public campeonato(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
