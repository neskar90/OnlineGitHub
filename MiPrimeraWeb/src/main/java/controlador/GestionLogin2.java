package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import modelo.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;





/**
 * Servlet implementation class GestionLogin2
 */
public class GestionLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 HttpSession sesion;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionLogin2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String mail = request.getParameter("mail");
		String pass = getMD5(request.getParameter("pass"));
		
		Usuario u = new Usuario();
		u.setMail(mail);
		
		
		//proteccion
		
		try {
			if(u.logeo(pass)) {
				
				sesion = request.getSession();
				
		
				
				sesion.setAttribute("id", u.getId());
				sesion.setAttribute("permiso", u.getPermiso());
				
							
		
				
				if (u.getPermiso() == 9 ) {
				
				response.sendRedirect("GestorPortal.html");
				
				} else if (u.getPermiso() == 1 ) {
					
					response.sendRedirect("index.html");
				}
			
			}else {
				
				response.sendRedirect("Login.html");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	public static String getMD5(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pass.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return pass;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}


