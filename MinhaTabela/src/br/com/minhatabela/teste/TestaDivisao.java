package br.com.minhatabela.teste;

import javax.persistence.EntityManager;

import br.com.minhatabela.beans.Divisao;
import br.com.minhatabela.util.JPAUtil;



public class TestaDivisao {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		Divisao div = new Divisao("Serie D");
		
		em.persist(div);
		
		em.getTransaction().commit();
				
		Divisao d = MostraDivisao(em);
		
		System.out.println("Divisao" + d.getDescricao());
		
		em.close();

	}

	private static Divisao MostraDivisao(EntityManager em) {
		return em.find(Divisao.class, 1);
		
	}

}
