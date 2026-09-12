import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/getsession"})
public class GetSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get existing session
        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Session Variable</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Session Variable Value</h2>");

        if (session != null) {

            // Retrieve username from session
            String username =
                    (String) session.getAttribute("username");

            if (username != null) {

                out.println("<p>User Name: "
                        + username
                        + "</p>");

            } else {

                out.println("<p>Session variable not found.</p>");
            }

        } else {

            out.println("<p>Session does not exist.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}