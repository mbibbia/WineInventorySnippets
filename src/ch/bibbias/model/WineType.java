package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineTypeEntity;

public class WineType {

	private final String DATABASE = "PT_Wine_Inventory";
	private String code;
	private WineTypeEntity persistent;

	public WineType() {
		this.persistent = new WineTypeEntity();

	}

	public WineType(String code) {
		this.code = code;
		this.persistent = new WineTypeEntity(this.code);

	}

	public String getName() {
		return this.persistent.getName();
	}

	public void reset() {
		this.persistent = new WineTypeEntity(this.code);
	}

	public void save() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.persistent);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

	public void delete() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		WineTypeEntity wt = em.find(WineTypeEntity.class, this.persistent.getCode());
		em.remove(wt);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

}
