<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi Strava</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/strava.css" type="text/css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="menu.jsp" %>
<img id="logoSVS" src="images/logo.png" alt="Descripción de la imagen">
<h1 class="InitialTextSV">Mi Strava</h1>
<h1 class="ScrollText">Mis Rutas</h1>	
<h1 class="ScrollTextCreadas">Mis Publicaciones</h1>
	<div>${requestScope.validaciones}</div>

<button id="btn-abrir-popup" class="btn-abrir-popup">Add Activity</button>

<div class="contenedor">	

<div class="overlay" id="overlay">
			<div class="popup" id="popup">
				<a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
				<h3>AÑADE</h3>
				<h4>una actividad en tu perfil.</h4>
				<form id = "formulario" name="formulario" action="/stravaPostActivityController" method="GET">
					<div class="contenedor-inputs">
            				<input id="Name" name="Name"type="text" placeholder="Nombre actividad" maxlength="40" required/><br/>    
							<select name="Type" required>
								<option value="Ride">Ride</option>
								<option value="Run">Run</option>
								<option value="Swim">Swim</option>
								<option value="Hike">Hike</option>
								<option value="Walk">Walk</option>
								<option value="AlpineSki">Alpine Ski</option>
								<option value="BackcountrySki">Backcountry Ski</option>
								<option value="Canoeing">Canoe</option>
								<option value="Crossfit">Crossfit</option>
								<option value="EBikeRide">E-Bike Ride</option>
								<option value="Elliptical">Elliptical</option>
								<option value="Handcycle">Handcycle</option>
								<option value="IceSkate">Ice Skate</option>
								<option value="InlineSkate">Inline Skate</option>
								<option value="Kayaking">Kayaking</option>
								<option value="Kitesurf">Kitesurf</option>
								<option value="NordicSki">Nordic Ski</option>
								<option value="RockClimbing">Rock Climb</option>
								<option value="RollerSki">Roller Ski</option>
								<option value="Rowing">Rowing</option>
								<option value="Snowboard">Snowboard</option>
								<option value="Snowshoe">Snowshoe</option>
								<option value="StairStepper">Stair-Stepper</option>
								<option value="StandUpPaddling">Stand Up Paddling</option>
								<option value="Surfing">Surfing</option>
								<option value="Velomobile">Velomobile</option>
								<option value="VirtualRide">Virtual Ride</option>
								<option value="VirtualRun">Virtual Run</option>
								<option value="WeightTraining">Weight Training</option>
								<option value="Wheelchair">Wheelchair</option>
								<option value="Windsurf">Windsurf</option>
								<option value="Workout">Workout</option>
								<option value="Yoga">Yoga</option>
							</select><br/>            		
							<input id="Date" name="Date" type="text" placeholder="Hora inicio (Format example: 13:32:11)" maxlength="8" required/><br/>
            				<input id="Elapsed"  name="Elapsed" type="text" placeholder="Tiempo transcurrido en seg" maxlength="6" required/><br/>      
          					<input id="Description"  name="Description" type="text" placeholder="Descripción" maxlength="100" required/><br/>
            				<input id="Distance"  name="Distance"  type="text" placeholder="Distancia recorrida" maxlength="6" required/><br/>
            				<input id="boton" class="btn-submit" type="submit" value="AÑADIR ACTIVIDAD" /><br/>
					</div>
				</form>
			</div>
		</div>
</div>
<script src="js/popup.js"></script>
</body>
</html>