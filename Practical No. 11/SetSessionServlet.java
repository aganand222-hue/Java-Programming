import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/setsession"})
public class SetSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get User Name from HTML form
        String username = request.getParameter("username");

        // Create or get session
        HttpSession session = request.getSession();

        // Store username in session
        session.setAttribute("username", username);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session Created</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Session Variable Created Successfully</h2>");

        out.println("<p>User Name: " + username + "</p>");

        out.println("<br>");

        out.println("<a href='getsession'>Display Session Value</a>");

        out.println("</body>");
        out.println("</html>");
    }
}