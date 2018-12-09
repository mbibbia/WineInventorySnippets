package ch.bibbias.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bibbias.persistence.objects.WineClassificationEntity;

public class WineClassificationList {

	private final String DATABASE = "PT_Wine_Inventory";

	public List<WineClassification> get() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("Select wc from WineClassificationEntity wc ");

		@SuppressWarnings("unchecked")
		List<WineClassificationEntity> list = (List<WineClassificationEntity>) query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		List<WineClassification> result = new ArrayList<WineClassification>();

		for (WineClassificationEntity wc : list) {
			result.add(new WineClassification(wc));
		}

		return result;
	}

	public static void main(String args[]) {

		WineClassificationList list = new WineClassificationList();
		for (WineClassification wc : list.get()) {
			System.out.print(wc.getCode());
			System.out.print("\t" + wc.getName());
			System.out.println();
		}
	}

}
