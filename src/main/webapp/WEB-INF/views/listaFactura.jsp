<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Facturas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-4">Listado de Facturas</h1>
		<br>
		<p><a class="btn btn-success" href="crearFactura">Crear Factura</a></p>
		<table class="table">
			<thead class="thead_dark">
				<tr>
					    <th>#</th>
					    <th>Fecha de Cobro</th>
                        <th>Fecha de Vencimiento</th>
                        <th>Extras</th>
                        <th>Impuestos</th>
                        <th>Subtotal</th>
                        <th>Total</th>
                        <th>Cliente</th>
				</tr>
							</thead>
			<tbody>
			<c:forEach items="${lista}" var="fact">
				<tr>
					<th scope="row"><a href="${pageContext.request.contextPath}/mostrarDetalleFactura/${fact.getId_factura()}">${fact.getId_factura()}</a></th>
					<td>${fact.getFechadecobro()}</td>
					<td>${fact.getFechaVencimiento()}</td>
					<td>${fact.getExtras()}</td>
					<td>${fact.getImpuestos()}</td>
					<td>${fact.getSubtotal()}</td>
					<td>${fact.getTotal()}</td>
					<td>${fact.getCliente().getNombreEmpresa()}</td>
					<td><a class="btn btn-primary"  href="${pageContext.request.contextPath}/editarFactura/${fact.getId_factura()}">Editar </a>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/eliminarFactura/${fact.getId_factura()}">Borrar</a></td>
			</c:forEach>
			</tbody>

		</table>
		
	</div>
</body>
</html>