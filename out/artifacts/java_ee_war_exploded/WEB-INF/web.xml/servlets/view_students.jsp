<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/23/2021
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Student List from Servlet</title>
</head>
<body>

<ul>
    <c:forEach var="student" items="${student_list}" >
        <li>${student}</li>
    </c:forEach>
</ul>


</body>
</html>