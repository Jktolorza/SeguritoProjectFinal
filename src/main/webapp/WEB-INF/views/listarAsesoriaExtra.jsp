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
		<h1 class="display-4">Listado de asesorias Extras</h1>
		<br>
		<p><a class="btn btn-success" href="crearAsesoriaExtra">Crear Asesoria</a></p>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Fecha y hora</th>
					<th>Motivo</th>
					<th>Detalle</th>
					<th>Cliente</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="asesoex">
					<tr>
						<th scope="row"><a
								href="${pageContext.request.contextPath}/mostrarAsesoriaExtra/${asesoex.getId_asesoriaextra()}">${asesoex.getId_asesoriaextra()}</a>
						</th>
						<td>${asesoex.getFechayhora()}</td>
						<td>${asesoex.getMotivo()}</td>
						<td>${asesoex.getDetalle()}</td>
						<td>${asesoex.getCliente().getNombreEmpresa()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarAsesoriaExtra/${asesoex.getId_asesoriaextra()}">Editar
							</a> <a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarAsesoriaExtra/${asesoex.getId_asesoriaextra()}">Borrar</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>