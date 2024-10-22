package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumn;
import modelo.AlumnoDAO;

/**
 * Servlet implementation class ServletLogin
 */

@WebServlet({"/ServletLogin","/tercero"} )
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
	    String pagina = "error.jsp"; 
	    try {
	        String nombre = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        // Validación básica de longitud
	        if (nombre.length() < 4 || password.length() < 4) {
	            // Si no cumple la validación de longitud, setea el mensaje de error
	            request.setAttribute("resultadoValidacion", "Rellena con al menos 6 caracteres.");
	        } else {
	            // Si la longitud es válida, validar el usuario contra la base de datos
	            Alumn alumno = AlumnoDAO.validateUser(nombre, password); // Cambiar a objeto Alumn
	            
	            if (alumno != null) { // Comprueba si el alumno no es nulo
	            	
	                // Si el usuario es válido, almacenar el ID y el nombre en la sesión
	                request.getSession().setAttribute("usuarioId", alumno.getId());
	                request.getSession().setAttribute("usuarioNombre", alumno.getNombre());

	                // Redirige a la página de respuesta con el mensaje de éxito
	                pagina = "respuesta.jsp";
	                request.setAttribute("resultado", nombre + " INICIO DE SESION CORRECTO");
	            } else {
	                // Si el usuario no es válido, setea el mensaje de error
	                request.setAttribute("resultadoValidacion", "Usuario o contraseña incorrectos.");
	            }
	        }
	        
	        
	        // Redirigir a la página correspondiente (error.jsp o respuesta.jsp)
	        request.getRequestDispatcher(pagina).forward(request, response);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}


		
		
		
		
	}


