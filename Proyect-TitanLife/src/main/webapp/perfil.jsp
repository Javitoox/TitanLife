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

<% String controller = "perfilcontroller"; %>
<div>${requestScope.validaciones}</div>		

       <form id = "formulario" action="<%= controller %>" method="GET">
            <input id="Username" name="Username"type="text" placeholder="Username" maxlength="40" value="${user.username}" required/><br/>    
            
            <input id="Email" name="Email" type="text" placeholder="E-mail" maxlength="40"  value="${user.email}" required/><br/> 
            <input id="Password" name="Password" type="text" placeholder="Password" maxlength="40" value="${user.password}" required/><br/>
            <input id="Age"  name="Age" type="text" placeholder="Age" maxlength="40"  value="${user.age}" required/><br/>      
          	<input id="Height"  name="Height" type="text" placeholder="Height" maxlength="40"  value="${user.height}" required/><br/>
            <input id="Weight"  name="Weight"  type="text" placeholder="Weight" maxlength="40"  value="${user.weight}"required/><br/>
            <input id="IMC" type="text" placeholder="IMC" maxlength="40"/><br/>
            <input id="Hip"  name="Hip" type="text" placeholder="Hip Measurement (cm)" maxlength="40"  value="${user.hip}"required/><br/>
            <input id="Waist"  name="Waist" type="text" placeholder="Waist Measurement (cm)" maxlength="40"  value="${user.waist}"required/><br/>
            <input type="text" placeholder="Objetivos separados por ','" maxlength="40"/><br/>            
           <input type="submit" value="Confirmar cambios" /><br />
       </form>

</body>
</html>