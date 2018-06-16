package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Compras;
import es.altair.bean.Usuarios;
import es.altair.util.SessionProvider;

public class CompraDAOImplHibernate implements CompraDAO {

	public void insertar(Compras c) {
		Session sesion = SessionProvider.getSession();
		
		try {
		System.out.println("entramos en try ");
		sesion.beginTransaction();
		System.out.println("antes de guardar");
		sesion.createSQLQuery("INSERT INTO compra (fecha, cantidad, precio, idUsuario, idLibro) values(:f, :c, :p, :u, :l) ")
			.setParameter("f", c.getFecha())
			.setParameter("c", c.getCantidad())
			.setParameter("p", c.getPrecio())
				.setParameter("u", c.getUsuario().getIdUsuarios())
			.setParameter("a", c.getLibro().getidLibro())
			.executeUpdate();
		
		System.out.println("despues de guardar");
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		
	}

	public List<Compras> listarPorUsu(Usuarios u) {
		List<Compras> compras = new ArrayList<Compras>();
		
		Session sesion = SessionProvider.getSession();
	
		try {
			System.out.println("entramos en try ");
			sesion.beginTransaction();
			System.out.println("antes de guardar");

			compras = sesion.createQuery("FROM Compra c WHERE usuario=:usu")
						.setParameter("usu", u).list();
			
			System.out.println("despues de guardar");
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return compras;
	}

	public void borrar(int idLibro) {
		Session sesion = SessionProvider.getSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.createQuery("DELETE FROM Compra WHERE idcompra=:clave")
					.setParameter("clave", idLibro)
					.executeUpdate();
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
		
	}

}
