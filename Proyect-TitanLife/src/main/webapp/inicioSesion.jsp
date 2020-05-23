<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Inicio Sesión</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/inicioSesion.css" type="text/css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
</head>
<body>
	

	<div>${requestScope.validaciones}</div>
	
	
	
    <div class="col-5 col-tab-5"><div class="cuadro">
    <div class="loginAccount"><h4>Login to Your Account</h4></div>
    
        <form id="formulario" action="/inicioSesionController" method="GET">
            
            <input class="campo" type="text" name = "username" placeholder="Username" value="${requestScope.username}" required/><br/>
            <input class="campo" type="password" id="campo2"  name = "password" placeholder="Password" value="${requestScope.password}" required/><br/>
            <input id="logIn" type="submit"/><br/>
            <a id="registrate" href="/validatorController">Regístrate</a>
            
        </form>
        </div>
    </div>
    	<div class="col-5 col-tab-5"><img id="logo" src="images/logo.png" alt="Logo TitanLife"></div>
    
    
    
</body>
</html>