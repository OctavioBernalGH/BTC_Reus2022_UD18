package MainApp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;

public class Ejercicio_1 {

	public static void ejecutarEjercicio1(Connection conn) throws SQLException {
		int bucle = 0;
		while (bucle == 0) {
			
	
		int seleccionFuncion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Crear BBDD", "Crear Tabla", "Realizar insert", "Exit" }, " 1");
		
		
		if (seleccionFuncion == 0) {
			SqlTools.createDB("Test", conn);
		} else if (seleccionFuncion == 1) {
			SqlTools.createDB("Test", conn);
		} else if (seleccionFuncion == 2) {
			SqlTools.createDB("Test", conn);
		} else if (seleccionFuncion == 3) {
			JOptionPane.showMessageDialog(null, "Se ha salido con exito");
			break;
		} 
		}
	}
}
