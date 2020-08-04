<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Cliente</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
<c:set var = "message" value = "f"/>
	<div class="container">
		<h1 class="display-4">Listado de Clientes</h1>
		<br>
		<p><a class="btn btn-success" href="crearCliente/${message}">Crear Cliente</a></p>

		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Rut</th>
					<th>Fecha Registro</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="cli">
					<tr>
						<th scope="row"><a
								href="${pageContext.request.contextPath}/mostrarCliente/${cli.getId_cliente()}">${cli.getId_cliente()}</a>
						</th>
						<td>${cli.getNombreEmpresa()}</td>
						<td>${cli.getRut()}</td>
						<td>${cli.getFechaRegistro()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarCliente/${cli.getId_cliente()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarCliente/${cli.getId_cliente()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>