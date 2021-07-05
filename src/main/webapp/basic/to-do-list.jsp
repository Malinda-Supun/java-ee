<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/3/2021
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Do List</title>
</head>
<body>

<%--Step 1. Create HTML form--%>
<form action="to-do-list.jsp">
    Add new item: <input type="text" name="theItem"/>

    <input type="submit" value="Submit"/>
</form>

<br>

Item entered: <%--<%= request.getParameter("theItem")%>--%>

<%--Step 2. Add new item to "To Do" list--%>
<%
    List<String> items = (List<String>) session.getAttribute("myToDoList");

    if (items == null) {
        items = new ArrayList<>();
        session.setAttribute("myToDoList", items);
    }

    String theItem = request.getParameter("theItem");
    if (theItem != null) {
        items.add(theItem);
    }
%>

<hr>
<b>To Do List Items:</b> <br>

<ol>
    <%--Step 3. Display all "To Do" items from session--%>
    <%
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
    %>
</ol>


</body>
</html>