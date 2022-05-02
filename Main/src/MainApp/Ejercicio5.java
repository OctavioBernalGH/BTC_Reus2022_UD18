package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio5 {
	
	public static void ejecutarEjercicio5(Connection conn) throws SQLException  {
		
		SqlTools.createDB("Ejercicio5", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE DESPACHOS("
				+ "NUMERO INT PRIMARY KEY NOT NULL,"
				+ "CAPACIDAD INT);");
		querysCreating.add("CREATE TABLE DIRECTORES("
				+ "DNI VARCHAR(8) PRIMARY KEY NOT NULL,"
				+ "NOMBREAPELLIDOS NVARCHAR(255),"
				+ "FK_DNIJEFE VARCHAR(8) NOT NULL,"
				+ "FK_DESPACHO INT NOT NULL,"
				+ "CONSTRAINT FK_DNIJEFE FOREIGN KEY (FK_DNIJEFE) "
				+ "REFERENCES DIRECTORES(DNI)ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "CONSTRAINT FK_DESPACHO FOREIGN KEY (FK_DESPACHO) "
				+ "REFERENCES DESPACHOS(NUMERO)ON DELETE CASCADE ON UPDATE CASCADE);");
		
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		
		String queryAddTuple = "INSERT INTO "
				+ "`DESPACHOS` (`NUMERO`, `CAPACIDAD`) VALUES"
				+ " ('1', '2'),"
				+ "('2', '3'),"
				+ "('4', '3');";
		String queryAddTuple2 = "INSERT INTO "
				+ "`DIRECTORES` (`DNI`, `NOMBREAPELLIDOS`, `FK_DNIJEFE`, `FK_DESPACHO`) VALUES "
				+ "('213332', 'jose', '213332', '2'),"
				+ "('3221', 'enric', '213332', '1'),"
				+ "('432234', 'eva', '3221', '1');";
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		
		//Print Directores
		String querySelectAllDirectores = "SELECT * FROM DIRECTORES";
		SqlTools.printDirectorObject(querySelectAllDirectores, conn);
		String querySelectAllDespachos = "SELECT * FROM DESPACHOS";
		SqlTools.printDespachoObject(querySelectAllDespachos, conn);
	}

}
