<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Amir
  Date: 10/2/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<h1>Add Book</h1>
<br/><br/>
<form:form action="/book/addBook" method="post">

  Name : <input type="text" name="name" id="name" /><br/><br/>
<%--  <form:errors path="username" cssStyle="color:red" /><br/><br/>--%>
  AuthorName : <input type="text" name="authorName" id="authorName" /><br/><br/>
<%--  <form:errors path="password" cssStyle="color:red"/><br/><br/>--%>
  Count : <input type="text" name="count" id="count" /><br/><br/><br/><br/>
<%--  Last Name : <input type="text" name="lastName" id="lastName" /><br/><br/>--%>
  <input type="submit" name="addBook" id="addBook" value="Add Book" />

</form:form>
</body>
</html>
