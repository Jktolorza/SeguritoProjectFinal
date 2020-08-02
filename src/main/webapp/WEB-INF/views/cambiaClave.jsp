<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Cambiar Contraseña</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<c:set var="u" value="${model.u}"></c:set>
		<h1 class="display-4">Cambiar Contraseña</h1>
		<br>
		
		<c:if test="${model.message != 'f'}">
			<c:out value = "${model.message}"/>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/guardarEditUsuario" method="post">
			<input type="hidden" name="id_usuario" value="${u.getId_usuario()}">
			<div class="row">
				<div class="col-3">Nickname:</div>
				<div class="col-7">
					<input class="form-control" type="text" name="nickname" value="${u.getNickname()}" readonly />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Rol:</div>
				<div class="col-7">
					<select name="rol" class="form-control">
						<option value="ROLE_ADMINISTRADOR" ${u.getRol()=='administrador' ? 'selected' : '' }>Administrador
						</option>
						<option value="ROLE_CLIENTE" ${u.getRol()=='cliente' ? 'selected' : '' }>Cliente</option>
						<option value="ROLE_PROFESIONAL" ${u.getRol()=='profesional' ? 'selected' : '' }>Profesional</option>
					</select>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Contraseña anterior:</div>
				<div class="col-7">
					<input class="form-control" type="password" name="oldPassword" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Nueva Contraseña:</div>
				<div class="col-7">
					<input id="pass" class="form-control" type="password" name="password" />
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Repita Nueva Contraseña:</div>
				<div class="col-7">
					<input id="pass2" class="form-control" type="password" name="newPassword"/>
					 <label id="mensaje_error" class="control-label col-md-12 text-success" style="display: block;">Las constraseñas si coinciden</label>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-1"><a class="btn btn-secondary"
						href="${pageContext.request.contextPath}/listarUsuario">Volver</a></div>
				<div class="col-1"><input id="boton" class="btn btn-success" type="submit" value="Guardar"></div>

			</div>
		</form:form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function () {
    $('#mensaje_error').hide();  
});

var cambioDePass = function() {
		var cont = $('#pass').val();
    var cont2 = $('#pass2').val();
    if (cont == cont2) {
        $('#mensaje_error').hide();
        $('#mensaje_error').attr("class", "control-label col-md-12 text-success");
        $('#mensaje_error').show();
        $('#mensaje_error').html("Las constraseñas si coinciden");
        $('#boton').prop('disabled', false);
    } else {
         $('#mensaje_error').html("Las constraseñas no coinciden");
         $('#mensaje_error').attr("class", "control-label col-md-12 text-danger");
        $('#mensaje_error').show();
        $('#boton').prop('disabled', true);
    }
}

$("#pass").on('keyup', cambioDePass);
$("#pass2").on('keyup', cambioDePass);
</script>
</html>