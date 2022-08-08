package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.LoggerFactory;

import model.Book;
import model.LiteraryElement;

public class CatalogueDAO {
	public static final org.slf4j.Logger log = LoggerFactory.getLogger(CatalogueDAO.class);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoSettimana_3-BE");

	public void addElement(LiteraryElement literaryElement) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(literaryElement);
			trans.commit();
		} catch (Exception e) {
			log.error("New Exception addElement method");
		} finally {
			em.close();
		}
	}

	public void removeElement(String isbnCode) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(LiteraryElement.QUERY_SELECT_SEARCH_ISBNCODE, LiteraryElement.class);
			query.setParameter("isbnCode", isbnCode);
			LiteraryElement r = query.getSingleResult();
			LiteraryElement id = em.find(LiteraryElement.class, r.getIsbnCode());
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(id);
			trans.commit();
		} catch (Exception e) {
			log.error("New Exception removeElement method");
		} finally {
			em.close();
		}

	}

	public LiteraryElement searchByIsbnCode(String isbnCode) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(LiteraryElement.QUERY_SELECT_SEARCH_ISBNCODE, LiteraryElement.class);
			query.setParameter("isbnCode", isbnCode);
			LiteraryElement r = query.getSingleResult();
			return r;
		} catch (Exception e) {
			log.error("New Exception searchByIsbnCode method");
		} finally {
			em.close();
		}
		return null;
	}

	public List<LiteraryElement> searchByTitle(String title) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(LiteraryElement.QUERY_SELECT_SEARCH_TITLE, LiteraryElement.class);
			query.setParameter("title", "%" + title + "%");
			List<LiteraryElement> r = query.getResultList();
			return r;
		} catch (Exception e) {
			log.error("New Exception searchByTitle method");
			return new ArrayList<LiteraryElement>();
		} finally {
			em.close();
		}
	}
	public List<LiteraryElement> searchByYearOfPublication(int yearOfPublication) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(LiteraryElement.QUERY_SELECT_SEARCH_YEAR, LiteraryElement.class);
			query.setParameter("yearOfPublication", yearOfPublication);
			List<LiteraryElement> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("New Exception searchByYearOfPublication method");
			return new ArrayList<LiteraryElement>();
		} finally {
			em.close();
		}
	}

	public List<Book> searchByAuthor(String author) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(Book.QUERY_SELECT_SEARCH_AUTHOR, Book.class);
			query.setParameter("author", author);
			List<Book> r = query.getResultList();
			return r;
		} catch (Exception e) {
			log.error("New Exception searchByAuthor method");
			return new ArrayList<Book>();
		} finally {
			em.close();
		}
	}

	
}
