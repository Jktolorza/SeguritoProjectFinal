<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Profesional</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<c:set var="p" value="${p}"></c:set>
	<h1 class="display-4">Editar Profesional</h1>
	<br>
	
	<form:form action="${pageContext.request.contextPath}/guardarEditProfesional" method="post">
			<input type="hidden" name="id_profesional" value="${p.getId_profesional()}">
			<div class="row">
				<div class="col-3">Nombre:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="nombre"
						value="${p.getNombre()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Apellido:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="apellido"
						value="${p.getApellido()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Correo:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="correo"
						value="${p.getCorreo()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Telefono:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="telefono"
						value="${p.getTelefono()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Cargo:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="cargo"
						value="${p.getCargo()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-1"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/listarProfesional">Volver</a></div>
				<div class="col-1"><input class="btn btn-success" type="submit" value="Guardar"></div>
				
			</div>
		</form:form>
</div>

</body>
</html>