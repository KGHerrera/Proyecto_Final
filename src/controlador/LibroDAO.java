package controlador;

import java.sql.ResultSet;

import conexion.ConexionBD;
import modelo.Libro;
import vista.VentanaPrincipal;

public class LibroDAO implements Runnable {

	private int opcion;
	private Libro libro;
	private ConexionBD con = VentanaPrincipal.empleadoDAO.getCon();
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

	public void setRes(boolean res) {
		this.res = res;
	}

	public ConexionBD getCon() {
		return con;
	}

	public boolean altaLibro(Libro e) {
		return con.altaLibro(e);
	}

	/*
	public boolean bajaEmpleado(Empleado e) {
		return con.bajaEmpleado(e);
	}

	public boolean cambioEmpleado(Empleado e) {
		return con.cambioEmpleado(e);
	}

	public void obtenerConsulta(Empleado e) {
		con.obtenerConsulta(e);
	}
	*/

	public void consultar() {
		if (opcion == 1) {
			altaLibro(libro);
		}
		/*
		} else if (opcion == 2) {
			bajaEmpleado(empleado);
		} else if (opcion == 3) {
			cambioEmpleado(empleado);
		} else if (opcion == 4) {
			obtenerConsulta(empleado);
		} */
	}

	

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Libro buscarEmpleadoID(Libro e) {
		ResultSet rs = con.consultaLibro(e);

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