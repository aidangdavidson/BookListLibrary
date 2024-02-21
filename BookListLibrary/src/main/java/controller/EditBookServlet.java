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

@WebServlet("/edit")
public class EditBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("id"));
        String newTitle = request.getParameter("newTitle");
        String newAuthor = request.getParameter("newAuthor");
        

        EntityManagerFactory emf = DatabaseUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Book book = em.find(Book.class, bookId);
        

        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
        }
        

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServletException("Error updating book details.", e);
        } finally {
            em.close();
        }
        

        response.sendRedirect(request.getContextPath() + "/IndexServlet");
    }
}
