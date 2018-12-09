package ch.bibbias.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.RegionEntity;

public class RegionList {

	private final String DATABASE = "PT_Wine_Inventory";

	public List<Region> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select r from RegionEntity r ");

		@SuppressWarnings("unchecked")
		List<RegionEntity> list = (List<RegionEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		List<Region> result = new ArrayList<Region>();

		for (RegionEntity r : list) {
			result.add(new Region(r));
		}

		return result;
	}
	
	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(r) from RegionEntity c ");

		return ((Number) query.getSingleResult()).intValue();

	}
	
	public static void main(String args[]) {

		RegionList list = new RegionList();
		for (Region r : list.get()) {
			System.out.print(r.getId());
			System.out.print("\t" + r.getName());
			System.out.print("\t" + r.getCountry().getCode());
			System.out.println();
		}
	}	

}
