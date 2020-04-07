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

<img id="logo" src="images/logo.png" alt="Descripción de la imagen">

<h1 id="texto4">Mi Perfil</h1>
<div class="form">
        <form id = "formulario" action="" method="GET">
            <input class="input100" type="text" placeholder="Nombre" maxlength="40" required/><br/>
            <input class="input101" type="text" placeholder="Apellidos" maxlength="40" required/><br/>
            <input class="input102" type="text" placeholder="Email" maxlength="40" required/><br/>
            <input class="input103" type="text" placeholder="**" maxlength="40" required/><br/>
            <input class="input104" type="text" placeholder="Altura" maxlength="40" required/><br/>
            <input class="input105" type="text" placeholder="Peso" maxlength="40" required/><br/>
            <input class="input106" type="text" placeholder="IMC" maxlength="40" required/><br/>
            <input class="input107" type="text" placeholder="Cadera" maxlength="40" required/><br/>
            <input class="input108" type="text" placeholder="Cintura" maxlength="40" required/><br/>
            <input class="input109" type="text" placeholder="Objetivos" maxlength="40"/><br/>
            <input class="input110" type="submit" value="Confirmar cambios" /><br />


        </form>
    </div>
</body>
</html>