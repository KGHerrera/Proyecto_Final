package vista.libros;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VentanaLibros extends JInternalFrame implements ActionListener, KeyListener {

	JTextField cajaIdLibro, cajaNombre, cajaAutor, cajaPrecio, cajaStock;
	JTable tablaLibros;
	JCheckBox checkIdLibro, checkNombre, checkAutor, checkPrecio, checkStock;
	JButton btnEnviar, btnVaciar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconLibros;

	public VentanaLibros() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Libros");
		setSize(1366 - 500, 650);
		
		setResizable(true);
		setVisible(true);
		setClosable(true);

		JLabel txtIdLibro = new JLabel("id empleado: ");
		JLabel txtNombre = new JLabel("nombre: ");
		JLabel txtAutor = new JLabel("autor: ");
		JLabel txtPrecio = new JLabel("precio: ");
		JLabel txtStock = new JLabel("stock: ");

		txtTitulo = new JLabel("Libros");

		txtTitulo.setFont(new Font("calibri", Font.BOLD, 20));

		cajaIdLibro = new JTextField(10);
		cajaNombre = new JTextField(10);
		cajaAutor = new JTextField(10);
		cajaPrecio = new JTextField(10);
		cajaStock = new JTextField(10);

		checkIdLibro = new JCheckBox();
		checkNombre = new JCheckBox();
		checkAutor = new JCheckBox();
		checkPrecio = new JCheckBox();
		checkStock = new JCheckBox();

		btnEnviar = new JButton("enviar");
		btnVaciar = new JButton("vaciar");
		
		txtIcono = new JLabel();
		iconLibros = new ImageIcon("src/iconos/altasLibros.png");
		
		txtIcono.setIcon(iconLibros);

		txtTitulo.setBounds(this.getWidth() / 12, 40, 300, 20);

		txtIdLibro.setBounds(this.getWidth() / 3, 80, 100, 20);
		txtNombre.setBounds(this.getWidth() / 3, 120, 100, 20);
		txtAutor.setBounds(this.getWidth() / 3, 160, 100, 20);
		txtPrecio.setBounds(this.getWidth() / 3, 200, 100, 20);
		txtStock.setBounds(this.getWidth() / 3, 240, 100, 20);
		
		txtIcono.setBounds(this.getWidth() / 11, 80, 160, 160);

		cajaIdLibro.setBounds(this.getWidth() / 2 + 70, 80, 100, 20);
		cajaNombre.setBounds(this.getWidth() / 2 + 70, 120, 100, 20);
		cajaAutor.setBounds(this.getWidth() / 2 + 70, 160, 100, 20);
		cajaPrecio.setBounds(this.getWidth() / 2 + 70, 200, 100, 20);
		cajaStock.setBounds(this.getWidth() / 2 + 70, 240, 100, 20);

		checkIdLibro.setBounds(this.getWidth() / 2 + 220, 80, 100, 20);
		checkNombre.setBounds(this.getWidth() / 2 + 220, 120, 100, 20);
		checkAutor.setBounds(this.getWidth() / 2 + 220, 160, 100, 20);
		checkPrecio.setBounds(this.getWidth() / 2 + 220, 200, 100, 20);
		checkStock.setBounds(this.getWidth() / 2 + 220, 240, 100, 20);

		btnEnviar.setBounds(this.getWidth() / 2 + 70, 280, 100, 20);
		btnVaciar.setBounds(this.getWidth() / 3, 280, 100, 20);

		tablaLibros = new JTable();
		tablaLibros.setBounds(this.getWidth() / 12, 320, 630, 270);

		Border line = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
		tablaLibros.setBorder(line);

		btnVaciar.addActionListener(this);

		checkIdLibro.addActionListener(this);
		checkNombre.addActionListener(this);
		checkAutor.addActionListener(this);
		checkStock.addActionListener(this);
		checkPrecio.addActionListener(this);

		cajaIdLibro.addKeyListener(this);
		cajaNombre.addKeyListener(this);
		cajaAutor.addKeyListener(this);
		cajaStock.addKeyListener(this);
		cajaPrecio.addKeyListener(this);

		add(txtIdLibro);
		add(txtNombre);
		add(txtAutor);
		add(txtPrecio);
		add(txtStock);

		cajaIdLibro.setEnabled(false);
		cajaNombre.setEnabled(false);
		cajaAutor.setEnabled(false);
		cajaPrecio.setEnabled(false);
		cajaStock.setEnabled(false);

		add(txtIcono);
		add(cajaIdLibro);
		add(cajaNombre);
		add(cajaAutor);
		add(cajaPrecio);
		add(cajaStock);

		add(checkIdLibro);
		add(checkNombre);
		add(checkAutor);
		add(checkPrecio);
		add(checkStock);

		add(btnVaciar);
		add(btnEnviar);

		add(txtTitulo);

		add(tablaLibros);
		
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
			restablecerComponentes(cajaIdLibro, cajaNombre, cajaAutor, cajaPrecio, cajaStock);
		}

		else if (e.getSource() == checkIdLibro) {
			if (checkIdLibro.isSelected())
				cajaIdLibro.setEnabled(true);
			else {
				cajaIdLibro.setEnabled(false);
				cajaIdLibro.setText("");
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

		else if (e.getSource() == checkAutor) {
			if (checkAutor.isSelected())
				cajaAutor.setEnabled(true);
			else {
				cajaAutor.setEnabled(false);
				cajaAutor.setText("");
			}
		}

		else if (e.getSource() == checkPrecio) {
			if (checkPrecio.isSelected())
				cajaPrecio.setEnabled(true);
			else {
				cajaPrecio.setEnabled(false);
				cajaPrecio.setText("");
			}
		}

		else if (e.getSource() == checkStock) {
			if (checkStock.isSelected())
				cajaStock.setEnabled(true);
			else {
				cajaStock.setEnabled(false);
				cajaStock.setText("");
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getSource() == cajaNombre || e.getSource() == cajaAutor) {
			if (!Character.isLetter(e.getKeyChar()))
				e.consume();
		} else if (e.getSource() == cajaIdLibro || e.getSource() == cajaStock) {
			if (!Character.isDigit(e.getKeyChar()))
				e.consume();
		} else if (((e.getKeyChar() < '0') || (e.getKeyChar() > '9')) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				&& (e.getKeyChar() != '.' || cajaPrecio.getText().contains("."))) {
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