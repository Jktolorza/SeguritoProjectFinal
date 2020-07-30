<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Capacitaciones</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<h1 class="display-4">Listado de capacitacion</h1>
		<br>
		        <p><a class="btn btn-success" href="crearCapacitacion">Crear Capacitacion</a></p>
        <table class="table">
            <thead class="thead_dark">
                <tr>
                        <th>#</th>
                        <th>Fecha y hora</th>
                        <th>Tema</th>
                        <th>Contenido</th>
                        <th>Cliente</th>
                        <th>Profesional</th>
                </tr>
                            </thead>
            <tbody>
            <c:forEach items="${lista}" var="capac">
                <tr>
                    <th scope="row"><a href="${pageContext.request.contextPath}/mostrarCapacitacion/${capac.getId_capacitacion()}">${capac.getId_capacitacion()}</a></th>
                    <td>${capac.getFechayhora()}</td>
                    <td>${capac.getTema()}</td>
                    <td>${capac.getContenido()}</td>
                    <td>${capac.getCliente().getNombreEmpresa()}</td>
                    <td>${capac.getProfesional().getNombre()} ${capac.getProfesional().getApellido()}</td>
                    <td><a class="btn btn-primary"  href="${pageContext.request.contextPath}/editarCapacitacion/${capac.getId_capacitacion()}">Editar </a>  <a class="btn btn-danger"  href="${pageContext.request.contextPath}/eliminarCapacitacion/${capac.getId_capacitacion()}">Borrar</a></td>
            </c:forEach>
            </tbody>

        </table>

    </div>
</body>
</html>