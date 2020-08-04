<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Usuarios</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>

 <c:set var = "message" value = "f"/>

	<div class="container">
		<h1 class="display-4">Listado de usuarios</h1>
		<br>
		
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>#</th>
					<th>Nickname</th>
					<th>Rol</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="user">
					<tr>
						<td>${user.getId_usuario()}</td>
						<td>${user.getNickname()}</td>
						<td>${user.getRol()}</td>
						<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/editarUsuario/${user.getId_usuario()}/${user.getNickname()}/${message}">Cambiar Contraseña
							</a>
						</td>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>

</html>