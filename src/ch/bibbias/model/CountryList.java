package ch.bibbias.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.CountryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CountryList {

	private final String DATABASE = "PT_Wine_Inventory";

	public ObservableList<Country> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select c from CountryEntity c ");

		@SuppressWarnings("unchecked")
		List<CountryEntity> list = (List<CountryEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		ObservableList<Country> result = FXCollections.observableArrayList();

		for (CountryEntity c : list) {
			result.add(new Country(c));
		}

		return result;
	}

	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(c) from CountryEntity c ");

		return ((Number) query.getSingleResult()).intValue();

	}

	public static void main(String args[]) {

		CountryList list = new CountryList();

		System.out.println("Anzahl:\t" + list.getCount());
		System.out.println();

		for (Country c : list.get()) {
			System.out.print(c.getCode());
			System.out.print("\t" + c.getName());
			System.out.println();
		}

	}

}
