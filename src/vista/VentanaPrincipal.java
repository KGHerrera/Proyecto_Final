package vista;

import javax.swing.*;

import vista.empleados.VentanaEmpleados;

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

		menuVentas.add(itemAltasVentas);
		menuVentas.add(itemBajasVentas);
		menuVentas.add(itemCambiosVentas);
		menuVentas.add(itemConsultasVentas);

		menuBar.add(menuVentas);

		setJMenuBar(menuBar);
		
		desktopPane = new JDesktopPane();
		internalFrameAltasEmpleados = new VentanaEmpleados();
		
		
		desktopPane.add(internalFrameAltasEmpleados);
		
		add(desktopPane, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == itemAltasEmpleados) {
			internalFrameAltasEmpleados.setVisible(true);
		}

		else if (e.getSource() == itemBajasEmpleados) {

		}
		
		else if (e.getSource() == itemCambiosEmpleados) {

		}
		
		else if (e.getSource() == itemConsultasEmpleados) {

		}
		
		
		else if (e.getSource() == itemAltasLibros) {

		}

		else if (e.getSource() == itemBajasLibros) {

		}
		
		else if (e.getSource() == itemCambiosLibros) {

		}
		
		else if (e.getSource() == itemConsultasLibros) {

		}
		

		else if (e.getSource() == itemAltasVentas) {

		}

		else if (e.getSource() == itemBajasVentas) {

		}
		
		else if (e.getSource() == itemCambiosVentas) {

		}
		
		else if (e.getSource() == itemConsultasVentas) {

		}

	}

}
