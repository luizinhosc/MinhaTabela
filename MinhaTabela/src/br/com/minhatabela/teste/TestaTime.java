package br.com.minhatabela.teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.beans.Temporada;
import br.com.minhatabela.beans.time;
import br.com.minhatabela.util.JPAUtil;

public class TestaTime {

	public static void main(String[] args) {

		// mostraTimeCadastro();

		// insereTime();

		// insereTimeMesmaDivisaoTemporada();
		 insereTimeSerieB();

		// deleteTemporada();

		ListaTimesSerieA();

	}

	private static void deleteTemporada() {
		EntityManager em = new JPAUtil().getEntityManager();

		Divisao divisao = em.find(Divisao.class, 3);
		Divisao divisao1 = em.find(Divisao.class, 4);
		time time1 = em.find(time.class, 7);
		time time2 = em.find(time.class, 8);
		em.getTransaction().begin();

		em.remove(time1);
		em.remove(time2);
		em.remove(divisao);
		em.remove(divisao1);
		em.getTransaction().commit();
		em.close();

	}

	private static void insereTimeSerieB() {
		EntityManager em = new JPAUtil().getEntityManager();

		Divisao divisao = em.find(Divisao.class, 1);
		Temporada temporada = em.find(Temporada.class, 1);

		Date datacad = new Date();
		time time1 = new time("Vasco da Gama", datacad, temporada, divisao);

		em.getTransaction().begin();
		em.persist(divisao);
		em.persist(temporada);
		em.persist(time1);

		em.getTransaction().commit();
		em.close();

	}

	private static void ListaTimesSerieA() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Divisao divisao = new Divisao();
		divisao.setDescricao("Série A");

		String jpql = "select t from time t join t.divisao d where d.descricao = :pDivisao";
		Query query = em.createQuery(jpql);
		query.setParameter("pDivisao", divisao.getDescricao());

		List<time> times = query.getResultList();

		for (time time : times) {

			System.out.println("Time: " + time.getTime() + " Divisao: " + time.getDivisao().getDescricao()
					+ " Temporada: " + time.getTemporada().getTemporada());

		}

		em.close();
	}

	private static void insereTimeMesmaDivisaoTemporada() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Divisao d = em.find(Divisao.class, 1);
		Temporada temporada = em.find(Temporada.class, 1);

		Date datacad = new Date();
		time times = new time("Santos", datacad, temporada, d);
		time times1 = new time("Corintians", datacad, temporada, d);
		time times2 = new time("Flamengo", datacad, temporada, d);

		em.persist(times);
		em.persist(times1);
		em.persist(times2);

		System.out.println("Nome do time: " + times.getTime() + " + " + times.getDivisao().getDescricao() + " - "
				+ times.getTemporada().getTemporada());
		em.getTransaction().commit();
		em.close();

	}

	private static void insereTime() {
		EntityManager em = new JPAUtil().getEntityManager();

		Divisao divisao = new Divisao("Série A");
		Temporada temporada = new Temporada("2018");

		Date datacad = new Date();
		time time1 = new time("São Paulo", datacad, temporada, divisao);

		em.getTransaction().begin();
		em.persist(divisao);
		em.persist(temporada);
		em.persist(time1);

		em.getTransaction().commit();
		em.close();

	}

	private static void mostraTimeCadastro() {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		// InsereDivisao();

		Divisao d = em.find(Divisao.class, 1);

		Temporada temporada = em.find(Temporada.class, 1);

		time times = em.find(time.class, 2);

		System.out.println("Nome do time: " + times.getTime() + " + " + times.getDivisao().getDescricao() + " - "
				+ times.getTemporada().getTemporada());

		em.close();
	}

}
