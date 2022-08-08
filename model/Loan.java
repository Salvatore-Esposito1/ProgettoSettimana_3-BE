package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Loans")
@NamedQuery(name = Loan.QUERY_SELECT_SEARCH_LOAN, query = "SELECT a FROM Loan a WHERE a.user.cardNumber = :cardNumber "
		+ "AND a.effectiveReturnDate IS NULL")
@NamedQuery(name = Loan.QUERY_SELECT_SEARCH_LOAN_EXPIRED, query = "SELECT a FROM Loan a WHERE a.effectiveReturnDate IS NULL"
		+ "AND a.effectiveReturnDate < :effectiveReturnDate")
public class Loan {
	private int id;
	private User user;
	private LiteraryElement lentElement;
	private LocalDate loanStartDate;
	private LocalDate expectedReturnDate;
	private LocalDate effectiveReturnDate;
	public static final String QUERY_SELECT_SEARCH_LOAN = "QUERY_SELECT_SEARCH_LOAN";
	public static final String QUERY_SELECT_SEARCH_LOAN_EXPIRED = "QUERY_SELECT_SEARCH_LOAN_EXPIRED";

	public Loan(User user, LiteraryElement lentElement, LocalDate loanStartDate, LocalDate effectiveReturnDate) {
		this.user = user;
		this.lentElement = lentElement;
		this.loanStartDate = loanStartDate;
		this.expectedReturnDate = loanStartDate.plusDays(30);
		this.effectiveReturnDate = effectiveReturnDate;
	}

	public Loan(User user, LiteraryElement lentElement, LocalDate loanStartDate) {
		this.user = user;
		this.lentElement = lentElement;
		this.loanStartDate = loanStartDate;
		this.expectedReturnDate = loanStartDate.plusDays(30);
		;
	}

	public Loan() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne
	public LiteraryElement getLentElement() {
		return lentElement;
	}

	public void setLentElement(LiteraryElement lentElement) {
		this.lentElement = lentElement;
	}

	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(LocalDate expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public LocalDate getEffectiveReturnDate() {
		return effectiveReturnDate;
	}

	public void setEffectiveReturnDate(LocalDate effectiveReturnDate) {
		this.effectiveReturnDate = effectiveReturnDate;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", user=" + user + ", lentElement=" + lentElement + ", loanStartDate=" + loanStartDate
				+ ", expectedReturnDate=" + expectedReturnDate + ", effectiveReturnDate=" + effectiveReturnDate + "]";
	}

}
