<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Actividades de mejora</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<h1>Lista de Actividades</h1>
		<br>
		<p><a class="btn btn-success" href="crearActividadMejora">Crear Actividad de mejora</a></p>

		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Fecha Inicio</th>
					<th>Fecha Termino</th>
					<th>Estado</th>
					<th>Detalle</th>
					<th>Cliente</th>
					<th>Profesional</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="act">
					<tr>
						<th scope="row"><a
								href="${pageContext.request.contextPath}/mostrarActividadMejora/${act.getIdactividadmejora()}">${act.getIdactividadmejora()}</a>
						</th>
						<td>${act.getNombre()}</td>
						<td>${act.getFechaInicio()}</td>
						<td>${act.getFechaTermino()}</td>
						<td>${act.getEstado()}</td>
						<td>${act.getDetalle()}</td>
						<td>${act.getCliente().getNombreEmpresa()}</td>
						<td>${act.getProfesional().getNombre()} ${act.getProfesional().getApellido()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarActividadMejora/${act.getIdactividadmejora()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarActividadMejora/${act.getIdactividadmejora()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>