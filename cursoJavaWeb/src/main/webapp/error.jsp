<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error de Inicio de Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 400px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #d9534f;
        }
        p {
            color: #333;
        }
        a {
            color: #5cb85c;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Error de Inicio de Sesión</h1>
        <p>Lo sentimos, el nombre de usuario o la contraseña son incorrectos. Por favor, intenta de nuevo.</p>
        <a href="login.jsp">Volver a intentar</a>
    </div>
</body>
</html>
