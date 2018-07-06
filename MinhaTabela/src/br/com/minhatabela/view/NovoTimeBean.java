package br.com.minhatabela.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.beans.Time;
import br.com.minhatabela.util.Dao;
import br.com.minhatabela.util.Util;

@ManagedBean
@ViewScoped
public class NovoTimeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	Time time = new Time();

	private Integer divisaoId;

	MensagemBootstrap mensagem = new MensagemBootstrap();
	
	Util util;

	/**
	 */
	public NovoTimeBean() {
		super();
		this.time = time;
		this.divisaoId = divisaoId;
		this.mensagem = mensagem;
	}

	public void gravar() {

		util.simularDemora();

		try {
			System.out.println("Cadastrando Time: " + this.time.getTime());

				time.setDivisao(new Dao<Divisao>(Divisao.class).buscaPorId(this.divisaoId));

				new Dao<Time>(Time.class).adiciona(this.time);

				mensagem.setMensagem(true, "Cadastro efetuado com sucesso !!!",
						MensagemBootstrap.TipoMensagem.TIPO_SUCESSO);
				
				new NovoTimeBean();

		} catch (Exception e) {
			mensagem.setMensagem(true, "Erro Desconhecido !!!",
					MensagemBootstrap.TipoMensagem.TIPO_ERRO);
		}
		
	}

	public List<Divisao> getDivisoes() {

		return new Dao<Divisao>(Divisao.class).listaTodos();
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Integer getDivisaoId() {
		return divisaoId;
	}

	public MensagemBootstrap getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemBootstrap mensagem) {
		this.mensagem = mensagem;
	}

	public void setDivisaoId(Integer divisaoId) {
		this.divisaoId = divisaoId;
	}

}
