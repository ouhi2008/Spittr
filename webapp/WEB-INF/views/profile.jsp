<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <c:out value="${spitter.username}"/><br/>
    <c:out value="${spitter.firstName}"/><br/>
    <c:out value="${spitter.lastName}" /><br/>

    <a href="<c:url value="/"/> ">Home</a>
</body>
</html>