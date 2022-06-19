package vista.ventas;

import java.awt.Color;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class BajasVentas extends VentanaVentas{
	
	public BajasVentas() {
		txtTitulo.setText("Eliminar venta");
		btnEnviar.setText("eliminar");
		iconVentas = new ImageIcon("src/iconos/bajasVenta.png");
		txtIcono.setIcon(iconVentas);
		
		btnActualizar.setVisible(false);
		
		nPane.setBackground(new Color(247, 62, 62));
	}
}
