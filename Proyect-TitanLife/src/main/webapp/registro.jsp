<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
<title>Registro</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link rel="stylesheet" href="css/registro.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@900&display=swap" rel="stylesheet">
</head>
<body>
				

	<center><div class="col-10 col-tab-10"><h1>TITAN LIFE</h1></div></center>
	<c:if test="${not empty requestScope.validaciones}">
	<div class="col-2 col-tab-2 validaciones">
		<c:if test="${requestScope.validaciones.username1!=''}">
	<h4>${requestScope.validaciones.username1}</h4>
	</c:if>
	<c:if test="${requestScope.validaciones.email!=''}">
	<h4>${requestScope.validaciones.email}</h4></c:if>
	<c:if test="${requestScope.validaciones.username2!=''}">
	<h4>${requestScope.validaciones.username2}</h4></c:if>
	<c:if test="${requestScope.validaciones.correo!=''}">
	<h4>${requestScope.validaciones.correo}</h4></c:if>
	<c:if test="${requestScope.validaciones.pass!=''}">
	<h4>${requestScope.validaciones.pass}</h4></c:if>
	<c:if test="${requestScope.validaciones.retype!=''}">
	<h4>${requestScope.validaciones.retype}</h4></c:if>
	<c:if test="${requestScope.validaciones.age!=''}">
	<h4>${requestScope.validaciones.age}</h4></c:if>	
	<c:if test="${requestScope.validaciones.height!=''}">
	<h4>${requestScope.validaciones.height}</h4></c:if>
	<c:if test="${requestScope.validaciones.weight!=''}">
	<h4>${requestScope.validaciones.weight}</h4></c:if>
	<c:if test="${requestScope.validaciones.hip!=''}">
	<h4>${requestScope.validaciones.hip}</h4></c:if>
	<c:if test="${requestScope.validaciones.waist!=''}">
	<h4>${requestScope.validaciones.waist}</h4></c:if>
	<c:if test="${requestScope.validaciones.sex!=''}">
	<h4>${requestScope.validaciones.sex}</h4>
	</c:if>
	
	</div>			
	
	
	<center><div class="col-8 col-tab-8">
	<div class="cuadro">
        <form id = "formulario" name="formulario" action="/validatorController" method="GET">
            <input id="Username" name="username"type="text" placeholder="Username" maxlength="40" value="${requestScope.username}" required/><br/>    
            <input id="Email" name="email" type="email" placeholder="E-mail" maxlength="40" value="${requestScope.email}" required/><br/> 
            <input id="Password" name="password" type="password" placeholder="Password" maxlength="40" value="${requestScope.password}" required/><br/>
            <input id="Retype" name="retype" type="password" placeholder="Retype password" maxlength="40" value="${requestScope.retype}" required/><br/>
            <input id="Age"  name="age" type="text" placeholder="Age (Format example: 19)" maxlength="3" value="${requestScope.age}" required/><br/>      
          	<input id="Height"  name="height" type="text" placeholder="Height (Format example(cm): 170.00)" maxlength="6" value="${requestScope.height}" required/><br/>
            <input id="Weight"  name="weight"  type="text" placeholder="Weight (Format example(kg): 68.00)" maxlength="6" value="${requestScope.weight}" required/><br/>
            <input id="Hip"  name="hip" type="text" placeholder="Hip (Format example(cm): 80.00)" maxlength="6" value="${requestScope.hip}" required/><br/>
            <input id="Waist"  name="waist" type="text" placeholder="Waist (Format example(cm): 80.00)" maxlength="6" value="${requestScope.waist}"required/><br/>
            <input id="Sex"  name="sex" type="text" placeholder="Sex (m/f)" maxlength="1" value="${requestScope.sex}"required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
        </form>
    </div> 
    </div>
    </center>
    
</c:if>
	<c:if test="${empty requestScope.validaciones}">			
			<center><div class="col-10 col-tab-10">
	<div class="cuadro">
        <form id = "formulario" name="formulario" action="/validatorController" method="GET">
            <input id="Username" name="username"type="text" placeholder="Username" maxlength="40" value="${requestScope.username}" required/><br/>    
            <input id="Email" name="email" type="email" placeholder="E-mail" maxlength="40" value="${requestScope.email}" required/><br/> 
            <input id="Password" name="password" type="password" placeholder="Password" maxlength="40" value="${requestScope.password}" required/><br/>
            <input id="Retype" name="retype" type="password" placeholder="Retype password" maxlength="40" value="${requestScope.retype}" required/><br/>
            <input id="Age"  name="age" type="text" placeholder="Age (Format example: 19)" maxlength="3" value="${requestScope.age}" required/><br/>      
          	<input id="Height"  name="height" type="text" placeholder="Height (Format example(cm): 170.00)" maxlength="6" value="${requestScope.height}" required/><br/>
            <input id="Weight"  name="weight"  type="text" placeholder="Weight (Format example(kg): 68.00)" maxlength="6" value="${requestScope.weight}" required/><br/>
            <input id="Hip"  name="hip" type="text" placeholder="Hip (Format example(cm): 80.00)" maxlength="6" value="${requestScope.hip}" required/><br/>
            <input id="Waist"  name="waist" type="text" placeholder="Waist (Format example(cm): 80.00)" maxlength="6" value="${requestScope.waist}"required/><br/>
            <input id="Sex"  name="sex" type="text" placeholder="Sex (m/f)" maxlength="1" value="${requestScope.sex}"required/><br/>
            <input id="boton" type="submit" value="SIGN ME UP" /><br/>
        </form>
    </div> 
    </div>
    </center>	
</c:if>

    
</body>
</html>