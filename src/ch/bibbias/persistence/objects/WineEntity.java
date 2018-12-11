package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "wine")
public class WineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wine_id")
	private Long id;
	@Column(name = "wine_name", length = 100)
	private String name;

	@OneToOne
	@JoinColumn(name = "wine_type")
	private WineTypeEntity wineType;
	@JoinColumn(name = "wine_classification")
	private WineClassificationEntity classification;
	@JoinColumn(name = "wine_country")
	private CountryEntity country;
	@JoinColumn(name = "wine_region")
	private RegionEntity region;
	@JoinColumn(name = "wine_producer")
	private ProducerEntity producer;

	public WineEntity(long id) {
		this.id = id;

	}

	public WineEntity() {

	}

	public String getName() {
		return this.name;
	}

	public WineTypeEntity getWineType() {
		return wineType;
	}

	public void setWineType(WineTypeEntity wineType) {
		this.wineType = wineType;
	}

	public WineClassificationEntity getClassification() {
		return classification;
	}

	public void setClassification(WineClassificationEntity classification) {
		this.classification = classification;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public RegionEntity getRegion() {
		return region;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}

	public ProducerEntity getProducer() {
		return producer;
	}

	public void setProducer(ProducerEntity producer) {
		this.producer = producer;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
