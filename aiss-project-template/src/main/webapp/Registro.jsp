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
<div id="cuadro">
        <form id = "formulario" action="" method="GET">
            <input id="Username" type="text" placeholder="Username" maxlength="40" required/><br/>    
            <input id="Email" type="email" placeholder="E-mail" maxlength="40" required/><br/> 
            <input id="Password" type="password" placeholder="Password" maxlength="40" required/><br/>
            <input id="Retype" type="password" placeholder="Retype" maxlength="40" required/><br/>
            <input id="Age" type="text" placeholder="Age" maxlength="40" required/><br/>      
          	<input id="Height" type="text" placeholder="Height" maxlength="40" required/><br/>
            <input id="Weight" type="text" placeholder="Weight" maxlength="40" required/><br/>
            <input id="Hip" type="text" placeholder="Hip Measurement (cm)" maxlength="40" required/><br/>
            <input id="Waist" type="text" placeholder="Waist Measurement (cm)" maxlength="40" required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
			</form>
    </div> 
</body>
</html>