package br.com.minhatabela.teste;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.minhatabela.beans.Temporada;
import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.beans.Time;
import br.com.minhatabela.util.JPAUtil;

public class TestaTimeDivisao {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Divisao d = new Divisao("SERIE A");
		em.persist(d);
		
		Temporada temporada = new Temporada("2018");
		em.persist(temporada);

		Date dataCad = new Date();
		//time times = new time("São Paulo", dataCad);
		//time times2 = new time("Palmeiras", dataCad);
		
		//em.persist(times);
		//em.persist(times2);

		//TimesPorDivisao timespordivisao = new TimesPorDivisao(temporada, Arrays.asList(times,times2), d);

		//em.persist(timespordivisao);

		em.getTransaction().commit();

		em.close();

	}

}
