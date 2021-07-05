<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/20/2021
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>For-Each JSTL</title>
</head>
<body>

<%
    String[] cities = {"Mumbai", "Singhapore", "Philadelphiya"};
    pageContext.setAttribute("mycities", cities);
%>

<c:forEach var="tempCity" items="${mycities}" >
    ${tempCity} </br>
</c:forEach>

</body>
</html>