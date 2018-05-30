package br.com.minhatabela.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.util.Dao;

@ManagedBean
@ViewScoped
public class NovaDivisaoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Divisao divisao = new Divisao();
	
	MensagemBootstrap mensagem;

	public void gravar() {
		System.out.println("Cadastrando Divisão: " + this.divisao.getDescricao() );
				
		new Dao<Divisao>(Divisao.class).adiciona(this.divisao);
	}
	 
	public Divisao getDivisao() {
		return divisao;
	}


	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}

	public MensagemBootstrap getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemBootstrap mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}