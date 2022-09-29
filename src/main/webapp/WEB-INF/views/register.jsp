<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Amir
  Date: 9/29/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<h1>Register User</h1>
<be/><br/>

<form:form action="/user/register" method="post" modelAttribute="dto">

    NID : <input type="text" name="username" id="username" />
    <form:errors path="username" cssStyle="color:red" /><br/><br/>
    Password : <input type="text" name="password" id="password" />
    <form:errors path="password" cssStyle="color:red"/><br/><br/>
    First Name : <input type="text" name="firstName" id="firstName" /><br/><br/>
    Last Name : <input type="text" name="lastName" id="lastName" /><br/><br/>
    <input type="submit" name="Register" id="Register" value="Register" />

</form:form>

</body>
</html>
