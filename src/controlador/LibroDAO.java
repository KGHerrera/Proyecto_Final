package controlador;

import java.sql.ResultSet;

import conexion.ConexionBD;
import modelo.Libro;

public class LibroDAO implements Runnable {

	private int opcion;
	private Libro libro;
	private boolean res;

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public boolean isRes() {
		return res;
	}


	public boolean altaLibro(Libro e) {
		res = ConexionBD.altaLibro(e);
		return res;
	}

	public boolean bajaLibro(Libro e) {
		return ConexionBD.bajaLibro(e);
	}

	public boolean cambioLibro(Libro e) {
		res = ConexionBD.cambioLibro(e);
		return res;
	}

	public void obtenerConsulta(Libro e) {
		ConexionBD.obtenerConsultaLibros(e);
	}
	
	public void actualizarTabla() {
		ConexionBD.actualizarTablaLibros();
	}

	public void consultar() {
		if (opcion == 1)
			altaLibro(libro);
		else if (opcion == 2)
			bajaLibro(libro);
		else if (opcion == 3)
			cambioLibro(libro);
		else if (opcion == 4)
			obtenerConsulta(libro);

	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Libro buscarLibroID(Libro e) {
		ResultSet rs = ConexionBD.consultaLibro(e);

		if (rs != null) {
			try {
				rs.next();
				String n = rs.getString(2);
				String ap = rs.getString(3);
				int sa = rs.getInt(4);
				double c = rs.getDouble(5);

				e.setNombre(n);
				e.setAutor(ap);
				e.setStock(sa);
				e.setPrecio(c);

				return e;

			} catch (Exception ex) {

			}

		}

		e.setNombre(null);
		e.setAutor(null);
		e.setStock(0);
		e.setPrecio(0.0);

		return e;
	}

	@Override
	public void run() {
		consultar();
	}

}