package br.com.minhatabela.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.beans.Temporada;
import br.com.minhatabela.beans.Time;
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
		Time time1 = em.find(Time.class, 7);
		Time time2 = em.find(Time.class, 8);
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

		Calendar datacad = Calendar.getInstance();
		Time time1 = new Time("Vasco da Gama", datacad, temporada, divisao);

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

		List<Time> Times = query.getResultList();

		for (Time Time : Times) {

			System.out.println("Time: " + Time.getTime() + " Divisao: " + Time.getDivisao().getDescricao()
					+ " Temporada: " );

		}

		em.close();
	}

	private static void insereTimeMesmaDivisaoTemporada() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Divisao d = em.find(Divisao.class, 1);
		Temporada temporada = em.find(Temporada.class, 1);

		Calendar datacad = Calendar.getInstance();
		Time Times = new Time("Santos", datacad, temporada, d);
		Time times1 = new Time("Corintians", datacad, temporada, d);
		Time times2 = new Time("Flamengo", datacad, temporada, d);

		em.persist(Times);
		em.persist(times1);
		em.persist(times2);

		System.out.println("Nome do time: " + Times.getTime() + " + " + Times.getDivisao().getDescricao());
		em.getTransaction().commit();
		em.close();

	}

	private static void insereTime() {
		EntityManager em = new JPAUtil().getEntityManager();

		Divisao divisao = new Divisao("Série A");
		Temporada temporada = new Temporada("2018");

		Calendar datacad = Calendar.getInstance();
		Time time1 = new Time("São Paulo", datacad, temporada, divisao);

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

		Time Times = em.find(Time.class, 2);

		System.out.println("Nome do time: " + Times.getTime() + " + " + Times.getDivisao().getDescricao() + " - "
				);

		em.close();
	}

}
