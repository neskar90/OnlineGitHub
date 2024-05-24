package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Carrera;


public class daoCarrera {

	//Patron Singelton aun mejor.
	
	public static Connection con = null;
	
	public daoCarrera() throws SQLException {
		
		this.con = DBConexion.getConexion();
 		
	}
	
	public void insertar(Carrera c) throws SQLException{
		
		String sql = "INSERT INTO carreras (fechaCarrera, nombreCarrera,ciudadCarrera,distanciaCarrera) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getFechaCarrera());
		ps.setString(2, c.getNombreCarrera());
		ps.setString(3, c.getCiudadCarrera());
		ps.setString(4, c.getDistanciaCarrera());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public Carrera obtenerPorID(int idCarrera) throws SQLException {
		String sql = " SELECT * FROM carreras where idCarrera=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idCarrera);
		
		ResultSet result = ps.executeQuery();
		
		result.next();
		
		Carrera c = (new Carrera(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
		
		return c;
		
	}
	
	public void actualizar(Carrera c) throws SQLException {
		String sql = " UPDATE carreras SET fechaCarrera=?, nombreCarrera=?, ciudadCarrera=?, distanciaCarrera=? WHERE idCarrera=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, c.getFechaCarrera());
		ps.setString(2, c.getNombreCarrera());
		ps.setString(3, c.getCiudadCarrera());
		ps.setString(4, c.getDistanciaCarrera());
		ps.setInt(5, c.getidCarrera());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public void borrar(int idCarrera) throws SQLException {
		
		String sql = "DELETE FROM carreras WHERE idCarrera=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,idCarrera);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	/**
	 * Metodo para Listar las carreras
	 */
	
	public ArrayList<Carrera> listar() throws SQLException {
		
		String sql = "SELECT * FROM carreras";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet result = ps.executeQuery();
		
		ArrayList<Carrera> ls = null;
				
		while(result.next()) {
			if(ls == null) {
				ls = new ArrayList<Carrera>();
			}
			ls.add(new Carrera(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
		}	
		return ls;
	}	
	
	/**
	 * Metodo Json que permite obtener todo lo datos de ArrayList listar
	 */
	
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}

}
