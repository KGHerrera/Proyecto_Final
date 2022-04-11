package vista.ventas;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class BajasVentas extends VentanaVentas{
	
	public BajasVentas() {
		txtTitulo.setText("Eliminar venta");
		btnEnviar.setText("eliminar");
		iconVentas = new ImageIcon("src/iconos/bajasLibro.png");
		txtIcono.setIcon(iconVentas);
	}
}
