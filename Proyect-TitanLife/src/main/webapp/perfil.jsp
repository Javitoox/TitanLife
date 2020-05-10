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
<%@ include file="includes/menu.jsp" %>

<img id="love" src="https://i.pinimg.com/originals/58/b8/01/58b801823c2ee845a6fa3e749dbe3d83.png" alt="Descripción de la imagen">

<img id="logo" src="images/logo.png" alt="Descripción de la imagen">

<h2 class="texto4" id="text">Datos de usuario</h2>

<h1 class="texto4">Mi Perfil</h1>

<div>${requestScope.validaciones}</div>		

<div id="cuadro">

       <form id = "formulario" action="/perfilController" method="GET">
       		<label>Username:</label>
            <input id="Username" name="Username"type="text" placeholder="Username" maxlength="40" value="${user.username}" required/><br/>
            <label>Email:</label>
                
            <input id="Email" name="Email" type="text" placeholder="E-mail" maxlength="40"  value="${user.email}" required/><br/> 
                   <label>Password:</label>
            
            <input id="Password" name="Password" type="text" placeholder="Password" maxlength="40" value="${user.password}" required/><br/>
                   <label>Age:</label>
            
            <input id="Age"  name="Age" type="text" placeholder="Age" maxlength="40"  value="${user.datosBMI.age}" required/><br/>
                   <label>Height:</label>
                  
          	<input id="Height"  name="Height" type="text" placeholder="Height" maxlength="40"  value="${user.datosBMI.height.value}" required/><br/>
          	       <label>Weight:</label>
          	
            <input id="Weight"  name="Weight"  type="text" placeholder="Weight" maxlength="40"  value="${user.datosBMI.weight.value}"required/><br/>
                   <label>Hip:</label>
            
            <input id="Hip"  name="Hip" type="text" placeholder="Hip Measurement (cm)" maxlength="40"  value="${user.datosBMI.hip}"required/><br/>
                   <label>Waist:</label>
            
            <input id="Waist"  name="Waist" type="text" placeholder="Waist Measurement (cm)" maxlength="40"  value="${user.datosBMI.waist}"required/><br/>
                   <label>Sex:</label>
            
            <input id="Sex"  name="Sex" type="text" placeholder="Sex (m/f)" maxlength="1" value="${user.datosBMI.sex}"required/><br/>
                              
             <label>Objetivos:</label>
            
                        <input id="opDep"  name="opDep" type="text" placeholder="" maxlength="1000" value="${user.objetivos}" required/><br/>
           <input type="submit" value="Confirmar cambios" /><br />
       </form>
       </div>

</body>
</html>