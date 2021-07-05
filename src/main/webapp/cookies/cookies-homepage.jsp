<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 6/5/2021
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training portal</title>
</head>
<body>
<%--read the favourite programme language cookie--%>
    <%
    //the defualt ... if there are no cookies
    String favLang = "Java";

    //get the cookie from browser request
    Cookie[] cookies = request.getCookies();

    //find favourite  language cookie
    if (cookies != null) {
        for (Cookie tempCookie : cookies) {

            if ("myapp.favouriteLanguage".equalsIgnoreCase(tempCookie.getName())) {
                favLang = tempCookie.getValue();
                break;
            }
        }
    }
%>
<%-- now show a personalized page ... use fav language variable--%>
<%--Show new book for this language--%>
<h4>New Books for <%= favLang %></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<h4>Latest News Reports for <%= favLang%></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<h4>Hot Jobs for <%= favLang%></h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<a href="cookies-personalize-form.html">Personalize this page</a>
