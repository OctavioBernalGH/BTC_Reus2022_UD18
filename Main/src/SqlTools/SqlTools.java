package SqlTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTools {
	
	protected String adressSQL;
	protected String userNameSQL;
	protected String passwordSQL;
	
	public SqlTools() {}
	
	public SqlTools(String adressSQL, String userNameSQL, String passwordSQL) {
		this.adressSQL = adressSQL;
		this.userNameSQL = userNameSQL;
		this.passwordSQL = passwordSQL;
	}
	
	static Connection mysqlConn = null;
	
	// M�todo para crear la conexi�n
	public static Connection createConnection(String addressSQL, String userNameSQL, String passwordSQL) throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			mysqlConn =DriverManager.getConnection("jdbc:mysql://"+addressSQL+":3306?useTimezone=UTC",userNameSQL,passwordSQL);	
			System.out.println("Conexi�n establecida con el servidor.");
			
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("No se ha podido connectar a la base de datos");
			System.out.println(e);
		}
		
		return mysqlConn;
	}
	
	// M�todo para crear el Statement de la conexi�n.
	public static Statement crearStatement(Connection mysqlConn) {
		
		try {
			Statement st = mysqlConn.createStatement();
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	// M�todo para cerrar la conexi�n
	public static Connection closeConnection() {
		try {
			mysqlConn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
		return mysqlConn;
	}

}
