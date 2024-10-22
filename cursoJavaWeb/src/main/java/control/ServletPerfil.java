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
 * Servlet implementation class ServletPerfil
 */
@WebServlet({"/ServletPerfil","/cuarto"})
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//buscar los datos del alumno apartir del id 
		try {
			Alumn alumn = AlumnoDAO.getById((int)request.getSession().getAttribute("usuarioId"));
	        request.setAttribute("nombre", alumn.getNombre());
	        request.setAttribute("Apellidos", alumn.getApellidos());
	        request.setAttribute("telefono", alumn.getNumTelefono());
	        
	        request.getRequestDispatcher("perfil.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
