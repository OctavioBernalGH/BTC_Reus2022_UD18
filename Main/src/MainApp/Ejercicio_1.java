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
				querysCreating.add(
						"CREATE TABLE fabricantes(codigo int NOT NULL PRIMARY KEY, nombre varchar(255) NOT NULL);");

				querysCreating.add(
						"CREATE TABLE articulos(codigo int NOT NULL PRIMARY KEY, nombre varchar(255) NOT NULL, precio int NOT NULL, "
								+ "fk_fabricantes int, FOREIGN KEY (fk_fabricantes) REFERENCES fabricantes(codigo));");

				// Recorrer las query y ejecutarlas
				for (String str : querysCreating) {
					SqlTools.createTable(str, conn);
				}

				String queryAddTuple = "INSERT INTO `fabricantes` VALUES " + "(1,'Fabricante_1'),"
						+ "(2,'Fabricante_2')" + ",(3, 'Fabricante_3')" + ",(4,'Fabricante_4') "
						+ ",(5, 'Fabricante_5');";
				SqlTools.createTuple(queryAddTuple, conn);

				queryAddTuple = "INSERT INTO `articulos` VALUES " + "(1,'Tuerca', 5, 1)," + "(2,'Arandela', 10, 2)"
						+ ",(3, 'Llave', 15, 3)" + ",(4,'Gancho', 25, 4) " + ",(5,'Macarron', 50, 5);";

				SqlTools.createTuple(queryAddTuple, conn);
				
			} else if (seleccionFuncion == 1) {
				JOptionPane.showMessageDialog(null, "Se ha salido con exito");
				break;
			}
		}
	}
}
