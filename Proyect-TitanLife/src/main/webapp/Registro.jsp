<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Registro</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link rel="stylesheet" href="css/registro.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@900&display=swap" rel="stylesheet">
</head>
<body>
	<h1>TITAN LIFE</h1>
	
	<% String controller = "validatorcontroller"; %>
	<div>${requestScope.validaciones}</div>
	
	
	<div id="cuadro">
        <form id = "formulario" name="formulario" action="<%= controller %>" method="GET">
            <input id="Username" name="Username"type="text" placeholder="Username" maxlength="40" required/><br/>    
            <input id="Email" name="Email" type="email" placeholder="E-mail" maxlength="40" required/><br/> 
            <input id="Password" name="Password" type="password" placeholder="Password" maxlength="40" required/><br/>
            <input id="Retype" name="Retype" type="password" placeholder="Retype" maxlength="40" required/><br/>
            <input id="Age"  name="Age" type="text" placeholder="Age" maxlength="40" required/><br/>      
          	<input id="Height"  name="Height" type="text" placeholder="Height" maxlength="40"required/><br/>
            <input id="Weight"  name="Weight"  type="text" placeholder="Weight" maxlength="40"required/><br/>
            <input id="Hip"  name="Hip" type="text" placeholder="Hip Measurement (cm)" maxlength="40"required/><br/>
            <input id="Waist"  name="Waist" type="text" placeholder="Waist Measurement (cm)" maxlength="40"required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
            </form>
    </div> 
</body>
</html>