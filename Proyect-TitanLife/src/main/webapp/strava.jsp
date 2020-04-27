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
<a class="boton_personalizado" href="REDIRIGE A AÑADIR EN STRAVA">Add</a>
<a class="boton_personalizado_enlace" href="REDIRIGE A AÑADIR EN STRAVA">Vincular Strava</a>
<!--  <div class="scrollSVS">
<iframe width="600" height="315" src="https://www.youtube.com/embed/BQ3aAX38kjI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="600" height="315" src="https://www.youtube.com/embed/0AmhFng8ufQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></iframe>
</div>
<div class="scrollSVCreadas">
<iframe width="600" height="315" src="https://www.youtube.com/embed/0AmhFng8ufQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></iframe>
</div>-->
<div id="cuadro">
        <form id = "formulario" name="formulario" action="/stravaActivityController" method="GET">
            <input id="Name" name="Name"type="text" placeholder="Username" maxlength="40" required/><br/>    
            <input id="Type" name="Type" type="text" placeholder="E-mail" maxlength="40" required/><br/> 
            <input id="Date" name="Date" type="text" placeholder="Retype password" maxlength="40" required/><br/>
            <input id="Elapsed"  name="Elapsed" type="text" placeholder="Age (Format example: 19)" maxlength="6" required/><br/>      
          	<input id="Description"  name="Description" type="text" placeholder="Height (Format example(cm): 170.00)" maxlength="6" required/><br/>
            <input id="Distance"  name="Distance"  type="text" placeholder="Weight (Format example(kg): 68.00)" maxlength="6" required/><br/>
            <input id="Trainer"  name="Trainer" type="text" placeholder="Hip (Format example(cm): 80.00)" maxlength="1" required/><br/>
            <input id="Commute"  name="Commute" type="text" placeholder="Waist (Format example(cm): 80.00)" maxlength="1" required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
        </form>
    </div> 
</body>
</html>