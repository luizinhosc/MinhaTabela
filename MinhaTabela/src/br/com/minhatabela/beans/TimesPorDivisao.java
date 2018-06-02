package br.com.minhatabela.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_time_divisao")
public class TimesPorDivisao {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_time_divisao")
	private Long id;
	
	@JoinColumn(unique=true)
	//@Column(name = "id_temporada")
	@ManyToOne
	private Temporada temporada;
	
	@Column(name = "id_time")
	@ManyToMany
	private List<Time> Times = new ArrayList();
	
	@JoinColumn(unique=true)
	@ManyToOne
	private Divisao divisoes;
	
	public TimesPorDivisao(){
		
	}

	public TimesPorDivisao(Temporada temporada, List<Time> list, Divisao divisoes) {
		this.temporada = temporada;
		this.Times = (List<Time>) list;
		this.divisoes = divisoes;
	}
	
	
}
