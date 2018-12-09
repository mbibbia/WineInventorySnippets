package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "wine_type")
public class WineTypeEntity {

	@Id
	@Column(name = "type_code", length = 20)
	private String code;

	@Column(name = "type_name", length = 40)
	private String name;
	
	public WineTypeEntity(String code) {
		this.code = code;

	}

	public WineTypeEntity() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}



}
