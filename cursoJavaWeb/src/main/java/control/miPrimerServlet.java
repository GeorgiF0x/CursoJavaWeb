package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class miPrimerServlet
 */
@WebServlet({"/miPrimerServlet","/primero"} )
public class miPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public miPrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Recuperar el valor del campos  enviado en el formulario como cadenas
		String operador1Str = request.getParameter("operador1");
	    String operador2Str = request.getParameter("operador2");
	    //
	    char operacion = ' ';
	    
	    //gestion de los botones de oepracion 
	    if (request.getParameter("buttonSumar") != null) {
	        operacion = '+';
	    } else if (request.getParameter("buttonRestar") != null) {
	        operacion = '-';
	    } else if (request.getParameter("buttonDividir") != null) {
	        operacion = '/';
	    } else if (request.getParameter("buttonMultiplicar") != null) {
	        operacion = '*';
	    }
	    // Convertir los parámetros a enteros
	    int operador1 = Integer.parseInt(operador1Str);
	    int operador2 = Integer.parseInt(operador2Str);
        int result = hacerOperacion(operador1,operador2,operacion);
        // Pasar el valor a la JSP como atributo
        request.setAttribute("resultado", result);

        // Redirigir a la página JSP que mostrará el nombre
        request.getRequestDispatcher("respuesta.jsp").forward(request, response);
	}
	
	private int hacerOperacion(int operador1, int operador2, char operacion) {
	    switch (operacion) {
	        case '+':
	            return operador1 + operador2;
	        case '-':
	            return operador1 - operador2;
	        case '*':
	            return operador1 * operador2;
	        case '/':
	            if (operador2 != 0) {
	                return operador1 / operador2;
	            } else {
	                throw new ArithmeticException("División por cero no permitida");
	            }
	        default:
	            throw new IllegalArgumentException("Operación no válida: " + operacion);
	    }
	}


}
