<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/25/2021
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Student Form</title>
    <link type="text/css" rel="stylesheet" href="jdbc/css/style.css">
    <link type="text/css" rel="stylesheet" href="jdbc/css/add-student-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>FooBar University</h2>
    </div>
</div>

<div id="container">
    <h3>Update Student</h3>

    <form action="StudentControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="studentId" value="${THE_STUDENT.id}">

        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><input type="text" name="firstName" value="${THE_STUDENT.firstName}" /></td>
            </tr>
            <tr>
                <td><label>Last Name:</label></td>
                <td><input type="text" name="lastName" value="${THE_STUDENT.lastName}"/></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input type="text" name="email" value="${THE_STUDENT.email}"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear: both"></div>
    <p>
        <a href="StudentControllerServlet">Back To List</a>
    </p>
</div>
</body>
</html>