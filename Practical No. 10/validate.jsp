<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login Validation</title>
</head>

<body>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String url = "jdbc:mysql://localhost:3306/studentdb";
    String user = "root";
    String dbPassword = "root";

    try {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                url, user, dbPassword);

        String sql = "SELECT * FROM registration "
                   + "WHERE name=? AND password=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

%>
            <h2>Login Successful!</h2>

            <p>Welcome, <%= username %></p>

<%
        } else {

%>
            <h2>Invalid Username or Password!</h2>

            <a href="login.html">Try Again</a>

<%
        }
        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

%>
        <h2>Database Error!</h2>

        <p><%= e.getMessage() %></p>

<%
    }
%>

</body>
</html>