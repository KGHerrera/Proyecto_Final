package vista.ventas;

import java.awt.Color;


@SuppressWarnings("serial")
public class AltasVentas extends VentanaVentas {
	public AltasVentas() {

		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);
		txtTitulo.setText("Agregar venta");
		cajaCantidadLibros.setEnabled(true);
		cajaTotalPagar.setEnabled(false);
		cajaIdLibro.setEnabled(true);
		cajaIdEmpleado.setEnabled(true);

		checkIdVenta.setVisible(false);
		checkCantidadLibros.setVisible(false);
		checkTotalPagar.setVisible(false);
		checkIdLibro.setVisible(false);
		checkIdEmpleado.setVisible(false);
		
		nPane.setBackground(new Color(38, 179, 119));

	}
}
