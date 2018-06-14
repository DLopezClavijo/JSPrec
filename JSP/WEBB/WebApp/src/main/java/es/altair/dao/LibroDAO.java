package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Libro;
import es.altair.bean.Usuario;

public interface LibroDAO {

	List<Libro> listaLibro();
	
	byte[] obtenerPortadaPorId(int idLibro);

	void borrar(String uuid);
	
	Libro obtenerLibroPorUUID(String uuid);

	void actualizar(String titulo, String autor, int isbn, float precio, ByteArrayOutputStream os,String uuid, Usuario usuario);

	void insertar(Libro l);
}
