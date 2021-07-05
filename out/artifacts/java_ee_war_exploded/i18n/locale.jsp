<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/22/2021
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="mylables" /> <%-- fully qualifies package name (in case where resources are not in defult directory) ex. com.luv2code.jsp.tagdemo.i18n.resources.mylables--%>
<html>
<head>
    <title>i18n</title>
</head>
<body>
<a href="i18n-messages.jsp?theLocale=en_US">English (US)</a>
|
<a href="i18n-messages.jsp?theLocale=es_ES">Spanish (ES)</a>
|
<a href="i18n-messages.jsp?theLocale=de_DE">German (DE)</a>

<br><br>

<fmt:message key="label.greeting"/> <br><br>
<fmt:message key="label.firstname"/> <i>John</i><br><br>
<fmt:message key="label.lastname"/> <i>Doe</i><br><br>
<fmt:message key="label.welcome"/> <br><br>
</body>
</html>