package vista.libros;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentanaPrincipal;


@SuppressWarnings("serial")
public class BajasLibros extends VentanaLibros {
	public static JTable tablaLibros;
	
	public BajasLibros() {
		txtTitulo.setText("Eliminar libro");
		btnEnviar.setText("eliminar");
		iconLibros = new ImageIcon("src/iconos/bajasLibro.png");
		txtIcono.setIcon(iconLibros);
		
		btnActualizar.setVisible(false);
		
		BajasLibros.tablaLibros = new JTable();
		configurarTabla(BajasLibros.tablaLibros, "n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviar) {
			if (!cajaIdLibro.getText().equals("") || !cajaNombre.getText().equals("")
					|| !cajaAutor.getText().equals("") || !cajaPrecio.getText().equals("")
					|| !cajaStock.getText().equals("")) {

				limpiarObjeto(libro);

				if (!cajaIdLibro.getText().equals("")) {
					libro.setIdLibro(Integer.parseInt(cajaIdLibro.getText()));
				}

				if (!cajaNombre.getText().equals("")) {
					libro.setNombre(cajaNombre.getText());
				}

				if (!cajaAutor.getText().equals("")) {
					libro.setAutor(cajaAutor.getText());
				}

				if (!cajaPrecio.getText().equals("")) {
					libro.setPrecio(Double.parseDouble(cajaPrecio.getText()));
				}

				if (!cajaStock.getText().equals("")) {
					libro.setStock(Integer.parseInt(cajaStock.getText()));
				}
				
				
				VentanaPrincipal.libroDAO.setLibro(libro);
				VentanaPrincipal.libroDAO.setOpcion(2);

				Thread h1 = new Thread(VentanaPrincipal.libroDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				if(VentanaPrincipal.libroDAO.isRes()) {
					JOptionPane.showMessageDialog(null, "se elimino correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "no se elimino");
				}
			} else {
				JOptionPane.showMessageDialog(null, "agrega datos");
			}
		} else {
			validacion(e);
		}
		
		if(e.getSource() == btnVaciar) {
			dasactivarCajas();
		}

	}
	
	

}
