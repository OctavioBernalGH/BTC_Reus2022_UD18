package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;


public class MainApp {
	
	public static Connection conn=null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String address = JOptionPane.showInputDialog("Direccion del servidor");
		String userSQL = JOptionPane.showInputDialog("Nombre del usuario");
		String password= JOptionPane.showInputDialog("Password");
	
		//conn = connectionDB(address, userSQL, password);
		
		conn = SqlTools.createConnection(address, userSQL, password);
		
		Ejercicio2.ejecutarEjercicio2(conn);
		
		SqlTools.closeConnection();
	}
}
