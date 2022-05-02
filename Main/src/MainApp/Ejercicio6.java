package MainApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTools.SqlTools;

public class Ejercicio6 {
	public static void ejecutarEjercicio6(Connection conn) throws SQLException {
		SqlTools.createDB("Ejercicio4", conn);
		//Creamos una List donde almacenar las querys que necesitamos 
		List<String> querysCreating = new ArrayList<String>();
		//Definimos las querys
		querysCreating.add("CREATE TABLE Piezas ("+
				  "CODIGO int NOT NULL,"+
				  "NOMBRE nvarchar(100) NOT NULL,"+
				  "PRIMARY KEY (CODIGO)"+
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE `Proveedores` ("+
				  "ID int NOT NULL,"+
				  "NOMBRE nvarchar(100) NOT NULL,"+
				  "PRIMARY KEY (`CODIGO`),"+				  
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		querysCreating.add("CREATE TABLE Suministra ("+
				  "`CODIGOPIEZA` int NOT NULL,"+
				  "`IDPROVEEDOR` nvarchar(100) NOT NULL,"+
				  "`PRECIO` int NOT NULL"+
				  "PRIMARY KEY (`CODIGOPIEZA`)"+
				  "PRIMARY KEY (`IDPROVEEDOR`"+
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
				+ "(1,'David',2),"
				+ "(2,'Octavio',2),"
				+ "(3,'Uri',1),";
		String queryAddTuple3 = "INSERT INTO `Proveedores` VALUES "
				+ "(1,'David',15),"
				+ "(2,'Octavio',12),"
				+ "(3,'Uri',15),";
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
	}
}
