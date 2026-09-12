<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <title>Display All Records</title>
</head>

<body>

<h2>All Registration Records</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Phone</th>
    </tr>

<%
    String url = "jdbc:mysql://localhost:3306/studentdb";
    String username = "root";
    String password = "root";

    try {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                url, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM registration");

        while (rs.next()) {
%>

    <tr>

        <td><%= rs.getInt("id") %></td>

        <td><%= rs.getString("name") %></td>

        <td><%= rs.getString("email") %></td>

        <td><%= rs.getString("password") %></td>

        <td><%= rs.getString("phone") %></td>

    </tr>

<%
        }

        rs.close();
        stmt.close();
        con.close();

    } catch (Exception e) {
%>

    <tr>
        <td colspan="5">
            Database Error: <%= e.getMessage() %>
        </td>
    </tr>

<%
    }
%>

</table>

</body>
</html>