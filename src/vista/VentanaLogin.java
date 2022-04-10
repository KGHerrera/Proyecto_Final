package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	JButton btnIniciar, btnCancelar;
	JTextField cajaUsuario;
	JPasswordField cajaContrasenia;
	JLabel txtTitulo;

	public VentanaLogin() {

		getContentPane().setLayout(gbl);
		gbc.insets = new Insets(14, 20, 14, 20);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		setTitle("Iniciar sesion");
		setSize(960, 620);

		setVisible(true);
		gbc.fill = GridBagConstraints.BOTH;

		txtTitulo = new JLabel("Login");
		txtTitulo.setFont(new Font("calibri", Font.BOLD, 20));
		txtTitulo.setForeground(new Color(7, 16, 58));

		JLabel txtUsuario = new JLabel("usuario");
		JLabel txtContrasenia = new JLabel("contraseña");

		JLabel txtIcono = new JLabel();
		ImageIcon iconLogin = new ImageIcon("src/iconos/usuario.png");

		txtIcono.setIcon(iconLogin);

		cajaUsuario = new JTextField(10);
		cajaContrasenia = new JPasswordField();

		btnIniciar = new JButton("iniciar");
		btnCancelar = new JButton("cerrar");

		alinearComponente(txtTitulo, 0, 0, 3, 1);
		alinearComponente(txtUsuario, 1, 1, 1, 1);
		alinearComponente(txtContrasenia, 1, 2, 1, 1);

		alinearComponente(cajaUsuario, 2, 1, 1, 1);
		alinearComponente(cajaContrasenia, 2, 2, 1, 1);

		alinearComponente(btnIniciar, 2, 3, 1, 1);
		alinearComponente(btnCancelar, 1, 3, 1, 1);

		alinearComponente(txtIcono, 0, 1, 1, 2);

		btnIniciar.addActionListener(this);
		btnCancelar.addActionListener(this);
		pack();
		setLocationRelativeTo(null);

	}

	public void alinearComponente(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciar) {
			dispose();

			new VentanaPrincipal();
		}

	}
}
