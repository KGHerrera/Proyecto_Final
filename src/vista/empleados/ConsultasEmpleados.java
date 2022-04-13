package vista.empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import conexion.ConexionBD;
import controlador.EmpleadoDAO;


@SuppressWarnings("serial")
public class ConsultasEmpleados extends VentanaEmpleados implements ActionListener {

	public ConsultasEmpleados() {
		txtTitulo.setText("Buscar empleado");
		btnEnviar.setText("buscar");
		iconEmpleado = new ImageIcon("src/iconos/consultas.png");
		txtIcono.setIcon(iconEmpleado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVaciar) {
			restablecerComponentes(cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo);
		}

		else if (e.getSource() == checkIdEmpleado) {
			if (checkIdEmpleado.isSelected())
				cajaIdEmpleado.setEnabled(true);
			else {
				cajaIdEmpleado.setEnabled(false);
				cajaIdEmpleado.setText("");
			}
		}

		else if (e.getSource() == checkNombre) {
			if (checkNombre.isSelected())
				cajaNombre.setEnabled(true);
			else {
				cajaNombre.setEnabled(false);
				cajaNombre.setText("");
			}
		}

		else if (e.getSource() == checkApellido) {
			if (checkApellido.isSelected())
				cajaApellido.setEnabled(true);
			else {
				cajaApellido.setEnabled(false);
				cajaApellido.setText("");
			}
		}

		else if (e.getSource() == checkSalario) {
			if (checkSalario.isSelected())
				cajaSalario.setEnabled(true);
			else {
				cajaSalario.setEnabled(false);
				cajaSalario.setText("");
			}
		}

		else if (e.getSource() == checkCargo) {
			if (checkCargo.isSelected())
				cajaCargo.setEnabled(true);
			else {
				cajaCargo.setEnabled(false);
				cajaCargo.setText("");
			}
		}

		if (e.getSource() == btnEnviar) {

			if (!cajaIdEmpleado.getText().equals("") || !cajaNombre.getText().equals("")
					|| !cajaApellido.getText().equals("") || !cajaCargo.getText().equals("")
					|| !cajaSalario.getText().equals("")) {
				
				
				limpiarObjeto(empleado);
				
				if (!cajaIdEmpleado.getText().equals("")){
					empleado.setIdEmpleado(Integer.parseInt(cajaIdEmpleado.getText()));
				}
				
				if (!cajaNombre.getText().equals("")){
					empleado.setNombre(cajaNombre.getText());
				}
				
				if (!cajaApellido.getText().equals("")){
					empleado.setApellido(cajaApellido.getText());
				}
				
				if (!cajaSalario.getText().equals("")){
					empleado.setSalario(Double.parseDouble(cajaSalario.getText()));
				}
				
				if (!cajaCargo.getText().equals("")){
					empleado.setCargo(cajaCargo.getText());
				}
				
				ConexionBD.getConexion();
				EmpleadoDAO empleadoDAO = new EmpleadoDAO();
				empleadoDAO.setEmpleado(empleado);
				empleadoDAO.setOpcion(4);
				empleadoDAO.start();
				
				try {
					empleadoDAO.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			} 

		}

	}

}
