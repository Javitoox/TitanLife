<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="aiss.model.repository.TitanLifeRepository"%>
<%@ page import="aiss.model.titan.User"%>
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

<img class="col-2 col-tab-2 logo" src="images/logo.png" alt="Descripción de la imagen">

<h1 class="menu">Mi Perfil</h1>
<h2 class="texto4" id="text">Datos de usuario</h2>


<div>${requestScope.validaciones}</div>		

<div class="col-10 col-tab-10">
<%
	User u=TitanLifeRepository.getInstance().findByUsername((String)session.getAttribute("username"));
%>
       <form class = "formulario" action="/perfilController" method="GET">
       		<label id="t">Username:</label>
            <input id="Username" name="Username"type="text" placeholder="Username" maxlength="40" value="<%= u.getUsername() %>" required/><br/>
            <label id="t">Email:</label>
                
            <input id="Email" name="Email" type="text" placeholder="E-mail" maxlength="40"  value="<%= u.getEmail() %>" required/><br/> 
                   <label id="t">Password:</label>
            
            <input id="Password" name="Password" type="text" placeholder="Password" maxlength="40" value="<%= u.getPassword() %>" required/><br/>
                   <label id="t">Age:</label>
            
            <input id="Age"  name="Age" type="text" placeholder="Age" maxlength="40"  value="<%= u.getDatosBMI().getAge() %>" required/><br/>
                   <label id="t">Height:</label>
                  
          	<input id="Height"  name="Height" type="text" placeholder="Height" maxlength="40"  value="<%= u.getDatosBMI().getHeight() %>" required/><br/>
          	       <label id="t">Weight:</label>
          	
            <input id="Weight"  name="Weight"  type="text" placeholder="Weight" maxlength="40"  value="<%= u.getDatosBMI().getWeight() %>"required/><br/>
                   <label id="t">Hip:</label>
            
            <input id="Hip"  name="Hip" type="text" placeholder="Hip Measurement (cm)" maxlength="40"  value="<%= u.getDatosBMI().getHip() %>"required/><br/>
                   <label id="t">Waist:</label>
            
            <input id="Waist"  name="Waist" type="text" placeholder="Waist Measurement (cm)" maxlength="40"  value="<%= u.getDatosBMI().getWaist() %>"required/><br/>
                   <label id="t">Sex:</label>
            
            <input id="Sex"  name="Sex" type="text" placeholder="Sex (m/f)" maxlength="1" value="<%= u.getDatosBMI().getSex() %>"required/><br/>
                              
             <label id="t">Objetivos:</label>
             
             <% if(u.getObjetivos()==null){
            	%>                
           
            	
            	<% 
            }else{
            	%>
            	<input id="opDep" name="opDep" type="text" placeholder="" maxlength="1000" value="" required/><br/>
            	
            	<input id="opDep" name="opDep" type="text" placeholder="" maxlength="1000" value="<%= u.getObjetivos() %>" required/><br/>
            	
            	
            	<% 
            	}
            
            %>       
            
           <input type="submit" value="Confirmar cambios" /><br />
       </form>
</div>

</body>
</html>