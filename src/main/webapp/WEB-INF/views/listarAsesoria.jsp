<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Asesorias</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<h1 class="display-4">Listado de asesorias</h1>
		<br>
		<p><a class="btn btn-success" href="crearAsesoria">Crear Asesoria</a></p>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Fecha y hora</th>
					<th>Motivo</th>
					<th>Detalle</th>
					<th>Cliente</th>
					<th>Profesional</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="aseso">
					<tr>
						<th scope="row"><a
								href="${pageContext.request.contextPath}/mostrarAsesoria/${aseso.getId_asesoria()}">${aseso.getId_asesoria()}</a>
						</th>
						<td>${aseso.getFechayhora()}</td>
						<td>${aseso.getMotivo()}</td>
						<td>${aseso.getDetalle()}</td>
						<td>${aseso.getCliente().getNombreEmpresa()}</td>
						<td>${aseso.getProfesional().getNombre()} ${aseso.getProfesional().getApellido()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarAsesoria/${aseso.getId_asesoria()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarAsesoria/${aseso.getId_asesoria()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>