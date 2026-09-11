<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Display Cookie</title>
</head>
<body>

<h2>Cookie Value</h2>

<%
    String username = null;

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("username")) {

                username = cookie.getValue();
                break;
            }
        }
    }
%>

<%
    if (username != null) {
%>

    <p>User Name: <%= username %></p>

<%
    } else {
%>

    <p>Cookie not found.</p>

<%
    }
%>

</body>
</html>