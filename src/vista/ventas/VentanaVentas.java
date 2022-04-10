package vista.ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VentanaVentas extends JInternalFrame implements ActionListener, KeyListener {

	JTextField cajaIdVentas, cajaCantidadLibros, cajaTotalPagar, cajaIdLibro, cajaIdEmpleado;
	JTable tablaVentas;
	JCheckBox checkIdVenta, checkCantidadLibros, checkTotalPagar, checkIdLibro, checkIdEmpleado;
	JButton btnEnviar, btnVaciar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconVentas;

	public VentanaVentas() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Libros");
		setSize(1366 - 500, 650);
		
		setResizable(true);
		setVisible(true);
		setClosable(true);

		JLabel txtIdLibro = new JLabel("id venta: ");
		JLabel txtNombre = new JLabel("cantidad de libros: ");
		JLabel txtAutor = new JLabel("total a pagar: ");
		JLabel txtPrecio = new JLabel("id libro: ");
		JLabel txtStock = new JLabel("id empleado: ");

		txtTitulo = new JLabel("Ventas");

		txtTitulo.setFont(new Font("calibri", Font.BOLD, 20));

		cajaIdVentas = new JTextField(10);
		cajaCantidadLibros = new JTextField(10);
		cajaTotalPagar = new JTextField(10);
		cajaIdLibro = new JTextField(10);
		cajaIdEmpleado = new JTextField(10);

		checkIdVenta = new JCheckBox();
		checkCantidadLibros = new JCheckBox();
		checkTotalPagar = new JCheckBox();
		checkIdLibro = new JCheckBox();
		checkIdEmpleado = new JCheckBox();

		btnEnviar = new JButton("enviar");
		btnVaciar = new JButton("vaciar");
		
		txtIcono = new JLabel();
		iconVentas = new ImageIcon("src/iconos/altasLibro.png");
		
		txtIcono.setIcon(iconVentas);

		txtTitulo.setBounds(this.getWidth() / 12, 40, 300, 20);

		txtIdLibro.setBounds(this.getWidth() / 3, 80, 100, 20);
		txtNombre.setBounds(this.getWidth() / 3, 120, 100, 20);
		txtAutor.setBounds(this.getWidth() / 3, 160, 100, 20);
		txtPrecio.setBounds(this.getWidth() / 3, 200, 100, 20);
		txtStock.setBounds(this.getWidth() / 3, 240, 100, 20);
		
		txtIcono.setBounds(this.getWidth() / 11, 80, 160, 160);

		cajaIdVentas.setBounds(this.getWidth() / 2 + 70, 80, 100, 20);
		cajaCantidadLibros.setBounds(this.getWidth() / 2 + 70, 120, 100, 20);
		cajaTotalPagar.setBounds(this.getWidth() / 2 + 70, 160, 100, 20);
		cajaIdLibro.setBounds(this.getWidth() / 2 + 70, 200, 100, 20);
		cajaIdEmpleado.setBounds(this.getWidth() / 2 + 70, 240, 100, 20);

		checkIdVenta.setBounds(this.getWidth() / 2 + 220, 80, 100, 20);
		checkCantidadLibros.setBounds(this.getWidth() / 2 + 220, 120, 100, 20);
		checkTotalPagar.setBounds(this.getWidth() / 2 + 220, 160, 100, 20);
		checkIdLibro.setBounds(this.getWidth() / 2 + 220, 200, 100, 20);
		checkIdEmpleado.setBounds(this.getWidth() / 2 + 220, 240, 100, 20);

		btnEnviar.setBounds(this.getWidth() / 2 + 70, 280, 100, 20);
		btnVaciar.setBounds(this.getWidth() / 3, 280, 100, 20);

		tablaVentas = new JTable();
		tablaVentas.setBounds(this.getWidth() / 12, 320, 630, 270);

		Border line = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
		tablaVentas.setBorder(line);

		btnVaciar.addActionListener(this);

		checkIdVenta.addActionListener(this);
		checkCantidadLibros.addActionListener(this);
		checkTotalPagar.addActionListener(this);
		checkIdEmpleado.addActionListener(this);
		checkIdLibro.addActionListener(this);

		cajaIdVentas.addKeyListener(this);
		cajaCantidadLibros.addKeyListener(this);
		cajaTotalPagar.addKeyListener(this);
		cajaIdEmpleado.addKeyListener(this);
		cajaIdLibro.addKeyListener(this);

		add(txtIdLibro);
		add(txtNombre);
		add(txtAutor);
		add(txtPrecio);
		add(txtStock);

		cajaIdVentas.setEnabled(false);
		cajaCantidadLibros.setEnabled(false);
		cajaTotalPagar.setEnabled(false);
		cajaIdLibro.setEnabled(false);
		cajaIdEmpleado.setEnabled(false);

		add(txtIcono);
		add(cajaIdVentas);
		add(cajaCantidadLibros);
		add(cajaTotalPagar);
		add(cajaIdLibro);
		add(cajaIdEmpleado);

		add(checkIdVenta);
		add(checkCantidadLibros);
		add(checkTotalPagar);
		add(checkIdLibro);
		add(checkIdEmpleado);

		add(btnVaciar);
		add(btnEnviar);

		add(txtTitulo);

		add(tablaVentas);
		
		setSize(1366 - 600, 680);
		setLocation(getWidth()/2 - getWidth()/7, 0);

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
			restablecerComponentes(cajaIdVentas, cajaCantidadLibros, cajaTotalPagar, cajaIdLibro, cajaIdEmpleado);
		}

		else if (e.getSource() == checkIdVenta) {
			if (checkIdVenta.isSelected())
				cajaIdVentas.setEnabled(true);
			else {
				cajaIdVentas.setEnabled(false);
				cajaIdVentas.setText("");
			}
		}

		else if (e.getSource() == checkCantidadLibros) {
			if (checkCantidadLibros.isSelected())
				cajaCantidadLibros.setEnabled(true);
			else {
				cajaCantidadLibros.setEnabled(false);
				cajaCantidadLibros.setText("");
			}
		}

		else if (e.getSource() == checkTotalPagar) {
			if (checkTotalPagar.isSelected())
				cajaTotalPagar.setEnabled(true);
			else {
				cajaTotalPagar.setEnabled(false);
				cajaTotalPagar.setText("");
			}
		}

		else if (e.getSource() == checkIdLibro) {
			if (checkIdLibro.isSelected())
				cajaIdLibro.setEnabled(true);
			else {
				cajaIdLibro.setEnabled(false);
				cajaIdLibro.setText("");
			}
		}

		else if (e.getSource() == checkIdEmpleado) {
			if (checkIdEmpleado.isSelected())
				cajaIdEmpleado.setEnabled(true);
			else {
				cajaIdEmpleado.setEnabled(false);
				cajaIdEmpleado.setText("");
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() == cajaIdVentas || e.getSource() == cajaIdEmpleado || e.getSource() == cajaCantidadLibros) {
			if (!Character.isDigit(e.getKeyChar()))
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