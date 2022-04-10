package vista.empleados;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VentanaEmpleados extends JInternalFrame {

	JTextField cajaIdEmpleado, cajaNombre, cajaApellido, cajaSalario, cajaCargo;

	JTable tablaEmpleados;

	JCheckBox checkIdEmpleado, checkNombre, checkApellido, checkSalario, checkCargo;

	JButton btnEnviar, btnVaciar;

	public VentanaEmpleados() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Empleados");
		setLocation(1366 / 4, 0);
		setSize(1366 / 2 - 50, 650);
		setResizable(true);
		setVisible(true);
		setClosable(true);

		JLabel txtIdEmpleado = new JLabel("id empleado: ");
		JLabel txtNombre = new JLabel("nombre: ");
		JLabel txtApellido = new JLabel("apellido: ");
		JLabel txtSalario = new JLabel("salario: ");
		JLabel txtCargo = new JLabel("cargo: ");

		JLabel txtTitulo = new JLabel("Empleados");

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

		txtTitulo.setBounds(this.getWidth() / 4, 40, 100, 20);

		txtIdEmpleado.setBounds(this.getWidth() / 4, 80, 100, 20);
		txtNombre.setBounds(this.getWidth() / 4, 120, 100, 20);
		txtApellido.setBounds(this.getWidth() / 4, 160, 100, 20);
		txtSalario.setBounds(this.getWidth() / 4, 200, 100, 20);
		txtCargo.setBounds(this.getWidth() / 4, 240, 100, 20);

		cajaIdEmpleado.setBounds(this.getWidth() / 2 + 50, 80, 100, 20);
		cajaNombre.setBounds(this.getWidth() / 2 + 50, 120, 100, 20);
		cajaApellido.setBounds(this.getWidth() / 2 + 50, 160, 100, 20);
		cajaSalario.setBounds(this.getWidth() / 2 + 50, 200, 100, 20);
		cajaCargo.setBounds(this.getWidth() / 2 + 50, 240, 100, 20);

		checkIdEmpleado.setBounds(this.getWidth() / 2 + 180, 80, 100, 20);
		checkNombre.setBounds(this.getWidth() / 2 + 180, 120, 100, 20);
		checkApellido.setBounds(this.getWidth() / 2 + 180, 160, 100, 20);
		checkSalario.setBounds(this.getWidth() / 2 + 180, 200, 100, 20);
		checkCargo.setBounds(this.getWidth() / 2 + 180, 240, 100, 20);

		btnEnviar.setBounds(this.getWidth() / 2 + 50, 280, 100, 20);
		btnVaciar.setBounds(this.getWidth() / 4, 280, 100, 20);

		tablaEmpleados = new JTable();
		tablaEmpleados.setBounds(this.getWidth() / 8, 320, this.getWidth() / 8 * 6, 270);

		Border line = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
		tablaEmpleados.setBorder(line);

		add(txtIdEmpleado);
		add(txtNombre);
		add(txtApellido);
		add(txtSalario);
		add(txtCargo);

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

	}
}
