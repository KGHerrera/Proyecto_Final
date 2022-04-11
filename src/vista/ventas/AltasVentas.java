package vista.ventas;

@SuppressWarnings("serial")
public class AltasVentas extends VentanaVentas{
public AltasVentas() {
		
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

		tablaVentas.setVisible(false);
		setSize(1366 - 600, 400);
	}
}
