package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
@NamedQuery(name = Book.QUERY_SELECT_SEARCH_AUTHOR, query = "SELECT a FROM Book a WHERE a.author = :author")
public class Book extends LiteraryElement {

	private String author;
	private String genre;
	public static final String QUERY_SELECT_SEARCH_AUTHOR = "QUERY_SELECT_SEARCH_AUTHOR";

	public Book(String isbnCode, String title, int yearOfPublication, int pageNumber, String author, String genre) {
		super(isbnCode, title, yearOfPublication, pageNumber);
		this.author = author;
		this.genre = genre;
	}

	public Book() {
		super();
	}

	@Column(length = 40, nullable = true)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 30, nullable = true)
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", genre=" + genre + ", isbnCode=" + isbnCode + ", title=" + title
				+ ", yearOfPublication=" + yearOfPublication + ", pageNumber=" + pageNumber + "]";
	}

}
