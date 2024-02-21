package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import model.Book;

@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 1: Receive Book ID to delete
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        // Step 2: Retrieve EntityManager and Begin Transaction
        EntityManagerFactory emf = DatabaseUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            // Step 3: Find Book by ID
            Book book = em.find(Book.class, bookId);
            
            if (book != null) {
                // Step 4: Begin Transaction and Remove Book
                tx.begin();
                em.remove(book);
                tx.commit();
            }
            
            // Step 5: Redirect to IndexServlet
            response.sendRedirect(request.getContextPath() + "/IndexServlet");
            
        } catch (Exception e) {
            // Handle Exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServletException("Error deleting book.", e);
        } finally {
            // Close EntityManager
            em.close();
        }
    }
}
