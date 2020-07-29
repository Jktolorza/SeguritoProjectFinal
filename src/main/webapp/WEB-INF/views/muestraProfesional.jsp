<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profesional</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>

<body>
<div class="container">
<div class="row">
	<div class="col align-self-start"></div>
	<div class="col align-self-center">
	<c:set var="p" value="${p}"></c:set>
	<div class="row">
		<div class="col"><h1 class="display-4">${p.getNombre()} ${p.getApellido()}</h1></div>
	</div>
	<div class="row">
		<div class="col"><h4>${p.getCargo()}</h4>
		
		
		</div>
	</div>
	<hr>
	<img class="rounded mx-auto d-block" width="200" height="200" border="30%" src="https://image.freepik.com/vector-gratis/perfil-avatar-mujer-icono-redondo_24640-14042.jpg">

	<div class="row">
		<div class="col-3">Correo:</div>
		<div class="col">${p.getCorreo()}</div>
	</div>
	<div class="row">
		<div class="col-3">Teléfono:</div>
		<div class="col">${p.getTelefono()}</div>
	</div>
	
	<hr>
	<div class="row">
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/listarProfesional">Volver</a>
	</div>

</div>
<div class="col align-self-end"></div>
</div>
</div>

</body>
</html>