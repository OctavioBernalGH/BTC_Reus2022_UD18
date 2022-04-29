package MainApp;

/**
 * @author Octavio, David, Uri
 * @date 29/04/2022
 * @version 0.0.1
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;

public class Ejercicio_1 {

	public static void ejecutarEjercicio1(Connection conn) throws SQLException {

		// Bucle infinito para el menú
		int bucle = 0;
		while (bucle == 0) {

			// Menú de opciones mediante showOptionalDialog
			int seleccionFuncion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Realizar ejercicio 1", "Exit" }, " 1");

			// Selector de opción y acción a realizar.
			if (seleccionFuncion == 0) {

				SqlTools.createDB("UD18_Ejercicio_1", conn);
				// Definimos una lista para llenarla de querys.
				List<String> querysCreating = new ArrayList<String>();

				// Definimos las querys de creación de tablas
				querysCreating.add("CREATE TABLE departamentos (" + "CODIGO int NOT NULL,"
						+ "NOMBRE varchar(255) NOT NULL," + "PRESUPUESTO decimal(10,0) NOT NULL,"
						+ "PRIMARY KEY (CODIGO)" + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
				querysCreating.add("CREATE TABLE `empleados` (" + "`DNI` int NOT NULL,"
						+ "`NOMBRE` varchar(255) NOT NULL," + "`APELLIDOS` varchar(255) NOT NULL,"
						+ "`DEPARTAMENTO` int NOT NULL," + "PRIMARY KEY (`DNI`),"
						+ "KEY `DEPARTAMENTO` (`DEPARTAMENTO`),"
						+ "CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`DEPARTAMENTO`) REFERENCES `departamentos` (`CODIGO`)"
						+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
				// Recorrer las query y ejecutarlas
				for (String str : querysCreating) {
					SqlTools.createTable(str, conn);
				}

				String queryAddTuple = "INSERT INTO `departamentos` VALUES " + "(14,'IT',65000),"
						+ "(37,'Accounting',15000)" + ",(59,'Human Resources',240000)" + ",(77,'Research',55000);";
				//Creamos las tuplas en la base de datos
				SqlTools.createTuple(queryAddTuple, conn);
				
			} else if (seleccionFuncion == 1) {
				JOptionPane.showMessageDialog(null, "Se ha salido con exito");
				break;
			}
		}
	}
}
