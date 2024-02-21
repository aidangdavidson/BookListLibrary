package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Library;


@WebServlet("/addLibrary")
public class AddLibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String libraryName = request.getParameter("libraryName");

        // Create a new Library object
        Library library = new Library();
        library.setName(libraryName);

        // Call the DatabaseUtil method to add the library to the database
        DatabaseUtil.addLibrary(library);

    }
}