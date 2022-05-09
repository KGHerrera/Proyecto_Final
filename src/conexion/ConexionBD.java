package conexion;

import modelo.Usuario;
import modelo.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vista.ResultSetTableModel;
import vista.empleados.AltasEmpleados;
import vista.empleados.BajasEmpleados;
import vista.empleados.CambiosEmpleados;
import vista.empleados.ConsultasEmpleados;

public class ConexionBD {

	private Connection conexion = null;
	private PreparedStatement pstm;
	private ResultSet rs;

	public ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/libreria";
			conexion = DriverManager.getConnection(URL, "root", "12345");

		} catch (ClassNotFoundException e) {

			System.out.println("Error de DRIVER");

		} catch (SQLException e) {

			System.out.println("Error de conexion en MySQL");

		}
	}

	public Connection getConexion() {
		if (conexion == null) {
			new ConexionBD();
		}
		return conexion;
	}

	public void cerrarConexion() {
		try {
			pstm.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}

	public ResultSet consultarUsuario(Usuario u) {
		try {
			String consulta = "select * from usuarios where usuario=? AND contrasenia=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setString(1, u.getUsuario());
			pstm.setString(2, u.getContrasenia());

			rs = pstm.executeQuery();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return rs;
	}

	public boolean altaEmpleado(Empleado e) {
		try {

			String filtro = "insert into empleados values (null,?,?,?,?)";
			pstm = conexion.prepareStatement(filtro);

			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setDouble(3, e.getSalario());
			pstm.setString(4, e.getCargo());
			pstm.executeUpdate();

			actualizarTabla();

			return true;

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return false;
	}

	public boolean bajaEmpleado(Empleado e) {
		try {
			String consulta = "delete from empleados where ";
			int pos = 1;
			consulta += generarConsultaEmpleado(e);

			pstm = conexion.prepareStatement(consulta);

			if (e.getIdEmpleado() != 0) {
				pstm.setInt(pos, e.getIdEmpleado());
				pos++;
			}

			if (e.getNombre() != null) {
				pstm.setString(pos, e.getNombre());
				pos++;
			}

			if (e.getApellido() != null) {
				pstm.setString(pos, e.getApellido());
				pos++;
			}

			if (e.getSalario() != 0.0) {
				pstm.setDouble(pos, e.getSalario());
				pos++;
			}

			if (e.getCargo() != null) {
				pstm.setString(pos, e.getCargo());
				pos++;
			}

			pstm.executeUpdate();

			actualizarTabla();

			return true;

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return false;
	}

	public boolean cambioEmpleado(Empleado e) {

		try {
			String consulta = "update empleados set nombre=?, apellido=?, salario=?, cargo=? WHERE id_empleado=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setDouble(3, e.getSalario());
			pstm.setString(4, e.getCargo());
			pstm.setInt(5, e.getIdEmpleado());
			pstm.executeUpdate();

			actualizarTabla();
			return true;

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return false;
	}

	public void obtenerConsulta(Empleado empleado) {

		ResultSetTableModel modeloDatos = null;
		String consulta = "select * from empleados where ";
		consulta += generarConsultaEmpleadoModel(empleado);

		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/libreria",
					consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConsultasEmpleados.tablaEmpleados.setModel(modeloDatos);

	}

	public ResultSet consultaEmpleado(Empleado e) {

		try {
			String consulta = "select * from empleados where id_empleado=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setInt(1, e.getIdEmpleado());
			rs = pstm.executeQuery();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return rs;
	}

	public String generarConsultaEmpleado(Empleado e) {

		String consulta = "";
		if (e.getIdEmpleado() != 0) {
			consulta += "id_empleado=? and ";
		}

		if (e.getNombre() != null) {
			consulta += "nombre=? and ";
		}

		if (e.getApellido() != null) {
			consulta += "apellido=? and ";
		}

		if (e.getSalario() != 0.0) {
			consulta += "salario=? and ";
		}

		if (e.getCargo() != null) {
			consulta += "cargo=? and ";
		}

		if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and ")))
			consulta = consulta.substring(0, consulta.length() - 4);

		return consulta;
	}

	public String generarConsultaEmpleadoModel(Empleado e) {

		String consulta = "";
		if (e.getIdEmpleado() != 0) {
			consulta += "id_empleado='" + e.getIdEmpleado() + "' and ";
		}

		if (e.getNombre() != null) {
			consulta += "nombre='" + e.getNombre() + "' and ";
		}

		if (e.getApellido() != null) {
			consulta += "apellido='" + e.getApellido() + "' and ";
		}

		if (e.getSalario() != 0.0) {
			consulta += "salario='" + e.getSalario() + "' and ";
		}

		if (e.getCargo() != null) {
			consulta += "cargo='" + e.getCargo() + "' and ";
		}

		if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and ")))
			consulta = consulta.substring(0, consulta.length() - 4);

		return consulta;
	}

	public void actualizarTabla() {
		String consulta;
		consulta = "SELECT * FROM empleados";

		ResultSetTableModel modeloDatos = null;

		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/libreria",
					consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		AltasEmpleados.tablaEmpleados.setModel(modeloDatos);
		ConsultasEmpleados.tablaEmpleados.setModel(modeloDatos);
		CambiosEmpleados.tablaEmpleados.setModel(modeloDatos);
		BajasEmpleados.tablaEmpleados.setModel(modeloDatos);
	}

}
