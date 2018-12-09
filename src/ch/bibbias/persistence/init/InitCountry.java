package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.CountryEntity;

public class InitCountry {

	public static void main(String[] args) {

		ArrayList<CountryEntity> countryList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		CountryEntity country;
		country = new CountryEntity("AR");
		country.setName("Argentinien");
		countryList.add(country);
		country = new CountryEntity("AT");
		country.setName("Österreich");
		countryList.add(country);
		country = new CountryEntity("AU");
		country.setName("Australien");
		countryList.add(country);
		country = new CountryEntity("CH");
		country.setName("Schweiz");
		countryList.add(country);
		country = new CountryEntity("CL");
		country.setName("Chile");
		countryList.add(country);
		country = new CountryEntity("DE");
		country.setName("Deutschland");
		countryList.add(country);
		country = new CountryEntity("ES");
		country.setName("Spanien");
		countryList.add(country);
		country = new CountryEntity("FR");
		country.setName("Frankreich");
		countryList.add(country);
		country = new CountryEntity("GR");
		country.setName("Griechenland");
		countryList.add(country);
		country = new CountryEntity("HR");
		country.setName("Ungarn");
		countryList.add(country);
		country = new CountryEntity("IL");
		country.setName("Israel");
		countryList.add(country);
		country = new CountryEntity("IT");
		country.setName("Italien");
		countryList.add(country);
		country = new CountryEntity("LI");
		country.setName("Liechtenstein");
		countryList.add(country);
		country = new CountryEntity("PT");
		country.setName("Portugal");
		countryList.add(country);
		country = new CountryEntity("US");
		country.setName("USA");
		countryList.add(country);
		country = new CountryEntity("ZA");
		country.setName("Südafrika");
		countryList.add(country);

		for (CountryEntity c : countryList) {
			em.persist(c);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
