package vista.ventas;

import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CambiosVentas extends VentanaVentas {
	public CambiosVentas() {
		txtTitulo.setText("Modificar venta");
		btnEnviar.setText("modificar");
		iconVentas = new ImageIcon("src/iconos/cambiosVenta.png");
		txtIcono.setIcon(iconVentas);
		
		btnActualizar.setVisible(false);
		
		checkIdVenta.setVisible(false);
		checkCantidadLibros.setVisible(false);
		checkTotalPagar.setVisible(false);
		checkIdLibro.setVisible(false);
		checkIdEmpleado.setVisible(false);
		
		cajaCantidadLibros.setEnabled(true);
		cajaTotalPagar.setEnabled(true);
		cajaIdLibro.setEnabled(true);
		cajaIdEmpleado.setEnabled(true);
		cajaIdVentas.setEnabled(true);
		
		nPane.setBackground(new Color(240, 152, 46));
	}
}
