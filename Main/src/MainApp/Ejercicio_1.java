package MainApp;

/**
 * @author Octavio, David, Uri
 * @date 29/04/2022
 * @version 0.0.1
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;

public class Ejercicio_1 {

	public static void ejecutarEjercicio1(Connection conn) throws SQLException {

		// Bucle infinito para el menú
		int bucle = 0;
		while (bucle == 0) {
			String bbddName = "Test";
			// Menú de opciones mediante showOptionalDialog
			int seleccionFuncion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Crear BBDD", "Crear Tabla", "Realizar insert", "Exit" }, " 1");

			// Selector de opción y acción a realizar.
			if (seleccionFuncion == 0) {
				bbddName = JOptionPane.showInputDialog("Introduce nombre de BBDD a crear");
				SqlTools.createDB(bbddName, conn);
			} else if (seleccionFuncion == 1) {
				SqlTools.createTable(conn, bbddName);
			} else if (seleccionFuncion == 2) {
				SqlTools.createDB("Test", conn);
			} else if (seleccionFuncion == 3) {
				JOptionPane.showMessageDialog(null, "Se ha salido con exito");
				break;
			}
		}
	}
}
