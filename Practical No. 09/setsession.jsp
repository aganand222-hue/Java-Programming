<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Get User Name from HTML form
    String username = request.getParameter("username");

    // Store User Name as session variable
    session.setAttribute("username", username);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Stored</title>
</head>

<body>

<h2>Session Variable Created</h2>

<p>User Name: <%= username %></p>

<br>

<a href="getsession.jsp">Display Session Value</a>

</body>
</html>