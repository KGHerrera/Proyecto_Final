package vista.empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import vista.ResultSetTableModel;

import javax.swing.border.Border;

import modelo.Empleado;

@SuppressWarnings("serial")
public class VentanaEmpleados extends JInternalFrame implements ActionListener, KeyListener {
	
	Empleado empleado = new Empleado();
	JTextField cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo;
	public static JTable tablaEmpleados;
	JCheckBox checkIdEmpleado, checkNombre, checkApellido, checkSalario, checkCargo;
	JButton btnEnviar, btnVaciar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconEmpleado;

	public VentanaEmpleados() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Empleados");
		setSize(1366 - 500, 650);

		setResizable(true);
		setVisible(true);
		setClosable(true);

		JLabel txtIdEmpleado = new JLabel("id empleado: ");
		JLabel txtNombre = new JLabel("nombre: ");
		JLabel txtApellido = new JLabel("apellido: ");
		JLabel txtSalario = new JLabel("salario: ");
		JLabel txtCargo = new JLabel("cargo: ");

		txtTitulo = new JLabel("Empleados");

		txtTitulo.setFont(new Font("calibri", Font.BOLD, 20));

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

		btnEnviar = new JButton("enviar");
		btnVaciar = new JButton("vaciar");

		txtIcono = new JLabel();
		iconEmpleado = new ImageIcon("src/iconos/altas.png");

		txtIcono.setIcon(iconEmpleado);

		txtTitulo.setBounds(this.getWidth() / 12, 40, 300, 20);

		txtIdEmpleado.setBounds(this.getWidth() / 3, 80, 100, 20);
		txtNombre.setBounds(this.getWidth() / 3, 120, 100, 20);
		txtApellido.setBounds(this.getWidth() / 3, 160, 100, 20);
		txtSalario.setBounds(this.getWidth() / 3, 200, 100, 20);
		txtCargo.setBounds(this.getWidth() / 3, 240, 100, 20);

		txtIcono.setBounds(this.getWidth() / 11, 80, 160, 160);

		cajaIdEmpleado.setBounds(this.getWidth() / 2 + 70, 80, 100, 20);
		cajaNombre.setBounds(this.getWidth() / 2 + 70, 120, 100, 20);
		cajaApellido.setBounds(this.getWidth() / 2 + 70, 160, 100, 20);
		cajaSalario.setBounds(this.getWidth() / 2 + 70, 200, 100, 20);
		cajaCargo.setBounds(this.getWidth() / 2 + 70, 240, 100, 20);

		checkIdEmpleado.setBounds(this.getWidth() / 2 + 220, 80, 100, 20);
		checkNombre.setBounds(this.getWidth() / 2 + 220, 120, 100, 20);
		checkApellido.setBounds(this.getWidth() / 2 + 220, 160, 100, 20);
		checkSalario.setBounds(this.getWidth() / 2 + 220, 200, 100, 20);
		checkCargo.setBounds(this.getWidth() / 2 + 220, 240, 100, 20);

		btnEnviar.setBounds(this.getWidth() / 2 + 70, 280, 100, 20);
		btnVaciar.setBounds(this.getWidth() / 3, 280, 100, 20);

		tablaEmpleados = new JTable();
		tablaEmpleados.setBounds(this.getWidth() / 12, 320, 630, 270);

		Border line = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
		tablaEmpleados.setBorder(line);

		btnVaciar.addActionListener(this);
		btnEnviar.addActionListener(this);

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

		add(txtTitulo);

		add(tablaEmpleados);

		setSize(1366 - 600, 680);
		setLocation(getWidth() / 2 - getWidth() / 7, 0);

		actualizarTabla();

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVaciar) {
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
		}

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

	public void actualizarTabla() {
		String consulta;
		consulta = "SELECT * FROM empleados";

		ResultSetTableModel modeloDatos = null;

		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/libreria",
					consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tablaEmpleados.setModel(modeloDatos);
	}
}
