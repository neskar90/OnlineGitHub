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
import modelo.Carrera;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.daoCarrera;

/**
 * Servlet implementation class GestionCarrera
 */
public class GestionCarrera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCarrera() {
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
		
			int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));
			Carrera c = new Carrera();
			try {
				c.obtenerPorID(idCarrera);
				out.print(c.dameJson());
				System.out.println(c.dameJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if(opcion==1) {
			daoCarrera Carreras;
			try {
				Carreras = new daoCarrera();
				out.print(Carreras.listarJson());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion==3){
			
			try {
				int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));
				daoCarrera Carreras = new daoCarrera();
				Carreras.borrar(idCarrera);
				out.print(Carreras.listarJson());
				
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
		
		String fechaCarrera = request.getParameter("fechaCarrera");
		String nombreCarrera = request.getParameter("nombreCarrera");
		String ciudadCarrera = request.getParameter("ciudadCarrera");
		String distanciaCarrera = request.getParameter("distanciaCarrera");
		String idCarrera = request.getParameter("idCarrera");

		Carrera c;
		
		try {
			
			c =  new Carrera(fechaCarrera, nombreCarrera, ciudadCarrera, distanciaCarrera);
			if(idCarrera == "") {
				
				daoCarrera dao = new daoCarrera();
				dao.insertar(c);

		
			}else {
				
				int idCarreraInt = Integer.parseInt(idCarrera);
				c.setidCarrera(idCarreraInt);		
				c.actualizar();	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	response.sendRedirect("ListaCarreraGestor.html");
	}
	
	
}



