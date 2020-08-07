<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accidentabilidad</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<h1 class="display-4">Accidentabilidad por mes  </h1>
			<h1 >Grafica de accidentabilidad mensual </h1>
		<br>		
		<div class="col-12">
			<canvas id="accidentabilidad" height="200" width="200"></canvas>
		</div> 
		
      	<hr>
      		
      	<h1 class="display-4">Listado de accidentabilidad por mes  </h1>
		<br>
  <table class="table">
            <thead class="thead_dark">
                <tr>
	<th>ID</th>
	<th>Profesional</th>
	<th>Accidentabilidad</th>
   </tr>
                  </thead>
            <tbody>
<c:forEach items="${listadoaccidentabilidad}" var="acc">
<tr>
	<td><c:out value="${acc.getId()}"/></td>
	<td><c:out value="${acc.getProfesional()}"/></td>
	<td><c:out value="${acc.getIndiceAccidentabilidad()}"/></td>
</tr>
</c:forEach>

</table>
</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
    
    var ctx = document.getElementById("accidentabilidad").getContext("2d"); 
    var graficoBarras = new Chart(ctx, {
    	 type: 'bar',
         data: {
             labels:${profesionales},
             datasets: [{
                 borderColor: [
                     'rgba(255,99,132,1)',
                     'rgba(54, 162, 235, 1)',
                     'rgba(255, 206, 86, 1)',
                     'rgba(75, 192, 192, 1)',
                     'rgba(153, 102, 255, 1)',
                     'rgba(255,99,132,1)',
                     'rgba(54, 162, 235, 1)',
                     'rgba(255, 206, 86, 1)',
                     'rgba(75, 192, 192, 1)',
                     'rgba(153, 102, 255, 1)'
                   ],
                 backgroundColor: [
                     'rgba(255, 99, 132, 0.2)',
                     'rgba(54, 162, 235, 0.2)',
                     'rgba(255, 206, 86, 0.2)',
                     'rgba(75, 192, 192, 0.2)',
                     'rgba(255, 99, 132, 0.2)',
                     'rgba(54, 162, 235, 0.2)',
                     'rgba(255, 206, 86, 0.2)',
                     'rgba(75, 192, 192, 0.2)',
                     'rgba(153, 102, 255, 0.2)'
                 ],
                 label: 'Accidentes/Capacitaciones',
                 data: ${accidentabilidad},
                 borderWidth: 1
             }]
         },
         options: {
             maintainAspectRatio: false,
             scales: {
                 yAxes: [{
                     ticks: {
                         beginAtZero: true
                     }
                 }]
             }
         }
     });
    
    </script>

</body>
</html>