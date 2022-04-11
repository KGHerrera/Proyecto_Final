package vista.ventas;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CambiosVentas extends VentanaVentas {
	public CambiosVentas() {
		txtTitulo.setText("Modificar venta");
		btnEnviar.setText("modificar");
		iconVentas = new ImageIcon("src/iconos/cambiosLibro.png");
		txtIcono.setIcon(iconVentas);
	}
}
