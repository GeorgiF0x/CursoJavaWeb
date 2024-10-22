<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error de Inicio de Sesión</title>
</head>
<body>
    <div class="container">
        <h1>Error de Inicio de Sesión</h1>
        
   			<%
                String resultadoValidacion = (String) request.getAttribute("resultadoValidacion");
                if (resultadoValidacion != null) {
                    out.println(resultadoValidacion);
                }
            %>
            
	    <form action="login" method="get">
	        <input type="submit" value="Volver a intentar">
	    </form>
    </div>
</body>
</html>
