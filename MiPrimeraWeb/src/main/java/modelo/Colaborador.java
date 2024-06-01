package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;
import dao.daoColaborador;


/**
 * Clase para el modelo Colaborador
 * @author Renaud Bronchart
 * @version 15/05/2024 v1.0
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
	 * Constructor para generar un objeto desde el formulario con id colaborador.
	 * @param idColaborador id del  Colaborador (PK) Atributo numero
	 * @param nombre nombre del Colaborador Atributo tipo texto
	 * @param apellidos apellidos del Colaborador Atributo tipo texto
	 * @param puesto puesto del Colaborador Atributo tipo texto
	 * @param foto foto del Colaborador Atributo tipo texto
	 */
	public Colaborador(int idColaborador, String nombre, String apellidos, String puesto, String foto) {
		super();
		this.idColaborador = idColaborador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.foto = foto;
	}
	/**
	 * Constructor para generar un objeto desde el formulario con id colaborador y sin foto.
	 * @param idColaborador id del  Colaborador (PK) Atributo numero
	 * @param nombre nombre del Colaborador Atributo tipo texto
	 * @param apellidos apellidos del Colaborador Atributo tipo texto
	 * @param puesto puesto del Colaborador Atributo tipo texto
	 */
	public Colaborador(int idColaborador, String nombre, String apellidos, String puesto) {
		super();
		this.idColaborador = idColaborador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin id colaborador.
	 * @param nombre nombre del Colaborador Atributo tipo texto
	 * @param apellidos apellidos del Colaborador Atributo tipo texto
	 * @param puesto puesto del Colaborador Atributo tipo texto
	 * @param foto foto del Colaborador Atributo tipo texto
	 */
	public Colaborador(String nombre, String apellidos,String puesto,String foto) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.foto = foto;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin ID colaborador y sin foto.
	 * @param nombre nombre del Colaborador Atributo tipo texto
	 * @param apellidos apellidos del Colaborador Atributo tipo texto
	 * @param puesto puesto del Colaborador Atributo tipo texto
	 */
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
	 *  @param idColaborador  idColaborador
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
	 * @param nombre nombre
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
	 * @param apellidos apellidos
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
	 * @param puesto puesto
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
	 * @param foto foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	/**
	 * Metodo que inserta el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error
	 */
	public void insertar( ) throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.insertar(this);
	}
	/**
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error
	 */
	public void actualizar() throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.actualizar(this);
	}
	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 * @param idColaborador objeto Colaborador
	 * @throws SQLException Si ocurre un error
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
	 * @param idColaborador objeto Colaborador
	 * @throws SQLException Si ocurre un error
	 */
	public void borrar(int idColaborador) throws SQLException {
		daoColaborador dao = new daoColaborador();
		dao.borrar(idColaborador);
	}
	/**
	 * Metodo para devolver Json de tipo String
	 * @return json
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
