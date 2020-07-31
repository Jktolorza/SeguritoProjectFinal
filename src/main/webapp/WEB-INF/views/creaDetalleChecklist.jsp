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
	<c:set var="dch" value="${model.dch}"></c:set>
	<h1>>Crear Detalle Checklist</h1>
	
	<form:form action="${pageContext.request.contextPath}/guardarDetalleChecklist" method="post">
			<div class="row">
				<div class="col-3">Descripcion:</div>
				<div class="col-3">
					<input class="form-control" type="text" name="descripcion"/>
				</div>
			</div>
			<div class="row">
				<div class="col-3">Estado:</div>
				<div class="col-3">
					<input class="form-control" type="text" name="estado"/>
				</div>
			</div>
			<div class="row">
				<div class="col-3">Checklist:</div>
				<div class="col-3">
					<input class="form-control" type="number" name="checklist.id_checklist" value="${model.id_checklist}" max=999999999 readonly/>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-3"><a href="${pageContext.request.contextPath}/mostrarDetalleChecklist/${model.id_checklist}">Volver al Detalle Factura</a></div>
					<div class="col-3"><a href="${pageContext.request.contextPath}/listarChecklist">Volver a Checklist</a></div>
				<div class="col-3"><input class="form-control" type="submit" value="Guardar"></div>
			</div>
		</form:form>
	</div>
</body>
</html>