<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="aiss.model.strava.StravaActivityC"%>
    <%@ page import="aiss.model.titan.User"%>
    <%@ page import="java.util.List"%>
    <%@ page import="aiss.model.repository.TitanLifeRepository"%>
    <%@ page import="aiss.model.resource.StravaResource"%>
    
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
<%@ include file="includes/menu.jsp" %>
<img id="logoSVS" src="images/logo.png" alt="Descripción de la imagen">
<h1 class="InitialTextSV">Mi Strava</h1>
<h1 class="ScrollText">Mis Actividades</h1>	
<h1 class="ScrollTextCreadas">Editar Actividades</h1>
	
<button id="btn-abrir-popup" class="btn-abrir-popup">Add Activity</button>

    <%
    	User u=TitanLifeRepository.getInstance().findByUsername((String)session.getAttribute("username"));
        	String accessToken = (String) request.getSession().getAttribute("Strava-token");
        	StravaResource yr=new StravaResource(accessToken);

            List<StravaActivityC> ls=u.getActividades();
        	if(ls.isEmpty()==true){
    %>
		
		
		<% 
		
	}else{

		%>
	

<div class="scroll">
<table id="agenda">
			<tr>
				<th>Foto</th>
				<th>Nombre</th>
				<th>Tipo</th>
				<th>Hora Inicio</th>
				<th>Tiempo transcurrido</th>
				<th>Descripcion</th>
				<th>Distancia</th>	
				<th>Calorias</th>	
				
				
			</tr>
<%
		

			for(StravaActivityC sa: ls){
				%>
				<tr>
				<%if(sa.getTotalPhotoCount()==0){
					
					%>
						<td>--</td>					
					<%
				}else{
					%>
					<td><img src="<%= sa.getPhotos().getPrimary().getUrls().get100() %>"></td>
					
					<% 
					
				}
				%>
				
				<td><%= sa.getName().toString() %></td>
				<td><%= sa.getType().toString() %></td>
				<td><%=  sa.getStartDateLocal().toString() %></td>
				<td><%= sa.getElapsedTime().toString() %></td>
				<td><%= sa.getDescription().toString() %></td>
				<td><%= sa.getDistance().toString() %></td>
				<td><%= sa.getCalories().toString() %></td>
				
				</tr>
				<%
				}
		
			%>
		
			</table>
		
			
</div>

		<div class="max"><div class="max2">El tipo de actividad más realizada es:</div><div class="max3">${requestScope.res}</div></div>
		
		
		<div class="cont" id="cont">	
				<form id = "form2" name="form2" action="/stravaUpdateActivityController" method="GET">
				
									<select name="Name" required>
									<%int r =0;
				while(r<ls.size()){
					
					
					 %>
										<option value="<%= ls.get(r).getName().toString() %>" label="<%= ls.get(r).getName().toString() %>"/>
										<% 
										r++;}
										
										
										%>
										
										</select><br/>
								<input id="NewName" name="NewName" type="text" placeholder="Nuevo nombre" maxlength="40" required/><br/>
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
            				<input id="Elapsed"  name="Elapsed" type="text" placeholder="Tiempo transcurrido en seg" maxlength="6" required/><br/>      
          					<input id="Description"  name="Description" type="text" placeholder="Descripción" maxlength="100" required/><br/>
            				<input id="Distance"  name="Distance"  type="text" placeholder="Distancia recorrida" maxlength="6" required/><br/>
            				<input id="boton" class="btn-submit2" type="submit" value="EDITAR ACTIVIDAD" /><br/>
				</form>
			
</div>
		<% 
										}
										
										%>
		
	

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
								<option value="Run">Run</option>
								<option value="Hike">Hike</option>
								<option value="Walk">Walk</option>
								<option value="VirtualRun">Virtual Run</option>
								<option value="Wheelchair">Wheelchair</option>
							</select><br/>            		
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