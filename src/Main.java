import javax.swing.SwingUtilities;
import vista.*;
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {				
				// TODO Auto-generated method stub
				//new VentanaLogin();
				
				String consulta = "delete from empleados where id_empleado=?";
				
				if ((consulta.substring(consulta.length()-4, consulta.length()).equals("and "))){
					consulta = consulta.substring(0, consulta.length()-4);
				}
				
				System.out.println(consulta);
				
			}
		});
	}
}
