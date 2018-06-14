package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Libros;
import es.altair.bean.Usuarios;

public interface LibroDAO {

	List<Libros> listaLibro();
	
	byte[] obtenerPortadaPorId(int idLibro);

	void borrar(String uuid);
	
	Libros obtenerLibroPorUUID(String uuid);

	void actualizar(String titulo, String autor, int isbn, float precio, ByteArrayOutputStream os,String uuid, Usuarios usuario);

	void insertar(Libros l);
}
