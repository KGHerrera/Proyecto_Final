package vista.libros;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BajasLibros extends VentanaLibros {
	
	public BajasLibros() {
		txtTitulo.setText("Eliminar libro");
		btnEnviar.setText("eliminar");
		iconLibros = new ImageIcon("src/iconos/bajasLibro.png");
		txtIcono.setIcon(iconLibros);
	}
	
	

}
