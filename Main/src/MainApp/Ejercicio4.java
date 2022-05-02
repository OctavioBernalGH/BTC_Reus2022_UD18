package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio4 {
	public static void ejecutarEjercicio4(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio4", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE peliculas ("+
				  "CODIGO int NOT NULL,"+
				  "NOMBRE nvarchar(100) NOT NULL,"+
				  "CALIFICACIONEDAD int NOT NULL,"+
				  "PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `salas` ("+
				  "`CODIGO` int NOT NULL,"+
				  "`NOMBRE` nvarchar(100) NOT NULL,"+
				  "`PELICULA` int NOT NULL,"+
				  "PRIMARY KEY (`CODIGO`),"+
				  "KEY `CODIGO` (`CODIGO`),"+
				  "CONSTRAINT `NOMBRE` FOREIGN KEY (`NOMBRE`) REFERENCES `peliculas` (`NOMBRE`)"+
				  "CONSTRAINT `CODIGO` FOREIGN KEY (`CODIGO`) REFERENCES `peliculas` (`CODIGO`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `peliculas` VALUES "
				+ "(1,'Piratas',16),"
				+ "(2,'Fast&Furius',18)"
				+ ",(3,'Sonic',6)";
		String queryAddTuple2 = "INSERT INTO `salas` VALUES "
				+ "(1,'Fast&Furius',2),"
				+ "(2,'Fast&Furius',2),"
				+ "(3,'Piratas',1),"
				+ "(2,'Piratas',1),"
				+ "(2,'Sonic',3),";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		
		//Print Empleados
		String querySelectAllEmpleados = "SELECT * FROM peliculas";
		SqlTools.printAlmacenesObject(querySelectAllEmpleados, conn);
		
		//Print Departamentos
		String querySelectAllDepartamentos = "SELECT * FROM salas";
		SqlTools.printCajasObject(querySelectAllDepartamentos, conn);
	}
}
