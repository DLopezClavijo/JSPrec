package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="libros") 
public class Libros implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibros;
	private String titulo;
	private String autor;
	private int isbn;
	private byte[] portada;
	private String uuid;
	private float precio;

	@OneToMany(mappedBy="libros")
	private Set<Compras> compras = new HashSet<Compras>();

	public Libros() {
		// TODO Auto-generated constructor stub
	}

	public Libros(String titulo, String autor, int isbn, byte[] portada, String uuid, float precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.portada = portada;
		this.uuid = uuid;
		this.precio = precio;
	}

	public int getidLibros() {
		return idLibros;
	}

	public void setidLibros(int idLibros) {
		this.idLibros = idLibros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public byte[] getPortada() {
		return portada;
	}

	public void setPortada(byte[] portada) {
		this.portada = portada;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "Libro [idLibros=" + idLibros + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", portada="
				+ Arrays.toString(portada) + ", uuid=" + uuid + ", precio=" + precio + ", compras=" + compras + "]";
	}

}
