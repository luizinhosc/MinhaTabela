package br.com.minhatabela.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.beans.Time;
import br.com.minhatabela.util.Dao;

@ManagedBean
@ViewScoped
public class NovoTimeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Time time = new Time();
	
	MensagemBootstrap mensagem;

	public void gravar() {
		System.out.println("Cadastrando Time: " + this.time.getTime() );
				
		new Dao<Time>(Time.class).adiciona(this.time);
	}
	
	public List<Divisao> getDivisoes(){
		
		return new Dao<Divisao>(Divisao.class).listaTodos();
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


	 

	
	
	
}
