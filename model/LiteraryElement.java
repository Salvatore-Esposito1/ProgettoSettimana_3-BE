package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Catalogue")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Catalogue", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = LiteraryElement.QUERY_SELECT_SEARCH_ISBNCODE, query = "SELECT i FROM LiteraryElement i WHERE i.isbnCode = :isbnCode")
@NamedQuery(name = LiteraryElement.QUERY_SELECT_SEARCH_TITLE, query = "SELECT t FROM LiteraryElement t WHERE t.title LIKE :title")
@NamedQuery(name = LiteraryElement.QUERY_SELECT_SEARCH_YEAR, query = "SELECT y FROM LiteraryElement y WHERE y.annoPublicazione = :yearOfPublication")

public abstract class LiteraryElement {

	protected String isbnCode;
	protected String title;
	protected int yearOfPublication;
	protected int pageNumber;
	public static final String QUERY_SELECT_SEARCH_ISBNCODE = "QUERY_SELECT_SEARCH_ISBNCODE";
	public static final String QUERY_SELECT_SEARCH_TITLE = "QUERY_SELECT_SEARCH_TITLE";
	public static final String QUERY_SELECT_SEARCH_YEAR = "QUERY_SELECT_SEARCH_YEAR";

	public LiteraryElement(String isbnCode, String title, Integer yearOfPublication, Integer pageNumber) {
		this.isbnCode = isbnCode;
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.pageNumber = pageNumber;
	}

	public LiteraryElement() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, nullable = false)
	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	@Column(length = 35, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 4, nullable = false)
	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "LiteraryElement [isbnCode=" + isbnCode + ", title=" + title + ", yearOfPublication=" + yearOfPublication
				+ ", pageNumber=" + pageNumber + "]";
	}

}
