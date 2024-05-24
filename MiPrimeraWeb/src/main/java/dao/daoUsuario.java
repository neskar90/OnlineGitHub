
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;



// TAD-DAO
public class daoUsuario {

	
	public static Connection con = null;
	
	public daoUsuario() throws SQLException {
		
		this.con = DBConexion.getConexion();
	}
	
	private boolean existe(Usuario u) {
		
		
		return true;
	}
	
	
	/**Metodo de inserción en la bd del objeto usuario
	 * 
	 * @param u Objeto tipo usuarios
	 * @throws SQLException
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
	
	public void borrar(int id) throws SQLException {
		
		String sql = "DELETE FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	
	public Usuario obtenerPorID(int id) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

		return u;
	}
	
	
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
	

	
	public ArrayList<Usuario> listar() throws SQLException{
		
		String sql = "SELECT * FROM usuarios";
		PreparedStatement ps = con.prepareStatement(sql);	
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		/*
		next-> 		  . 
		null [4][5][6][7][8][7] null
		*/
		while(rs.next()) {	
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}	
		return ls;

	}
	
	
	/**
	 * Metodo listas que<strong> retorna los usarios con el flitrado</strong> de tipo
	 * @param tipo
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<Usuario> listar(int tipo) throws SQLException{
		
		String sql = "SELECT * FROM usuarios WHERE permiso=?";
		PreparedStatement ps = con.prepareStatement(sql);	
		ps.setInt(1, tipo);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		/*
		next-> 		  . 
		null [4][5][6][7][8][7] null
		*/
		while(rs.next()) {	
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}	
		return ls;

	}
	

	
	public String listarJson() throws SQLException {
		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	
	}
	
public String listarJson(int tipo) throws SQLException {
		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar(tipo));
		
		return json;
	
	}
	
	
	
}
