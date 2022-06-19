package vista.libros;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class CambiosLibros extends VentanaLibros {

	public static JTable tablaLibros;

	public CambiosLibros() {
		txtTitulo.setText("Modificar libro");
		btnEnviar.setText("modificar");
		iconLibros = new ImageIcon("src/iconos/cambiosLibro.png");
		txtIcono.setIcon(iconLibros);

		cajaIdLibro.setEnabled(true);
		cajaNombre.setEnabled(true);
		cajaAutor.setEnabled(true);
		cajaStock.setEnabled(true);
		cajaPrecio.setEnabled(true);

		checkIdLibro.setVisible(false);
		checkNombre.setVisible(false);
		checkAutor.setVisible(false);
		checkStock.setVisible(false);
		checkPrecio.setVisible(false);

		btnActualizar.setVisible(false);
		nPane.setBackground(new Color(240, 152, 46));
		btnEnviar.setBackground(nPane.getBackground());
		
		tablaLibros = new JTable();
		configurarTabla(tablaLibros, "n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviar) {
			if (!cajaIdLibro.getText().equals("") && !cajaNombre.getText().equals("") && !cajaAutor.getText().equals("")
					&& !cajaPrecio.getText().equals("") && !cajaStock.getText().equals("")) {
				limpiarObjeto(libro);

				libro.setIdLibro(Integer.parseInt(cajaIdLibro.getText()));
				libro.setNombre(cajaNombre.getText());
				libro.setAutor(cajaAutor.getText());
				libro.setStock(Integer.parseInt(cajaStock.getText()));
				libro.setPrecio(Double.parseDouble(cajaPrecio.getText()));

				VentanaPrincipal.libroDAO.setLibro(libro);
				VentanaPrincipal.libroDAO.setOpcion(3);

				Thread h1 = new Thread(VentanaPrincipal.libroDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				if (VentanaPrincipal.libroDAO.isRes()) {
					JOptionPane.showMessageDialog(null, "se modifico correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "no se modifico");
				}

			} else {
				JOptionPane.showMessageDialog(null, "faltan datos");
			}
		} else {
			validacion(e);
		}
	}

}
