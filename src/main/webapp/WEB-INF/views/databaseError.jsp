<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DatabaseError</title>
</head>
<body>
<%-- 	<c:if test="${not empty errCode}"> --%>
<%-- 		<h1>${errCode} : System Errors</h1> --%>
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${not empty errCode}"> --%>
<%-- 		<h1>${stackTrace} : Stack Trace</h1> --%>
<%-- 	</c:if> --%>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
</body>
</html>