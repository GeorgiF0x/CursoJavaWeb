<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Resultado de la solicitud</h2>
    <p>Hola, <%= request.getAttribute("resultado") %>!</p>
     <form action="index.jsp" method="get">
        <input type="submit" value="Volver al inicio">
    </form>
</body>
</html>