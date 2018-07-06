package br.com.minhatabela.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_time")
public class Time {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_time")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "nm_time")
	private String time;

	@Basic(optional = false)
	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro = Calendar.getInstance();
	
	@JoinColumn(name="id_divisao", referencedColumnName = "id_divisao")
	@ManyToOne(fetch=FetchType.LAZY)
	private Divisao divisao;
	

	public Time() {
	}

	public Time(String time, Calendar dataCadastro, Temporada temporada, Divisao divisao) {
		this.time = time;
		this.dataCadastro = dataCadastro;
		this.divisao = divisao;
	}

	public Time(Integer Id) {
		this.id = Id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Divisao getDivisao() {
		return divisao;
	}

	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}
	
	
	
}
