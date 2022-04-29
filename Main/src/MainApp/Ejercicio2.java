package MainApp;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio2 {
	
	public static void ejecutarEjercicio2(Connection conn) throws SQLException {
		SqlTools.createDB("PruebaJAVA2", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		querysCreating.add("CREATE TABLE departamentos ("+
				  "CODIGO int NOT NULL,"+
				  "NOMBRE varchar(255) NOT NULL,"+
				  "PRESUPUESTO decimal(10,0) NOT NULL,"+
				  "PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `empleados` ("+
				  "`DNI` int NOT NULL,"+
				  "`NOMBRE` varchar(255) NOT NULL,"+
				  "`APELLIDOS` varchar(255) NOT NULL,"+
				  "`DEPARTAMENTO` int NOT NULL,"+
				  "PRIMARY KEY (`DNI`),"+
				  "KEY `DEPARTAMENTO` (`DEPARTAMENTO`),"+
				  "CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`DEPARTAMENTO`) REFERENCES `departamentos` (`CODIGO`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		
		
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		String queryAddTuple = "INSERT INTO `departamentos` VALUES "
				+ "(14,'IT',65000),"
				+ "(37,'Accounting',15000)"
				+ ",(59,'Human Resources',240000)"
				+ ",(77,'Research',55000);";
		SqlTools.createTuple(queryAddTuple, conn);
		
	}

}
