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

	<img id="logo" src="images/logo.png" alt="Logo TitanLife">
    <div id="cuadro"></div>
    <p id="loginAccount">Login to Your Account</p>
    
        <form id="formulario" action="get">
            
            <input class="campo" type="text" name = "user" placeholder="Usuario" required/><br/>
            <input class="campo" id="campo2" type="password" name = "pass" placeholder="Contraseña" required/><br/>
            <input id="logIn" type="submit"/><br/>
            <input id = "checkbox" type="checkbox">
            <p id="recuerda"><strong>Recordar contraseña</strong> </p>
            <a id= "forgetPass" href="dondeSeaQueSeCambieLaContraseña">¿Has olvidado la contraseña?</a>
            <a id="registrate" href="Registro.jsp">Regístrate</a>
            
        </form>
    
</body>
</html>