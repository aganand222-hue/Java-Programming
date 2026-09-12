import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/displaycookies"})
public class DisplayCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Cookies</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Cookies Stored on Client</h2>");

        out.println("<table border='1' cellpadding='10'>");

        out.println("<tr>");
        out.println("<th>Cookie Name</th>");
        out.println("<th>Cookie Value</th>");
        out.println("</tr>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                out.println("<tr>");

                out.println("<td>"
                        + cookie.getName()
                        + "</td>");

                out.println("<td>"
                        + cookie.getValue()
                        + "</td>");

                out.println("</tr>");
            }

        } else {

            out.println("<tr>");
            out.println("<td colspan='2'>No cookies found</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}