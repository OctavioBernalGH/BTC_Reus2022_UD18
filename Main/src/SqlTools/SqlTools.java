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
		
		public static void createTable(Connection conn, String name) throws SQLException {
			int numCol = Integer.parseInt(JOptionPane.showInputDialog("Introduce número de columnas de la tabla"));
			String añadirTupla = "";
			String nombreCol = "";
			for (int i=0; i<numCol; i++) {
				
				int seleccionOperación = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Varchar", "Nvarchar", "int", "float", "Exit" }, " 1");
				
				if(seleccionOperación == 0) {
					nombreCol = JOptionPane.showInputDialog("Introduce el nombre de la columna");
					añadirTupla = nombreCol + " varchar(40)"; 
				}
			}
			String query = "CREATE IF NOT EXISTS TABLE TEST( "+ añadirTupla+" );";
			Statement st = (Statement) conn.createStatement();
			st.execute("USE " + name);
			st.executeUpdate(query);
		}
	


}