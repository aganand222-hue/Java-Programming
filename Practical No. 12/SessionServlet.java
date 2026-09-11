import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session"})
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Create or get session
        HttpSession session = request.getSession();

        // Store value in session variable
        session.setAttribute("username", "Shravan");

        // Open JSP page
        response.sendRedirect("session.jsp");
    }
}