package modelo;

public class Usuario {
	private String usuario;
	private String nombre;
	private String contrasenia;

	public Usuario(String usuario, String nombre, String contrasenia) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Administrador [usuario=" + usuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + "]";
	}

}
