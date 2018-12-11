package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "region")
public class RegionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private long id;

	@Column(name = "region_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "country")
	private CountryEntity country;

	public RegionEntity(long id) {
		this.id = id;

	}

	public RegionEntity() {

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return this.id;
	}

	public CountryEntity getCountry() {
		return this.country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

}
