package ch.bibbias.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.WineTypeEntity;

public class WineTypeList {

	private final String DATABASE = "PT_Wine_Inventory";

	public List<WineType> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select wt from WineTypeEntity wt ");

		@SuppressWarnings("unchecked")
		List<WineTypeEntity> list = (List<WineTypeEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		List<WineType> result = new ArrayList<WineType>();

		for (WineTypeEntity wt : list) {
			result.add(new WineType(wt));
		}

		return result;
	}
	
	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(wt) from WineTypeEntity wt ");

		return ((Number) query.getSingleResult()).intValue();

	}

	public static void main(String args[]) {

		WineTypeList list = new WineTypeList();
		for (WineType wt : list.get()) {
			System.out.print(wt.getCode());
			System.out.print("\t" + wt.getName());
			System.out.println();
		}
	}

}
