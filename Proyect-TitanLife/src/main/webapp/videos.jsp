<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<%@ include file="menu.jsp" %>

<img id="logoSD" src="images/logo.png" alt="Descripción de la imagen">
<div class="scroll">
<c:forEach items="${videos}" var="video">
        <div>
        <iframe width="600" height="315" src="https://www.youtube.com/embed/${video.id.videoId}"></iframe>
        </div>
</c:forEach>
</div>
</body>
</html>