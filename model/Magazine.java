package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Magazines")
public class Magazine extends LiteraryElement {

	private Periodicity periodicity;

	public Magazine(String isbnCode, String title, int yearOfPublication, int pageNumber, Periodicity periodicity) {
		super(isbnCode, title, yearOfPublication, pageNumber);
		this.periodicity = periodicity;
	}

	public Magazine() {
		super();
	}

	@Column(length = 20, nullable = true)
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [periodicity=" + periodicity + ", isbnCode=" + isbnCode + ", title=" + title
				+ ", yearOfPublication=" + yearOfPublication + ", pageNumber=" + pageNumber + "]";
	}

}
