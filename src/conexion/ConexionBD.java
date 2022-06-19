package conexion;

import modelo.Usuario;
import modelo.Empleado;
import modelo.Libro;

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
import vista.libros.AltasLibros;
import vista.libros.BajasLibros;
import vista.libros.CambiosLibros;
import vista.libros.ConsultasLibros;

public class ConexionBD {

	private static Connection conexion = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;

	private ConexionBD() {
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

	public static Connection getConexion() {
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
			//e.printStackTrace();
		}
	}

	public static ResultSet consultarUsuario(Usuario u) {
		try {
			String consulta = "select * from usuarios where usuario=? AND contrasenia=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setString(1, u.getUsuario());
			pstm.setString(2, u.getContrasenia());

			rs = pstm.executeQuery();

		} catch (Exception ex) {
			//System.out.println(ex.toString());
		}

		return rs;
	}

	public static boolean altaEmpleado(Empleado e) {
		int res = 0;
		try {

			String filtro = "insert into empleados values (null,?,?,?,?)";
			pstm = conexion.prepareStatement(filtro);

			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setDouble(3, e.getSalario());
			pstm.setString(4, e.getCargo());
			res = pstm.executeUpdate();		

		} catch (SQLException error) {
			res = 0;
			//error.printStackTrace();
		}
		
		if (res != 0) return true; 
		else return false;
	
	}

	public static boolean bajaEmpleado(Empleado e) {
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

			int res = pstm.executeUpdate();

			if (res!= 0) return true; 
			else return false;
			

		} catch (Exception ex) {
			//System.out.println(ex.toString());
		}
		return false;
	}

	public static boolean cambioEmpleado(Empleado e) {
		int res = 0;
		try {
			String consulta = "update empleados set nombre=?, apellido=?, salario=?, cargo=? WHERE id_empleado=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setDouble(3, e.getSalario());
			pstm.setString(4, e.getCargo());
			pstm.setInt(5, e.getIdEmpleado());
			
			res = pstm.executeUpdate();

		} catch (Exception ex) {
			res = 0;
			//System.out.println(ex.toString());
		}
		
		if (res!= 0) return true; 
		else return false;
	}

	public static void obtenerConsulta(Empleado empleado) {

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

	public static ResultSet consultaEmpleado(Empleado e) {

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

	public static String generarConsultaEmpleado(Empleado e) {

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

	public static String generarConsultaEmpleadoModel(Empleado e) {

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

	public static void actualizarTabla() {
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

	public static boolean altaLibro(Libro e) {
		try {

			String filtro = "insert into libros values (null,?,?,?,?)";
			pstm = conexion.prepareStatement(filtro);

			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getAutor());
			pstm.setInt(3, e.getStock());
			pstm.setDouble(4, e.getPrecio());
			int res = pstm.executeUpdate();

			actualizarTablaLibros();

			if (res!= 0) return true; 
			else return false;

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return false;
	}

	public static boolean bajaLibro(Libro e) {
		try {
			String consulta = "delete from libros where ";
			int pos = 1;
			consulta += generarConsultaLibro(e);

			pstm = conexion.prepareStatement(consulta);

			if (e.getIdLibro() != 0) {
				pstm.setInt(pos, e.getIdLibro());
				pos++;
			}

			if (e.getNombre() != null) {
				pstm.setString(pos, e.getNombre());
				pos++;
			}

			if (e.getAutor() != null) {
				pstm.setString(pos, e.getAutor());
				pos++;
			}

			if (e.getStock() != 0) {
				pstm.setInt(pos, e.getStock());
				pos++;
			}

			if (e.getPrecio() != 0.0) {
				pstm.setDouble(pos, e.getPrecio());
				pos++;
			}

			int res = pstm.executeUpdate();

			actualizarTablaLibros();

			if (res!= 0) return true; 
			else return false;

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public static boolean cambioLibro(Libro e) {

		try {
			String consulta = "update libros set nombre=?, autor=?, stock=?, precio=? WHERE id_libro=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getAutor());
			pstm.setInt(3, e.getStock());
			pstm.setDouble(4, e.getPrecio());
			pstm.setInt(5, e.getIdLibro());
			int res = pstm.executeUpdate();

			actualizarTablaLibros();
			
			if (res!= 0) return true; 
			else return false;

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public static void obtenerConsultaLibros(Libro libro) {

		ResultSetTableModel modeloDatos = null;
		String consulta = "select * from libros where ";
		consulta += generarConsultaLibroModel(libro);

		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/libreria",
					consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConsultasLibros.tablaLibros.setModel(modeloDatos);

	}

	public static String generarConsultaLibro(Libro e) {

		String consulta = "";
		if (e.getIdLibro() != 0) {
			consulta += "id_libro=? and ";
		}

		if (e.getNombre() != null) {
			consulta += "nombre=? and ";
		}

		if (e.getAutor() != null) {
			consulta += "autor=? and ";
		}

		if (e.getStock() != 0) {
			consulta += "stock=? and ";
		}

		if (e.getPrecio() != 0.0) {
			consulta += "precio=? and ";
		}

		if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and ")))
			consulta = consulta.substring(0, consulta.length() - 4);

		return consulta;
	}

	public static void actualizarTablaLibros() {
		String consulta;
		consulta = "SELECT * FROM libros";

		ResultSetTableModel modeloDatos = null;

		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/libreria",
					consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		AltasLibros.tablaLibros.setModel(modeloDatos);
		BajasLibros.tablaLibros.setModel(modeloDatos);
		CambiosLibros.tablaLibros.setModel(modeloDatos);
		ConsultasLibros.tablaLibros.setModel(modeloDatos);

	}

	public static ResultSet consultaLibro(Libro e) {

		try {
			String consulta = "select * from libros where id_libro=?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setInt(1, e.getIdLibro());
			rs = pstm.executeQuery();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return rs;
	}
	
	public static String generarConsultaLibroModel(Libro e) {

		String consulta = "";
		if (e.getIdLibro() != 0) {
			consulta += "id_libro='" + e.getIdLibro() + "' and ";
		}

		if (e.getNombre() != null) {
			consulta += "nombre='" + e.getNombre() + "' and ";
		}

		if (e.getAutor() != null) {
			consulta += "autor='" + e.getAutor() + "' and ";
		}

		if (e.getStock() != 0) {
			consulta += "stock='" + e.getStock() + "' and ";
		}

		if (e.getPrecio() != 0.0) {
			consulta += "precio='" + e.getPrecio() + "' and ";
		}

		if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and ")))
			consulta = consulta.substring(0, consulta.length() - 4);

		return consulta;
	}

}
