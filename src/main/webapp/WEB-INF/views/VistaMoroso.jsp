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
		<h1 class="display-4">Listado De Morosos </h1>
		<br>
		 
        <table class="table">
            <thead class="thead_dark">
                <tr>
              		    <th>ID</th>
                        <th>Nombre</th>
                        <th>Fecha</th>
                        
                </tr>
                  </thead>
            <tbody>
            <c:forEach items="${lista}" var="moroso">
                <tr>
                    <td>${moroso.getId()}</td>
                    <td>${moroso.getNombre()}</td>
                    <td>${moroso.getFechaVencimiento()}</td>
            
               
            </c:forEach>
            </tbody>
          
        </table>
      
    </div>
</body>
</html>