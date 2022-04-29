package MainApp;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;


public class MainApp {
	public static void main(String[] args) {
		String address = JOptionPane.showInputDialog("Direccion del servidor");
		String userSQL = JOptionPane.showInputDialog("Nombre del usuario");
		String password= JOptionPane.showInputDialog("Password");
	
		try {
			SqlTools.createConnection(address, userSQL, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
}
