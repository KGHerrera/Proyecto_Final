package vista.empleados;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ConsultasEmpleados extends VentanaEmpleados {
	
	public ConsultasEmpleados() {
		txtTitulo.setText("Buscar empleado");
		btnEnviar.setText("buscar");
		iconEmpleado = new ImageIcon("src/iconos/consultas.png");
		txtIcono.setIcon(iconEmpleado);
	}
}
