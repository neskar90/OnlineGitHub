package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.daoNoticia;
/**
 * Clase para el Modelo Noticia
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */
/**
 ** clase noticia
 * @param ID de la noticia (PK) Atributo numero
 * @param titulo de la noticia Atributo tipo texto
 * @param descripcion de la noticia Atributo tipo texto
 * @throws SQLException 
 */
public class Noticia {
	
	private int idNoticia;
	private String titulo;
	private String descripcion;
	
	/**
	 * Constructor para generar un objeto vacio 
	 */

	public Noticia() {	
	}
	/**
	 * Constructor para generar un objeto desde el formulario con INT idNoticia.
	 * @param ID de la noticia (PK) Atributo numero
	 * @param titulo de la noticia Atributo tipo texto
	 * @param descripcion de la noticia Atributo tipo texto
	 */	
	
	public Noticia(int idNoticia, String titulo, String descripcion) {
		super();
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin INT idNoticia.
	 * @param titulo de la noticia Atributo tipo texto
	 * @param descripcion de la noticia Atributo tipo texto
	 */	
	public Noticia(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	/**
	 * Metodo Para obtener el id de Noticia
	 * @return el id en tipo entero.
	 */
	public int getidNoticia() {
		return idNoticia;
	}
	/**
	 * Metodo Para establecer el id de Noticia
	 */
	public void setidNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	/**
	 * Metodo Para obtener el titulo de Noticia
	 * @return el titulo en tipo texto.
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Metodo Para establecer el titulo de Noticia
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Metodo Para obtener la descripcion de la Noticia
	 * @return la descripcion de la noticia en tipo texto
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Metodo Para establecer la descripcion de la Noticia
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Metodo que permite insertar el elemento en la base de datos via DAO
	 */
	public void insertar() throws SQLException {
		daoNoticia dao = new daoNoticia();
		dao.insertar(this);
	}
	/**
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 */
	public void actualizar() throws SQLException {
		daoNoticia dao = new daoNoticia();
		dao.actualizar(this);
	}
	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 */
	public void obtenerPorID(int idNoticia) throws SQLException {
		daoNoticia dao = new daoNoticia();
		Noticia aux = dao.obtenerPorID(idNoticia);
		
		this.setidNoticia(aux.getidNoticia());
		this.setTitulo(aux.getTitulo());
		this.setDescripcion(aux.getDescripcion());
	}
	/**
	 * Metodo que permite borrar el elemento en la base de datos via DAO
	 */
	public void borrar (int idNoticia) throws SQLException {
		daoNoticia dao = new daoNoticia();
		dao.borrar(idNoticia);
	}
	
	/**
	 * Metodo para devolver Json de tipo String
	 */
	public String dameJson() {
		String json = "";
		
		Gson gson = new Gson();
		
		json = gson.toJson(this);
		return json;
		
	}
	/**
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Noticias [idNoticia=" + idNoticia + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}

}