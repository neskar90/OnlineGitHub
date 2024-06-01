/**
 * Provee los servlets necesarios para correr la funcionalidad del controlador de la aplicacion 
 */
/**
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Corredor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import dao.daoCorredor;

/**
 * Servlet implementation class GestionCorredores
 */
public class GestionCorredores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 HttpSession sesion;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCorredores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sesion = request.getSession();
		
		String email = (String) sesion.getAttribute("email");
		if (email != null) { 
			
			PrintWriter out = response.getWriter();
		
			
			int opcion = Integer.parseInt(request.getParameter("op"));
			
			
			if(opcion == 2) {
				
				
				//proceso logica edicion
			
				int id = Integer.parseInt(request.getParameter("id"));
				Corredor co = new Corredor();
				try {
					co.obtenerPorID(id);
					out.print(co.dameJson());
					System.out.println(co.dameJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
			}else if(opcion==1) {
				daoCorredor Corredores;
				try {
					Corredores = new daoCorredor();
					out.print(Corredores.listarJson());
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	
			}else if(opcion==3){
				
					try {
						int id = Integer.parseInt(request.getParameter("id"));
						daoCorredor Corredores = new daoCorredor();
						Corredores.borrar(id);
						out.print(Corredores.listarJson());
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		
		}else {
			System.out.println("error");
			response.sendRedirect("Loginsierror.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> parameters = request.getParameterMap();
		for(String parameter : parameters.keySet()) {
			System.out.println("Parameter num: " + parameter);
			System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
		}
	
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("mail");
		String dni = request.getParameter("dni");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String sexo = request.getParameter("sexo");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String telefono = request.getParameter("telefono");
		String id = request.getParameter("id");
		
		
		Corredor co;
		
		try {
			
			
			co = new Corredor(nombre,apellidos,mail,dni,fechanacimiento,sexo,direccion,ciudad,telefono);
			if(id == "") {
				
			daoCorredor dao = new daoCorredor();	
			dao.insertar(co);
				 
			}else {
				int idInt = Integer.parseInt(id);
				co.setid(idInt);		
				co.actualizar();	
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		response.sendRedirect("index.html");
	
		
	
	}

}
