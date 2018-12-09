package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.WineTypeEntity;

public class InitWineType {

	public static void main(String[] args) {

		ArrayList<WineTypeEntity> wineTypeList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Init values
		WineTypeEntity wineType;

		wineType = new WineTypeEntity("RED");
		wineType.setName("Rotwein");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("WHITE");
		wineType.setName("Weisswein");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("ROSE");
		wineType.setName("Roséwein");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("SPARKLING_WHITE");
		wineType.setName("Schaumwein weiss");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("SPARKLING_ROSE");
		wineType.setName("Schaumwein rosé");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("SWEET_RED");
		wineType.setName("Süsswein rot");
		wineTypeList.add(wineType);

		wineType = new WineTypeEntity("SWEET_WHITE");
		wineType.setName("Süsswein rot");
		wineTypeList.add(wineType);

		for (WineTypeEntity t : wineTypeList) {
			em.persist(t);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
