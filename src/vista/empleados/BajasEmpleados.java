package vista.empleados;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import conexion.ConexionBD;
import controlador.EmpleadoDAO;

@SuppressWarnings("serial")
public class BajasEmpleados extends VentanaEmpleados{
	public static JTable tablaBajas;
	
	public BajasEmpleados() {
		txtTitulo.setText("Eliminar empleado");
		btnEnviar.setText("eliminar");
		iconEmpleado = new ImageIcon("src/iconos/bajas.png");
		txtIcono.setIcon(iconEmpleado);
		
		tablaBajas = new JTable();
		alinearTabla(tablaBajas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		

	}
}
