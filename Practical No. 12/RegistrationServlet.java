import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/register"})
public class RegistrationServlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USER = "root";

    private static final String PASSWORD = "root";


    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            String sql = "INSERT INTO registration "
                       + "(name, email, password, phone) "
                       + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);

            int result = ps.executeUpdate();

            if (result > 0) {

                out.println("<html>");
                out.println("<body>");
                out.println("<h2>Registration Successful!</h2>");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Phone: " + phone + "</p>");
                out.println("</body>");
                out.println("</html>");

            } else {

                out.println("<h2>Registration Failed!</h2>");

            }

            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Database Error!</h2>");
            out.println("<p>" + e.getMessage() + "</p>");

        }
    }
}