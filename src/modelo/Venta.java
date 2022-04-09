package modelo;

public class Venta {
	private int idVenta;
	private int cantidadLibros;
	private double totalPagar;
	private int idEmpleado;
	private int idLibro;

	public Venta(int idVenta, int cantidadLibros, double totalPagar, int idEmpleado, int idLibro) {
		super();
		this.idVenta = idVenta;
		this.cantidadLibros = cantidadLibros;
		this.totalPagar = totalPagar;
		this.idEmpleado = idEmpleado;
		this.idLibro = idLibro;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getCantidadLibros() {
		return cantidadLibros;
	}

	public void setCantidadLibros(int cantidadLibros) {
		this.cantidadLibros = cantidadLibros;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", cantidadLibros=" + cantidadLibros + ", totalPagar=" + totalPagar
				+ ", idEmpleado=" + idEmpleado + ", idLibro=" + idLibro + "]";
	}

}
