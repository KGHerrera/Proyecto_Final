package vista.empleados;

import java.awt.event.ActionEvent;


import javax.swing.ImageIcon;
import javax.swing.JTable;

import controlador.EmpleadoDAO;

@SuppressWarnings("serial")
public class BajasEmpleados extends VentanaEmpleados {

	public static JTable tablaEmpleados;

	public BajasEmpleados() {
		txtTitulo.setText("Eliminar empleado");
		btnEnviar.setText("eliminar");
		iconEmpleado = new ImageIcon("src/iconos/bajas.png");
		txtIcono.setIcon(iconEmpleado);

		BajasEmpleados.tablaEmpleados = new JTable();
		configurarTabla(BajasEmpleados.tablaEmpleados, "n");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validacion(e);

		if (e.getSource() == btnEnviar) {
			if (!cajaIdEmpleado.getText().equals("") || !cajaNombre.getText().equals("")
					|| !cajaApellido.getText().equals("") || !cajaCargo.getText().equals("")
					|| !cajaSalario.getText().equals("")) {

				limpiarObjeto(empleado);

				if (!cajaIdEmpleado.getText().equals("")) {
					empleado.setIdEmpleado(Integer.parseInt(cajaIdEmpleado.getText()));
				}

				if (!cajaNombre.getText().equals("")) {
					empleado.setNombre(cajaNombre.getText());
				}

				if (!cajaApellido.getText().equals("")) {
					empleado.setApellido(cajaApellido.getText());
				}

				if (!cajaSalario.getText().equals("")) {
					empleado.setSalario(Double.parseDouble(cajaSalario.getText()));
				}

				if (!cajaCargo.getText().equals("")) {
					empleado.setCargo(cajaCargo.getText());
				}

				EmpleadoDAO empleadoDAO = new EmpleadoDAO();
				empleadoDAO.setEmpleado(empleado);
				empleadoDAO.setOpcion(2);
				empleadoDAO.start();

				try {
					empleadoDAO.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
