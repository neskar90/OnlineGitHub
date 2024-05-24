package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;
import dao.daoColaborador;

/**
 * Clase para el Modelo Colaborador
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */

/**
 * clase Colaborador
 * @param ID del Colaborador (PK) Atributo numero
 * @param nombre del Colaborador Atributo tipo texto
 * @param apellidos del Colaborador Atributo tipo texto
 * @param puesto del Colaborador Atributo tipo texto
 * @param foto del Colaborador Atributo tipo texto
 * @throws SQLException 
 */
public class Colaborador {

	private int idColaborador;
	private String nombre;
	private String apellidos; 
	private String puesto;
	private String foto;
	
	/**
	 * Constructor para generar un objeto vacio 
	 */
	public Colaborador() {

	}
	/**
	 * Constructor para generar un objeto desde el formulario con INT colaborador.
	 * @param ID del  Colaborador (PK) Atributo numero
	 * @param nombre del Colaborador Atributo tipo texto
	 * @param apellidos del Colaborador Atributo tipo texto
	 * @param puesto del Colaborador Atributo tipo texto
	 * @param foto del Colaborador Atributo tipo texto
	 */
	public Colaborador(int idColaborador, String nombre, String apellidos, String puesto, String foto) {
		super();
		this.idColaborador = idColaborador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.foto = foto;
	}
	public Colaborador(int idColaborador, String nombre, String apellidos, String puesto) {
		super();
		this.idColaborador = idColaborador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin INT colaborador.
	 * @param nombre del Colaborador Atributo tipo texto
	 * @param apellidos del Colaborador Atributo tipo texto
	 * @param puesto del Colaborador Atributo tipo texto
	 * @param foto del Colaborador Atributo tipo texto
	 */
	public Colaborador(String nombre, String apellidos,String puesto,String foto) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.foto = foto;
	}
	public Colaborador(String nombre, String apellidos,String puesto) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
	}
	/**
	 * Metodo Para obtener el id del colaborador
	 * @return el id en tipo entero.
	 */
	public int getidColaborador() {
		return idColaborador;
	}
	/**
	 * Metodo Para establecer el id del colaborador
	 */
	public void setidColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	/**
	 * Metodo Para obtener el nombre del colaborador
	 * @return el nombre del colaborador
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo Para establecer el nombre del colaborador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo Para obtener los apellidos del colaborador
	 * @return el nombre del colaborador
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Metodo Para establecer los apellidos del colaborador
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Metodo Para obtener el puesto del colaborador
	 * @return el nombre del colaborador
	 */
	public String getPuesto() {
		return puesto;
	}
	/**
	 * Metodo Para establecer el puesto del colaborador
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	/**
	 * Metodo Para obtener la foto del colaborador
	 * @return el nombre del colaborador
	 */
	public String getFoto() {
		return foto;
	}
	/**
	 * Metodo Para establecer la foto del colaborador
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	/**
	 * Metodo que inserta el elemento en la base de datos via DAO
	 */
	public void insertar( ) throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.insertar(this);
	}
	/**
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 */
	public void actualizar() throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.actualizar(this);
	}
	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 */
	public void obtenerPorID(int idColaborador) throws SQLException {
		daoColaborador dao = new daoColaborador();
		Colaborador aux = dao.obtenerPorID(idColaborador);

		this.setidColaborador(aux.getidColaborador());
		this.setNombre(aux.getNombre());
		this.setApellidos(aux.getApellidos());
		this.setPuesto(aux.getPuesto());
		this.setFoto(aux.getFoto());
		
	}
	/**
	 * Metodo que permite borrar el elemento en la base de datos via DAO
	 */
	public void borrar(int idColaborador) throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.borrar(idColaborador);
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
		return "Colaborador [idColaborador=" + idColaborador + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", puesto=" + puesto + ", foto=" + foto + "]";
	}

}
