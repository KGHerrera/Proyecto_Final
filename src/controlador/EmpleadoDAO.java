package controlador;

import java.sql.ResultSet;

import conexion.ConexionBD;
import modelo.Empleado;

public class EmpleadoDAO implements Runnable {

	private int opcion;
	private Empleado empleado;
	private ConexionBD con = new ConexionBD();
	private boolean res;

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

	public ConexionBD getCon() {
		return con;
	}

	public boolean altaEmpleado(Empleado e) {
		return con.altaEmpleado(e);
	}

	public boolean bajaEmpleado(Empleado e) {
		return con.bajaEmpleado(e);
	}

	public boolean cambioEmpleado(Empleado e) {
		return con.cambioEmpleado(e);
	}

	public void obtenerConsulta(Empleado e) {
		con.obtenerConsulta(e);
	}

	public void consultar() {
		if (opcion == 1) {
			altaEmpleado(empleado);
		} else if (opcion == 2) {
			bajaEmpleado(empleado);
		} else if (opcion == 3) {
			cambioEmpleado(empleado);
		} else if (opcion == 4) {
			obtenerConsulta(empleado);
		} 
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Empleado buscarEmpleadoID(Empleado e) {
		ResultSet rs = con.consultaEmpleado(e);

		if (rs != null) {
			try {
				rs.next();
				String n = rs.getString(2);
				String ap = rs.getString(3);
				double sa = rs.getDouble(4);
				String c = rs.getString(5);

				e.setNombre(n);
				e.setApellido(ap);
				e.setSalario(sa);
				e.setCargo(c);

				return e;

			} catch (Exception ex) {

			}

		}
		
		e.setNombre(null);
		e.setApellido(null);
		e.setSalario(0.0);
		e.setCargo(null);

		return empleado;
	}

	@Override
	public void run() {
		consultar();
	}

}
