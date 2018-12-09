package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineClassificationEntity;

public class WineClassification {

	private final String DATABASE = "PT_Wine_Inventory";
	private String code;
	private WineClassificationEntity persistent;

	public WineClassification() {
		this.persistent = new WineClassificationEntity();

	}

	public WineClassification(String code) {
		this.code = code;
		this.persistent = new WineClassificationEntity(this.code);

	}

	WineClassification(WineClassificationEntity persistent) {
		this.persistent = persistent;
	}

	public String getCode() {
		return this.persistent.getCode();
	}

	public String getName() {
		return this.persistent.getName();
	}

	public void reset() {
		this.persistent = new WineClassificationEntity(this.code);
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

		WineClassificationEntity e = em.find(WineClassificationEntity.class, this.persistent.getCode());
		em.remove(e);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

}
