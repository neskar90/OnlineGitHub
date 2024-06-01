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

import dao.daoColaborador;

/**
 * Servlet implementation class GestionColaborador
 */
@MultipartConfig
public class GestionColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles = "C:\\Users\\Renaud\\eclipse-workspace\\MiPrimeraWeb\\src\\main\\webapp\\fotosSubidas";
	private File upload = new File(pathFiles);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionColaborador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		daoColaborador Colaboradores;
		try {
			Colaboradores = new daoColaborador();
			out.print(Colaboradores.listarJson());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

		Part part = request.getPart("foto");	
		
		Path path = Paths.get(part.getSubmittedFileName());//Obtengo la ruta/nombre del archivo
		String FileName = path.getFileName().toString();
	
		
		InputStream input = part.getInputStream();//Preparo el camino para enviar datos
		
		
		File file = new File(upload, FileName);//Creo el contenedor
		

		//Copio los datos del archivo dentro del contenedor utilizando el buffer crado input
		Files.copy(input,file.toPath());
		
		Colaborador co =  new Colaborador(nombre, apellidos, puesto, FileName);

			try {
				co.insertar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("ListaColaboradores.html");
			
		}
	}
	