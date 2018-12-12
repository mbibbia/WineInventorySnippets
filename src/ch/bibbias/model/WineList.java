package ch.bibbias.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.WineEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WineList {

	private final String DATABASE = "PT_Wine_Inventory";

	public ObservableList<Wine> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select w from WineEntity w ");

		@SuppressWarnings("unchecked")
		List<WineEntity> list = (List<WineEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		ObservableList<Wine> result = FXCollections.observableArrayList();

		for (WineEntity w : list) {
			result.add(new Wine(w));
		}

		return result;
	}

	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(w) from WineEntity w ");

		return ((Number) query.getSingleResult()).intValue();

	}

	public static void main(String args[]) {

		System.out.println(new WineList().getCount());

	}

}
