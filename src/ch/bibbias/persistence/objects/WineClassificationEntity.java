package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "wine_classification")
public class WineClassificationEntity {

	@Id
	@Column(name = "classification_code", length = 40)
	private String code;

	@Column(name = "classification_name", length = 100)
	private String name;

	public WineClassificationEntity(String code) {
		this.code = code;

	}

	public WineClassificationEntity() {

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
