package vista.empleados;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CambiosEmpleados extends VentanaEmpleados{
	
	public CambiosEmpleados() {
		txtTitulo.setText("Modificar empleado");
		btnEnviar.setText("modificar");
		iconEmpleado = new ImageIcon("src/iconos/cambios.png");
		txtIcono.setIcon(iconEmpleado);
	}
}
