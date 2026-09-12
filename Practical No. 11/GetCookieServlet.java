import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/getcookie"})
public class GetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String username = null;

        // Get all cookies from browser
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                // Find username cookie
                if (cookie.getName().equals("username")) {

                    username = cookie.getValue();
                    break;
                }
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Cookie</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Cookie Value</h2>");

        if (username != null) {

            out.println("<p>User Name: " + username + "</p>");

        } else {

            out.println("<p>Cookie not found.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}