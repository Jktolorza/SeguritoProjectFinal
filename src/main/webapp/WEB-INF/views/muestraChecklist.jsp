<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Checklist</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-4">Listado de Checklist</h1>
		<br>
		<p><a class="btn btn-success" href="../crearChecklist">Crear Checklist</a></p>
		<p><a class="btn btn-danger" href="../listarVisita">Volver a Visitas</a></p>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					    <th>Detalle Checklist</th>
					    <th>Version</th>
					    <th>Profesional</th>
					    <th>Cliente</th>
					    <th>Numero de Visita</th>
					    <th>Id Visita</th>
                       
				</tr>
							</thead>
			<tbody>
			<c:forEach items="${model.lista}" var="check">
				<tr>
					<th scope="row"><a href="${pageContext.request.contextPath}/mostrarDetalleChecklist/${check.getId_checklist()}">${check.getId_checklist()}</a></th>
					<td>${check.getVersion()}</td>
					<td>${check.getVisita().getProfesional().getNombre()} ${ check.getVisita().getProfesional().getApellido()}</td>
					<td>${check.getVisita().getCliente().getNombreEmpresa()}</td>
					<td>${check.getVisita().getNumerovisita()}</td>
					<td>${check.getVisita().getId_visita()}</td>
					<td><a class="btn btn-primary"  href="${pageContext.request.contextPath}/editarChecklist/${check.getId_checklist()}">Editar </a>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/eliminarChecklist/${check.getId_checklist()}">Borrar</a></td>
			</c:forEach>
			</tbody>

		</table>
		
	</div>
</body>
</html>