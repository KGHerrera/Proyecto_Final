package vista.empleados;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import conexion.ConexionBD;
import controlador.EmpleadoDAO;

@SuppressWarnings("serial")
public class CambiosEmpleados extends VentanaEmpleados {
	public static JTable tablaCambios;

	public CambiosEmpleados() {
		txtTitulo.setText("Modificar empleado");
		btnEnviar.setText("modificar");
		iconEmpleado = new ImageIcon("src/iconos/cambios.png");
		
		cajaIdEmpleado.setEnabled(true);
		cajaNombre.setEnabled(true);
		cajaApellido.setEnabled(true);
		cajaSalario.setEnabled(true);
		cajaCargo.setEnabled(true);

		checkIdEmpleado.setVisible(false);
		checkNombre.setVisible(false);
		checkApellido.setVisible(false);
		checkSalario.setVisible(false);
		checkCargo.setVisible(false);

		tablaCambios = new JTable();
		alinearTabla(tablaCambios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		validacion(e);
		
		if (e.getSource() == btnVaciar) {
			restablecerComponentes(cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo);
		}

		if (e.getSource() == btnEnviar) {
			if (!cajaIdEmpleado.getText().equals("") && !cajaNombre.getText().equals("") && !cajaApellido.getText().equals("")
					&& !cajaCargo.getText().equals("") && !cajaSalario.getText().equals("")) {
				limpiarObjeto(empleado);
				
				empleado.setIdEmpleado(Integer.parseInt(cajaIdEmpleado.getText()));
				empleado.setNombre(cajaNombre.getText());
				empleado.setApellido(cajaApellido.getText());
				empleado.setSalario(Double.parseDouble(cajaSalario.getText()));
				empleado.setCargo(cajaCargo.getText());

				ConexionBD.getConexion();
				EmpleadoDAO empleadoDAO = new EmpleadoDAO();
				empleadoDAO.setEmpleado(empleado);
				empleadoDAO.setOpcion(3);
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
