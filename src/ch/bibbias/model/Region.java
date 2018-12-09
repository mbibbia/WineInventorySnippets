package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.RegionEntity;

public class Region {

	private final String DATABASE = "PT_Wine_Inventory";
	private long id;
	private RegionEntity persistent;

	public Region() {
		this.persistent = new RegionEntity();

	}

	public Region(long id) {
		this.id = id;
		this.persistent = new RegionEntity(this.id);

	}

	Region(RegionEntity persistent) {
		this.persistent = persistent;
	}

	public long getId() {
		return this.persistent.getId();
	}

	public Country getCountry() {
		return new Country(this.persistent.getCountry());

	}

	public String getName() {
		return this.persistent.getName();
	}

	public void reset() {
		this.persistent = new RegionEntity(this.id);
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

		RegionEntity r = em.find(RegionEntity.class, this.persistent.getId());
		em.remove(r);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

}
