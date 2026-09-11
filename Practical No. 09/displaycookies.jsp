<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Display Cookies</title>
</head>

<body>

<h2>Cookies Stored on Client</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>Cookie Name</th>
        <th>Cookie Value</th>
    </tr>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {

        for (Cookie cookie : cookies) {
%>

    <tr>
        <td><%= cookie.getName() %></td>
        <td><%= cookie.getValue() %></td>
    </tr>

<%
        }

    } else {
%>

    <tr>
        <td colspan="2">No cookies found</td>
    </tr>

<%
    }
%>

</table>

</body>
</html>