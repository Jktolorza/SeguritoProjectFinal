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
			</div>
			<h2>Problema</h2>
			<p>Alto, No tienes permiso para estar aca </p>
			<img alt="" src="https://image.flaticon.com/icons/png/512/10/10688.png" style="width: 90%">
			<a href="<c:url value="/" /> ">Vuelva al menu</a>
		</div>
	</div>
</html>