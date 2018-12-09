package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineEntity;

public class Wine {

	private final String DATABASE = "PT_Wine_Inventory";
	private long id;
	private WineEntity persistent;

	public Wine() {
		this.persistent = new WineEntity();

	}

	public Wine(long id) {
		this.id = id;
		this.persistent = new WineEntity(this.id);

	}

	public String getName() {
		return this.persistent.getName();
	}

	public WineType getType() {
		return new WineType(this.persistent.getWineType().getCode());
	}

	public WineClassification getClassification() {
		return new WineClassification(this.persistent.getClassification().getCode());
	}

	public Country getCountry() {
		return new Country(this.persistent.getCountry().getCode());
	}

	public Region getRegion() {
		return new Region(this.persistent.getRegion().getId());
	}

	public void reset() {
		this.persistent = new WineEntity(id);
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

		WineEntity w = em.find(WineEntity.class, this.persistent.getId());
		em.remove(w);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

}
