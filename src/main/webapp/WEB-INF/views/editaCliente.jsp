<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Cliente </title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.css">	
</head>
<body>
<div class="container">
	<c:set var="c" value="${model.c}"></c:set>
	<c:set var="u" value="${model.u}"></c:set>
	<h1 class="display-4">Editar Cliente</h1>
	<br>
	<form:form action="${pageContext.request.contextPath}/guardarEditCliente" method="post">
			<input type="hidden" name="id_cliente" value="${c.getId_cliente()}">
			<div class="row">
				<div class="col-3">Nombre:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="nombreEmpresa"
						value="${c.getNombreEmpresa()}" />
				</div>
			</div>
					<hr>
			<div class="row">
				<div class="col-3">Rut:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="rut"
						value="${c.getRut()}" />
				</div>
			</div>
					<hr>
			<div class="row">
				<div class="col-3">Fecha Registro:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="fechaRegistro" id="datetimepicker"
						value="${c.getFechaRegistro()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Nickname:</div>
				<div class="col-7">
					<input id="nickname1" class="form-control" type="text" name="nickname" readonly
						value="${c.getUsuario().getNickname()}" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Password:</div>
				<div class="col-7">
					<input class="form-control" type="password" name="password"
						value="${u.getPassword()}" />
				</div>
			</div>
			<hr>
			<input class="form-control" type="hidden" name="id_usuario" value="${u.getId_usuario()}" />
						<div class="row">
				<div class="col-3">Rol:</div>
				<div class="col-7">
					<select name="rol" class="form-control">
  						 <option value="administrador" ${u.getRol()=='administrador' ? 'selected' : '' }>Administrador</option> 
 						 <option value="cliente" ${u.getRol()=='cliente' ? 'selected' : '' }>Cliente</option>
 						 <option value="profesional" ${u.getRol()=='profesional' ? 'selected' : '' }>Profesional</option>
					</select>

				</div>
			</div>
			<hr>		
			<div class="row">
				<div class="col-1"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/listarCliente">Volver</a></div>
				<div class="col-1"><input class="btn btn-success" type="submit" value="Guardar"></div>
				
			</div>
		</form:form>
</div>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="https://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.js"></script>
				<script>
			$(function () {
				$('#datetimepicker').datepicker({
					dateFormat: 'yy-mm-dd',
				});
			});			
		</script>
</body>
</html>