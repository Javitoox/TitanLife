<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Iniciar Sesion</title>
    <link rel="stylesheet" href="css/inicioSesion.css">
</head>
<body>

	<img id="logo" src="images/logo.png" alt="Logo TitanLife">
    <h1 id="loginAccount">Login to Your Account</h1><br>
    <form id="formulario" action="get">
        
            <input id="campos" type="text" name = "user" placeholder="Usuario" required/><br/>
            <input id="campos" type="password" name = "pass" placeholder="Contraseña" required/><br/>
            <input class="logIn" type="submit" value="Iniciar sesión" /><br/>
            <a id= "forgetPass" href="dondeSeaQueSeCambieLaContraseña">¿Has olvidado la contraseña?</a>
            <p id= "registro"><strong>¿No tienes una cuenta?</strong></p><p><a id="registrate" href="registro.jsp">Regístrate</a></p>
        
    </form>
    
</body>
</html>