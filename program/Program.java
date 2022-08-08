package program;

import java.time.LocalDate;

import dao.CatalogueDAO;
import dao.LoanDAO;
import model.Book;
import model.LiteraryElement;
import model.Loan;
import model.Magazine;
import model.Periodicity;
import model.User;

public class Program {

	public static void main(String[] args) {
		var catalogue = new CatalogueDAO();
		var loan = new LoanDAO();
		
		LiteraryElement b1 = new Book("17396", "first book", 2022, 168, "Giuseppe Verdi", "Fantasy");
		LiteraryElement b2 = new Book("52123", "second book", 2018, 321, "Mario Rossi", "Strategy");
		LiteraryElement r1 = new Magazine("12404", "first magazine", 1976, 34, Periodicity.WEEKLY);
		catalogue.addElement(b1);
		catalogue.addElement(b2);
		catalogue.addElement(r1);
		
		User u1 = new User("Giovanni", "Neri", LocalDate.of(2000, 7, 12), 725);
		Loan l1 = new Loan(u1, b1, LocalDate.now());
		
		loan.addUser(u1);
		loan.addLoan(l1);
		
		catalogue.searchByAuthor("Giuseppe Verdi");
		catalogue.searchByIsbnCode("17396");
		catalogue.searchByTitle("first magazine");
		catalogue.searchByYearOfPublication(2018);
	}

}
