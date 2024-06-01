
package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.daoUsuario;

/**
 * Clase para el modelo usuario
 * @author Renaud Bronchart
 * @version 15/05/2024 v1.0
 */

public class Usuario {
	private int id; 
	private String nombre;
	private String apellidos; 
	private String mail;
	private int permiso;
	/**
	 * Constructor para generar un objeto vacio 
	 */
	public Usuario() {
		
	}

	/**
	 * Constructor para generar un objeto desde el formulario sin INT usuario.
	 * @param nombre nombre del Usuario  Atributo tipo texto
	 * @param apellidos apellidos del Usuario Atributo tipo texto
	 * @param mail mail del Usuario Atributo tipo texto
	 * @param permiso permiso del Usuario Atributo tipo numero
	 * 
	 */
	public Usuario(String nombre, String apellidos, String mail,int permiso) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.permiso = permiso;
	} 

	/**
	 * Constructor para generar un objeto desde el formulario con INT usuario.
	 * @param id del Usuario (PK) Atributo numero
	 * @param nombre nombre del Usuario  Atributo tipo texto
	 * @param apellidos apellidos del Usuario Atributo tipo texto
	 * @param mail mail del Usuario Atributo tipo texto
	 * @param permiso permiso del Usuario Atributo tipo numero
	 */
	public Usuario(int id, String nombre,String apellidos, String mail, int permiso) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.permiso = permiso;
	}
	public Usuario(String nombre, String apellidos, String mail) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.permiso = permiso;
	} 
	
	/**
	 * Metodo Para obtener el id del Usuario
	 * @return el id en tipo entero.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo Para establecer el id del Usuario
	 *  @param id  id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo Para obtener el nombre del Usuario
	 * @return el nombre del Usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo Para establecer el nombre del Usuario
	 * @param nombre nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo Para obtener los apellidos del Usuario
	 * @return el nombre del Usuario
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Metodo Para establecer el apellido del Usuario
	 * @param apellidos  apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Metodo Para obtener el mail del Usuario
	 * @return el nombre del Usuario
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * Metodo Para establecer el mail del Usuario
	 * @param mail  mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * Metodo Para obtener el permiso del Usuario
	 * @return el nombre del Usuario
	 */
	public int getPermiso() {
		return permiso;
	}
	/**
	 * Metodo Para establecer el permiso del Usuario
	 * @param permiso  permiso
	 */
	public void setPermiso(int permiso) {
	
		this.permiso = permiso;
	}
	

	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 * @param id objeto Usuario
	 * @throws SQLException Si ocurre un error 
	 */
	public void obtenerPorId(int id) throws SQLException {
		
		daoUsuario dao = new daoUsuario();
		Usuario aux = dao.obtenerPorID(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellidos(aux.getApellidos());
		this.setMail(aux.getMail());
		this.setPermiso(aux.getPermiso());
	}
	/**
	 * Metodo que permite el proceso de login del usuario respecto a un usuario y contrasena 
	 * @param pass pass
	 * @return pass si correcto
	 * @throws SQLException Si ocurre un error 
	 */
	public boolean logeo(String pass) throws SQLException {
		
		boolean ok = false;
				
		daoUsuario dao = new daoUsuario();
		Usuario aux = dao.logear(this, pass); // bd
		
		if(aux != null) {
			ok=true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setApellidos(aux.getApellidos());
			this.setMail(aux.getMail());
			this.setPermiso(aux.getPermiso());
		}	
		return ok;
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
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error 
	 */
	public void actualizar() throws SQLException {
		
		daoUsuario dao = new daoUsuario();
		dao.actualizar(this);
	}
	/**
	 * Metodo que permite insertar el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error 
	 */
	public void insertar() throws SQLException {
		
		daoUsuario dao = new daoUsuario();
		dao.insertar(this);
	}
	
	/**
	 * Metodo que permite borrar el elemento en la base de datos via DAO
	 * @param id id
	 * @throws SQLException Si ocurre un error 
	 */
	public void borrar(int id) throws SQLException {
		daoUsuario dao = new daoUsuario();
		dao.borrar(id);
		
		
	}
	/**
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mail=" + mail + ", permiso=" + permiso
				+ "]";
	} 
	

	

}
