package vista;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JButton btnIniciar;
	JTextField cajaUsuario;
	JPasswordField cajaContrasenia;
	
	public VentanaLogin() {
		
		getContentPane().setLayout(gbl);
		gbc.insets = new Insets(5,10,5,10);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Iniciar sesion");
		setSize(960, 620);
		setLocationRelativeTo(null);
		setVisible(true);
		gbc.fill = GridBagConstraints.BOTH;
		
		JLabel txtTitulo = new JLabel("Login");
		txtTitulo.setFont(new Font("calibri", Font.BOLD, 16));
		
		JLabel txtUsuario = new JLabel("usuario");
		JLabel txtContrasenia = new JLabel("contraseña");
		
		cajaUsuario = new JTextField(10);
		cajaContrasenia = new JPasswordField();
		
		btnIniciar = new JButton("Iniciar sesion");
		
		alinearComponente(txtTitulo, 0, 0, 3, 1);
		alinearComponente(txtUsuario, 1, 1, 1, 1);
		alinearComponente(txtContrasenia, 1, 2, 1, 1);
		
		alinearComponente(cajaUsuario, 2, 1, 1, 1);
		alinearComponente(cajaContrasenia, 2, 2, 1, 1);
		
		alinearComponente(btnIniciar, 1, 3, 1, 1);
		
		pack();
		
	}
	
	public void alinearComponente(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		
		gbc.gridwidth = w;
		gbc.gridheight = h;
		
		gbl.setConstraints(c, gbc);
		add(c);
	}	
}
