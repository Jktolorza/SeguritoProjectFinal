<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moroso</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<h1 class="display-4">Listado de accidentes por mes  </h1>
		<br>
		 
        <table class="table">
            <thead class="thead_dark">
                <tr>
              		    <th>ID</th>
                        <th>Nombre</th>
                        <th>Accidentes</th>
                        
                </tr>
                  </thead>
            <tbody>
            <c:forEach items="${lista}" var="accxmes">
                <tr>
                    <td>${accxmes.getId()}</td>
                    <td>${accxmes.getNombre()}</td>
                    <td>${accxmes.getAccidentes()}</td>
            
               
            </c:forEach>
            </tbody>
          
        </table>
      
    </div>
</body>
</html>