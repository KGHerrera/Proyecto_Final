package vista.empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.Empleado;
import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaEmpleados extends JInternalFrame implements ActionListener, KeyListener {

	Empleado empleado = new Empleado();

	JTextField cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo;

	JCheckBox checkIdEmpleado, checkNombre, checkApellido, checkSalario, checkCargo;
	JButton btnEnviar, btnVaciar, btnBuscar, btnCancelar, btnActualizar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconEmpleado;
	JScrollPane jp;
	JPanel nPane;

	public VentanaEmpleados() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Empleados");
		setSize(1366 - 500, 650);

		setResizable(false);
		setVisible(false);
		setClosable(true);

		// setBackground(Color.white);

		// ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

		JLabel txtIdEmpleado = new JLabel("id empleado: ");
		JLabel txtNombre = new JLabel("nombre: ");
		JLabel txtApellido = new JLabel("apellido: ");
		JLabel txtSalario = new JLabel("salario: ");
		JLabel txtCargo = new JLabel("cargo: ");

		txtTitulo = new JLabel("Empleados");

		txtTitulo.setFont(new Font("Montserrat", Font.BOLD, 28));
		txtTitulo.setForeground(Color.white);

		cajaIdEmpleado = new JTextField(10);
		cajaNombre = new JTextField(10);
		cajaApellido = new JTextField(10);
		cajaSalario = new JTextField(10);
		cajaCargo = new JTextField(10);

		checkIdEmpleado = new JCheckBox();
		checkNombre = new JCheckBox();
		checkApellido = new JCheckBox();
		checkSalario = new JCheckBox();
		checkCargo = new JCheckBox();

		btnEnviar = new JButton("agregar");
		btnVaciar = new JButton("vaciar");
		btnBuscar = new JButton("buscar");
		btnCancelar = new JButton("cerrar");
		btnActualizar = new JButton("ver todos");

		btnCancelar.setBackground(new Color(211, 47, 47));
		btnCancelar.setForeground(Color.white);

		btnEnviar.setBackground(new Color(38, 179, 119));
		btnEnviar.setForeground(Color.white);

		btnActualizar.setBackground(new Color(0, 120, 215));
		btnActualizar.setForeground(Color.white);

		btnBuscar.setBackground(new Color(0, 120, 215));
		btnBuscar.setForeground(Color.white);

		btnVaciar.setBackground(new Color(0, 120, 215));
		btnVaciar.setForeground(Color.white);

		txtIcono = new JLabel();
		iconEmpleado = new ImageIcon("src/iconos/altas.png");

		txtIcono.setIcon(iconEmpleado);

		nPane = new JPanel();
		nPane.setBackground(new Color(52, 88, 235));

		txtTitulo.setBounds(this.getWidth() / 2 - 400, 10, 300, 35);

		txtIdEmpleado.setBounds(this.getWidth() / 4 + 90, 90, 100, 30);
		txtNombre.setBounds(this.getWidth() / 4 + 90, 130, 100, 30);
		txtApellido.setBounds(this.getWidth() / 4 + 90, 170, 100, 30);
		txtSalario.setBounds(this.getWidth() / 4 + 90, 210, 100, 30);
		txtCargo.setBounds(this.getWidth() / 4 + 90, 250, 100, 30);

		txtIcono.setBounds(this.getWidth() / 11, 90, 160, 160);

		cajaIdEmpleado.setBounds(this.getWidth() / 2, 90, 100, 30);
		cajaNombre.setBounds(this.getWidth() / 2, 130, 100, 30);
		cajaApellido.setBounds(this.getWidth() / 2, 170, 100, 30);
		cajaSalario.setBounds(this.getWidth() / 2, 210, 100, 30);
		cajaCargo.setBounds(this.getWidth() / 2, 250, 100, 30);

		checkIdEmpleado.setBounds(this.getWidth() / 4 + 40, 90, 20, 30);
		checkNombre.setBounds(this.getWidth() / 4 + 40, 130, 20, 30);
		checkApellido.setBounds(this.getWidth() / 4 + 40, 170, 20, 30);
		checkSalario.setBounds(this.getWidth() / 4 + 40, 210, 20, 30);
		checkCargo.setBounds(this.getWidth() / 4 + 40, 250, 20, 30);

		btnBuscar.setBounds(this.getWidth() / 2 + 140, 90, 100, 30);
		btnActualizar.setBounds(this.getWidth() / 2 + 140, 130, 100, 30);
		btnVaciar.setBounds(this.getWidth() / 2 + 140, 170, 100, 30);
		btnEnviar.setBounds(this.getWidth() / 2 + 140, 210, 100, 30);
		btnCancelar.setBounds(this.getWidth() / 2 + 140, 250, 100, 30);

		nPane.setBounds(0, 0, this.getWidth(), 60);

		btnVaciar.addActionListener(this);
		btnEnviar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnActualizar.addActionListener(this);

		checkIdEmpleado.addActionListener(this);
		checkNombre.addActionListener(this);
		checkApellido.addActionListener(this);
		checkCargo.addActionListener(this);
		checkSalario.addActionListener(this);

		cajaIdEmpleado.addKeyListener(this);
		cajaNombre.addKeyListener(this);
		cajaApellido.addKeyListener(this);
		cajaCargo.addKeyListener(this);
		cajaSalario.addKeyListener(this);

		add(txtIdEmpleado);
		add(txtNombre);
		add(txtApellido);
		add(txtSalario);
		add(txtCargo);

		cajaIdEmpleado.setEnabled(false);
		cajaNombre.setEnabled(false);
		cajaApellido.setEnabled(false);
		cajaSalario.setEnabled(false);
		cajaCargo.setEnabled(false);

		add(txtIcono);
		add(cajaIdEmpleado);
		add(cajaNombre);
		add(cajaApellido);
		add(cajaSalario);
		add(cajaCargo);

		add(checkIdEmpleado);
		add(checkNombre);
		add(checkApellido);
		add(checkSalario);
		add(checkCargo);

		add(btnVaciar);
		add(btnEnviar);
		add(btnCancelar);
		add(btnBuscar);
		add(btnActualizar);
		add(txtTitulo);

		add(nPane);

		setSize(1366 - 600, 680);
		setLocation(getWidth() / 2 - getWidth() / 7, 0);

	}

	public void configurarTabla(JTable tablaEmpleados, String s) {

		jp = new JScrollPane(tablaEmpleados);
		jp.setBounds(this.getWidth() / 12, 320, 630, 270);


		/*
		 * Border line = BorderFactory.createLineBorder(nPane.getBackground(), 2);
		 * jp.setBorder(line);
		 */
		
		add(jp);

		tablaEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarDatosEmpleados(e, tablaEmpleados);
				activarCajas();

				if (s.equals("s")) {
					cajaIdEmpleado.setEnabled(false);
					cajaIdEmpleado.setText(null);
				}

			}
		});

	}

	public void limpiarObjeto(Empleado e) {
		e.setIdEmpleado(0);
		e.setNombre(null);
		e.setApellido(null);
		e.setCargo(null);
		e.setSalario(0.0);
	}

	public void restablecerComponentes(JComponent... componentes) {
		for (JComponent c : componentes) {

			if (c instanceof JTextField)
				((JTextField) c).setText("");

			else if (c instanceof JCheckBox)
				((JCheckBox) c).setSelected(false);
		}
	}

	public void cargarDatosEmpleados(java.awt.event.MouseEvent evt, JTable tablaEmpleados) {
		cajaIdEmpleado.setText(String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0)));
		cajaNombre.setText((String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
		cajaApellido.setText((String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
		cajaSalario.setText(String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 3)));
		cajaCargo.setText((String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 4));
	}

	public void activarCajas() {

		checkIdEmpleado.setSelected(true);
		checkNombre.setSelected(true);
		checkApellido.setSelected(true);
		checkSalario.setSelected(true);
		checkCargo.setSelected(true);

		cajaIdEmpleado.setEnabled(true);
		cajaNombre.setEnabled(true);
		cajaApellido.setEnabled(true);
		cajaSalario.setEnabled(true);
		cajaCargo.setEnabled(true);
	}

	public void desactivarCajas() {

		checkIdEmpleado.setSelected(false);
		checkNombre.setSelected(false);
		checkApellido.setSelected(false);
		checkSalario.setSelected(false);
		checkCargo.setSelected(false);

		cajaIdEmpleado.setEnabled(false);
		cajaNombre.setEnabled(false);
		cajaApellido.setEnabled(false);
		cajaSalario.setEnabled(false);
		cajaCargo.setEnabled(false);
	}

	public void validacion(ActionEvent e) {

		if (e.getSource() == btnBuscar) {

			if (!cajaIdEmpleado.getText().equals("")) {

				limpiarObjeto(empleado);
				empleado.setIdEmpleado(Integer.parseInt(cajaIdEmpleado.getText()));
				VentanaPrincipal.empleadoDAO.setEmpleado(empleado);

				empleado = VentanaPrincipal.empleadoDAO.buscarEmpleadoID(empleado);

				if (empleado.getNombre() != null) {

					cajaIdEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
					cajaNombre.setText(empleado.getNombre());
					cajaApellido.setText(empleado.getApellido());
					cajaSalario.setText(String.valueOf(empleado.getSalario()));
					cajaCargo.setText(empleado.getCargo());

					activarCajas();
				}

			}

		}

		else if (e.getSource() == btnVaciar) {
			restablecerComponentes(cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo);
		}

		else if (e.getSource() == checkIdEmpleado) {
			if (checkIdEmpleado.isSelected())
				cajaIdEmpleado.setEnabled(true);
			else {
				cajaIdEmpleado.setEnabled(false);
				cajaIdEmpleado.setText("");
			}
		}

		else if (e.getSource() == checkNombre) {
			if (checkNombre.isSelected())
				cajaNombre.setEnabled(true);
			else {
				cajaNombre.setEnabled(false);
				cajaNombre.setText("");
			}
		}

		else if (e.getSource() == checkApellido) {
			if (checkApellido.isSelected())
				cajaApellido.setEnabled(true);
			else {
				cajaApellido.setEnabled(false);
				cajaApellido.setText("");
			}
		}

		else if (e.getSource() == checkSalario) {
			if (checkSalario.isSelected())
				cajaSalario.setEnabled(true);
			else {
				cajaSalario.setEnabled(false);
				cajaSalario.setText("");
			}
		}

		else if (e.getSource() == checkCargo) {
			if (checkCargo.isSelected())
				cajaCargo.setEnabled(true);
			else {
				cajaCargo.setEnabled(false);
				cajaCargo.setText("");
			}
		} else if (e.getSource() == btnCancelar) {
			setVisible(false);
		} else if (e.getSource() == btnActualizar) {
			VentanaPrincipal.empleadoDAO.actualizarTabla();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getSource() == cajaNombre || e.getSource() == cajaCargo || e.getSource() == cajaApellido) {
			if (!Character.isLetter(e.getKeyChar()))
				e.consume();
		} else if (e.getSource() == cajaIdEmpleado) {
			if (!Character.isDigit(e.getKeyChar()))
				e.consume();
		} else if (((e.getKeyChar() < '0') || (e.getKeyChar() > '9')) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				&& (e.getKeyChar() != '.' || cajaSalario.getText().contains("."))) {
			e.consume();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
