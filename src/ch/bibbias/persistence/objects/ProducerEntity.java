package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "producer")
public class ProducerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producer_id")
	private Long id;
	@Column(name = "producer_name", length = 60)
	private String name;
	@Column(name = "producer_company", length = 60)
	private String company;
	@Column(name = "producer_addressline_1", length = 100)
	private String addressLine1;
	@Column(name = "producer_addressline_2", length = 100)
	private String addressLine2;
	@Column(name = "producer_zip_code", length = 10)
	private String zipCode;
	@Column(name = "producer_place", length = 60)
	private String place;
	@Column(name = "producer_phone", length = 20)
	private String phone;
	@Column(name = "producer_fax", length = 20)
	private String fax;
	@Column(name = "producer_email", length = 100)
	private String eMail;
	@Column(name = "producer_url", length = 100)
	private String url;

	@OneToOne
	@JoinColumn(name = "producer_country")
	private CountryEntity country;
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

	@JoinColumn(name = "producer_region")
	private RegionEntity region;

	public ProducerEntity(long id) {
		this.id = id;

	}

	public ProducerEntity() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

}
