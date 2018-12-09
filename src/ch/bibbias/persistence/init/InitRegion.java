package ch.bibbias.persistence.init;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.CountryEntity;
import ch.bibbias.persistence.objects.RegionEntity;

public class InitRegion {

	public static void main(String[] args) {

		ArrayList<RegionEntity> regionList = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PT_Wine_Inventory");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Truncate table region
		String query = new StringBuilder("TRUNCATE TABLE ").append("region").toString();
		em.createNativeQuery(query).executeUpdate();

		// Init values
		ArrayList<String> regionNameList = new ArrayList<>();
		CountryEntity country;
		RegionEntity region;

		// AR
		regionNameList.clear();
		regionNameList.add("Mendoza");
		country = new CountryEntity("AR");
		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// AT
		country = new CountryEntity("AT");
		regionNameList.clear();
		regionNameList.add("Carnuntum");
		regionNameList.add("Eisenberg");
		regionNameList.add("Kamptal");
		regionNameList.add("Kremstal");
		regionNameList.add("Leithaberg");
		regionNameList.add("Mittelburgenland");
		regionNameList.add("Neusiedler See");
		regionNameList.add("Neusiedlersee-Hügelland");
		regionNameList.add("Steiermark");
		regionNameList.add("Südburgenland");
		regionNameList.add("Thermenregion");
		regionNameList.add("Traisental");
		regionNameList.add("Wachau");
		regionNameList.add("Wagram");
		regionNameList.add("Weinviertel");
		regionNameList.add("Wien");

		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// AU
		country = new CountryEntity("AU");
		regionNameList.clear();
		regionNameList.add("New South Wales");
		regionNameList.add("South Australia");
		regionNameList.add("Victoria");
		regionNameList.add("Western Australia");

		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// CH
		country = new CountryEntity("CH");
		regionNameList.clear();
		regionNameList.add("Aargau");
		regionNameList.add("Bündner Herrschaft");
		regionNameList.add("Drei-Seen-Land");
		regionNameList.add("Genf");
		regionNameList.add("Luzern");
		regionNameList.add("Schaffhausen");
		regionNameList.add("Tessin");
		regionNameList.add("Thunersee");
		regionNameList.add("Waadt");
		regionNameList.add("Wallis");
		regionNameList.add("Zürich");
		regionNameList.add("Puschlav");

		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// DE
		country = new CountryEntity("DE");
		regionNameList.clear();
		regionNameList.add("Ahr");
		regionNameList.add("Baden");
		regionNameList.add("Franken");
		regionNameList.add("Hessische Bergstraße");
		regionNameList.add("Mittelrhein");
		regionNameList.add("Mosel");
		regionNameList.add("Nahe");
		regionNameList.add("Pfalz");
		regionNameList.add("Rheingau");
		regionNameList.add("Rheinhessen");
		regionNameList.add("Saale-Unstrut");
		regionNameList.add("Sachsen");
		regionNameList.add("Württemberg");

		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// ES
		regionNameList.clear();
		regionNameList.add("Andalusien");
		regionNameList.add("Aragonien");
		regionNameList.add("Asturien");
		regionNameList.add("Balearen");
		regionNameList.add("Baskenland");
		regionNameList.add("Extremadura");
		regionNameList.add("Galicien");
		regionNameList.add("Kanarische Inseln");
		regionNameList.add("Kantabrien");
		regionNameList.add("Kastilien-La Mancha");
		regionNameList.add("Kastilien-León");
		regionNameList.add("Katalonien");
		regionNameList.add("La Rioja");
		regionNameList.add("Madrid");
		regionNameList.add("Murcia");
		regionNameList.add("Navarra");
		country = new CountryEntity("ES");
		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// FR
		regionNameList.clear();
		regionNameList.add("Beaujolais");
		regionNameList.add("Bordeaux");
		regionNameList.add("Burgund");
		regionNameList.add("Champagne");
		regionNameList.add("Elsass");
		regionNameList.add("Jura");
		regionNameList.add("Korsika");
		regionNameList.add("Languedoc-Roussillon");
		regionNameList.add("Loire");
		regionNameList.add("Provence");
		regionNameList.add("Rhône");
		regionNameList.add("Savoyen");
		country = new CountryEntity("FR");
		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// IT
		regionNameList.clear();
		regionNameList.add("Abruzzen");
		regionNameList.add("Aostatal");
		regionNameList.add("Apulien");
		regionNameList.add("Basilikata");
		regionNameList.add("Emilia-Romagna");
		regionNameList.add("Friaul");
		regionNameList.add("Kalbrien");
		regionNameList.add("Kampanien");
		regionNameList.add("Latium");
		regionNameList.add("Ligurien");
		regionNameList.add("Lombardei");
		regionNameList.add("Marken");
		regionNameList.add("Molise");
		regionNameList.add("Piemont");
		regionNameList.add("Sardinien");
		regionNameList.add("Sizilien");
		regionNameList.add("Südtirol");
		regionNameList.add("Toskana");
		regionNameList.add("Trentino");
		regionNameList.add("Umbrien");
		regionNameList.add("Venetien");
		regionNameList.add("Campania");
		regionNameList.add("Veltlin");
		country = new CountryEntity("IT");
		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		// PT
		regionNameList.clear();
		regionNameList.add("Douro");
		country = new CountryEntity("PT");
		for (String name : regionNameList) {
			region = new RegionEntity();
			region.setName(name);
			region.setCountry(country);
			regionList.add(region);
		}

		for (RegionEntity r : regionList) {
			em.persist(r);
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
