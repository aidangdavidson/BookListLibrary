package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteLibrary")
public class DeleteLibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the library ID parameter from the request
        int libraryId = Integer.parseInt(request.getParameter("libraryId"));

        // Call DatabaseUtil method to delete the library
        DatabaseUtil.deleteLibrary(libraryId);

        // Redirect to a success page or appropriate response
        response.sendRedirect(request.getContextPath() + "/success.jsp");
    }
}
