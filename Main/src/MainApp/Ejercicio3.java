package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio3 {
	public static void ejecutarEjercicio3(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio3", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE almacenes ("+
				  "CODIGO int NOT NULL,"+
				  "LUGAR Nvarchar(100) NOT NULL,"+
				  "CAPACIDAD int NOT NULL,"+
				  "PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `cajas` ("+
				  "`NUMREFERENCIA` int NOT NULL,"+
				  "`CONTENIDO` varchar(255) NOT NULL,"+
				  "`VALOR` varchar(255) NOT NULL,"+
				  "`ALAMACEN` int NOT NULL,"+
				  "PRIMARY KEY (`NUMREFERENCIA`),"+
				  "KEY `CODIGO` (`ALMACEN`),"+
				  "CONSTRAINT `ALMACEN` FOREIGN KEY (`ALMACENES`) REFERENCES `almacenes` (`CODIGO`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `almacenes` VALUES "
				+ "(14,'Reus',200),"
				+ "(37,'Tarragona',500)"
				+ ",(59,'Barcelona',1000)";
		String queryAddTuple2 = "INSERT INTO `cajas` VALUES "
				+ "(2023,'Perchas',200,14),"
				+ "(152934485,'Calcetines',100,37),"
				+ "(222364883,'Juguetes',550,59),"
				+ "(326587417,'Esparadrapos',50,37),"
				+ "(332154719,'Pegamento',250,37),"
				+ "(332569843,'Atun',1500,59),"
				+ "(546523478,'Ladrillos',1300,14),";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		
		//Print Almacenes
		String querySelectAllAlmacenes = "SELECT * FROM almacenes";
		SqlTools.printAlmacenesObject(querySelectAllAlmacenes, conn);
		
		//Print Cajas
		String querySelectAllCajas = "SELECT * FROM cajas";
		SqlTools.printCajasObject(querySelectAllCajas, conn);
	}
}
