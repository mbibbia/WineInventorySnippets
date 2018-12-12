package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.CountryEntity;
import ch.bibbias.persistence.objects.ProducerEntity;
import ch.bibbias.persistence.objects.RegionEntity;
import ch.bibbias.persistence.objects.WineClassificationEntity;
import ch.bibbias.persistence.objects.WineEntity;
import ch.bibbias.persistence.objects.WineTypeEntity;

public class InitWine {

	public static void main(String[] args) {

		ArrayList<WineEntity> wineList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Init values
		WineEntity wine;

		wine = new WineEntity();
		wine.setName("Langhe Nebbiolo");
		wine.setWineType(new WineTypeEntity("RED"));
		wine.setClassification(new WineClassificationEntity("DOC"));
		wine.setCountry(new CountryEntity("IT"));
		wine.setRegion(new RegionEntity(18));
		wine.setProducer(new ProducerEntity(99));
		wineList.add(wine);
		
		wine = new WineEntity();
		wine.setName("Barolo");
		wine.setWineType(new WineTypeEntity("RED"));
		wine.setClassification(new WineClassificationEntity("DOC"));
		wine.setCountry(new CountryEntity("IT"));
		wine.setRegion(new RegionEntity(18));
		wine.setProducer(new ProducerEntity(99));
		wineList.add(wine);

		for (WineEntity w : wineList) {
			em.persist(w);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
