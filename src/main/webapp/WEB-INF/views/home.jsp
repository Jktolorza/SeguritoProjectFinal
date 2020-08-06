<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Configuraci�n de Caracteres -->
        <meta charset="ISO-8859-1"/>
        <title>Index</title>

        <!-- Llamado a boostrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>

        <!-- Hoja de estilo -->
        <link rel="stylesheet" href="<core:url value="/res/css/style.css" />">
        
        <!-- Hoja de estilo -->
        <link rel="stylesheet" href="<core:url value="/res/css/style2.css" />">
        
        <!-- Google fonts -->
        <link href="https://fonts.googleapis.com/css?family=Muli:400,700&display=swap" rel="stylesheet">

        <!-- Ionic icons --> 
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
     </head>
     
     <body>
     <c:set var = "message" value = "f"/>
		 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
              <a style="border: none;" class="navbar-brand" href="#">PSegurito</a>
              
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		<div class="collapse navbar-collapse" id="navbarNav">
                        <ul
                            class="navbar-nav">
                            <!-- Datos Administrador -->

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Datos Administrador
                                </a>

                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="crearProfesional/${message}" target="myFrame">Crear Profesional</a>
                                    <a class="dropdown-item" href="listarProfesional" target="myFrame">Listar Profesional</a>
                                    <a class="dropdown-item" href="listarCliente" target="myFrame">Listar Cliente</a>
                                    <a class="dropdown-item" href="listadoclientespost" target="myFrame">Listar Cliente API REST</a>
                                    <a class="dropdown-item" href="crearCliente/${message}" target="myFrame">Crear Cliente</a>
                                    <a class="dropdown-item" href="listarAdministrador" target="myFrame">Listar Administrador</a>
                                    <a class="dropdown-item" href="crearAdministrador/${message}" target="myFrame">Crear Administrador</a>
                                    <a class="dropdown-item" href="crearFactura" target="myFrame">Facturacion Clientes</a>
                                    <a class="dropdown-item" href="listarUsuario" target="myFrame">Gestion de usuarios</a>
                       
                                    <a class="dropdown-item" href="accidentespormes" target="myFrame">Listado de Accidentes por mes </a>                                        
                                </div>
                            </li>

                            <!-- Detalle Profesional -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Datos Profesional
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="crearActividadMejora" target="myFrame">Ingresar Actividad a mejorar</a>
                                    <a class="dropdown-item" href="crearAsesoria" target="myFrame">Agendar Asesoria</a>
                                    <a class="dropdown-item" href="crearCapacitacion" target="myFrame">Agendar Capacitacion</a>
                                    <a class="dropdown-item" href="listarReporteAccidente" target="myFrame">Revisar Accidentes</a>
                                    <a class="dropdown-item" href="listarFactura" target="myFrame">Revisar Facturacion de clientes</a>
                                    <a class="dropdown-item" href="listarAsesoriaExtra" target="myFrame">Revisar Asesorias Extras </a>
                                    <a class="dropdown-item" href="listarChecklist" target="myFrame">Revisar Checklist</a>
                                    <a class="dropdown-item" href="listarVisita" target="myFrame">Revisar Visitas</a>
                                </div>
                            </li>
                            <!-- Detalle Cliente -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Datos Cliente
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="listarActividadMejora" target="myFrame">Actividades a mejorar</a>
                                    <a class="dropdown-item" href="listarAsesoria" target="myFrame">Revisar Asesorias</a>
                                    <a class="dropdown-item" href="listarCapacitacion" target="myFrame">Revisar	Capacitaciones</a>
                                    <a class="dropdown-item" href="crearReporteAccidente" target="myFrame">Reportar Accidente</a>
                                    <a class="dropdown-item" href="listarFactura" target="myFrame">Facturacion</a>
                                    <a class="dropdown-item" href="crearAsesoriaExtra" target="myFrame">Agregar Asesoria Extra</a>
                                    <a class="dropdown-item" href="crearVisita" target="myFrame">Agendar Visita</a>
                                </div>
                            </li>
                        </ul>
                        <!--Boton cerrar sesion  -->

                        <div class="dropdown">
                            <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cerrar Sesion</button>
                            <div class="dropdown-menu text-center">


                                <a class="dropdown-item" href="#">Nombre</a>
                                <a class="dropdown-item" href="#">Cargo</a>
                                <div class="dropdown-divider"></div>
                                <a name="accion" value="Salir" class="dropdown-item" href="logout">
                                    Salir
                                </a>

                            </div>
                        </div>

                    </div>
                </nav>

                <div
                    class="d-flex" id="content-wrapper">


                    <!-- Sidebar -->
                    <div id="sidebar-container" class="bg-light border-right">

                        <div class="menu list-group-flush">
                            <a href="#" target="myFrame"  class="list-group-item list-group-item-action text-muted bg-light p-3 border-0">
                                <i class="icon ion-md-calendar lead mr-2"></i>
                                Accidentabilidad</a>   
                            <a href="listarmorosos" target="myFrame"  class="list-group-item list-group-item-action text-muted bg-light p-3 border-0">
                                <i class="icon ion-md-apps lead mr-2"></i>
                                Listado de Morosos</a>
                            <a href="accidentespormes" target="myFrame" class="list-group-item list-group-item-action text-muted bg-light p-3 border-0">
                                <i class="icon ion-md-people lead mr-2"></i>
                                Reporte Cliente</a>
                                <ul>
                                	<li><a href="accidentespormes" target="myFrame" class="text-muted">Reporte Accidente</a></li>
                                	<li><a href="#" target="myFrame" class="text-muted">Reporte de Mejoras </a></li>
                                	<li><a href="capacitacionespromesc" target="myFrame" class="text-muted">Reporte de Capacitaciones </a></li>
                                	<li><a href="#" target="myFrame" class="text-muted">Reporte de Asesoria</a></li>
                                </ul> 
                            <a href="#" target="myFrame" class="list-group-item list-group-item-action text-muted bg-light p-3 border-0">
                                <i class="icon ion-md-stats lead mr-2"></i>
                               Reporte Global</a>
                                <ul>
                                	<li><a href="accidentespormesp" target="myFrame" class="text-muted">Responsables de accidentes</a></li>
                                	<li><a href="#" target="myFrame" class="text-muted">Responsables de asesorias </a></li>
                                	<li><a href="capacitacionespromesp" target="myFrame" class="text-muted">Responsables de Capacitaciones</a></li>
                                	<li><a href="#" target="myFrame" class="text-muted">Responsables de Mejoras</a></li>
                                </ul> 
                        </div>
                    </div>
                    <!-- Fin sidebar -->

                    <!-- Page Content -->
                    <div id="page-content-wrapper" class="w-100 bg-light-blue">

                        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                            <div class="container">
                                <button class="btn btn-primary text-primary" id="menu-toggle">Mostrar
                                    					/ esconder menu</button>

                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>

                            </div>
                        </nav>

                        <div
                            id="content">
                            <!-- Iframe -->
                            <div class="m-4" style="height: 800px; width: 100%;">
                                <iframe name="myFrame" style="height: 100%; width: 100%; border: none;"></iframe>
                            </div>

                        </div>
                    </div>
                    <!-- Fin Page Content -->
                </div>
                <!-- Fin wrapper -->

                <!-- jquery -->

                    <script src="<c:url value='/res/js/jquery.js'/>"></script>


                    <script>
                        $("#menu-toggle").click(function (e) {
                            e.preventDefault();
                            $("#content-wrapper").toggleClass("toggled");
                        });
                    </script>


                    <!-- Jss boostrap -->
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                </body>

            </html>
