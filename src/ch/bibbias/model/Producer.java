package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.ProducerEntity;

public class Producer {

	private final String DATABASE = "PT_Wine_Inventory";
	private long id;
	private ProducerEntity persistent;

	public Producer() {
		this.persistent = new ProducerEntity();

	}

	public Producer(long id) {
		this.id = id;
		this.persistent = new ProducerEntity(this.id);

	}

	Producer(ProducerEntity persistent) {
		this.persistent = persistent;
	}
	
	public long getId() {
		return this.persistent.getId();
	}

	public String getName() {
		return this.persistent.getName();
	}

	public String getCompany() {
		return this.persistent.getCompany();
	}

	public String getAddressLine1() {
		return this.persistent.getAddressLine1();
	}

	public String getAddressLine2() {
		return this.persistent.getAddressLine2();
	}

	public String getZipCode() {
		return this.persistent.getZipCode();
	}

	public String getPlace() {
		return this.persistent.getPlace();
	}

	public String getPhone() {
		return this.persistent.getPhone();
	}

	public String getFax() {
		return this.persistent.getFax();
	}

	public String geteMail() {
		return this.persistent.geteMail();
	}

	public String getUrl() {
		return this.persistent.getUrl();
	}

	public void reset() {
		this.persistent = new ProducerEntity(this.id);
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

		ProducerEntity e = em.find(ProducerEntity.class, this.persistent.getId());
		em.remove(e);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

}
