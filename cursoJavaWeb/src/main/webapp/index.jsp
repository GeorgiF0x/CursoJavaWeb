<html>
<body>
<h2><%= "Merequetengue!" %></h2>

<form action="miPrimerServlet" method='POST'>
	<p>
	<input type="number" name="operador1">
    <label for="operador1">Operador 1:</label>
    </p>
    <input type="number" name="operador2">
    <label for="operador2">Operador 2:</label>
    <p>
	<input type="submit" name="buttonSumar" value="Sumar">
	<input type="submit" name="buttonRestar" value="Restar">
	<input type="submit" name="buttonDividir" value="Dividir">
	<input type="submit" name="buttonMultiplicar" value="Multiplicar">
	</p>

</form>

     <form action="login.jsp" method="get">
        <input type="submit" value="Login">
    </form>
</body>
</html>
