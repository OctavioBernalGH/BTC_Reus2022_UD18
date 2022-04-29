package SqlTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	public void closeConnection() {
		try {
			mysqlConn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
