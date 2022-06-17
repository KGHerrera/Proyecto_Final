package vista.empleados;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class BajasEmpleados extends VentanaEmpleados {

	public static JTable tablaEmpleados;

	public BajasEmpleados() {
		txtTitulo.setText("Eliminar empleado");
		btnEnviar.setText("eliminar");
		iconEmpleado = new ImageIcon("src/iconos/bajas.png");
		txtIcono.setIcon(iconEmpleado);
		btnActualizar.setVisible(false);

		BajasEmpleados.tablaEmpleados = new JTable();
		configurarTabla(BajasEmpleados.tablaEmpleados, "n");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

				VentanaPrincipal.empleadoDAO.setEmpleado(empleado);
				VentanaPrincipal.empleadoDAO.setOpcion(2);

				Thread h1 = new Thread(VentanaPrincipal.empleadoDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				if(VentanaPrincipal.empleadoDAO.isRes()) {
					
					
					JOptionPane.showMessageDialog(null, "se elimino correctamente");
					restablecerComponentes(cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo);
					desactivarCajas();
				} else {
					JOptionPane.showMessageDialog(null, "no se elimino");
				}

			} else {
				JOptionPane.showMessageDialog(null, "agrega un dato");
			}
		} else {
			validacion(e);
		}
		
		if(e.getSource() == btnVaciar) {
			desactivarCajas();
		}

	}
}
