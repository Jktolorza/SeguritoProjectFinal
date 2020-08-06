<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reporte Actividades Mejora Por Mes</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<h1 class="display-4">Actividades por mes  </h1>

		<h1 >Grafica de actividades registradas por empresa </h1>
		<br>		
		<div class="col-12">
			<canvas id="actividadmejorapormesc" height="200" width="200"></canvas>
		</div> 
		
      	<hr>

		<h1 class="display-4">Listado de actividades por mes  </h1>
		<br>
		 
        <table class="table">
            <thead class="thead_dark">
                <tr>
              		    <th>ID</th>
                        <th>Nombre</th>
                        <th>Actividades mejora</th>
                        
                </tr>
                  </thead>
            <tbody>
            <c:forEach items="${model.lista}" var="actxmes">
                <tr>
                    <td>${actxmes.getId()}</td>
                    <td>${actxmes.getNombre()}</td>
                    <td>${actxmes.getActividadmejora()}</td>
            
               
            </c:forEach>
            </tbody>
          
        </table>
      
    </div>


	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
    var empresas = ${model.empresas};
    var actividadmejora = ${model.actividadmejora};
    
    var ctx = document.getElementById("actividadmejorapormesc").getContext("2d"); 
    var graficoBarras = new Chart(ctx, {
    	 type: 'bar',
         data: {
             labels: ${model.empresas},
             datasets: [{
                 borderColor: 'rgba(10, 115, 160, 0.75)',
                 backgroundColor: 'rgba(100, 75, 160, 0.5)',
                 label: 'Actividades por mes',
                 data: ${model.actividadmejora},
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