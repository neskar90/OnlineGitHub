package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.daoCarrera;

/**
 * Clase para el Modelo Carrera
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */

/**
 * clase carrera
 * @param ID de la carrera (PK) Atributo numero
 * @param fecha de la carrera Atributo tipo texto
 * @param nombre de la carrera Atributo tipo texto
 * @param ciudad de la carrera Atributo tipo texto
 * @param distancia de la carrera Atributo tipo texto
 * @throws SQLException 
 */
public class Carrera {
	
	private int idCarrera;
	private String fechaCarrera;
	private String nombreCarrera;
	private String ciudadCarrera;
	private String distanciaCarrera;
	
/**
 * Constructor para generar un objeto vacio 
 */

	public Carrera() {
		
	}
/**
 * Constructor para generar un objeto desde el formulario con INT idCarrera.
 * @param ID de la carrera (PK) Atributo numero
 * @param fecha de la carrera Atributo tipo texto
 * @param nombre de la carrera Atributo tipo texto
 * @param ciudad de la carrera Atributo tipo texto
 * @param distancia de la carrera Atributo tipo texto
 */	
	public Carrera(int idCarrera, String fechaCarrera, String nombreCarrera, String ciudadCarrera, String distanciaCarrera) {
		super();
		this.idCarrera = idCarrera;
		this.fechaCarrera = fechaCarrera;
		this.nombreCarrera = nombreCarrera;
		this.ciudadCarrera = ciudadCarrera;
		this.distanciaCarrera = distanciaCarrera;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin INT idCarrera.
	 * @param fecha de la carrera Atributo tipo texto
	 * @param nombre de la carrera Atributo tipo texto
	 * @param ciudad de la carrera Atributo tipo texto
	 * @param distancia de la carrera Atributo tipo texto
	 */	
	public Carrera(String fechaCarrera, String nombreCarrera, String ciudadCarrera, String distanciaCarrera) {
		this.fechaCarrera = fechaCarrera;
		this.nombreCarrera = nombreCarrera;
		this.ciudadCarrera = ciudadCarrera;
		this.distanciaCarrera = distanciaCarrera;
	}
	/**
	 * Metodo Para obtener el id de carrera
	 * @return el id en tipo entero.
	 */
	public int getidCarrera() {
		return idCarrera;
	}
	/**
	 * Metodo Para establecer el id de carrera
	 */
	public void setidCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	/**
	 * Metodo Para obtener la fecha de carrera
	 * @return la fecha de la carrera
	 */

	public String getFechaCarrera() {
		return fechaCarrera;
	}
	/**
	 * Metodo Para establecer la fecha de carrera
	 */
	public void setFechaCarrera(String fechaCarrera) {
		this.fechaCarrera = fechaCarrera;
	}
	/**
	 * Metodo Para obtener el nombre de carrera
	 * @return el nombre de la carrera
	 */
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	/**
	 * Metodo Para establecer el nombre de carrera
	 */
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	/**
	 * Metodo Para obtener la ciudad de carrera
	 * @return la ciudad de la cerrara
	 */
	public String getCiudadCarrera() {
		return ciudadCarrera;
	}
	/**
	 * Metodo Para establecer la ciudad de carrera
	 */
	public void setCiudadCarrera(String ciudadCarrera) {
		this.ciudadCarrera = ciudadCarrera;
	}
	/**
	 * Metodo Para obtener la distancia de carrera
	 * @return la distancia de la carrera
	 */
	public String getDistanciaCarrera() {
		return distanciaCarrera;
	}
	/**
	 * Metodo Para establecer la distancia de carrera
	 */
	public void setDistanciaCarrera(String distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}
	/**
	 * Metodo que inserta el elemento en la base de datos via DAO
	 */
	public void Insertar() throws SQLException {
		daoCarrera dao = new daoCarrera();
		dao.insertar(this);
	}
	/**
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 */
	public void actualizar() throws SQLException {
		daoCarrera dao = new daoCarrera();
		dao.actualizar(this);
	}
	/**
	 * Metodo que permite borrar el elemento en la base de datos via DAO
	 */
	public void borrar(int idCarrera) throws SQLException {
		daoCarrera dao = new daoCarrera();
		dao.borrar(idCarrera);
	}
	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 */
	public void obtenerPorID(int idCarrera) throws SQLException {
		daoCarrera dao = new daoCarrera();
		Carrera aux = dao.obtenerPorID(idCarrera);
		
		this.setidCarrera(aux.getidCarrera());
		this.setFechaCarrera(aux.getFechaCarrera());
		this.setNombreCarrera(aux.getNombreCarrera());
		this.setCiudadCarrera(aux.getCiudadCarrera());
		this.setDistanciaCarrera(aux.getDistanciaCarrera());
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
		return "AnadirCarrera [idCarrera=" + idCarrera + ", fechaCarrera=" + fechaCarrera + ", nombreCarrera=" + nombreCarrera
				+ ", ciudadCarrera=" + ciudadCarrera + ", distanciaCarrera=" + distanciaCarrera + "]";
	}


	
}

