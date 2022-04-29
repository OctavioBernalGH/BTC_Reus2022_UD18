package SqlTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.MysqlType;

public class SqlTools {

	static Connection mysqlConn = null;

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

	public void createDB(String nombre, Connection con) {		
		try {
			String Query = "CREATE DATABASE " + nombre;
			Statement st = con.createStatement();
			st.executeUpdate(Query);
			SqlTools.closeConnection();
			createConnection("root","", nombre);
		} catch (Exception ex) {
			Logger.getLogger(MysqlType.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void createTable(String db, String nombre, Connection con) {
		try {
			String Querydb = "USE" + db + ";";
			Statement stdb = con.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + nombre + "" + "Codigo INT PRIMARY KEY AUTO_INCREMENT, Lugar NVARCHAR(100), Capacidad INT";
			Statement st = con.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla");
		}
	}

	public static void closeConnection() {
		try {
			mysqlConn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
