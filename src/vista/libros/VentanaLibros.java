package vista.libros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Libro;
import vista.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaLibros extends JInternalFrame implements ActionListener, KeyListener {

	Libro libro = new Libro();
	JTextField cajaIdLibro, cajaNombre, cajaAutor, cajaPrecio, cajaStock;
	JCheckBox checkIdLibro, checkNombre, checkAutor, checkPrecio, checkStock;
	JButton btnEnviar, btnVaciar, btnBuscar, btnCancelar, btnActualizar;

	JLabel txtTitulo, txtIcono;
	ImageIcon iconLibros;
	JScrollPane jp;

	JPanel nPane;

	public VentanaLibros() {

		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Libros");
		setSize(1366 - 500, 650);

		setResizable(false);
		setVisible(false);
		setClosable(true);

		// setBackground(Color.white);

		// ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

		JLabel txtIdLibro = new JLabel("id libro: ");
		JLabel txtNombre = new JLabel("nombre: ");
		JLabel txtAutor = new JLabel("autor: ");
		JLabel txtPrecio = new JLabel("precio: ");
		JLabel txtStock = new JLabel("stock: ");

		txtTitulo = new JLabel("Libros");

		txtTitulo.setFont(new Font("Montserrat", Font.BOLD, 28));
		txtTitulo.setForeground(Color.white);

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

		btnEnviar = new JButton("agregar");
		btnVaciar = new JButton("vaciar");
		btnBuscar = new JButton("buscar");
		btnCancelar = new JButton("cerrar");
		btnActualizar = new JButton("actualizar");

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
		iconLibros = new ImageIcon("src/iconos/altasLibro.png");

		txtIcono.setIcon(iconLibros);

		nPane = new JPanel();
		nPane.setBackground(new Color(52, 88, 235));

		txtTitulo.setBounds(this.getWidth() / 2 - 400, 10, 300, 35);

		txtIdLibro.setBounds(this.getWidth() / 4 + 90, 90, 100, 30);
		txtNombre.setBounds(this.getWidth() / 4 + 90, 130, 100, 30);
		txtAutor.setBounds(this.getWidth() / 4 + 90, 170, 100, 30);
		txtStock.setBounds(this.getWidth() / 4 + 90, 210, 100, 30);
		txtPrecio.setBounds(this.getWidth() / 4 + 90, 250, 100, 30);

		txtIcono.setBounds(this.getWidth() / 11, 90, 160, 160);

		cajaIdLibro.setBounds(this.getWidth() / 2, 90, 100, 30);
		cajaNombre.setBounds(this.getWidth() / 2, 130, 100, 30);
		cajaAutor.setBounds(this.getWidth() / 2, 170, 100, 30);
		cajaStock.setBounds(this.getWidth() / 2, 210, 100, 30);
		cajaPrecio.setBounds(this.getWidth() / 2, 250, 100, 30);

		checkIdLibro.setBounds(this.getWidth() / 4 + 40, 90, 20, 30);
		checkNombre.setBounds(this.getWidth() / 4 + 40, 130, 20, 30);
		checkAutor.setBounds(this.getWidth() / 4 + 40, 170, 20, 30);
		checkStock.setBounds(this.getWidth() / 4 + 40, 210, 20, 30);
		checkPrecio.setBounds(this.getWidth() / 4 + 40, 250, 20, 30);

		btnBuscar.setBounds(this.getWidth() / 2 + 140, 90, 100, 30);
		btnActualizar.setBounds(this.getWidth() / 2 + 140, 130, 100, 30);
		btnEnviar.setBounds(this.getWidth() / 2 + 140, 210, 100, 30);
		btnVaciar.setBounds(this.getWidth() / 2 + 140, 170, 100, 30);
		btnCancelar.setBounds(this.getWidth() / 2 + 140, 250, 100, 30);

		nPane.setBounds(0, 0, this.getWidth(), 60);

		btnVaciar.addActionListener(this);
		btnEnviar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnActualizar.addActionListener(this);

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
		add(btnCancelar);
		add(btnBuscar);
		add(btnActualizar);
		add(txtTitulo);

		add(nPane);

		setSize(1366 - 600, 680);
		setLocation(getWidth() / 2 - getWidth() / 7, 0);

	}

	public void configurarTabla(JTable tablaLibros, String s) {

		jp = new JScrollPane(tablaLibros);
		jp.setBounds(this.getWidth() / 12, 320, 630, 270);
		add(jp);

		tablaLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarDatosLibros(e, tablaLibros);
				activarCajas();

				if (s.equals("s")) {
					cajaIdLibro.setEnabled(false);
					cajaIdLibro.setText(null);
				}

			}
		});

	}

	public void cargarDatosLibros(java.awt.event.MouseEvent evt, JTable tablaLibros) {
		
		try {
			cajaIdLibro.setText(String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0)));
			cajaNombre.setText((String) tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1));
			cajaAutor.setText((String) tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2));
			cajaStock.setText(String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3)));
			cajaPrecio.setText(String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 4)));
		} catch (Exception e) {
			
		}
		
	}

	public void activarCajas() {

		checkIdLibro.setSelected(true);
		checkNombre.setSelected(true);
		checkAutor.setSelected(true);
		checkStock.setSelected(true);
		checkPrecio.setSelected(true);

		cajaIdLibro.setEnabled(true);
		cajaNombre.setEnabled(true);
		cajaAutor.setEnabled(true);
		cajaStock.setEnabled(true);
		cajaPrecio.setEnabled(true);
	}

	public void dasactivarCajas() {

		checkIdLibro.setSelected(false);
		checkNombre.setSelected(false);
		checkAutor.setSelected(false);
		checkStock.setSelected(false);
		checkPrecio.setSelected(false);

		cajaIdLibro.setEnabled(false);
		cajaNombre.setEnabled(false);
		cajaAutor.setEnabled(false);
		cajaStock.setEnabled(false);
		cajaPrecio.setEnabled(false);
	}

	public void restablecerComponentes(JComponent... componentes) {
		for (JComponent c : componentes) {

			if (c instanceof JTextField)
				((JTextField) c).setText("");

			else if (c instanceof JCheckBox)
				((JCheckBox) c).setSelected(false);
		}
	}

	public void validacion(ActionEvent e) {

		if (e.getSource() == btnBuscar) {

			if (!cajaIdLibro.getText().equals("")) {

				limpiarObjeto(libro);
				libro.setIdLibro(Integer.parseInt(cajaIdLibro.getText()));
				VentanaPrincipal.libroDAO.setLibro(libro);

				libro = VentanaPrincipal.libroDAO.buscarLibroID(libro);

				if (libro.getNombre() != null) {

					cajaIdLibro.setText(String.valueOf(libro.getIdLibro()));
					cajaNombre.setText(libro.getNombre());
					cajaAutor.setText(libro.getAutor());
					cajaPrecio.setText(String.valueOf(libro.getPrecio()));
					cajaStock.setText(String.valueOf(libro.getStock()));

					activarCajas();
				}

			}

		}

		else if (e.getSource() == btnVaciar) {
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

		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}

		else if (e.getSource() == btnActualizar) {
			VentanaPrincipal.libroDAO.actualizarTabla();
		}
	}

	public void limpiarObjeto(Libro e) {
		e.setIdLibro(0);
		e.setNombre(null);
		e.setAutor(null);
		e.setPrecio(0.0);
		e.setStock(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getSource() == cajaAutor || e.getSource() == cajaNombre) {
			if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ') {
				e.consume();
			}
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