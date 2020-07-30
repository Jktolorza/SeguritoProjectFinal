<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Mejoras</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col align-self-start"></div>
			<div class="col align-self-center">
				<c:set var="ac" value="${ac}"></c:set>
				<div class="row">
					<div class="col">
						<h1 class="display-4">${ac.getCliente().getNombreEmpresa()}</h1>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h2>${ac.getNombre()}</h2>
					</div>
				</div>

				<hr>
				<div class="row">
					<div class="col-3">#</div>
					<div class="col">${ac.getIdactividadmejora()}</div>
				</div>
				<div class="row">
					<div class="col-3">Fecha Inicio:</div>
					<div class="col">${ac.getFechaInicio()}</div>
				</div>
				<div class="row">
					<div class="col-3">Fecha Termino:</div>
					<div class="col">${ac.getFechaTermino()}</div>
				</div>
				<div class="row">
					<div class="col-3">Estado:</div>
					<div class="col">${ac.getEstado()}</div>
				</div>
				<div class="row">
					<div class="col-3">Detalle:</div>
					<div class="col">${ac.getDetalle()}</div>
				</div>

				<hr>
				<div class="row">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/listarActividadMejora">Volver</a>
				</div>
			</div>
			<div class="col align-self-end"></div>
		</div>

</body>

</html>