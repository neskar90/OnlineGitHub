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
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.daoUsuario;

/**
 * Servlet implementation class GestionUsuarios
 */
public class GestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		
		int opcion = Integer.parseInt(request.getParameter("op"));
		
		
		if(opcion == 2) {
			//proceso logica edicion
		
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = new Usuario();
			try {
				u.obtenerPorId(id);
				out.print(u.dameJson());
				System.out.println(u.dameJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if(opcion==1) {
			daoUsuario usuarios;
			try {
				
				
				usuarios = new daoUsuario();
				out.print(usuarios.listarJson());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion==3){
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				daoUsuario usuarios = new daoUsuario();
				usuarios.borrar(id);
				out.print(usuarios.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion==4){

			int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
			try {
				daoUsuario daoUsuario = new daoUsuario();

				out.print(daoUsuario.listarJson(tipoUsuario));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("mail");
		int permiso = Integer.parseInt(request.getParameter("permiso"));
		String id = request.getParameter("id");
		
		Usuario u;
		
		try {
			
			u = new Usuario(nombre, mail, apellidos, permiso);
			if(id == "") {
				
				daoUsuario dao = new daoUsuario();
				dao.insertar(u);
				
				
				//u.insertar();
			}else {
				
				int idInt = Integer.parseInt(id);
				u.setId(idInt);		
				u.actualizar();	
				

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			response.sendRedirect("ListaUsuariosGestor.html");
	
		

	}

}
