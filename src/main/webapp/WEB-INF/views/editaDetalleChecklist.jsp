<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Segurito Project</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<c:set var="f" value="${model.dch}"></c:set>
	<h1>>Editar Detalle Checklist</h1>
	
	<form:form action="${pageContext.request.contextPath}/guardarEditDetalleChecklist" method="post">
			<input type="hidden" name="id_detallechecklist" value="${model.dch.getId_detallechecklist()}">
			<div class="row">
				<div class="col-3">Descripcion:</div>
				<div class="col-3">
					<input class="form-control" type="text" name="descripcion"
						value="${model.dch.getDescripcion()}" required />
				</div>
			</div>
			<div class="row">
				<div class="col-3">Estado:</div>
				<div class="col-3">
					<input class="form-control" type="text" name="estado"
						value="${model.dch.getEstado()}" required />
				</div>
			</div>

			<div class="row">
				<div class="col-3">Checklist:</div>
				<div class="col-3">
					<input class="form-control" type="number" name="checklist.id_checklist"
						value="${model.dch.getChecklist().getId_checklist()}" readonly />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3"><a href="${pageContext.request.contextPath}/mostrarDetalleChecklist/${model.dch.getChecklist().getId_checklist()}">Volver al detalle Factura</a></div>
				<div class="col-3"><a href="${pageContext.request.contextPath}/listarChecklist">Volver a las facturas</a></div>
				<div class="col-3"><input class="form-control" type="submit" value="Guardar"></div>
				
			</div>
		</form:form>
</div>
</body>
</html>