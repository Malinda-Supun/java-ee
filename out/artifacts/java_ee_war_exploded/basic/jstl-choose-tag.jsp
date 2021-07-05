<%@ page import="com.luv2code.jsp.Student" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/21/2021
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Student Data Table</title>
</head>
<body>

<%
    List<Student> data = new ArrayList<>();
    data.add(new Student("John", "Doe", false));
    data.add(new Student("Maxwell", "Johnson", false));
    data.add(new Student("Mary  ", "Public", true));

    pageContext.setAttribute("myStudents", data);
%>

<table>
    <thead>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Gold Customer</th>
    </thead>
    <tbody>
    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>
                <c:choose>

                    <c:when test="${tempStudent.goldCustomer}">
                        Special Discount
                    </c:when>

                    <c:otherwise>
                        otherwise
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>