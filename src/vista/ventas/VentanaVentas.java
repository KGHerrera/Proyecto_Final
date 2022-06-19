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
	JButton btnEnviar, btnVaciar, btnBuscar, btnCancelar, btnActualizar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconVentas;

	JPanel nPane;
	public VentanaVentas() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Libros");
		setSize(1366 - 500, 650);
		//setBackground(Color.white);
		
		//((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		setResizable(false);
		setVisible(false);
		setClosable(true);

		JLabel txtIdVenta = new JLabel("id venta: ");
		JLabel txtCantidadLibros = new JLabel("cantidad: ");
		JLabel txtTotalPagar = new JLabel("total a pagar: ");
		JLabel txtIdLibro = new JLabel("id libro: ");
		JLabel txtIdEmpleado = new JLabel("id empleado: ");

		txtTitulo = new JLabel("Ventas");

		txtTitulo.setFont(new Font("Montserrat", Font.BOLD, 28));
		txtTitulo.setForeground(Color.white);

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
		iconVentas = new ImageIcon("src/iconos/altasVenta.png");
		
		txtIcono.setIcon(iconVentas);
		
		nPane = new JPanel();
		nPane.setBackground(new Color(52, 88, 235));

		txtTitulo.setBounds(this.getWidth() / 2 - 400, 10, 300, 35);
		
		txtIdVenta.setBounds(this.getWidth() / 4 + 90, 90, 100, 25);
		txtCantidadLibros.setBounds(this.getWidth() / 4 + 90, 130, 100, 30);
		txtTotalPagar.setBounds(this.getWidth() / 4 + 90, 170, 100, 30);
		txtIdLibro.setBounds(this.getWidth() / 4 + 90, 210, 100, 30);
		txtIdEmpleado.setBounds(this.getWidth() / 4 + 90, 250, 100, 30);

		
		txtIcono.setBounds(this.getWidth() / 11, 80, 160, 160);

		txtIcono.setBounds(this.getWidth() / 11, 90, 160, 160);

		cajaIdVentas.setBounds(this.getWidth() / 2, 90, 100, 30);
		cajaCantidadLibros.setBounds(this.getWidth() / 2, 130, 100, 30);
		cajaTotalPagar.setBounds(this.getWidth() / 2, 170, 100, 30);
		cajaIdLibro.setBounds(this.getWidth() / 2, 210, 100, 30);
		cajaIdEmpleado.setBounds(this.getWidth() / 2, 250, 100, 30);

		checkIdVenta.setBounds(this.getWidth() / 4 + 40, 90, 20, 30);
		checkCantidadLibros.setBounds(this.getWidth() / 4 + 40, 130, 20, 30);
		checkTotalPagar.setBounds(this.getWidth() / 4 + 40, 170, 20, 30);
		checkIdLibro.setBounds(this.getWidth() / 4 + 40, 210, 20, 30);
		checkIdEmpleado.setBounds(this.getWidth() / 4 + 40, 250, 20, 30);

		btnBuscar.setBounds(this.getWidth() / 2 + 140, 90, 100, 30);
		btnActualizar.setBounds(this.getWidth() / 2 + 140, 130, 100, 30);

		btnVaciar.setBounds(this.getWidth() / 2 + 140, 170, 100, 30);
		btnEnviar.setBounds(this.getWidth() / 2 + 140, 210, 100, 30);
		btnCancelar.setBounds(this.getWidth() / 2 + 140, 250, 100, 30);

		nPane.setBounds(0, 0, this.getWidth(), 60);

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

		add(txtIdVenta);
		add(txtCantidadLibros);
		add(txtTotalPagar);
		add(txtIdLibro);
		add(txtIdEmpleado);

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
		add(btnCancelar);
		add(btnBuscar);
		add(btnActualizar);

		add(txtTitulo);

		add(tablaVentas);
		
		add(nPane);
		
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
		
		if (e.getSource() == cajaIdVentas || e.getSource() == cajaIdEmpleado || e.getSource() == cajaCantidadLibros || e.getSource() == cajaIdLibro) {
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