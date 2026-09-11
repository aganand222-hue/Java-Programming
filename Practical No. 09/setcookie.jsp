<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Get username from HTML form
    String username = request.getParameter("username");

    // Create cookie
    Cookie userCookie = new Cookie("username", username);

    // Set cookie age to 1 hour
    userCookie.setMaxAge(60 * 60);

    // Add cookie to response
    response.addCookie(userCookie);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Stored</title>
</head>
<body>

<h2>Cookie Created Successfully</h2>

<p>User Name: <%= username %></p>

<br>

<a href="getcookie.jsp">View Cookie Value</a>

</body>
</html>