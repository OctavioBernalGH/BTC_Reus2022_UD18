package MainApp;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;


public class MainApp {
	
		
	public static void main(String[] args) {
		
		String address = JOptionPane.showInputDialog("Direccion del servidor");
		String userSQL = JOptionPane.showInputDialog("Nombre del usuario");
		String password= JOptionPane.showInputDialog("Password");
		

		SqlTools herramientasSQL = new SqlTools(address, userSQL, password);
		
		String Query;
		String name;
		
		try {
			SqlTools.createConnection(address, userSQL, password);
	
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


			try {
			name = JOptionPane.showInputDialog("Introduce número de DDBB a crear:");
			Query = "CREATE DATABASE " + name;
			Statement st = SqlTools.crearStatement(null);
			st.execute(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la BBDD " + name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}

}
