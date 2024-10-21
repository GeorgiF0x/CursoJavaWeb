package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;


public class Alumn {

	private  int id;
	private String nombre;
	private String apellidos;
	private String numTelefono;
	
	public Alumn(int id, String nombre, String apellidos, String numTelefono) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numTelefono = numTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	


	@Override
	public String toString() {
		return "Alumn [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", numTelefono=" + numTelefono
				+ "]";
	}
	
	
	
	
	
}
