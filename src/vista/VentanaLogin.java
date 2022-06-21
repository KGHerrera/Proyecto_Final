package vista;

import javax.swing.*;

import conexion.ConexionBD;
import modelo.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	JButton btnIniciar, btnCancelar;
	JTextField cajaUsuario;
	JPasswordField cajaContrasenia;
	JLabel txtTitulo;

	JPanel nPane;
	Usuario usuario;

	public VentanaLogin() {

		usuario = new Usuario();

		getContentPane().setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		setTitle("Iniciar sesion");
		setSize(400, 230);

		setVisible(true);

		txtTitulo = new JLabel("iniciar sesion");
		txtTitulo.setFont(new Font("calibri", Font.BOLD, 20));
		txtTitulo.setForeground(Color.white);

		nPane = new JPanel();
		nPane.setBackground(new Color(52, 88, 235));

		JLabel txtUsuario = new JLabel("usuario");
		JLabel txtContrasenia = new JLabel("contraseña");

		JLabel txtIcono = new JLabel();
		ImageIcon iconLogin = new ImageIcon("src/iconos/usuario.png");

		txtIcono.setIcon(iconLogin);

		cajaUsuario = new JTextField(10);
		cajaContrasenia = new JPasswordField();

		btnIniciar = new JButton("iniciar");
		btnCancelar = new JButton("cerrar");

		btnCancelar.setBackground(new Color(211, 47, 47));
		btnCancelar.setForeground(Color.white);
		btnCancelar.setBorder(null);

		btnIniciar.setBackground(new Color(38, 179, 119));
		btnIniciar.setForeground(Color.white);
		btnIniciar.setBorder(null);

		txtTitulo.setBounds(20, 15, 200, 20);
		txtIcono.setBounds(40, 80, 64, 64);
		txtUsuario.setBounds(130, 80, 100, 25);
		txtContrasenia.setBounds(130, 130, 100, 25);
		cajaUsuario.setBounds(260, 80, 100, 25);
		cajaContrasenia.setBounds(260, 130, 100, 25);
		btnIniciar.setBounds(130, 180, 100, 25);
		btnCancelar.setBounds(260, 180, 100, 25);

		nPane.setBounds(0, 0, this.getWidth(), 40);

		add(txtTitulo);
		add(txtIcono);
		add(txtUsuario);
		add(txtContrasenia);
		add(cajaUsuario);
		add(cajaContrasenia);

		add(btnCancelar);
		add(btnIniciar);

		add(nPane);

		btnIniciar.addActionListener(this);
		btnCancelar.addActionListener(this);
		setLocationRelativeTo(null);
		ConexionBD.getConexion();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		char[] arrayC = cajaContrasenia.getPassword();
		String pass = new String(arrayC);

		if (e.getSource() == btnIniciar && !cajaUsuario.getText().equals("") && !pass.equals("")) {
			usuario.setUsuario(cajaUsuario.getText());
			usuario.setContrasenia(pass);

			ConexionBD.getConexion();

			try {
				if (ConexionBD.consultarUsuario(usuario).next()) {

					try {

						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						UIManager.put("control", new Color(240, 240, 240));
						
						


					} catch (Exception ex) {

					}

					new VentanaPrincipal();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "datos erroneos");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == btnCancelar) {
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "faltan datos");
		}

	}
}
