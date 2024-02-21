package controller;

import model.Book;
import model.Library;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int libraryId = Integer.parseInt(request.getParameter("libraryId"));

        EntityManagerFactory entityManagerFactory = DatabaseUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            
            Library library = DatabaseUtil.getLibraryById(libraryId);
            book.setLibrary(library);

            entityManager.persist(book);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new ServletException("Error processing request", e);
        } finally {
            entityManager.close();
        }

        response.sendRedirect(request.getContextPath());
    }
}
