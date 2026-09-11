<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Display Session Variable</title>
</head>

<body>

<h2>Session Variable Value</h2>

<%
    // Retrieve User Name from session
    String username = (String) session.getAttribute("username");
%>

<%
    if (username != null) {
%>

    <p>User Name: <%= username %></p>

<%
    } else {
%>

    <p>Session variable not found.</p>

<%
    }
%>

</body>
</html>