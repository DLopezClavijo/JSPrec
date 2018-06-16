package es.altair.dao;

import java.util.List;

import es.altair.bean.Compras;
import es.altair.bean.Usuarios;

public interface CompraDAO {
	void insertar(Compras c);
	List<Compras> listarPorUsu(Usuarios u);
	void borrar(int idLibro);
}
