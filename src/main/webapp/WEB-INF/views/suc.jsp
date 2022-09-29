<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Amir
  Date: 9/29/2022
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${name}

<a href="/logoutUrl">Logout</a>


<%--<form:form action="${pageContext.request.contextPath}/logoutUrl"--%>
<%--           method="POST">--%>
<%--    <input type="submit" value="Logout" />--%>
<%--</form:form>--%>

</body>
</html>
