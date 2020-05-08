<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
     <%@ include file="includes/menu.jsp"%>
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
        <c:forEach items="${requestScope.foods}" var="food">
                <li>${food}</li>
		</c:forEach>
    </ul>

    <h1 id="consumidas">[Aquí se mostrarán las <br> Kcal Consumidas]</h1>
    <h1 id="restantes">[Aquí se mostrarán las <br> Kcal Restantes]</h1>
    </div>

    <form id = "formulario" action="/fatSecretCaloriesController">
    <div>
        <input id="search" type="text" name="search" placeholder="Search" maxlength="40" required>   
        <input type="submit" value="Añadir a la lista">
    </div>
    </form>

</body>
</html>