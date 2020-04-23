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
	
	<div>${requestScope.validaciones}</div>
	
	<div id="cuadro">
        <form id = "formulario" name="formulario" action="/validatorController" method="GET">
            <input id="Username" name="username"type="text" placeholder="Username" maxlength="40" value="${requestScope.username}" required/><br/>    
            <input id="Email" name="email" type="email" placeholder="E-mail" maxlength="40" value="${requestScope.email}" required/><br/> 
            <input id="Password" name="password" type="password" placeholder="Password" maxlength="40" value="${requestScope.password}" required/><br/>
            <input id="Retype" name="retype" type="password" placeholder="Retype password" maxlength="40" value="${requestScope.retype}" required/><br/>
            <input id="Age"  name="age" type="text" placeholder="Age (Format example: 19)" maxlength="3" value="${requestScope.age}" required/><br/>      
          	<input id="Height"  name="height" type="text" placeholder="Height (Format example(cm): 170.00)" maxlength="6" value="${requestScope.height}" required/><br/>
            <input id="Weight"  name="weight"  type="text" placeholder="Weight (Format example(kg): 68.00)" maxlength="6" value="${requestScope.weight}" required/><br/>
            <input id="Hip"  name="hip" type="text" placeholder="Hip (Format example(cm): 80.00)" maxlength="6" value="${requestScope.hip}" required/><br/>
            <input id="Waist"  name="waist" type="text" placeholder="Waist (Format example(cm): 80.00)" maxlength="6" value="${requestScope.waist}"required/><br/>
            <input id="Sex"  name="sex" type="text" placeholder="Sex (m/f)" maxlength="1" value="${requestScope.sex}"required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
        </form>
    </div> 
</body>
</html>