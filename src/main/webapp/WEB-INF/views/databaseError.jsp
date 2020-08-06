<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error 403: Acceso Denegado</title>
	<!-- Hoja de estilo -->
    <link rel="stylesheet" href="<core:url value="/res/css/styleerror.css" />">
    	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900" rel="stylesheet">
</head>
	<body>
	
	<div id="notfound"    >
		<div class="notfound" >
			<div class="notfound-403">
				<h1>Oops!</h1>
				<%-- 	<c:if test="${not empty errCode}"> --%>
<%-- 		<h1>${errCode} : System Errors</h1> --%>
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${not empty errCode}"> --%>
<%-- 		<h1>${stackTrace} : Stack Trace</h1> --%>
<%-- 	</c:if> --%>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
			</div>
			<h2>Estas un poco perdido</h2>
			<p>Te ayudo, Psegurito te guia </p>
			<img alt="" src="https://cdn3.iconfinder.com/data/icons/bipolar-disorder/298/bipolar-disorder-007-512.png" style="width: 90%">
			<a href="<c:url value="/" /> ">Vuelva al menu</a>
		</div>
	</div>
</html>