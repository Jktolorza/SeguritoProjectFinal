<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Detalle de post</h1>

ID: <c:out value="${ps.getId_cliente()}"></c:out><br/>
Nombre Empresa: <c:out value="${ps.getNombreEmpresa()}"></c:out><br/>
Rut: <c:out value="${ps.getRut()}"></c:out><br/>
Fecha Registro: <c:out value="${ps.getFechaRegistro()}"></c:out><br/>

</body>
</html>