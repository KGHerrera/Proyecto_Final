package vista.empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class ConsultasEmpleados extends VentanaEmpleados implements ActionListener {
	public static JTable tablaEmpleados;

	public ConsultasEmpleados() {

		txtTitulo.setText("Buscar empleado");
		btnEnviar.setText("consultar");
		iconEmpleado = new ImageIcon("src/iconos/consultas.png");
		txtIcono.setIcon(iconEmpleado);

		tablaEmpleados = new JTable();
		configurarTabla(tablaEmpleados, "n");
		
		btnEnviar.setBackground(nPane.getBackground());

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviar) {

			if ((!cajaIdEmpleado.getText().equals("") || !cajaNombre.getText().equals("")
					|| !cajaApellido.getText().equals("") || !cajaCargo.getText().equals("")
					|| !cajaSalario.getText().equals("")) && !cajaSalario.getText().equals(".")) {

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

				VentanaPrincipal.empleadoDAO.setEmpleado(empleado);
				VentanaPrincipal.empleadoDAO.setOpcion(4);

				Thread h1 = new Thread(VentanaPrincipal.empleadoDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "faltan datos");
			}

		} else {
			validacion(e);
		}

		if (e.getSource() == btnVaciar) {
			desactivarCajas();
		}

	}

}
