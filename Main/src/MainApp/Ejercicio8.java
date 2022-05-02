package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;
import SqlTools.SqlTools;

public class Ejercicio8 {
	public static void ejecutarEjercicio8(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio8", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE Productos ("+
				"CODIGO INT NOT NULL,"+
				"NOMBRE nvarchar(100) NOT NULL,"+
				"PRECIO INT NOT NULL,"+
				"PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE Cajeros ("+
				"CODIGO INT NOT NULL,"+
				"NOMAPELS nvarchar(255) NOT NULL,"+
				"PRIMARY KEY (CODIGO),"+				  
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE Maquinas_Registradoras ("+
				"CODIGO INT NOT NULL,"+
				"PISO INT NOT NULL,"+				
				"PRIMARY KEY (ID),"+				  
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `Venta` ("+
				"`CAJERO` INT NOT NULL,"+
				"`MAQUINA` INT NOT NULL,"+
				"`PRODUCTO` INT NOT NULL," +
				"PRIMARY KEY (`CAJERO`),"+
				"PRIMARY KEY (`MAQUINA`),"+
				"PRIMARY KEY (`PRODUCTO`),"+
				"CONSTRAINT `CAJERO` FOREIGN KEY (`CAJERO`) REFERENCES `Cajeros` (`CODIGO`)"+
				"CONSTRAINT `CAJERO` FOREIGN KEY (`CAJERO`) REFERENCES `Maquinas_Registradoras` (`CODIGO`)"+
				"CONSTRAINT `CAJERO` FOREIGN KEY (`CAJERO`) REFERENCES `Productos` (`CODIGO`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `Cajeros` VALUES "
				+ "(1,'David'),"
				+ "(2,'Octavio'),"
				+ "(3,'Uri')";
		String queryAddTuple2 = "INSERT INTO `Maquinas_Registradoras` VALUES "
				+ "(1,2),"
				+ "(2,21),"
				+ "(3,1),";
		String queryAddTuple3 = "INSERT INTO `Productos` VALUES "
				+ "(1,'Manzana',2),"
				+ "(2,'Pera',3),"
				+ "(3,'Aguacate',5),";
		String queryAddTuple4 = "INSERT INTO `Venta` VALUES "
				+ "(1,1,2),"
				+ "(2,2,3),"
				+ "(3,3,1),";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		SqlTools.createTuple(queryAddTuple3, conn);
		SqlTools.createTuple(queryAddTuple4, conn);

		//Print Cajero
		String querySelectAllCajero = "SELECT * FROM Cajeros";
		SqlTools.printAlmacenesObject(querySelectAllCajero, conn);

		//Print Maquinas
		String querySelectAllMaquinaRegistradora = "SELECT * FROM Maquinas_Registradoras";
		SqlTools.printCajasObject(querySelectAllMaquinaRegistradora, conn);

		//Print Productos
		String querySelectAllProducto = "SELECT * FROM Productos";
		SqlTools.printCajasObject(querySelectAllProducto, conn);
		
		//Print Venta
		String querySelectAllVenta = "SELECT * FROM Venta";
		SqlTools.printCajasObject(querySelectAllVenta, conn);
	}
}

