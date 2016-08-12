
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spittr</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
    <style type="text/css"> 
	<!-- 
	.ceshi {font-size:14px; color:#FF0000;}/*这里是设置CSS的样式内容*/ 
	--> 
	span.error {
		color: red;
	}
	div.errors {
		color: red;
	}
	
	</style> 
</head>
<body>
  <h1>Register</h1>
  <sf:form method="POST" commandName="spitter">
		First Name: <sf:input path="firstName" /> <sf:errors path="firstName"  cssClass="error" /><br/>		
		Last Name: <sf:input path="lastName" /> <sf:errors path="lastName"  cssClass="error" /><br/>
		Email: <sf:input path="email" /> <sf:errors path="email"  cssClass="error" /><br/>
		Username: <sf:input path="username" /> <sf:errors path="username"  cssClass="error" /><br/>
		Password: <sf:password path="password" /> <sf:errors path="password"  cssClass="error" /><br/>
		<input type="submit" value="Register" />
		<input type="button" value="Return" onclick="javascript:window.location.href ='<c:url value="/"/>';">
   </sf:form>
  
  <!-- 
  <form method="POST">
    First Name: <input type="text" name="firstName" /><br/>
    Last Name: <input type="text" name="lastName"/><br/>
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Register" />
  </form>
   -->
</body>
</html>