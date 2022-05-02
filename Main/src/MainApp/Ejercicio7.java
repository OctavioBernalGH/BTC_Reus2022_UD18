package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;
import SqlTools.SqlTools;

public class Ejercicio7 {
	public static void ejecutarEjercicio7(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio7", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE Cientificos ("+
				"DNI VARCHAR(8) NOT NULL,"+
				"NOMAPELS nvarchar(255) NOT NULL,"+
				"PRIMARY KEY (DNI)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `Proyecto` ("+
				"ID char(4) NOT NULL,"+
				"NOMBRE nvarchar(255) NOT NULL,"+
				"HORAS int NOT NULL"+
				"PRIMARY KEY (ID),"+				  
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE Asignado_a ("+
				"`CIENTIFICO` VARCHAR(8) NOT NULL,"+
				"`PROYECTO` char(4) NOT NULL,"+
				"PRIMARY KEY (`CIENTIFICO`)"+
				"PRIMARY KEY (`PROYECTO`)"+
				"CONSTRAINT `CIENTIFICO` FOREIGN KEY (`CIENTIFICO`) REFERENCES `cientificos` (`DNI`)"+
				"CONSTRAINT `PROYECTO` FOREIGN KEY (`PROYECTO`) REFERENCES `proyecto` (`ID`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `Cientificos` VALUES "
				+ "('39934923F','David'),"
				+ "('39932343A','Octavio'),"
				+ "('39232134C','Uri')";
		String queryAddTuple2 = "INSERT INTO `Proyecto` VALUES "
				+ "('3241','Bootcamp','2'),"
				+ "('3421','TSystem','17'),"
				+ "('6821','UwU','1'),";
		String queryAddTuple3 = "INSERT INTO `Asignado_a` VALUES "
				+ "('39934923F','3241'),"
				+ "('39932343A','3421'),"
				+ "('39232134C','6821'),";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		SqlTools.createTuple(queryAddTuple3, conn);

		//Print Piezas
		String querySelectAllCientificos = "SELECT * FROM Piezas";
		SqlTools.printAlmacenesObject(querySelectAllCientificos, conn);

		//Print Proveedores
		String querySelectAllProyecto = "SELECT * FROM Proveedores";
		SqlTools.printCajasObject(querySelectAllProyecto, conn);

		//Print Proveedores
		String querySelectAllAsignadoA = "SELECT * FROM Suministra";
		SqlTools.printCajasObject(querySelectAllAsignadoA, conn);
	}
}

