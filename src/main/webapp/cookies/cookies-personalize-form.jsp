<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/5/2021
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<%
    //read from data
    String favLang = request.getParameter("favouriteLanguage");

    //create the cokkie
    Cookie cookie = new Cookie("myapp.favouriteLanguage", favLang);

    //set the life span ... total number of seconds (yuk!)
    cookie.setMaxAge(60*60*24*365);

    //send cookie to browser
    response.addCookie(cookie);

%>

Thanks! we set your favourite language to: ${param.favouriteLanguage}

<br><br>

<a href="cookies-homepage.jsp">Return  to hompage</a>

</body>
</html>