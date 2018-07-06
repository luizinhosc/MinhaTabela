package br.com.minhatabela.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import org.hibernate.service.spi.InjectService;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.util.Dao;
import br.com.minhatabela.util.Util;

@ManagedBean
@ViewScoped
public class NovaDivisaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Divisao divisao = new Divisao();

	MensagemBootstrap mensagem = new MensagemBootstrap();
	
	Util util; 

	public void gravar() {
		
		util.simularDemora();
		try {
			System.out.println("Cadastrando Divisão: " + this.divisao.getDescricao());

			new Dao<Divisao>(Divisao.class).adiciona(this.divisao);

			mensagem.setMensagem(true, "Cadastro efetuado com sucesso !!!",
					MensagemBootstrap.TipoMensagem.TIPO_SUCESSO);
			
			this.divisao = new Divisao();

		} catch (PersistenceException e) {
			mensagem.setMensagem(true, "Erro desconhecido !!!", MensagemBootstrap.TipoMensagem.TIPO_ERRO);

		}

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

	public List<Divisao> getDivisoes() {
		util.simularDemora();
		return new Dao<Divisao>(Divisao.class).listaTodos();
	}

	public void carregar(Divisao divisao) {
		this.divisao = divisao;

	}

	public void excluir(Divisao divisao) {

		util.simularDemora();
		try {
			new Dao<Divisao>(Divisao.class).remove(divisao);
			
			mensagem.setMensagem(true, "Divisão ecluida com sucesso !!!",
					MensagemBootstrap.TipoMensagem.TIPO_SUCESSO);

		} catch (PersistenceException e) {
			mensagem.setMensagem(true, "Erro desconhecido !!! "+e.getCause(),
					MensagemBootstrap.TipoMensagem.TIPO_ERRO);
		}

	}

}
