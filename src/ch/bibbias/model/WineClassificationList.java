package ch.bibbias.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.WineClassificationEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WineClassificationList {

	private final String DATABASE = "PT_Wine_Inventory";

	public ObservableList<WineClassification> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select wc from WineClassificationEntity wc ");

		@SuppressWarnings("unchecked")
		List<WineClassificationEntity> list = (List<WineClassificationEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		ObservableList<WineClassification> result = FXCollections.observableArrayList();

		for (WineClassificationEntity wc : list) {
			result.add(new WineClassification(wc));
		}

		return result;
	}
	
	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(wc) from WineClassificationEntity wc ");

		return ((Number) query.getSingleResult()).intValue();

	}

	public static void main(String args[]) {

		WineClassificationList list = new WineClassificationList();
		
		System.out.println("Anzahl:\t" + list.getCount());
		System.out.println();
		
		for (WineClassification wc : list.get()) {
			System.out.print(wc.getCode());
			System.out.print("\t" + wc.getName());
			System.out.println();
		}
	}

}
