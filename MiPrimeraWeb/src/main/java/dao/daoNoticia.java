package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Noticia;


public class daoNoticia {

	//Patron Singelton aun mejor.
	
	public static Connection con = null;
	
	public daoNoticia() throws SQLException {
		
		this.con = DBConexion.getConexion();
 		
	}
	
	public void insertar(Noticia no) throws SQLException{
		
		String sql = "INSERT INTO noticias (titulo,descripcion) VALUES (?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, no.getTitulo());
		ps.setString(2, no.getDescripcion());
	
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public Noticia obtenerPorID(int idNoticia) throws SQLException {
		String sql = " SELECT * FROM noticias where idNoticia=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idNoticia);
		
		ResultSet result = ps.executeQuery();
		
		result.next();
		
		Noticia no = (new Noticia(result.getInt(1),result.getString(2),result.getString(3)));
		
		return no;
		
	}
	
	public void actualizar(Noticia no) throws SQLException {
		String sql = " UPDATE  noticias SET titulo = ?, descripcion = ? WHERE idNoticia = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, no.getTitulo());
		ps.setString(2, no.getDescripcion());
		ps.setInt(3, no.getidNoticia());

		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public void borrar(int idNoticia) throws SQLException {
		
		String sql = "DELETE FROM noticias WHERE idNoticia=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,idNoticia);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Noticia> listar() throws SQLException {
		String sql = " SELECT * FROM noticias";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();
		
		ArrayList<Noticia> no = null;
		
		while(result.next()) {
			
			if( no== null ) {
				no = new ArrayList<Noticia>();
			}
			
			no.add(new Noticia(result.getInt(1),result.getString(2),result.getString(3)));
		}
		return no;
	}
	

	
	
	public String listarJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}

}
