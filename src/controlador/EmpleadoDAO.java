package controlador;

import java.sql.ResultSet;

import conexion.ConexionBD;
import modelo.Empleado;

public class EmpleadoDAO extends Thread {

	private int opcion;
	private Empleado empleado;

	public boolean altaEmpleado(Empleado e) {
		return ConexionBD.altaEmpleado(e);
	}

	public boolean bajaEmpleado(Empleado e) {
		return ConexionBD.bajaEmpleado(e);
	}

	public boolean cambioEmpleado(Empleado e) {
		return ConexionBD.cambioEmpleado(e);
	}

	public ResultSet consultaEmpleado(Empleado e) {
		return ConexionBD.consultaEmpleado(e);
	}

	public void consultar() {
		if (opcion == 1) {
			altaEmpleado(empleado);
		} else if (opcion == 2) {
			bajaEmpleado(empleado);
		} else if (opcion == 3) {
			cambioEmpleado(empleado);
		} else if (opcion == 4) {
			consultaEmpleado(empleado);
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

	@Override
	public void run() {
		consultar();
	}

}
