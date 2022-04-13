package vista.empleados;

import javax.swing.ImageIcon;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class CambiosEmpleados extends VentanaEmpleados{
	public static JTable tablaCambios;
	
	public CambiosEmpleados() {
		txtTitulo.setText("Modificar empleado");
		btnEnviar.setText("modificar");
		iconEmpleado = new ImageIcon("src/iconos/cambios.png");
		txtIcono.setIcon(iconEmpleado);
		
		tablaCambios = new JTable();
		alinearTabla(tablaCambios);
	}
}
