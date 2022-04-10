package vista.empleados;

@SuppressWarnings("serial")
public class AltasEmpleados extends VentanaEmpleados {

	public AltasEmpleados() {
		txtTitulo.setText("Agregar Empleados");
		cajaNombre.setEnabled(true);
		cajaApellido.setEnabled(true);
		cajaSalario.setEnabled(true);
		cajaCargo.setEnabled(true);

		checkIdEmpleado.setVisible(false);
		checkNombre.setVisible(false);
		checkApellido.setVisible(false);
		checkSalario.setVisible(false);
		checkCargo.setVisible(false);

		tablaEmpleados.setVisible(false);
		setSize(1366 - 600, 400);

	}
}
