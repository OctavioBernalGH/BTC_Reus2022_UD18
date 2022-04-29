package SqlTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SqlTools {
	
	static Connection mysqlConn = null;
	
//Open connection
	public static Connection createConnection(String address, String userMysql, String passwordMysql) throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			mysqlConn =DriverManager.getConnection("jdbc:mysql://"+address+":3306?useTimezone=UTC",userMysql,passwordMysql);	
			System.out.println("Conectado");
			
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("No se ha podido connectar a la base de datos");
			System.out.println(e);
		}
		
		return mysqlConn;
	}
	
//Close connection
	public static void closeConnection() {
		try {
			mysqlConn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
//Create database @param: "name of database"
		public static void createDB(String name, Connection conn) throws SQLException {
			try {
				//Crear base de datos
				String query ="CREATE DATABASE IF NOT EXISTS " + name;
				Statement st = (Statement) conn.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Base de datos "+name+" creada");
				
				//Apuntar a la base de datos
				query ="USE " + name;
				st = (Statement) conn.createStatement();
				st.executeUpdate(query);
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				
			}
			
		}
		
		//Create Table on Database
				public static void createTable(String query, Connection conn) throws SQLException {
					try {
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tabla creada");
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
		//Create Tuple
				public static void createTuple(String query, Connection conn) throws SQLException{
					try {
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tupla creada");
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}

	


}