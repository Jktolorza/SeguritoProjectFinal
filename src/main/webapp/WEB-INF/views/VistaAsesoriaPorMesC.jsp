<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reporte Asesorias Por Mes</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<h1 class="display-4">Asesorias por mes  </h1>

		<h1 >Grafica de asesorias registradas por empresa </h1>
		<br>		
		<div class="col-12">
			<canvas id="asesoriapormesc" height="200" width="200"></canvas>
		</div> 
		
      	<hr>

		<h1 class="display-4">Listado de asesorias por mes  </h1>
		<br>
		 
        <table class="table">
            <thead class="thead_dark">
                <tr>
              		    <th>ID</th>
                        <th>Nombre</th>
                        <th>Asesorias</th>
                        
                </tr>
                  </thead>
            <tbody>
            <c:forEach items="${model.lista}" var="asxmes">
                <tr>
                    <td>${asxmes.getId()}</td>
                    <td>${asxmes.getNombre()}</td>
                    <td>${asxmes.getAsesorias()}</td>
            
               
            </c:forEach>
            </tbody>
          
        </table>
      
    </div>


	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
    var nombre = ${model.nombre};
    var asesoria = ${model.asesoria};
    
    var ctx = document.getElementById("asesoriapormesc").getContext("2d"); 
    var graficoBarras = new Chart(ctx, {
    	 type: 'bar',
         data: {
             labels: ${model.nombre},
             datasets: [{
                 borderColor: 'rgba(10, 115, 160, 0.75)',
                 backgroundColor: 'rgba(100, 75, 160, 0.5)',
                 label: 'Asesorias por mes',
                 data: ${model.asesoria},
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