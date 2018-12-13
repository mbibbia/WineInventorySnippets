package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineTypeEntity;

public class WineType {

	private final String DATABASE = "PT_Wine_Inventory";
	private WineTypeEntity persistent;
	private String code;
	private boolean isDirty;

	public WineType() {
		this.persistent = new WineTypeEntity();
		this.code = this.persistent.getCode();

	}

	public WineType(String code) {
		this.code = code;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(WineTypeEntity.class, this.code);

	}

	WineType(WineTypeEntity persistent) {
		if (persistent != null) {
			this.code = persistent.getCode();
			this.persistent = persistent;
		}

	}

	public String getCode() {
		return this.persistent.getCode();
	}

	public String getName() {
		return this.persistent.getName();
	}

	public void setName(String name) {
		this.persistent.setName(name);
		this.isDirty = true;
	}

	public boolean isDirty() {
		return this.isDirty;
	}

	public void reset() {
		this.persistent = new WineTypeEntity(this.persistent.getCode());
		this.isDirty = false;
	}

	public void save() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.persistent);

		em.getTransaction().commit();
		em.close();
		emf.close();

		this.isDirty = false;

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

	@Override
	public String toString() {
		return this.persistent.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
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
		WineType other = (WineType) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		return true;
	}

}
