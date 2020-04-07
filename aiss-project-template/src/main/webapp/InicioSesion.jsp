<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Inicio Sesión</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0">
	<link rel="stylesheet" href="css/inicioSesion.css">
	<link rel="shortcut icon" href="images/logo.png">
	<link rel="apple-touch-icon" href="images/logo.png">
</head>
<body>

	<img id="logo" src="images/logo.png" alt="Logo TitanLife">
    <h1 id="loginAccount">Login to Your Account</h1><br>
    <form id="formulario" action="get">
        
            <input id="campos" type="text" name = "user" placeholder="Usuario" required/><br/>
          <!--  <input id="campos" type="password" name = "pass" placeholder="Contraseña" required/><br/>-->
            <input class="logIn" type="submit" value="Iniciar sesión" /><br/>
            <a id= "forgetPass" href="dondeSeaQueSeCambieLaContraseña">¿Has olvidado la contraseña?</a>
            <p id= "registro"><strong>¿No tienes una cuenta?</strong></p><p><a id="registrate" href="registro.jsp">Regístrate</a></p>
        
    </form>
    
</body>
</html>