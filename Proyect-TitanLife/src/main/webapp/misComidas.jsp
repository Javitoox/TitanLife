<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="aiss.model.repository.TitanLifeRepository"%>
<%@ page import="aiss.model.titan.User"%>
<%@ page import="aiss.utility.CalculatorFatSecret"%>
<%@ page import="com.fatsecret.platform.model.Food"%>
<%@ page import="java.util.List"%>

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
	<script src="js/foods.js"></script>
</head>
<body>
     <%@ include file="includes/menu.jsp"%>
     <%
     	User u=TitanLifeRepository.getInstance().findByUsername((String)session.getAttribute("username"));
     %>
     <h1 id="texto">Mis Comidas</h1>
    <img id="logo" src="images/logo.png" alt="Logo">
    <div id="calendario">
    <div class="month">
        <ul>
            <li class="prev">&#10094;</li>
            <li class="next">&#10095;</li>
            <li> Calorías diarias<br><br> Personalizadas </li>
        </ul>
    </div>

    <ul class="weekdays">
        <li>-</li>
        <li>-</li>
        <li>-</li>
        <li>-</li>
        <li>-</li>
        <li>-</li>
        <li>-</li>
    </ul>

    <ul class="mealsKcal">  
    </ul>
    
    <h1 id="consumidas"><%= u.getBaseCaloriasDiarias()-u.getCaloriasDiarias() %></h1>
    <%Integer restantes = u.getCaloriasDiarias(); 
    if(restantes>0){
    %>
    <h1 id="restantes1"><%=restantes%></h1>
    <%}else{
    %>
    <h1 id="restantes2"><%=restantes%></h1>
    <%
    }
    %>
    </div>
    
    <div>
    <form action="/deleteFatSecretController" method="GET">
			<select multiple id="comidasUsuario" name="comidasUsuario">
			<%
			List<String> comidasUsuario=u.getComidasDiarias();
			for(String f: comidasUsuario){
				String []trozos=f.split("/");
				String formato=trozos[0]+" / "+trozos[4]+" kcal por "+trozos[3]+"g";
				%>
				 <option value='<%=f%>' label='<%=formato%>'/>
				<%
				}
			%>
			</select>
			<input id="botonComidasUsuario" type="submit" value="Eliminar" />
	</form>
    </div>

    <span id="foodCalories"></span>
    <span id="validaciones">${validaciones}</span>
    <form id = "formulario" action="/foodsFatSecretController">
        <input id="search" type="text" name="search" placeholder="Búsqueda" maxlength="40" onclick="setSearch()">
        <input id="cantidad" type="text" name="cantidad" placeholder="Cantidad a añadir en gr" onkeyup="getCalories()">
        <input id="caloriasOcultas" name="caloriasOcultas" type="hidden">
        <select name="comidas" id="comidas" onclick="setFoods()">
	        <% @SuppressWarnings("unchecked")List<Food> comidasRecibidas=(List<Food>)request.getAttribute("sugerencias");
	        if(comidasRecibidas!=null){
	        for(Food f: comidasRecibidas){%>
	        <option value='<%=f.getName()+"/"+f.getId()+"/"+CalculatorFatSecret.caloriesPer100(f)%>'
	        label='<%=f.getName()+" / "+CalculatorFatSecret.caloriesPer100(f)%> kcal por 100g'/>
	        <%	
	        }
	        }
	        %>
		</select>
        <input id="botonComidas" name="botonComidas" type="submit" value="Buscar/Añadir" disabled>
    </form>

</body>
</html>