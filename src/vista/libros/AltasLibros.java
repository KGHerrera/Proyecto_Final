package vista.libros;

@SuppressWarnings("serial")
public class AltasLibros extends VentanaLibros{
	public AltasLibros() {
		
		txtTitulo.setText("Agregar libro");
		cajaNombre.setEnabled(true);
		cajaAutor.setEnabled(true);
		cajaPrecio.setEnabled(true);
		cajaStock.setEnabled(true);

		checkIdLibro.setVisible(false);
		checkNombre.setVisible(false);
		checkAutor.setVisible(false);
		checkPrecio.setVisible(false);
		checkStock.setVisible(false);
	}
}
