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
		//Definimos las querys
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
		
		//Recorremos las querys y las ejecutamos
		for (String str : querysCreating) {
			SqlTools.createTable(str, conn);
		}
		//Definimos las query para insertar tuplas
		String queryAddTuple = "INSERT INTO `departamentos` VALUES "
				+ "(14,'IT',65000),"
				+ "(37,'Accounting',15000)"
				+ ",(59,'Human Resources',240000)"
				+ ",(77,'Research',55000);";
		String queryAddTuple2 = "INSERT INTO `empleados` VALUES "
				+ "(123234877,'Michael','Rogers',14),"
				+ "(152934485,'Anand','Manikutty',14),"
				+ "(222364883,'Carol','Smith',37),"
				+ "(326587417,'Joe','Stevens',37),"
				+ "(332154719,'Mary-Anne','Foster',14),"
				+ "(332569843,'George','ODonnell',77),"
				+ "(546523478,'John','Doe',59),"
				+ "(631231482,'David','Smith',77),"
				+ "(654873219,'Zacary','Efron',59),"
				+ "(745685214,'Eric','Goldsmith',59),"
				+ "(845657233,'Luis','López',14),"
				+ "(845657245,'Elizabeth','Doe',14),"
				+ "(845657246,'Kumar','Swamy',14),"
				+ "(845657266,'Jose','Pérez',77)";;
		//Creamos las tuplas en la base de datos
		SqlTools.createTuple(queryAddTuple, conn);
		SqlTools.createTuple(queryAddTuple2, conn);
		
		//Print Empleados
		String querySelectAllEmpleados = "SELECT * FROM empleados";
		SqlTools.printEmpleadotoObject(querySelectAllEmpleados, conn);
		
		//Print Departamentos
		String querySelectAllDepartamentos = "SELECT * FROM departamentos";
		SqlTools.printDepartamentoObject(querySelectAllDepartamentos, conn);
	}

}
