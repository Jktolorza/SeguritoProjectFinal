<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listado de posts</h1>
<table>
<tr>
	<th>ID</th>
	<th>Nombre Empresa</th>
	<th>Rut</th>
	<th>Fecha Registro</th>
	<th>Acciones</th>
</tr>
<c:forEach items="${listadoposts}" var="ps">
<tr>
	<td><c:out value="${ps.getId_cliente()}"/></td>
	<td><c:out value="${ps.getNombreEmpresa()}"/></td>
	<td><c:out value="${ps.getRut()}"/></td>
	<td><c:out value="${ps.getFechaRegistro()}"/></td>
	<td><a href="detalleclientepost/${ps.getId_cliente()}">Ver detalle</a></td>
</tr>
</c:forEach>

</table>


</body>
</html>