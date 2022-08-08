package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.LoggerFactory;

import model.Loan;
import model.User;

public class LoanDAO {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoanDAO.class);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoSettimana_3-BE");

	public void addUser(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			log.error("new Exception addUser method");
		} finally {
			em.close();
		}
	}

	public void addLoan(Loan loan) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(loan);
			trans.commit();
		} catch (Exception e) {
			log.error("new Exception addLoan method");
		} finally {
			em.close();
		}
	}

	public List<Loan> expiredLoanSearch() {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(Loan.QUERY_SELECT_SEARCH_LOAN_EXPIRED, Loan.class);
			query.setParameter("effectiveReturnDate", LocalDate.now());
			List<Loan> l = query.getResultList();
			return l;
		} catch (Exception e) {
			log.error("New Exception expiredLoanSearch method");
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}

	public List<Loan> searchLoanByCard(int cardNumber) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(Loan.QUERY_SELECT_SEARCH_LOAN, Loan.class);
			query.setParameter("cardNumber", cardNumber);
			List<Loan> l = query.getResultList();
			return l;
		} catch (Exception e) {
			log.error("New Exception searchLoanByCard method");
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}

}
