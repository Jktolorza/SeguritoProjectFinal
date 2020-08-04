<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Detalle de Checklist</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-4">Detalle Checklist</h1>
		<br>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					    <th>#</th>
					    <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Checklist</th>
				</tr>
				</thead>
			<tbody>
			<c:forEach items="${model.lista}" var="detallecheck">
				<tr>
					<th scope="row">${detallecheck.getId_detallechecklist()}</th>
					<td>${detallecheck.getDescripcion()}</td>
					<td>${detallecheck.getEstado()}</td>
					<td>${detallecheck.getChecklist().getId_checklist()}</td>
					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/editarDetalleChecklist/${detallecheck.getId_detallechecklist()}">Editar </a>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/eliminarDetalleChecklist/${detallecheck.getId_detallechecklist()}/${model.id_checklist}">Borrar</a></td>
			</c:forEach>
			</tbody>
			
		</table>
		<p><a class="btn btn-primary" href="../crearDetalleChecklist/${model.id_checklist}">Crear Detalle Checklist</a></p>
		<p><a class="btn btn-danger" href="../listarChecklist">Volver al Checklist</a></p>
	</div>
</body>
</html>