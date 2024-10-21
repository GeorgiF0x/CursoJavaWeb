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

	                    Alumn alumno = new Alumn(id, nombre, apellidos, telefono);
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
	                
	                Alumn alumno = new Alumn(id, nombre, apellidos, telefono);
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
	
	public static boolean validateUser(String nombre, String password) throws SQLException {
	    boolean isValid = false;

	    // Instanciar clase Connection usando el método de la clase conexión 
	    Connection conn = Conexion.getConexion();

	    // Comprobar si se ha instanciado correctamente
	    if (conn != null) {
	        System.out.println("Conexión establecida con éxito.");

	        String sql = "SELECT * FROM alumno WHERE nombre = ? AND password = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, nombre);
	        pstmt.setString(2, password);

	        // Ejecutar la consulta
	        ResultSet rs = pstmt.executeQuery();

	        // Verificar si hay resultados
	        if (rs.next()) { // Si existe al menos un registro
	            isValid = true; // Usuario y password válidos
	            System.out.println("Usuario validado con éxito.");
	        } else {
	            System.out.println("Usuario o contraseña incorrectos.");
	        }

	        // Cerrar recursos
	        rs.close();
	        pstmt.close();
	        conn.close(); // Asegúrate de cerrar la conexión también
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	    }

	    return isValid;
	}



	
	
	
}
