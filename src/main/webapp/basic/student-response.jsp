<%--
  Created by IntelliJ IDEA.
  User: USUPUMA
  Date: 5/31/2021
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>
The student is confirmed: ${param.firstName} ${param.lastName} from ${param.country} whoes favourite programming Language is ${param.language.toUpperCase()}

<br><br>
Favourite Languages
<%
    String[] lang = request.getParameterValues("favouriteLanguages");
    if(lang!=null) {
        for (String lan : lang) {
            out.println("<li>" + lan + "</li>");
        }
    }
%>

</body>
</html>