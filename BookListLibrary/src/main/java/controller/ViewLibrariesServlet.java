package controller;
import java.util.List;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.Library;
import controller.DatabaseUtil;

@WebServlet("/viewLibraries")
public class ViewLibrariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve the list of libraries and their associated books from the database
        List<Library> libraries = DatabaseUtil.getAllLibraries(); // Example method to retrieve libraries
        
        // Set the list of libraries as a request attribute
        request.setAttribute("libraries", libraries);
        
        // Forward the request to the libraries.jsp file for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("libraries.jsp");
        dispatcher.forward(request, response);
    }
}
