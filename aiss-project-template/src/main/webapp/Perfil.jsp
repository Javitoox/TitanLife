<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Perfil</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link rel="stylesheet" href="css/perfil.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="menu.jsp" %>

<img id="love" src="https://i.pinimg.com/originals/58/b8/01/58b801823c2ee845a6fa3e749dbe3d83.png" alt="Descripción de la imagen">

<img id="logo" src="images/logo.png" alt="Descripción de la imagen">

<h2 class="texto4" id="text">Datos de usuario</h2>

<h1 class="texto4">Mi Perfil</h1>	

       <form id = "formulario" action="" method="GET">
           <input type="text" placeholder="Nombre" maxlength="40" required/><br/>
           <input type="text" placeholder="Apellidos" maxlength="40" required/><br/>
           <input type="text" placeholder="Email" maxlength="40" required/><br/>
           <input type="text" placeholder="**" maxlength="40" required/><br/>
           <input type="text" placeholder="Altura" maxlength="40" required/><br/>
           <input type="text" placeholder="Peso" maxlength="40" required/><br/>
           <input type="text" placeholder="IMC" maxlength="40" required/><br/>
           <input type="text" placeholder="Cadera" maxlength="40" required/><br/>
           <input type="text" placeholder="Cintura" maxlength="40" required/><br/>
           <input type="text" placeholder="Objetivos separados por ','" maxlength="40"/><br/>
           <input type="submit" value="Confirmar cambios" /><br />
       </form>

</body>
</html>