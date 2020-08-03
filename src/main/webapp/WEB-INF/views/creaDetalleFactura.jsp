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
	<c:set var="df" value="${model.df}"></c:set>
	<h1>>Crear Detalle Factura</h1>
	
	<form:form action="${pageContext.request.contextPath}/guardarDetalleFactura" method="post">
			<div class="row">
				<div class="col-3">Nombre:</div>
				<div class="col-3">
					<input class="form-control" type="text" name="nombre" required/>
				</div>
			</div>
			<div class="row">
				<div class="col-3">Precio:</div>
				<div class="col-3">
					<input class="form-control" type="number" name="precio" required/>
				</div>
			</div>
			<div class="row">
			<div class="col-3">Cantidad:</div>
				<div class="col-3">
					<input class="form-control" type="number" name="cantidad" max=999999999 required/>
				</div>
			</div>
			<div class="row">
				<div class="col-3">Factura:</div>
				<div class="col-3">
					<input class="form-control" type="number" name="factura.id_factura" value="${model.id_factura}" max=999999999 readonly/>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-3"><a href="${pageContext.request.contextPath}/mostrarDetalleFactura/${model.id_factura}">Volver al Detalle Factura</a></div>
					<div class="col-3"><a href="${pageContext.request.contextPath}/listarFactura">Volver a Factura</a></div>
				<div class="col-3"><input class="form-control" type="submit" value="Guardar"></div>
			</div>
		</form:form>
	</div>
</body>
</html>