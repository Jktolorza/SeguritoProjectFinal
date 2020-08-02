<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Editar Administrador</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<c:set var="a" value="${model.a}"></c:set>
		<h1 class="display-4">Editar Administrador</h1>
		<br>
		<form:form action="${pageContext.request.contextPath}/guardarEditAdministrador" method="post">
			<input type="hidden" name="id_administrador" value="${a.getId_administrador()}">
			<div class="row">
				<div class="col-3">Nombre:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="nombre" value="${a.getNombre()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Nickname:</div>
				<div class="col-7">
					<input id="nickname1" class="form-control" type="text" name="usuario.nickname" readonly
						value="${a.getUsuario().getNickname()}" />
				</div>
			</div>
			<hr>
			<input class="form-control" type="hidden" name="usuario.id_usuario" value="${a.getUsuario().getId_usuario()}" />
			<div class="row">
				<div class="col-1"><a class="btn btn-secondary"
						href="${pageContext.request.contextPath}/listarAdministrador">Volver</a></div>
				<div class="col-1"><input class="btn btn-success" type="submit" value="Guardar"></div>

			</div>
		</form:form>
	</div>
</body>

</html>