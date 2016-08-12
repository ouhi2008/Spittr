<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <table>
    <tr><td><b>Id</b></td><td> <c:out value="${spitter.id}"/></td></tr>
    <tr><td><b>Username</b></td><td> <c:out value="${spitter.username}"/></td></tr>
    <tr><td><b>First Name</b></td><td> <c:out value="${spitter.firstName}"/></td></tr>
    <tr><td><b>Last Name</b></td><td> <c:out value="${spitter.lastName}" /></td></tr>
    <tr><td><b>Email</b></td><td> <c:out value="${spitter.email}" /> </td></tr>
    </table>
    <a href="<c:url value='/'/> ">Home</a>
</body>
</html>