package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;


/**
 * Clase dao daoUsuario
 * @author Renaud Bronchart
 * @version 15/05/2024 v1.0
 */

public class daoUsuario {

	/**
	 * Generar un atributo tipo Connection llamado con
	 */
	
	public static Connection con = null;
	
	/**
	 * Constructor DaoCarrera para que se hace la connexion
	 * @throws SQLException Si ocurre un error 
	 */
	
	
	public daoUsuario() throws SQLException {
		
		this.con = DBConexion.getConexion();
	}
	
	/**Metodo para verificar si existe el usuario
	 * @return true : existe / false : no existe
	 */
	
	private boolean existe(Usuario u) {
		
		
		return true;
	}
	
	
	/**Metodo de insercion en la BDD del objeto usuario
	 * @param u Objeto tipo usuario 
	 * @throws SQLException proponga los errores si ocurre un error
	 */

	public void insertar(Usuario u) throws SQLException {
		
		String sql = "INSERT INTO usuarios (nombre,apellidos,mail,permiso) VALUES (?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getMail());
		ps.setString(3, u.getApellidos());
		ps.setInt(4, u.getPermiso());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * Metodo para actualizar 
	 * @param u Objeto tipo usuario 
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public void actualizar(Usuario u) throws SQLException {
		String sql = "UPDATE usuarios SET nombre=?,apellidos=?,mail=?,permiso=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getMail());
		ps.setString(3, u.getApellidos());
		ps.setInt(4, u.getPermiso());
		ps.setInt(5,u.getId());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	/**
	 * Metodo para borrar 
	 * @param id borrar usuario con el id
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public void borrar(int id) throws SQLException {
		
		String sql = "DELETE FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Metodo para buscar el ID
	 * @param id buscar el id de Usuario
	 * @return id return id del usuario tipo entero
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public Usuario obtenerPorID(int id) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

		return u;
	}
	
	/**
	 * Metodo para logear
	 *@return u el usuario 
	 *@throws SQLException proponga los errores si ocurre un error
	 */
	public Usuario logear(Usuario u, String pass) throws SQLException {
		
		
		String sql = "SELECT * FROM usuarios WHERE mail=? AND pass=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getMail());
		ps.setString(2,pass);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario aux = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

		return aux;
		
	}
	
	/**
	 * Metodo para Listar los usuarios
	 * @param tipo usuario
	 * @return usuario
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public ArrayList<Usuario> listar() throws SQLException{
		
		String sql = "SELECT * FROM usuarios";
		PreparedStatement ps = con.prepareStatement(sql);	
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;

		while(rs.next()) {	
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}	
		return ls;

	}
	
	
	/**
	 * Metodo para Listar los usuarios con el filtro del permiso
	 * @param tipo usuario
	 * @return tipo usuario
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public ArrayList<Usuario> listar(int tipo) throws SQLException{
		
		String sql = "SELECT * FROM usuarios WHERE permiso=?";
		PreparedStatement ps = con.prepareStatement(sql);	
		ps.setInt(1, tipo);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;

		while(rs.next()) {	
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}	
		return ls;

	}
	
	/**
	 * Metodo Json que permite obtener todo lo datos de ArrayList listar
	 * @param tipo usuario
	 * @return tipoJson
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
	public String listarJson() throws SQLException {
		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	
	}
	/**
	 * Metodo Json que permite obtener todo lo datos de ArrayList listar
	 * @param tipo
	 * @return tipo int 
	 * @throws SQLException proponga los errores si ocurre un error
	 */
	
public String listarJson(int tipo) throws SQLException {
		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar(tipo));
		
		return json;
	
	}
	
	
	
}
