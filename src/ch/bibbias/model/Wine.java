package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineEntity;
import ch.bibbias.persistence.objects.WineTypeEntity;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wine {

	private final String DATABASE = "PT_Wine_Inventory";
	private long id;
	private WineEntity persistent;

	public Wine() {
		this.persistent = new WineEntity();

	}

	public Wine(long id) {
		this.id = id;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(WineEntity.class, this.id);

	}

	public Wine(WineEntity persistent) {
		this.persistent = persistent;
	}

	public LongProperty getIdProperty() {
		return new SimpleLongProperty(this.persistent.getId());
	}

	public long getId() {
		return this.id;

	}

	public StringProperty getNameProperty() {
		return new SimpleStringProperty(this.persistent.getName());

	}

	public String getName() {
		return this.persistent.getName();
	}

	public void setName(String name) {
		this.persistent.setName(name);
	}

	public StringProperty getTypeProperty() {
		return new SimpleStringProperty(this.persistent.getWineType().getName());
	}

	public WineType getType() {
		return new WineType(this.persistent.getWineType());
	}

	public void setType(WineType wineType) {
		this.persistent.setWineType(new WineTypeEntity(wineType.getCode()));
	}

	public StringProperty getClassificationProperty() {
		return new SimpleStringProperty(this.persistent.getClassification().getCode());
	}

	public WineClassification getClassification() {
		return new WineClassification(this.persistent.getClassification().getCode());
	}

	public StringProperty getCountryProperty() {
		return new SimpleStringProperty(this.persistent.getCountry().getName());
	}

	public Country getCountry() {
		return new Country(this.persistent.getCountry().getCode());
	}

	public StringProperty getRegionProperty() {
		return new SimpleStringProperty(this.persistent.getRegion().getName());
	}

	public Region getRegion() {
		return new Region(this.persistent.getRegion().getId());
	}

	public StringProperty getProducerProperty() {
		return new SimpleStringProperty(this.persistent.getProducer().getName());
	}

	public Producer getProducer() {
		return new Producer(this.persistent.getProducer().getId());
	}

	public void reset() {
		this.persistent = new WineEntity(this.id);
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

	@Override
	public String toString() {
		return this.persistent.getName();
	}

}
