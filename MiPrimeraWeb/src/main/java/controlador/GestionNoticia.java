package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Noticia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import dao.daoNoticia;

/**
 * Servlet implementation class GestionCorredores
 */
public class GestionNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionNoticia() {
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
		
			int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
			Noticia no = new Noticia();
			try {
				no.obtenerPorID(idNoticia);
				out.print(no.dameJson());
				System.out.println(no.dameJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		}else if(opcion==1) {
			daoNoticia Noticias;
			try {
				Noticias = new daoNoticia();
				out.print(Noticias.listarJson());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		}else if(opcion==3){
			
			try {
				int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
				daoNoticia Noticias = new daoNoticia();
				Noticias.borrar(idNoticia);
				out.print(Noticias.listarJson());
				
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
		
		Map<String,String[]> parameters = request.getParameterMap();
		for(String parameter : parameters.keySet()) {
			System.out.println("Parameter num: " + parameter);
			System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
		}
	
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String idNoticia = request.getParameter("idNoticia");
		
		
		Noticia no;
		
	try {
		
		
		no = new Noticia(titulo,descripcion);
		if(idNoticia == "") {
			
		daoNoticia dao = new daoNoticia();	
		dao.insertar(no);
			
		}else {
			int idNoticiaInt = Integer.parseInt(idNoticia);
			no.setidNoticia(idNoticiaInt);		
			no.actualizar();	
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	response.sendRedirect("ListaNoticiasGestor.html");

	}
	
	

}

