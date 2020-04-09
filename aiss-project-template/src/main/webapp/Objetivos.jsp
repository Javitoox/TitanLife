<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Perfil</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/objetivos.css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
 $( function() {
   $( "#datepicker" ).datepicker();
 } );
 </script>
</head>
<body>
	<img id="logo" src="images/logo.png" alt="Descripción de la imagen">
	
	<div class="form3">
		<form id = "formulario3" action="" method="GET">
			<input type="text" id="datepicker"></br>
			<input id="done2" type="submit" value="DONE" /><br/>
		</form>
	</div>
	
<%@include file="menu.jsp"%>

<h1 class="texto4">Mis Objetivos</h1>


	<div class="form">
		<form id = "formulario" action="" method="GET">
			<input id="boton" type="submit" value="GENERAR IMC" /><br/>
		</form>
	</div>
	
	<div class="form2">
		<form id = "formulario2" action="" method="GET">
			<input list="opcionesDeportivas" name="opDep" id="provincia"/>
				<datalist id="opcionesDeportivas">
				  	<option>Fuerza</option>
					<option>Fuerza explosiva</option>
					<option>Fuerza de resistencia</option>
				</datalist>
			<input id="done1" type="submit" value="DONE" /><br/>
		</form>
	</div>
			
	<div class="cuadro3">
	Objetivos corporales
	</div>
	<div class="cuadro4">
	Objetivos deportivos
	</div>	
		
	<div class="cuadro5">
	xx.xx%
	</div>
	<div class="cuadro6">
	xx.xx KG.
	</div>	
	
	<div class="cuadro1">
	IMC ACTUAL<br/>
	xx.xx%
	</div>
	<div class="cuadro2">
	PESO ACTUAL<br/>
	xx.xx KG.
	</div>	
	
</body>
</html>