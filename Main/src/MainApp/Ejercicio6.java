package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio6 {
	public static void ejecutarEjercicio6(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio6", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE Piezas ("+
				"CODIGO int NOT NULL,"+
				"NOMBRE nvarchar(100) NOT NULL,"+
				"PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `Proveedores` ("+
				"ID char(4) NOT NULL,"+
				"NOMBRE nvarchar(100) NOT NULL,"+
				"PRIMARY KEY (`CODIGO`),"+				  
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE Suministra ("+
				"`CODIGOPIEZA` int NOT NULL,"+
				"`IDPROVEEDOR` char(4) NOT NULL,"+
				"`PRECIO` int NOT NULL"+
				"PRIMARY KEY (`CODIGOPIEZA`)"+
				"PRIMARY KEY (`IDPROVEEDOR`)"+
				"CONSTRAINT `CODIGOPIEZA` FOREIGN KEY (`CODIGOPIEZA`) REFERENCES `Piezas` (`CODIGO`)"+
				"CONSTRAINT `IDPROVEEDOR` FOREIGN KEY (`IDPROVEEDOR`) REFERENCES `Proveedores` (`ID`)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `Piezas` VALUES "
				+ "(1,'Tornillo'),"
				+ "(2,'Hembra')"
				+ ",(3,'Destornillador')";
		String queryAddTuple2 = "INSERT INTO `Proveedores` VALUES "
				+ "(1,'David','CD22'),"
				+ "(2,'Octavio','CD44'),"
				+ "(3,'Uri','121C'),";
		String queryAddTuple3 = "INSERT INTO `suministra` VALUES "
				+ "(1,'CD22',15),"
				+ "(2,'CD44',12),"
				+ "(3,'121C',15),";
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		SqlTools.createTuple(queryAddTuple3, conn);

		//Print Piezas
		String querySelectAllPiezas = "SELECT * FROM Piezas";
		SqlTools.printAlmacenesObject(querySelectAllPiezas, conn);

		//Print Proveedores
		String querySelectAllProveedor = "SELECT * FROM Proveedores";
		SqlTools.printCajasObject(querySelectAllProveedor, conn);

		//Print Proveedores
		String querySelectAllSuminstra = "SELECT * FROM Suministra";
		SqlTools.printCajasObject(querySelectAllSuminstra, conn);
	}
}
