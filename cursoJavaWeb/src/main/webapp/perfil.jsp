<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<h1>Tu perfil</h1>
    
     <form action="index.jsp" method="get"> 
     	<input type="text" value=<%request.getAttribute("nombre"); %>>
     	 	<input type="text" value=<%request.getAttribute("Apellidos"); %>>
     	 	 	<input type="text" value=<%request.getAttribute("telefono"); %>>
        <input type="submit" value="Volver al inicio">
    </form>
    

</body>
</html>