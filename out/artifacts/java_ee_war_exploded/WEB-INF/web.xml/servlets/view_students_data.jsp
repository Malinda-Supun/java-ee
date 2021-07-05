<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/23/2021
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Data Table</title>
</head>
<body>
<table border="1">
    <thead>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    </thead>
    <tbody>
    <c:forEach var="student" items="${student_list}">
        <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>