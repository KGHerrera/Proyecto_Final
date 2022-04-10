package vista.libros;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CambiosLibros extends VentanaLibros {
	
	public CambiosLibros() {
		txtTitulo.setText("Modificar libro");
		btnEnviar.setText("modificar");
		iconLibros = new ImageIcon("src/iconos/cambiosLibro.png");
		txtIcono.setIcon(iconLibros);
	}

}
