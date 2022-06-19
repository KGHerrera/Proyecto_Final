import javax.swing.SwingUtilities;
import vista.*;
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {				
				// TODO Auto-generated method stub
				
				new VentanaLogin();
						
			}
		});
	}
}
