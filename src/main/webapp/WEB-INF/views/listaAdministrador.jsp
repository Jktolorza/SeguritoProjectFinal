<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Administrador</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
<c:set var = "message" value = "f"/>
	<div class="container">
		<h1 class="display-4">Listado de administrador</h1>
		<br>
		<p><a href="crearAdministrador/${message}" class="btn btn-success">Crear administrador</a></p>

		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="adm">
					<tr>
						<td>${adm.getId_administrador()}</td>
						<td>${adm.getNombre()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarAdministrador/${adm.getId_administrador()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarAdministrador/${adm.getId_administrador()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>