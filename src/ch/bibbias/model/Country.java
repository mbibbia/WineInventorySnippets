package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.CountryEntity;

public class Country {

	private final String DATABASE = "PT_Wine_Inventory";
	private String code;
	private CountryEntity persistent;

	public Country() {
		this.persistent = new CountryEntity();

	}

	public Country(String code) {
		this.code = code;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(CountryEntity.class, this.code);

	}

	Country(CountryEntity persistent) {
		this.persistent = persistent;
	}

	public String getCode() {
		return this.persistent.getCode();
	}

	public String getName() {
		return this.persistent.getName();
	}

	public void reset() {
		this.persistent = new CountryEntity(this.code);
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

		CountryEntity c = em.find(CountryEntity.class, this.persistent.getCode());
		em.remove(c);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

	@Override
	public String toString() {
		return this.persistent.getCode() + " - " + this.persistent.getName();
	}

}
