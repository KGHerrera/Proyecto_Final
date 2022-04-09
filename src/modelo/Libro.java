package modelo;

public class Libro {
	private int idLibro;
	private String nombre;
	private String autor;
	private int stock;
	private double precio;

	public Libro(int idLibro, String nombre, String autor, int stock, double precio) {
		super();
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.autor = autor;
		this.stock = stock;
		this.precio = precio;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", nombre=" + nombre + ", autor=" + autor + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}

}
