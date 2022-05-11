package vista.libros;

import java.awt.event.ActionEvent;

import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class AltasLibros extends VentanaLibros {

	public static JTable tablaLibros;

	public AltasLibros() {
		
		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);

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
		tablaLibros = new JTable();
		configurarTabla(tablaLibros, "s");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviar) {
			if (!cajaNombre.getText().equals("") && !cajaAutor.getText().equals("") && !cajaPrecio.getText().equals("")
					&& !cajaStock.getText().equals("")) {
				
				limpiarObjeto(libro);

				libro.setNombre(cajaNombre.getText());
				libro.setAutor(cajaAutor.getText());
				libro.setPrecio(Double.parseDouble(cajaPrecio.getText()));
				libro.setStock(Integer.parseInt(cajaStock.getText()));

				VentanaPrincipal.libroDAO.setLibro(libro);
				VentanaPrincipal.libroDAO.setOpcion(1);

				Thread h1 = new Thread(VentanaPrincipal.libroDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				restablecerComponentes(cajaIdLibro, cajaNombre, cajaAutor, cajaPrecio, cajaStock);

			}
		} else {
			validacion(e);
		}

	}
}
