package vista.empleados;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class AltasEmpleados extends VentanaEmpleados {

	public static JTable tablaEmpleados;

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

		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);
		
		nPane.setBackground(new Color(38, 179, 119));
		btnEnviar.setBackground(nPane.getBackground());

		tablaEmpleados = new JTable();
		configurarTabla(tablaEmpleados, "s");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviar) {
			if (!cajaNombre.getText().equals("") && !cajaApellido.getText().equals("")
					&& !cajaCargo.getText().equals("") && !cajaSalario.getText().equals("")
					&& !cajaSalario.getText().equals(".")) {
				limpiarObjeto(empleado);

				empleado.setNombre(cajaNombre.getText());
				empleado.setApellido(cajaApellido.getText());
				empleado.setSalario(Double.parseDouble(cajaSalario.getText()));
				empleado.setCargo(cajaCargo.getText());

				VentanaPrincipal.empleadoDAO.setEmpleado(empleado);
				VentanaPrincipal.empleadoDAO.setOpcion(1);

				Thread h1 = new Thread(VentanaPrincipal.empleadoDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				if (VentanaPrincipal.empleadoDAO.isRes()) {

					JOptionPane.showMessageDialog(null, "se agrego correctamente");

				} else {
					JOptionPane.showMessageDialog(null, "no se agrego");
				}
				restablecerComponentes(cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo);

			} else {
				JOptionPane.showMessageDialog(null, "faltan datos");
			}
		} else {
			validacion(e);
		}

	}
}
