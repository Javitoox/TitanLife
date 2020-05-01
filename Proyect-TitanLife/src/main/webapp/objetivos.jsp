
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<title>Mis objetivos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/objetivos.css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <%@include file="menu.jsp"%>

    <h1 id="text">Mis Objetivos</h1>
	<img id="logo" src="images/logo.png" alt="Descripción de la imagen">
	
	<div class="cuadro" id="cuadro4">
	Objetivos corporales
	</div>	
	<div class="cuadro" id="cuadro5">
	xx.xx%
	</div>
	<div class="cuadro" id="cuadro6">
	xx.xx KG.
	</div>	
	<div >
		<form action="" method="GET">
			<input class="obj" id="objPeso" type="text" >
			<input class="boton" id="done2" type="submit" value="DONE" />
		</form>
	</div>

	<div>
		<form action="/misObjetivosController" method="GET" >
			<input name="IMC" class="boton" type="submit" value="GENERAR IMC" />
		</form>
	</div>
	
	<div class="cuadro" id="cuadro1">
	IMC ACTUAL	
	
	<c:if test="${not empty sessionScope['bmi'] and not null}">
   		 ${sessionScope['bmi']}
	</c:if>
	<c:if test="${empty sessionScope['bmi'] or null}">
   		 XX.XX%
	</c:if>
	
	
	</div>
	<div class="cuadro" id="cuadro2">
	PESO ACTUAL
	
	<c:if test="${not empty sessionScope['peso'] and not null}">
   		  ${sessionScope['peso']}
	</c:if>
	<c:if test="${ empty sessionScope['peso'] or null}">
   		  XX.XX KG.
	</c:if>
	
	</div>	

	<div>
		<form action="" method="GET">
			<input class="obj" id="objDep" placeholder="Objetivos separados por ','" list="opcionesDeportivas" name="opDep"/>
				<datalist id="opcionesDeportivas">
				  	<option>Fuerza</option>
					<option>Fuerza explosiva</option>
					<option>Fuerza de resistencia</option>
				</datalist>
			<input class="boton" id="done1" type="submit" value="DONE" />
		</form>
	</div>
	
	<div class="cuadro" id="cuadro3">
	Objetivos deportivos
	</div>
	
</body>
</html>