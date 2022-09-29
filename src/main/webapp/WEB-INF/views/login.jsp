<%--<%@include file="/WEB-INF/views/template/header.jsp"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<div class="container-wrapper">--%>

<%--    <div class="container">--%>


<%--        <div class="page-header title">--%>
<%--            <h1>Login with Username and Paassword</h1>--%>

<%--            <p class="lead">Fill the below information to login</p>--%>
<%--        </div>--%>


<%--        <div class="form-layout">--%>
<%--            <form:form method="post" action="/authenticateTheUser" class="form-horizontal">--%>

<%--                &lt;%&ndash;                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>

<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label"></label>--%>
<%--                    <div class="col-xs-9">--%>
<%--                        <c:if test="${not empty error}">--%>

<%--                            <div class="error" style="color:#ff0000">--%>
<%--                                    ${error}--%>
<%--                            </div>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label"></label>--%>
<%--                    <div class="col-xs-9">--%>
<%--                        <c:if test="${not empty msg}">--%>
<%--                            <div class="msg">${msg}</div>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>
<%--                </div>--%>


<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label" for="username">Username :</label>--%>
<%--                    <div class="col-xs-9">--%>


<%--                        <input type="text" class="form-control" placeholder="Enter Username" name="username"--%>
<%--                               id="username"/>--%>
<%--                    </div>--%>
<%--                </div>--%>


<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label" for="password">Password :</label>--%>
<%--                    <div class="col-xs-9">--%>


<%--                        <input type="password" class="form-control" name="password" placeholder="Enter Password"--%>
<%--                               id="password"/>--%>
<%--                    </div>--%>
<%--                </div>--%>


<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label"></label>--%>
<%--                    <div class="col-xs-9">--%>

<%--                        Remember Me: <input type="checkbox" name="remember-me"/>--%>
<%--                    </div>--%>
<%--                </div>--%>


<%--                <div class="form-group has-success">--%>
<%--                    <label class="col-xs-3 control-label"></label>--%>
<%--                    <div class="col-xs-9">--%>
<%--                        <input type="submit" value="Submit" class="btn btn-default">--%>

<%--                    </div>--%>
<%--                </div>--%>


<%--            </form:form>--%>
<%--        </div>--%>

<%--    </div>--%>

<%--</div>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form:form method="post" action="/authenticateTheUser">
            Username : <input type="text"  name="username" id="username"/><br/><br/>
            Password : <input type="password"  name="password" id="password"/><br/><br/>
            <input type="submit" value="Submit" >
</form:form>
</body>
</html>


<%--<%@include file="/WEB-INF/views/template/footer.jsp"%>--%>