<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="aiss.model.repository.TitanLifeRepository"%>
<%@ page import="aiss.model.titan.Objetivo"%>
<%@ page import="aiss.model.titan.User"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
<head>
<title>Mis objetivos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/objetivos.css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <%@include file="includes/menu.jsp"%>
    <%
    	User u=TitanLifeRepository.getInstance().findByUsername((String)session.getAttribute("username"));
    %>

    <h1 id="text">Mis Objetivos</h1>
	<img  id="logo" src="images/logo.png" alt="Descripción de la imagen">
	<div class="col-3 cuadro" id="cuadro4">
	Objetivos corporales
	</div>	
	<div class="col-3 cuadro" id="cuadro5">
	<%
		if(u.getImcObj()!=null && !u.getImcObj().equals("")){
	%>
   		<%=u.getImcObj()%>
	<%
		}else{
	%>
   		 XX.XX%
	<%
		}
	%>
	</div>
	<div >
		<form action="/objetivosCorporalesController" method="GET">
		    <%
		    	if(u.getPesoObj()==null || u.getPesoObj().equals("")){
		    %>
			<input name="pesoObj" placeholder="Peso (Formato ej(kg): 74.00)" class="col-3 obj" id="objPeso" type="text" required>
			<%
				}else{
			%>
			<input name="pesoObj" placeholder="Peso (Formato ej(kg): 74.00)" class="col-3 obj" id="objPeso" type="text" value="<%=u.getPesoObj()%>" required>
			<%
				}
			%>
			<input name="fechaObj" placeholder="Fecha para su objetivo" class="col-3 obj" id="objPeso2" type="date" value="<%=u.getFechaObj()%>" required>
			<%
				if(u.getImc()==null || u.getImc().equals("")){
			%>
			<input class="boton" id="done2" type="submit" value="DONE" disabled/>
			<span class="advert">Debe de generar su IMC primero</span>
			<%
				}else{
			%>
			<input class="col-3 boton" id="done2" type="submit" value="DONE"/>
			<%
				}
			%>
			<span class="advert">${requestScope.validaciones}</span>
		</form>
	</div>

	<div>
		<form action="/misObjetivosController" method="GET" >
			<input name="IMC" class="col-2 boton" type="submit" value="GENERAR IMC" />
		</form>
	</div>
	
	<div class="col-2 cuadro" id="cuadro1">
	IMC ACTUAL	
	<%
			if(u.getImc()!=null && !u.getImc().equals("")){
		%>
   		<%=u.getImc()%>
	<%
		}else{
	%>
   		 XX.XX%
	<%
		}
	%>
	
	</div>
	<div class="col-2 cuadro" id="cuadro2">
	PESO ACTUAL
    <%=u.getDatosBMI().getWeight().getValue()+" kg"%>
   
	</div>	

	<div>
	<span id="youtubeMessage">${requestScope.mensajeYoutube}</span>
		<form action="/parseoObjetivosController" method="GET">
			<select multiple required class="col-3 obj" id="objDep" name="opDep">
			<%
				List<Objetivo> o=u.getObjetivos();
					List<Objetivo> objetivos=TitanLifeRepository.getInstance().getObjetivosAplicacion();
					
					for(Objetivo obj: objetivos){
						if(o!=null && o.contains(obj)){
			%>		
				<option value='<%= obj.getNombre() %>' label='<%= obj.getNombre() %>' selected/>
				<%
				}else{
				%>
				<option value='<%= obj.getNombre() %>' label='<%= obj.getNombre() %>'/>
				<%
				}
			}
			%>
			</select>
			<input class="col-3 boton" id="done1" type="submit" value="DONE" />
		</form>
	</div>
	
	<div class="col-3 cuadro" id="cuadro3">
	Objetivos deportivos
	</div>
	
</body>
</html>