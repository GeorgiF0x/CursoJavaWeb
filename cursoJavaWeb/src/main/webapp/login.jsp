<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Mondongo Login</h1>
 <form action="ServletLogin" method="post">
            <label for="username">Nombre:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
            
            <input type="submit" value="Iniciar Sesión">
        </form>
     <p>   
     <form action="index.jsp" method="get">
        <input type="submit" value="Volver al inicio">
    </form>
    </p>
</body>
</html>