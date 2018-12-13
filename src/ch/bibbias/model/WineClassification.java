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
		this.code = this.persistent.getCode();

	}

	public WineClassification(String code) {
		this.code = code;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(WineClassificationEntity.class, this.code);

	}

	WineClassification(WineClassificationEntity persistent) {
		if (persistent != null) {
			this.persistent = persistent;
			this.code = this.persistent.getCode();
		}
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

	@Override
	public String toString() {
		return this.persistent.getCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WineClassification other = (WineClassification) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
