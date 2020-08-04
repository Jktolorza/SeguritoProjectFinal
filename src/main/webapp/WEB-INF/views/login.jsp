<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loggin</title>
<!-- Llamado a boostrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	
	<!-- Hoja de estilo -->
    <link rel="stylesheet" href="<core:url value="/res/css/stylelog.css" />">

</head>
<body>


    <div class="login-box">
    <img  class="avatar" src="<core:url value="/res/css/avatar.png" />">
        <h1>PSegurito</h1>     
         <div class="alert alert-primary" role="alert">	
				<%
					String error = (String) request.getAttribute("error");
						if (error != null && error.equals("true")) {							
						out.println("Credenciales no validas, Intente nuevamente!!");
				}
				%>
			</div>
        
        
        
           <form name="loginForm" action="<c:url value="login" />" method="POST">
            <p>Nickname</p>
            <input type="text" name="username" placeholder="Ingrese Nickname">
            
            <p>Contraseña</p>
            <input type="password" name="password" placeholder="Ingrese Password">
    
            <input type="submit" value="Entrar" class="btn float-right login_btn">

			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	

            
            </form>   
            
<!-- Modal -->

<!-- Modal -->

        </div>
        <script type="text/javascript">

        </script>
        





	<!-- Jss boostrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		
		
	<marquee style="color: white;" class="info" behaviour=alternate scrolldelay=100%>Ayuda de password, si desea entrar como: usuario admininistror-administrador, Cliente-cliente,Profesional,profesional</marquee>	
</body>
</html>