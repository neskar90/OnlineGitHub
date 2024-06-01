package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.daoCorredor;

/**
 * Clase para el modelo Corredor
 * @author Renaud Bronchart
 * @version 15/05/2024 v1.0
 */
public class Corredor {
	private int id;
	private String  nombre;
	private String  apellidos; 
	private String  mail;
	private String  dni;
	private String  fechanacimiento;
	private String  sexo;
	private String  direccion;
	private String  ciudad;
	private String telefono;
	
	/**
	 * Constructor para generar un objeto vacio 
	 */
	
	public Corredor() {
		
	}
	/**
	 * Constructor para generar un objeto desde el formulario con INT ID.
	 * @param id id del corredor (PK) Atributo numero
	 * @param nombre nombre del corredor Atributo tipo texto
	 * @param apellidos apellidos del corredor Atributo tipo texto
	 * @param mail mail del corredor Atributo tipo texto
	 * @param dni dni del corredor Atributo tipo texto
	 * @param fechanacimiento fechanacimiento del corredor Atributo tipo texto
	 * @param sexo sexo del corredor Atributo tipo texto
	 * @param direccion direccion del corredor Atributo tipo texto
	 * @param ciudad ciudad del corredor Atributo tipo texto
	 * @param telefono telefono  del corredor Atributo tipo texto
	 */
	public Corredor(int id, String nombre, String apellidos, String mail, String dni, String fechanacimiento, String sexo,
			String direccion, String ciudad, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}
	/**
	 * Constructor para generar un objeto desde el formulario sin INT ID.
	 * @param nombre nombre del corredor Atributo tipo texto
	 * @param apellidos apellidos del corredor Atributo tipo texto
	 * @param mail mail del corredor Atributo tipo texto
	 * @param dni dni del corredor Atributo tipo texto
	 * @param fechanacimiento fechanacimiento del corredor Atributo tipo texto
	 * @param sexo sexo del corredor Atributo tipo texto
	 * @param direccion direccion del corredor Atributo tipo texto
	 * @param ciudad ciudad del corredor Atributo tipo texto
	 * @param telefono telefono  del corredor Atributo tipo texto
	 */
	public Corredor(String nombre, String apellidos, String mail, String dni, String fechanacimiento, String sexo,
			String direccion, String ciudad, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}
	/**
	 * Metodo Para obtener el id del corredor
	 * @return el id en tipo entero.
	 */
	public int getid() {
		return id;
	}
	/**
	 * Metodo Para establecer el id del corredor
	 * @param id  id
	 */
	public void setid(int id) {
		this.id = id;
	}
	/**
	 * Metodo Para obtener el nombre del corredor
	 * @return el nombre del corredor
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo Para establecer el nombre del corredor
	 * @param nombre  nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo Para obtener el  apellido del corredor
	 * @return el apellido del corredor
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Metodo Para establecer el  apellido del corredor
	 * @param apellidos  apellidos
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Metodo Para obtener el mail del corredor
	 * @return el mail del corredor
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * Metodo Para establecer el mail del corredor
	 * @param mail  mail
	 */
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * Metodo Para obtener el DNI del corredor
	 * @return obtener el DNI del corredor
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Metodo Para establecer el DNI del corredor
	 * @param dni  dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Metodo Para obtener la fecha de nacimiento del corredor
	 * @return la fecha de nacimiento del corredor
	 */
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	/**
	 * Metodo Para establecer la fecha de nacimiento del corredor
	 * @param fechanacimiento  fechanacimiento
	 */
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	/**
	 * Metodo Para obtener el sexo del corredor
	 * @return el sexo del corredor
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Metodo Para establecer el sexo del corredor
	 * @param sexo  sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Metodo Para obtener la direccion del corredor
	 * @return la direccion del corredor
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo Para establecer la direccion del corredor
	 * @param direccion  direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo Para obtener la ciudad del corredor
	 * @return la ciudad del corredor
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * Metodo Para establecer la ciudad del corredor
	 * @param ciudad  ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * Metodo Para obtener el telefono del corredor
	 * @return el telefono del corredor
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo Para establecer el telefono del corredor
	 * @param telefono  telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo que inserta el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error 
	 */
	public void insertar() throws SQLException {
		daoCorredor dao = new daoCorredor();
		dao.insertar(this);
	}
	/**
	 * Metodo que permite actualizar el elemento en la base de datos via DAO
	 * @throws SQLException Si ocurre un error 
	 */
	public void actualizar() throws SQLException {
	daoCorredor dao = new daoCorredor();
	dao.actualizar(this);
	}
	/**
	 * Metodo que permite obtener un ID del elemento en la base de datos via DAO
	 * @param id objeto corredor
	 * @throws SQLException Si ocurre un error 
	 * 
	 */
	
	public void obtenerPorID(int id) throws SQLException {
		daoCorredor dao = new daoCorredor();
		Corredor aux = dao.obtenerPorID(id);
		
		this.setid(aux.getid());
		this.setApellidos(aux.getApellidos());
		this.setMail(aux.getMail());
		this.setDni(aux.getDni());
		this.setFechanacimiento(aux.getFechanacimiento());
		this.setSexo(aux.getSexo());
		this.setDireccion(aux.getDireccion());
		this.setCiudad(aux.getCiudad());
		this.setTelefono(aux.getTelefono());
	}
	/**
	 * Metodo que permite borrar el elemento en la base de datos via DAO
	 * @param id objeto corredor
	 * @throws SQLException Si ocurre un error 
	 */
	public void borrar (int id) throws SQLException {
	daoCorredor dao = new daoCorredor();
	dao.borrar(id);
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
		return "Corredor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mail=" + mail + ", dni="
				+ dni + ", fechanacimiento=" + fechanacimiento + ", sexo=" + sexo + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", telefono=" + telefono + "]";
	}

	
	
}
