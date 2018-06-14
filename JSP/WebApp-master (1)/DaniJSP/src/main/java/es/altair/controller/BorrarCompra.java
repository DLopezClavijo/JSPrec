package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.altair.dao.CompraDAO;
import es.altair.dao.CompraDAOImplHibernate;

/**
 * Servlet implementation class BorrarCompra
 */
public class BorrarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entramos en comprar");
		int idArticulo = Integer.parseInt(request.getParameter("id"));

		CompraDAO cDAO = new CompraDAOImplHibernate();
		System.out.println("Vamos a borrar");
		cDAO.borrar(idArticulo); 
		
		System.out.println("Volvemos a la pagina");
		response.sendRedirect("jsp/misCompras.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
