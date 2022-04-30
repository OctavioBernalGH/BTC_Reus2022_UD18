package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio9 {

	public static void ejecutarEjercicio9(Connection conn) throws SQLException  {
		
		SqlTools.createDB("Ejercicio9", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys para crear las tablas
		querysCreating.add("CREATE TABLE FACULTAD("
				+ "CODIGO INT PRIMARY KEY AUTO_INCREMENT,"
				+ "NOMBRE NVARCHAR(100) NOT NULL);");
		querysCreating.add("CREATE TABLE INVESTIGADORES("
				+ "DNI VARCHAR(8) PRIMARY KEY,"
				+ "NOMBRE_APELLIDOS NVARCHAR(255) NOT NULL,"
				+ "COD_FACULTAD_I INT NOT NULL,"
				+ "CONSTRAINT COD_FACULTAD_I FOREIGN KEY (COD_FACULTAD_I) "
				+ "REFERENCES FACULTAD(CODIGO)ON DELETE CASCADE ON UPDATE CASCADE);");
		querysCreating.add("CREATE TABLE EQUIPOS("
				+ "NUMSERIE CHAR(4) PRIMARY KEY,"
				+ "NOMBRE NVARCHAR(100) NOT NULL,"
				+ "COD_FACULTAD_E INT NOT NULL,"
				+ "CONSTRAINT COD_FACULTAD_E FOREIGN KEY (COD_FACULTAD_E) "
				+ "REFERENCES FACULTAD(CODIGO)ON DELETE CASCADE ON UPDATE CASCADE);");
		querysCreating.add("CREATE TABLE RESERVA("
				+ "DNI_RES VARCHAR(8) NOT NULL,"
				+ "NUMSERIE_RES CHAR(4) NOT NULL,"
				+ "PRIMARY KEY (DNI_RES, NUMSERIE_RES),"
				+ "CONSTRAINT DNI_RES FOREIGN KEY (DNI_RES) "
				+ "REFERENCES INVESTIGADORES(DNI)ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "CONSTRAINT NUMSERIE_RES FOREIGN KEY (NUMSERIE_RES) "
				+ "REFERENCES EQUIPOS(NUMSERIE)ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "COMIENZO DATETIME NOT NULL,"
				+ "FIN DATETIME NOT NULL);");
		
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `FACULTAD` (`CODIGO`, `NOMBRE`) VALUES "
				+ "('1', 'popeu'),"
				+ "('2', 'bootcamp'),"
				+ "('3', 'happyCamp');";
		String queryAddTuple2 = "INSERT INTO `INVESTIGADORES` (`DNI`, `NOMBRE_APELLIDOS`, `COD_FACULTAD_I`) VALUES "
				+ "('122112', 'Ingrid', '1'),"
				+ "('3121', 'eva', '2');";
		String queryAddTuple3 = "INSERT INTO `EQUIPOS` (`NUMSERIE`, `NOMBRE`, `COD_FACULTAD_E`) VALUES "
				+ "('11', 'team1', '1'),"
				+ "('12', 'team2', '2');";
		String queryAddTuple4 = "INSERT INTO `INVESTIGADORES` (`DNI`, `NOMBRE_APELLIDOS`, `COD_FACULTAD_I`) VALUES "
				+ "('122112', 'Ingrid', '1'),"
				+ "('3121', 'eva', '2');";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		SqlTools.createTuple(queryAddTuple3, conn);
		SqlTools.createTuple(queryAddTuple4, conn);
		
	}
	
}
