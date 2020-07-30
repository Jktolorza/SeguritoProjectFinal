<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Detalle de Facturas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-4">Detalle Factura</h1>
		<br>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					    <th>#</th>
					    <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Factura</th>
				</tr>
				</thead>
			<tbody>
			<c:forEach items="${model.lista}" var="detallefact">
				<tr>
					<th scope="row">${detallefact.getId_detallefactura()}</th>
					<td>${detallefact.getNombre()}</td>
					<td>${detallefact.getPrecio()}</td>
					<td>${detallefact.getCantidad()}</td>
					<td>${detallefact.getFactura().getId_factura()}</td>
					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/editarDetalleFactura/${detallefact.getId_detallefactura()}">Editar </a>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/eliminarDetalleFactura/${detallefact.getId_detallefactura()}">Borrar</a></td>
			</c:forEach>
			</tbody>
			
		</table>
		<p><a class="btn btn-primary" href="../crearDetalleFactura/${model.id_factura}">Crear Detalle Factura</a></p>
	</div>
</body>
</html>