package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import conexion.Conexion;

public class AlumnoDAO {

	public static  ArrayList<Alumn>  getAlumnsByName(String filtro) throws SQLException {
		ArrayList <Alumn>lista_alumnos= new ArrayList<Alumn>();
		
		//instanciar clase Connection usando el metodo de la clase conexion 
		 Connection conn = Conexion.getConexion();
	        //comprobar si se ha instanicado con el metodo correctamente
	        if (conn != null) {
	            System.out.println("Conexión establecida con éxito.");
	            String sql="Select * from alumno where nombre like ?";
	            //crear un objeto preparedStatement al que se le pasa una cadena con el sql preparado
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, filtro+"%");
	            //crear objeto resultSet para manipular los datos ejecutando el statment
	            ResultSet rs = pstmt.executeQuery();
	            if (!rs.isBeforeFirst()) {    
	                // Si no hay registros, mostrar mensaje
	                System.out.println("No hay registros disponibles.");
	            } else {
	                while(rs.next()) {
	                    int id = rs.getInt(1);
	                    String nombre = rs.getString(2);
	                    String apellidos = rs.getString(3);
	                    String telefono = rs.getString(4);
	                    String password = rs.getString(4);
		                
		                Alumn alumno = new Alumn(id, nombre, apellidos, telefono,password);
	                    lista_alumnos.add(alumno);
	                }
	            }
	            // Finalmente, desconectamos
	            Conexion.desconectar();
	        } else {
	            System.out.println("No se pudo establecer la conexión.");
	        }
	        
			return lista_alumnos;
	}
	
	public static  Alumn  getById(int id) throws SQLException {

		Alumn alumno= new Alumn();
		//instanciar clase Connection usando el metodo de la clase conexion 
		 Connection conn = Conexion.getConexion();
	        //comprobar si se ha instanicado con el metodo correctamente
	        if (conn != null) {
	            System.out.println("Conexión establecida con éxito.");
	            String sql="Select * from alumno where id = ?";
	            //crear un objeto preparedStatement al que se le pasa una cadena con el sql preparado
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            //crear objeto resultSet para manipular los datos ejecutando el statment
	            ResultSet rs = pstmt.executeQuery();
	            if (!rs.isBeforeFirst()) {    
	                // Si no hay registros, mostrar mensaje
	                System.out.println("No hay registros disponibles.");
	            } else {
	                while(rs.next()) {
	                    int idAlumno = rs.getInt(1);
	                    String nombre = rs.getString(2);
	                    String apellidos = rs.getString(3);
	                    String telefono = rs.getString(4);
	                    String password = rs.getString(4);
		                
		                alumno = new Alumn(idAlumno, nombre, apellidos, telefono,password);
	                   
	                }
	            }
	     
	        } else {
	            System.out.println("No se pudo establecer la conexión.");
	        }
	        
			return alumno;
	}
	
	public static ArrayList<Alumn> getAll() throws SQLException {
	    ArrayList<Alumn> lista_alumnos = new ArrayList<Alumn>();
	    
	    // Instanciar clase Connection usando el método de la clase conexión 
	    Connection conn = Conexion.getConexion();
	    
	    // Comprobar si se ha instanciado correctamente
	    if (conn != null) {
	        System.out.println("Conexión establecida con éxito.");
	        
	        String sql = "SELECT * FROM alumno";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	        // Crear objeto ResultSet para manipular los datos ejecutando el preparedStatement
	        ResultSet rs = pstmt.executeQuery(); // Cambiado a executeQuery
	        
	        // Verificar si hay registros
	        if (!rs.isBeforeFirst()) {    
	            // Si no hay registros, mostrar mensaje
	            System.out.println("No hay registros disponibles.");
	        } else {
	            while (rs.next()) {
	                int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellidos = rs.getString(3);
                    String telefono = rs.getString(4);
                    String password = rs.getString(4);
	                
	                Alumn alumno = new Alumn(id, nombre, apellidos, telefono,password);
	                lista_alumnos.add(alumno);
	            }
	        }
	        
	        // Cerrar recursos
	        rs.close();
	        pstmt.close();
	        conn.close(); // Asegúrate de cerrar la conexión también
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	    }
	    
	    return lista_alumnos;
	}
	
	public static void insert(Alumn alumno) throws SQLException {
	    ArrayList<Alumn> lista_alumnos = new ArrayList<Alumn>();
	    
	    // Instanciar clase Connection usando el método de la clase conexión 
	    Connection conn = Conexion.getConexion();
	    
	    // Comprobar si se ha instanciado correctamente
	    if (conn != null) {
	        System.out.println("Conexión establecida con éxito.");
	        
	        String sql = "INSERT INTO alumno (id,nombre,apellidos,telefono) VALUES (?,?,?,?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	       // pstmt.setInt(1, (Integer) null);
            pstmt.setString(2,alumno.getNombre());
            pstmt.setString(3, alumno.getApellidos());
            pstmt.setString(4, alumno.getNumTelefono());
	        
	       
	        int filasInsertadas = pstmt.executeUpdate(); 
	        
	   
	        if (filasInsertadas > 0) {
                System.out.println("Alumno insertado con éxito."+alumno.toString());
            } else {
                System.out.println("No se pudo insertar el alumno.");
            }
	    	
	        pstmt.close();
	        conn.close(); 
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	    }
	    
	}
	
	public static Alumn validateUser(String nombre, String password) throws SQLException {
	    Alumn alumno = null; // Inicializa como null

	    // Instanciar clase Connection usando el método de la clase conexión 
	    try (Connection conn = Conexion.getConexion()) { // Usar try-with-resources para cerrar automáticamente
	        if (conn != null) {
	            System.out.println("Conexión establecida con éxito.");
	            String sql = "SELECT * FROM alumno WHERE nombre = ? AND password = ?"; // Considera usar hash en lugar de texto plano
	            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                pstmt.setString(1, nombre);
	                pstmt.setString(2, password);

	                // Ejecutar la consulta
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    // Verificar si hay resultados
	                    if (rs.next()) { // Usa if en lugar de while para obtener solo un resultado
	                        int id = rs.getInt(1);
	                        String nombreAlumno = rs.getString(2);
	                        String apellidos = rs.getString(3);
	                        String telefono = rs.getString(4);
	                        String passwordAlumno = rs.getString(5); // Corrige el índice

	                        alumno = new Alumn(id, nombreAlumno, apellidos, telefono, passwordAlumno);
	                    }
	                }
	            }
	        } else {
	            System.out.println("No se pudo establecer la conexión.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Captura y muestra excepciones
	    }

	    return alumno; // Devolverá null si no se encontró un usuario
	}

	



	
	
	
}
