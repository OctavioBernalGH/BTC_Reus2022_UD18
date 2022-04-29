package MainApp;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;

import SqlTools.SqlTools;

public class Ejercicio2 {
	
	public static void ejecutarEjercicio2(Connection conn) throws SQLException {
		SqlTools.createDB("PruebaJAVA2", conn);
	}

}
