package ch.bibbias.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.ProducerEntity;

public class ProducerList {

	private final String DATABASE = "PT_Wine_Inventory";

	public List<Producer> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select p from ProducerEntity p ");

		@SuppressWarnings("unchecked")
		List<ProducerEntity> list = (List<ProducerEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		List<Producer> result = new ArrayList<Producer>();

		for (ProducerEntity p : list) {
			result.add(new Producer(p));
		}

		return result;
	}
	
	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(p) from ProducerEntity c ");

		return ((Number) query.getSingleResult()).intValue();

	}

}
