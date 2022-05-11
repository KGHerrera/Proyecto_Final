package vista;

import javax.swing.*;

import controlador.EmpleadoDAO;
import controlador.LibroDAO;
import vista.empleados.*;
import vista.libros.*;
import vista.ventas.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {

	JInternalFrame internalFrameAltasEmpleados, internalFrameBajasEmpleados, internalFrameCambiosEmpleados,
			internalFrameConsultasEmpleados, internalFrameAltasVentas, internalFrameBajasVentas,
			internalFrameCambiosVentas, internalFrameConsultasVentas, internalFrameAltasLibros,
			internalFrameBajasLibros, internalFrameCambiosLibros, internalFrameConsultasLibros;

	JMenuItem itemAltasEmpleados, itemBajasEmpleados, itemCambiosEmpleados, itemConsultasEmpleados, itemAltasLibros,
			itemBajasLibros, itemCambiosLibros, itemConsultasLibros, itemAltasVentas, itemBajasVentas,
			itemCambiosVentas, itemConsultasVentas;

	JDesktopPane desktopPane;
	
	public static EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	public static LibroDAO libroDAO = new LibroDAO();

	public VentanaPrincipal() {

		getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana Princpal");
		setSize(1366, 768);

		setVisible(true);

		JMenuBar menuBar = new JMenuBar();

		JMenu menuEmpleados = new JMenu("Empleado");
		JMenu menuLibros = new JMenu("Libro");
		JMenu menuVentas = new JMenu("Venta");
		Dimension d1 = new Dimension(90, 25);
		Dimension d2 = new Dimension(87, 25);

		menuEmpleados.setPreferredSize(d1);
		menuLibros.setPreferredSize(d1);
		menuVentas.setPreferredSize(d1);

		itemAltasEmpleados = new JMenuItem("Agregar");
		itemBajasEmpleados = new JMenuItem("Eliminar");
		itemCambiosEmpleados = new JMenuItem("Modificar");
		itemConsultasEmpleados = new JMenuItem("Buscar");

		itemAltasEmpleados.addActionListener(this);
		itemBajasEmpleados.addActionListener(this);
		itemCambiosEmpleados.addActionListener(this);
		itemConsultasEmpleados.addActionListener(this);

		menuEmpleados.add(itemAltasEmpleados);
		menuEmpleados.add(itemBajasEmpleados);
		menuEmpleados.add(itemCambiosEmpleados);
		menuEmpleados.add(itemConsultasEmpleados);

		menuBar.add(menuEmpleados);

		itemAltasLibros = new JMenuItem("Agregar");
		itemBajasLibros = new JMenuItem("Eliminar");
		itemCambiosLibros = new JMenuItem("Modificar");
		itemConsultasLibros = new JMenuItem("Buscar");

		itemAltasLibros.addActionListener(this);
		itemBajasLibros.addActionListener(this);
		itemCambiosLibros.addActionListener(this);
		itemConsultasLibros.addActionListener(this);

		menuLibros.add(itemAltasLibros);
		menuLibros.add(itemBajasLibros);
		menuLibros.add(itemCambiosLibros);
		menuLibros.add(itemConsultasLibros);

		menuBar.add(menuLibros);

		itemAltasVentas = new JMenuItem("Agregar");
		itemBajasVentas = new JMenuItem("Eliminar");
		itemCambiosVentas = new JMenuItem("Modificar");
		itemConsultasVentas = new JMenuItem("Buscar");

		itemAltasLibros.addActionListener(this);
		itemBajasLibros.addActionListener(this);
		itemCambiosLibros.addActionListener(this);
		itemConsultasLibros.addActionListener(this);

		itemAltasEmpleados.setPreferredSize(d2);
		itemBajasEmpleados.setPreferredSize(d2);
		itemCambiosEmpleados.setPreferredSize(d2);
		itemConsultasEmpleados.setPreferredSize(d2);

		itemAltasLibros.setPreferredSize(d2);
		itemBajasLibros.setPreferredSize(d2);
		itemCambiosLibros.setPreferredSize(d2);
		itemConsultasLibros.setPreferredSize(d2);

		itemAltasVentas.setPreferredSize(d2);
		itemBajasVentas.setPreferredSize(d2);
		itemCambiosVentas.setPreferredSize(d2);
		itemConsultasVentas.setPreferredSize(d2);

		menuVentas.add(itemAltasVentas);
		menuVentas.add(itemBajasVentas);
		menuVentas.add(itemCambiosVentas);
		menuVentas.add(itemConsultasVentas);

		itemAltasVentas.addActionListener(this);
		itemBajasVentas.addActionListener(this);
		itemCambiosVentas.addActionListener(this);
		itemConsultasVentas.addActionListener(this);

		menuBar.add(menuVentas);
		setJMenuBar(menuBar);

		desktopPane = new JDesktopPane();
		internalFrameAltasEmpleados = new AltasEmpleados();
		desktopPane.add(internalFrameAltasEmpleados);

		internalFrameBajasEmpleados = new BajasEmpleados();
		desktopPane.add(internalFrameBajasEmpleados);

		internalFrameCambiosEmpleados = new CambiosEmpleados();
		desktopPane.add(internalFrameCambiosEmpleados);

		internalFrameConsultasEmpleados = new ConsultasEmpleados();
		desktopPane.add(internalFrameConsultasEmpleados);

		internalFrameAltasLibros = new AltasLibros();
		desktopPane.add(internalFrameAltasLibros);

		internalFrameBajasLibros = new BajasLibros();
		desktopPane.add(internalFrameBajasLibros);

		internalFrameCambiosLibros = new CambiosLibros();
		desktopPane.add(internalFrameCambiosLibros);

		internalFrameConsultasLibros = new ConsultasLibros();
		desktopPane.add(internalFrameConsultasLibros);

		internalFrameAltasVentas = new AltasVentas();
		desktopPane.add(internalFrameAltasVentas);

		internalFrameBajasVentas = new BajasVentas();
		desktopPane.add(internalFrameBajasVentas);

		internalFrameCambiosVentas = new CambiosVentas();
		desktopPane.add(internalFrameCambiosVentas);

		internalFrameConsultasVentas = new ConsultasVentas();
		desktopPane.add(internalFrameConsultasVentas);

		esconderVentanas();

		add(desktopPane, BorderLayout.CENTER);

		setLocationRelativeTo(null);

		VentanaPrincipal.empleadoDAO.getCon().actualizarTabla();
		VentanaPrincipal.empleadoDAO.getCon().actualizarTablaLibros();

	}

	public void esconderVentanas() {
		internalFrameAltasEmpleados.setVisible(false);
		internalFrameBajasEmpleados.setVisible(false);
		internalFrameCambiosEmpleados.setVisible(false);
		internalFrameConsultasEmpleados.setVisible(false);

		internalFrameAltasLibros.setVisible(false);
		internalFrameBajasLibros.setVisible(false);
		internalFrameCambiosLibros.setVisible(false);
		internalFrameConsultasLibros.setVisible(false);

		internalFrameAltasVentas.setVisible(false);
		internalFrameBajasVentas.setVisible(false);
		internalFrameCambiosVentas.setVisible(false);
		internalFrameConsultasVentas.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == itemAltasEmpleados) {
			esconderVentanas();
			internalFrameAltasEmpleados.setVisible(true);
		}

		else if (e.getSource() == itemBajasEmpleados) {
			esconderVentanas();
			internalFrameBajasEmpleados.setVisible(true);
		}

		else if (e.getSource() == itemCambiosEmpleados) {
			esconderVentanas();
			internalFrameCambiosEmpleados.setVisible(true);
		}

		else if (e.getSource() == itemConsultasEmpleados) {
			esconderVentanas();
			internalFrameConsultasEmpleados.setVisible(true);
		}

		else if (e.getSource() == itemAltasLibros) {
			esconderVentanas();
			internalFrameAltasLibros.setVisible(true);
		}

		else if (e.getSource() == itemBajasLibros) {
			esconderVentanas();
			internalFrameBajasLibros.setVisible(true);
		}

		else if (e.getSource() == itemCambiosLibros) {
			esconderVentanas();
			internalFrameCambiosLibros.setVisible(true);
		}

		else if (e.getSource() == itemConsultasLibros) {
			esconderVentanas();
			internalFrameConsultasLibros.setVisible(true);
		}

		else if (e.getSource() == itemAltasVentas) {
			esconderVentanas();
			internalFrameAltasVentas.setVisible(true);
		}

		else if (e.getSource() == itemBajasVentas) {
			esconderVentanas();
			internalFrameBajasVentas.setVisible(true);
		}

		else if (e.getSource() == itemCambiosVentas) {
			esconderVentanas();
			internalFrameCambiosVentas.setVisible(true);
		}

		else if (e.getSource() == itemConsultasVentas) {
			esconderVentanas();
			internalFrameConsultasVentas.setVisible(true);
		}

	}

}
