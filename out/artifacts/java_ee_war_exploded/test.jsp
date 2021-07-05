<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/6/2021
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test JSTL</title>
</head>
<body>

<c:set var="stuff" value="<%= new Date()%>" />

Time on the server is ${stuff}


</body>
</html>