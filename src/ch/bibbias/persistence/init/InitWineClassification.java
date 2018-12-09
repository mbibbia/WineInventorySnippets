package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineClassificationEntity;

public class InitWineClassification {

	public static void main(String[] args) {

		ArrayList<WineClassificationEntity> wineClassificationList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Init values
		WineClassificationEntity wineClassification;

		wineClassification = new WineClassificationEntity("DOC");
		wineClassification.setName("Denominazione di origine controllata");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("DOCG");
		wineClassification.setName("Denominazione di origine controllata e garantita");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("IGT");
		wineClassification.setName("Indicazione Geografica Tipica");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("VdT");
		wineClassification.setName("Vino da Tavola");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("DOP");
		wineClassification.setName("Denominazione d'Origine Protetta");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("1er grand cru classé");
		wineClassification.setName("1er Grand Cru Classé");
		wineClassificationList.add(wineClassification);
		
		wineClassification = new WineClassificationEntity("2ème grand cru classé");
		wineClassification.setName("2ème Grand Cru Classé");
		wineClassificationList.add(wineClassification);

		wineClassification = new WineClassificationEntity("AOC");
		wineClassification.setName("Appellation d'Origine Contrôlée");
		wineClassificationList.add(wineClassification);

		for (WineClassificationEntity c : wineClassificationList) {
			em.persist(c);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
