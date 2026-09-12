import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/setcookie"})
public class SetCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get User Name from HTML form
        String username = request.getParameter("username");

        // Create cookie
        Cookie cookie = new Cookie("username", username);

        // Cookie will remain for 1 hour
        cookie.setMaxAge(60 * 60);

        // Add cookie to browser
        response.addCookie(cookie);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookie Stored</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Cookie Created Successfully</h2>");

        out.println("<p>User Name: " + username + "</p>");

        out.println("<br>");

        out.println("<a href='getcookie'>Display Cookie</a>");

        out.println("</body>");
        out.println("</html>");
    }
}