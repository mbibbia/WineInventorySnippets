package ch.bibbias.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.ProducerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProducerList {

	private final String DATABASE = "PT_Wine_Inventory";

	public ObservableList<Producer> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select p from ProducerEntity p ");

		@SuppressWarnings("unchecked")
		List<ProducerEntity> list = (List<ProducerEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		ObservableList<Producer> result = FXCollections.observableArrayList();

		for (ProducerEntity p : list) {
			result.add(new Producer(p));
		}

		return result;
	}

	public int getCount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select Count(p) from ProducerEntity c ");

		return ((Number) query.getSingleResult()).intValue();

	}

	public static void main(String args[]) {

		ProducerList list = new ProducerList();
		for (Producer p : list.get()) {
			System.out.print(p.getId());
			System.out.print("\t" + p.getName());
			// System.out.print("\t" + p.getCountry().getCode());
			System.out.println();
		}
	}

}
