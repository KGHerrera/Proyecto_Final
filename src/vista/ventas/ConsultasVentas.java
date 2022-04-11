package vista.ventas;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ConsultasVentas extends VentanaVentas{
	public ConsultasVentas() {
		txtTitulo.setText("Buscar venta");
		btnEnviar.setText("buscar");
		iconVentas = new ImageIcon("src/iconos/consultasVenta.png");
		txtIcono.setIcon(iconVentas);
	}
}
