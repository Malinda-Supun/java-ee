<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/20/2021
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Functions JSTL</title>
</head>
<body>

<c:set var="data" value="luv2code" />

Length of the string <b>${data}</b>:${fn:length(data)}

<br><br>

Upper case version of the string <b>${data}</b>: ${fn:toUpperCase(data)}

<br><br>

Does the String starts with <b>${data}</b>: ${fn:startsWith(data, "l")}

<br><br>
<c:set var="splitdata" value="Singapore,Tokiyo,Colombo,London"/>

Split Operation
<br><br>
<c:set var="citiesArray" value="${fn:split(splitdata, ',')}" />

<c:forEach var="value" items="${citiesArray}" >
    ${value} <br>
</c:forEach>

<br><br>
Join Operation
<c:set var="joindata" value="${fn:join(citiesArray, '*')}" />

<br>
Result of Joining: ${joindata}

</body>
</html>