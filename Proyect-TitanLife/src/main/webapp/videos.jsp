<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="aiss.model.youtube.Item"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Videos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="css/videos.css" type="text/css">
<link rel="shortcut icon" href="images/logo.png">
<link rel="apple-touch-icon" href="images/logo.png">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;700&display=swap" rel="stylesheet">
</head>
<body>

<%@ include file="includes/menu.jsp" %>
<h1 id="text">Mis Videos</h1>

<img id="logoSD" src="images/logo.png" alt="Descripción de la imagen">
<div id="scroll">
<c:forEach items="${videos}" var="video">
        <a href="/youtubeVideosController?videoPrincipal=${video.id.videoId}">
        <img class="miniatura" src="http://img.youtube.com/vi/${video.id.videoId}/0.jpg"/>
        </a>
</c:forEach>
</div>
<div>
<iframe id="principal" src="https://www.youtube.com/embed/${videoPrincipal}"></iframe>
<form action="/setDeleteYoutubeController" method="GET">
<input type="hidden" name="videoPrincipal" value="${videoPrincipal}"/>
<input type="hidden" name="playlistTitanLifeId" value="${playlistTitanLifeId}"/>
<input type="hidden" name="idVideoPlaylist" value="${idVideoPlaylist}"/>
<c:choose>
   <c:when test="${videoPrincipalEnPlaylist=='0'}">
   <input name="boton" id="boton" type="submit" value="Añadir a la playlist TitanLife"/>
   </c:when>
   <c:when test="${videoPrincipalEnPlaylist=='1'}">
   <input name="boton" id="boton" type="submit" value="Eliminar de la playlist TitanLife"/>
   </c:when>
</c:choose>
</form>
</div>
</body>
</html>