package vista;

import java.sql.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class ResultSetTableModel extends AbstractTableModel {
	private Connection conexion;
	private Statement instruccion;
	private ResultSet conjuntoResultados;
	private ResultSetMetaData metaDatos;
	private int numeroDeFilas;

	private boolean conectadoALaBaseDeDatos = false;

	public ResultSetTableModel(String controlador, String url, String consulta)
			throws SQLException, ClassNotFoundException {

		Class.forName(controlador);

		conexion = DriverManager.getConnection(url, "root", "12345");

		instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		conectadoALaBaseDeDatos = true;

		establecerConsulta(consulta);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columna) throws IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		try {
			String nombreClase = metaDatos.getColumnClassName(columna + 1);

			return Class.forName(nombreClase);
		}

		catch (Exception excepcion) {
			excepcion.printStackTrace();
		}

		return Object.class;
	}

	public int getColumnCount() throws IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		try {
			return metaDatos.getColumnCount();
		}

		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}

		return 0;
	}

	public String getColumnName(int columna) throws IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		try {
			return metaDatos.getColumnName(columna + 1);
		}

		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}

		return "";
	}

	public int getRowCount() throws IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		return numeroDeFilas;
	}

	public Object getValueAt(int fila, int columna) throws IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		try {
			conjuntoResultados.absolute(fila + 1);

			return conjuntoResultados.getObject(columna + 1);
		}

		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}

		return "";
	}

	public void establecerConsulta(String consulta) throws SQLException, IllegalStateException {

		if (!conectadoALaBaseDeDatos)
			throw new IllegalStateException("No hay conexion a la base de datos");

		conjuntoResultados = instruccion.executeQuery(consulta);

		metaDatos = conjuntoResultados.getMetaData();

		conjuntoResultados.last();
		numeroDeFilas = conjuntoResultados.getRow();

		fireTableStructureChanged();
	}

	public void desconectarDeLaBaseDeDatos() {

		try {
			instruccion.close();
			conexion.close();
		}

		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}

		finally {
			conectadoALaBaseDeDatos = false;
		}
	}

}

/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and * Prentice Hall. All
 * Rights Reserved. * * DISCLAIMER: The authors and publisher of this book have
 * used their * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs * to
 * determine their effectiveness. The authors and publisher make * no warranty
 * of any kind, expressed or implied, with regard to these * programs or to the
 * documentation contained in these books. The authors * and publisher shall not
 * be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/