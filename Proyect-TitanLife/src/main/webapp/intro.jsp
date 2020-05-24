<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Inicio</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0">
	<link rel="stylesheet" href="css/inicio.css">
	<link rel="shortcut icon" href="images/logo.png">
	<link rel="apple-touch-icon" href="images/logo.png">
</head>
<body>
<div class="col-6 col-tab-6">
<c:choose>
   <c:when test="${param['sesion']=='1'}"><%@ include file="includes/menu.jsp" %></c:when> 
   <c:otherwise><%@ include file="includes/menu2.jsp" %></c:otherwise>
</c:choose>
</div>
<div class="col-1 col-tab-1">
<div id="enlace1">
<a href="https://www.fatsecret.es/"> 
<img src="images/apps.png" width=40 height=40 alt="Logo">
</a>
</div>
</div>

<div class="col-1 col-tab-1">
<div id="enlace2">
<a href="https://rapidapi.com/navii/api/bmi-calculator?utm_source=mashape&utm_medium=301">
<img src="images/61tjuB12BybL.png" width=40 height=40 alt="Logo">
</a>
</div>
</div>

<div class="col-1 col-tab-1">
<div id="enlace3">
<a href="https://www.strava.com/?hl=es">
<img src="images/strava.png" width=40 height=40 alt="Logo">
</a>
</div>
</div>

<div class="col-1 col-tab-1">
<div id="enlace4">
<a href="https://www.youtube.com/">
<img src="images/pngwing.com.png" width=40 height=40 alt="Logo">
</a>
</div>
</div>

<center><img align="middle" class="col-3 col-tab-10 logo" src="images/logo.png" alt="Descripción de la imagen"><center>
<div class="col-10 col-tab-10"><h2 id="sentence"> No tengas un sueño,ten un plan.</h2></div>
<div class="swagger"><a href="https://titanlife.appspot.com/docs/index.html" style="color:#FF0000;">SWAGGER URL</a></div>

</body>
</html>