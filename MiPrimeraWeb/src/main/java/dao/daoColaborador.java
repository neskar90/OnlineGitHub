package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Colaborador;


/**
 * Clase dao daoColaborador
 * @author Renaud Bronchart
 * @version 15/05/2024 v1.0
 */
public class daoColaborador {

	/**
	 * Generar un atributo tipo Connection llamado con
	 */
	
	public static Connection con = null;
	/**
	 * Constructor daoColaborador para que se hace la connexion
	 * @throws SQLException Si ocurre un error 
	 */
	
	public daoColaborador() throws SQLException {
		
		this.con = DBConexion.getConexion();
 		
	}
	/**
	 * Metodo de insercion en la BDD  del objeto Colaborador
	 * @param co Objeto tipo Colaborador 
	 * @throws SQLException Si ocurre un error 
	 */

	public void insertar(Colaborador co) throws SQLException{
		
		String sql = "INSERT INTO Colaboradores (nombre,apellidos,puesto,foto) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, co.getNombre());
		ps.setString(2, co.getApellidos());
		ps.setString(3, co.getPuesto());
		ps.setString(4, co.getFoto());
			
		
		int filas = ps.executeUpdate();
		ps.close();
	
	}
	/**
	 * Metodo para buscar el ID
	 * @param idColaborador buscar el idColaborador de Colaborador
	 * @return idColaborador return id de Colaborador tipo entero
	 * @throws SQLException Si ocurre un error 
	 */
	
	
	public Colaborador obtenerPorID(int idColaborador) throws SQLException {
		String sql = " SELECT * FROM Colaboradores where idColaboradores=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idColaborador);
		
		ResultSet result = ps.executeQuery();
		
		result.next();
		
		Colaborador co = (new Colaborador(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
		
		return co;
		
	}
	/**
	 * Metodo para actualizar 
	 * @param co Objeto tipo Colaborador 
	 * @throws SQLException Si ocurre un error 
	 */
	
	public void actualizar(Colaborador co) throws SQLException {
		String sql = " UPDATE Colaboradores SET nombre=?, apellidos=?, puesto=?, foto=? WHERE idColaboradores=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, co.getNombre());
		ps.setString(2, co.getApellidos());
		ps.setString(3, co.getPuesto());
		ps.setString(4, co.getFoto());
		ps.setInt(5, co.getidColaborador());

		int filas = ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * Metodo para borrar 
	 * @param idColaborador borrar Colaborador con el idColaborador
	 * @throws SQLException Si ocurre un error 
	 */
	
	public void borrar(int idColaborador) throws SQLException {
		
		String sql = "DELETE FROM Colaboradores WHERE idColaboradores=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,idColaborador);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	/**
	 * Metodo para Listar las carreras
	 * @return Colaborador
	 * @throws SQLException Si ocurre un error 
	 */
	
	public ArrayList<Colaborador> listar() throws SQLException {
		String sql = " SELECT * FROM Colaboradores";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();
		
		ArrayList<Colaborador> co = null;
		
		while(result.next()) {
			
			if( co== null ) {
				co = new ArrayList<Colaborador>();
			}
			
			co.add(new Colaborador(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
		}
		return co;
	}
	
	/**
	 * Metodo Json que permite obtener todo lo datos de ArrayList listar
	 * @return tipo Json
	 * @throws SQLException Si ocurre un error 
	 */
	
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}

}
