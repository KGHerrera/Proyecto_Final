package vista.libros;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ConsultasLibros extends VentanaLibros {
	
	public ConsultasLibros() {
		txtTitulo.setText("Buscar libro");
		btnEnviar.setText("buscar");
		iconLibros = new ImageIcon("src/iconos/consultasLibro.png");
		txtIcono.setIcon(iconLibros);
	}
}
