package ch.bibbias.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.WineEntity;

public class WineList {

	private final String DATABASE = "PT_Wine_Inventory";

	public List<Wine> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select w from WineEntity w ");

		@SuppressWarnings("unchecked")
		List<WineEntity> list = (List<WineEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		List<Wine> result = new ArrayList<Wine>();

		for (WineEntity w : list) {
			result.add(new Wine(w.getId()));
		}

		return result;
	}

}
