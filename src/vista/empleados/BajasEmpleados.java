package vista.empleados;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BajasEmpleados extends VentanaEmpleados{
	public BajasEmpleados() {
		txtTitulo.setText("Eliminar empleado");
		btnEnviar.setText("eliminar");
		iconEmpleado = new ImageIcon("src/iconos/bajas.png");
		txtIcono.setIcon(iconEmpleado);
	}
}
