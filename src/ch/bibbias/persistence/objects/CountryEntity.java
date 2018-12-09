package ch.bibbias.persistence.objects;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class CountryEntity {

	@Id
	@Column(name = "country_code", length = 2)
	private String code;

	@Column(name = "country_name", length = 60)
	private String name;

	@OneToMany(targetEntity = RegionEntity.class)
	@JoinColumn(name = "country_regions")
	private List<RegionEntity> regionList;

	public CountryEntity(String code) {
		this.code = code;

	}

	public CountryEntity() {

	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RegionEntity> getRegionList() {
		return regionList;
	}

}
