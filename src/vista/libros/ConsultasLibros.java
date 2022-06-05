package vista.libros;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class ConsultasLibros extends VentanaLibros {
	
	public static JTable tablaLibros;
	
	public ConsultasLibros() {
		txtTitulo.setText("Buscar libro");
		btnEnviar.setText("consultar");
		btnActualizar.setVisible(true);
		btnActualizar.setText("ver todos");
		iconLibros = new ImageIcon("src/iconos/consultasLibro.png");
		txtIcono.setIcon(iconLibros);
		
		tablaLibros = new JTable();
		configurarTabla(tablaLibros, "n");
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
				VentanaPrincipal.libroDAO.setOpcion(4);

				Thread h1 = new Thread(VentanaPrincipal.libroDAO);
				h1.start();

				try {
					h1.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			} 

		} else {
			validacion(e);
		}
		
		if(e.getSource() == btnVaciar) {
			dasactivarCajas();
		}

	}
}
