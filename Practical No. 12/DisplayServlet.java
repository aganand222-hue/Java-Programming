import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/display"})
public class DisplayServlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM registration";

            ResultSet rs = stmt.executeQuery(sql);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Records</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h2>All Registration Records</h2>");

            out.println("<table border='1' cellpadding='10'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Password</th>");
            out.println("<th>Phone</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getInt("id") + "</td>");

                out.println("<td>" + rs.getString("name") + "</td>");

                out.println("<td>" + rs.getString("email") + "</td>");

                out.println("<td>" + rs.getString("password") + "</td>");

                out.println("<td>" + rs.getString("phone") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Database Error</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}