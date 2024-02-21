package controller;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import model.Book;
import model.Library;


/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 15, 2024
 */
public class DatabaseUtil {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Booklist");

    public static EntityManagerFactory getEntityManagerFactory() {
        
        return emfactory;
    }
    
    public List <Book> getAllBooks(){
		EntityManager em = emfactory.createEntityManager();
		List <Book> allBooks = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		em.close();
		return allBooks;
	}
    public static void addLibrary(Library library) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(library);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Library> getAllLibraries() {
        EntityManager em = emfactory.createEntityManager();
        List<Library> allLibraries = em.createQuery("SELECT l FROM Library l", Library.class).getResultList();
        em.close();
        return allLibraries;
    }
    
    public static void deleteLibrary(int libraryId) throws ServletException {
        EntityManager em = emfactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Library library = em.find(Library.class, libraryId);
        if (library != null) {
            em.remove(library);
        }
        transaction.commit();

        em.close();
    }
    
    public static Library getLibraryById(int libraryId) {
        EntityManager em = emfactory.createEntityManager();
        Library library = em.find(Library.class, libraryId);
        em.close();
        return library;
    }
}

