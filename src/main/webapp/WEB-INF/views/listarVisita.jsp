<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Visitas</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<h1 class="display-4">Listado de Visitas</h1>
		<br>
		<p><a class="btn btn-success" href="crearVisita">Crear Visita</a></p>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Fecha visita</th>
					<th>Cliente</th>
					<th>Profesional</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="vis">
					<tr>
						<th scope="row"><a
								href="${pageContext.request.contextPath}/mostrarVisita/${vis.getId_visita()}">${vis.getId_visita()}</a>
						</th>
						<td>${vis.getFechavisita()}</td>
						<td>${vis.getCliente().getNombreEmpresa()}</td>
						<td>${vis.getProfesional().getNombre()} ${vis.getProfesional().getApellido()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarVisita/${vis.getId_visita()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarVisita/${vis.getId_visita()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>