<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Segurito Project</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col align-self-start"></div>
			<div class="col align-self-center">
				<c:set var="ase" value="${ase}"></c:set>
				<div class="row">
					<div class="col">
						<h1 class="display-4">${ase.getCliente().getNombreEmpresa()}</h1>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h2>${ase.getMotivo()}</h2>
					</div>
				</div>

				<hr>
				<div class="row">
					<div class="col-3">#</div>
					<div class="col">${ase.getId_asesoriaextra()}</div>
				</div>
				<div class="row">
					<div class="col-3">Fecha y hora:</div>
					<div class="col">${ase.getFechayhora()}</div>
				</div>
				<div class="row">
					<div class="col-3">Detalle:</div>
					<div class="col">${ase.getDetalle()}</div>
				</div>

				<hr>
				<div class="row">
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/listarAsesoriaExtra">Volver</a>
				</div>
			</div>
			<div class="col align-self-end"></div>
		</div>
	</div>

</body>

</html>