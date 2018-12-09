package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.CountryEntity;
import ch.bibbias.persistence.objects.ProducerEntity;
import ch.bibbias.persistence.objects.RegionEntity;

public class InitProducer {

	public static void main(String[] args) {

		ArrayList<ProducerEntity> producerList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Init values
		ProducerEntity producer;

		producer = new ProducerEntity();
		producer.setName("Parusso");
		producer.setCompany("Parusso Armando di Parusso F.lli Società Agricola");
		producer.setAddressLine1("Loc. Bussia 55");
		producer.setZipCode("12065");
		producer.setPlace("Monforte d'Alba");
		producer.setPhone("0039 173 78257");
		producer.seteMail("info@parusso.com");
		producer.setUrl("http://parusso.com/");
		producer.setCountry(new CountryEntity("IT"));
		producer.setRegion(new RegionEntity(18)); // Piemont
		producerList.add(producer);

		for (ProducerEntity p : producerList) {
			em.persist(p);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
