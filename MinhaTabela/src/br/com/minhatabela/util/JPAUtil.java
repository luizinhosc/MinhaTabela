package br.com.minhatabela.util;

import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@RequestScoped
public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaTabela");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}