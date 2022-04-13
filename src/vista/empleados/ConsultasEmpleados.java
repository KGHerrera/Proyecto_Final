package vista.empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import conexion.ConexionBD;
import controlador.EmpleadoDAO;


@SuppressWarnings("serial")
public class ConsultasEmpleados extends VentanaEmpleados implements ActionListener {
	public static JTable tablaConsultas;
	
	public ConsultasEmpleados() {
		txtTitulo.setText("Buscar empleado");
		btnEnviar.setText("buscar");
		iconEmpleado = new ImageIcon("src/iconos/consultas.png");
		txtIcono.setIcon(iconEmpleado);
		tablaConsultas = new JTable();
		alinearTabla(tablaConsultas);
		
		ConexionBD.actualizarTabla();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		validacion(e);

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
