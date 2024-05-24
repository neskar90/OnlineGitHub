package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Corredor;

/**
 * Clase daoCorredor
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */
public class daoCorredor {

	/**
	 * Generar un atributo tipo Connection llamado con
	 */
	
	public static Connection con = null;
	/**
	 * Constructor daoCorredor para que se hace la connexion
	 */
	
	public daoCorredor() throws SQLException {
		
		this.con = DBConexion.getConexion();
 		
	}
	/**
	 * Metodo de insercion en la BDD  del objeto Carrera
	 */
	public void insertar(Corredor co) throws SQLException{
		
		String sql = "INSERT INTO corredores (nombre,apellidos,mail,dni,fechanacimiento,sexo,direccion,ciudad,telefono) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, co.getNombre());
		ps.setString(2, co.getApellidos());
		ps.setString(3, co.getMail());
		ps.setString(4, co.getDni());
		ps.setString(5, co.getFechanacimiento());
		ps.setString(6, co.getSexo());
		ps.setString(7, co.getDireccion());
		ps.setString(8, co.getCiudad());
		ps.setString(9, co.getTelefono());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	/**
	 * Metodo para buscar el ID
	 * @return tipo int
	 */
	
	public Corredor obtenerPorID(int id) throws SQLException {
		String sql = " SELECT * FROM corredores where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		result.next();
		
		Corredor co = (new Corredor(result.getInt(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5), result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10)));
		
		return co;
		
	}
	/**
	 * Metodo para actualizar 
	 */
	public void actualizar(Corredor co) throws SQLException {
		String sql = " UPDATE  corredores SET nombre=?, apellidos=?, mail=?, dni=?, fechanacimiento=?, sexo=?,direccion=?,ciudad=?,telefono=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, co.getNombre());
		ps.setString(2, co.getApellidos());
		ps.setString(3, co.getMail());
		ps.setString(4, co.getDni());
		ps.setString(5, co.getFechanacimiento());
		ps.setString(6, co.getSexo());
		ps.setString(7, co.getDireccion());
		ps.setString(8, co.getCiudad());
		ps.setString(9, co.getTelefono());
		ps.setInt(10, co.getid());

		int filas = ps.executeUpdate();
		ps.close();
		
	}
	/**
	 * Metodo para borrar 
	 */
	
	public void borrar(int id) throws SQLException {
		
		String sql = "DELETE FROM corredores WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	/**
	 * Metodo para Listar las carreras
	 * @return listacarreras
	 */
	public ArrayList<Corredor> listar() throws SQLException {
		String sql = " SELECT * FROM corredores";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();
		
		ArrayList<Corredor> lc = null;
		
		while(result.next()) {
			
			if( lc== null ) {
				lc = new ArrayList<Corredor>();
			}
			
			lc.add(new Corredor(result.getInt(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5), result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10)));
		}
		return lc;
	}
	

	
	/**
	 * Metodo Json que permite obtener todo lo datos de ArrayList listar
	 * @return tipo Json
	 */
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}

}
