/**
 * Provee los servlets necesarios para correr la funcionalidad del controlador de la aplicacion 
 */
/**
 * @author: Renaud Bronchart
 * @version: 15/05/2024 v1.0
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Colaborador;
import modelo.Usuario;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import dao.daoCarrera;
import dao.daoColaborador;

/**
 * Servlet implementation class GestionColaboradorEditar
 */
@MultipartConfig
public class GestionColaboradorEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles = "C:\\Users\\Renaud\\eclipse-workspace\\MiPrimeraWeb\\src\\main\\webapp\\fotosSubidas";
	private File upload = new File(pathFiles);
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionColaboradorEditar() {
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
		
			int idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
			Colaborador co = new Colaborador();
			try {
				co.obtenerPorID(idColaborador);
				out.print(co.dameJson());
				System.out.println(co.dameJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion==1) {
			daoColaborador Colaboradores;
			try {
				Colaboradores = new daoColaborador();
				out.print(Colaboradores.listarJson());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion==3){
			
			try {
				int idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
				daoColaborador Colaboradores = new daoColaborador();
				Colaboradores.borrar(idColaborador);
				out.print(Colaboradores.listarJson());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> parameters = request.getParameterMap();
		for(String parameter : parameters.keySet()) {
			System.out.println("Parameter num: " + parameter);
			System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
		}

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String puesto = request.getParameter("puesto");
		String idColaborador = request.getParameter("idColaborador");



		
		Colaborador co;

			try {
				
			co =  new Colaborador(nombre, apellidos, puesto);
				if(idColaborador == "") {
					
					daoColaborador dao = new daoColaborador();
					dao.insertar(co);
				}else {
				int idColaboradorInt = Integer.parseInt(idColaborador);
				co.setidColaborador(idColaboradorInt);		
				co.actualizar();
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			response.sendRedirect("ListaColaboradoresGestor.html");
			
		}
	}
	