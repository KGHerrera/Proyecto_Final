package vista.empleados;

import java.awt.event.ActionEvent;

import javax.swing.JTable;

import controlador.EmpleadoDAO;

@SuppressWarnings("serial")
public class AltasEmpleados extends VentanaEmpleados {
	public static JTable tablaAltas;

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
		
		tablaAltas = new JTable();
		alinearTabla(tablaAltas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		validacion(e);
		
		if(e.getSource() == btnEnviar) {
			if (!cajaNombre.getText().equals("")
					&& !cajaApellido.getText().equals("") && !cajaCargo.getText().equals("")
					&& !cajaSalario.getText().equals("")) {
				limpiarObjeto(empleado);
				
				empleado.setNombre(cajaNombre.getText());
				empleado.setApellido(cajaApellido.getText());
				empleado.setSalario(Double.parseDouble(cajaSalario.getText()));
				empleado.setCargo(cajaCargo.getText());
				
				
				EmpleadoDAO empleadoDAO = new EmpleadoDAO();
				empleadoDAO.setEmpleado(empleado);
				empleadoDAO.setOpcion(1);
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
