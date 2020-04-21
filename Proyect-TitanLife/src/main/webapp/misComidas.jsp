<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Mis Comidas</title>
    <link rel="stylesheet" href="css/misComidas.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="images/logo.png">
	<link rel="apple-touch-icon" href="images/logo.png">
</head>
<body>
     <%@ include file="menu.jsp" %>
     <h1 id="texto">Mis Comidas</h1>
    <img id="logo" src="images/logo.png" alt="Logo">
    <div id="calendario">
    <div class="month">
        <ul>
            <li class="prev">&#10094;</li>
            <li class="next">&#10095;</li>
            <li> Abril<br><br> Hoy </li>
        </ul>
    </div>

    <ul class="weekdays">
        <li>Mo</li>
        <li>Tu</li>
        <li>We</li>
        <li>Th</li>
        <li>Fr</li>
        <li>Sa</li>
        <li>Su</li>
    </ul>

    <ul class="mealsKcal">  
        <li>Melón 500gr - 110kcal</li>
        <li>Pollo 330gr - 410kcal</li>
        <li>Plátano -90kcal</li>
        <li>Monster 500ml - 15kcal</li>
    </ul>

    <h1 id="consumidas">625 Kcal <br>Consumidas</h1>
    <h1 id="restantes">+ 1300 Kcal Restantes</h1>
    </div>
    <div class="box">
        <div class="container-1">
            <span class="icon"><i class="fa fa-search"></i></span>
            <input type="search" id="search" placeholder="Search..." />
        </div>
    </div>
    
    <h1 id="titulo">Recomendaciones de comidas <br> según sus Objetivos:</h1>

    <form id = "formulario" action="MisComidas.jsp">

        <select id = "comidas" multiple>
            <option value="1">Avena 200gr - 610kcal</option>
            <option value="2">Pisto 330 - 510kcal</option>
            <option value="3">Zumo naranja 250ml - 40kcal</option>
            <option value="4">Pasta variada 400 - 800kcal</option>
            <option value="5">Plátano - 90Kcal</option>
            <option value="6">Sandía 500gr - 110Kcal</option>
            <option value="7">Rabano 200gr - 130Kcal</option>
            <option value="8">Pepino 100gr - 70Kcal</option>
            <option value="9">Mango 120gr - 70Kcal</option>
            <option value="10">Plátano 110gr - 80Kcal</option>
        </select>
        
        <input type="submit" value="Añadir a la lista">
    </form>

</body>
</html>