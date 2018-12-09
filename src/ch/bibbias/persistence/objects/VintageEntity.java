package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "vintage")
public class VintageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vintage_id")
	private Long id;
	@Column(name = "vintage_year", length = 4)
	private int year;
	@Column(name = "vintage_size", length = 5)
	private double size;
	@Column(name = "vintage_alcohol", length = 5)
	private double alcohol;
	@Column(name = "vintage_drink_from", length = 4)
	private int drinkFrom;
	@Column(name = "vintage_drink_to", length = 4)
	private int drinkTo;

	@OneToOne
	@JoinColumn(name = "vintage_wine")
	private WineEntity wine;

	public VintageEntity(long id) {
		this.id = id;

	}

	public VintageEntity() {

	}

	public int getYear() {
		return this.year;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public int getDrinkFrom() {
		return drinkFrom;
	}

	public void setDrinkFrom(int drinkFrom) {
		this.drinkFrom = drinkFrom;
	}

	public int getDrinkTo() {
		return drinkTo;
	}

	public void setDrinkTo(int drinkTo) {
		this.drinkTo = drinkTo;
	}

	public Long getId() {
		return id;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
