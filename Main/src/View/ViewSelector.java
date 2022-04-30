package View;

/**
 * @author Octavio, David, Uri
 * @date 29/04/2022
 * @version 0.0.1
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import MainApp.Ejercicio2;
import MainApp.Ejercicio5;
import MainApp.Ejercicio9;
import MainApp.Ejercicio_1;
import SqlTools.SqlTools;

public class ViewSelector {

	// Atributos de clase
	static String address;
	static String userSQL;
	static String password;

	// Instancia de la Connection
	public static Connection conn = null;

	// M�todo para elegir el servidor
	public static void selectorVistas() throws ClassNotFoundException, SQLException {
		
		// Bucle infinito.
		int bucle = 0;
		while (bucle == 0) {

			// Panel de selecci�n mediante showOptionalDialog.
			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "IP Uri", "IP David", "IP Octavio", "IP Manual", "Exit" }, " 1");

			// Condicional selector de servidor.
			if (seleccion == 0) {
				address = "192.168.56.102";
				userSQL = "remote";
				password = "Reus_2022";
				System.out.println("Conectado a BBDD de Uri");
				conn = SqlTools.createConnection(address, userSQL, password);
			} else if (seleccion == 1) {
				address = "192.168.1.69";
				userSQL = "remote";
				password = "Reus_2022";
				System.out.println("Conectado a BBDD de David");
				conn = SqlTools.createConnection(address, userSQL, password);
			} else if (seleccion == 2) {
				address = "192.168.1.123";
				userSQL = "remote";
				password = "Reus_2022";
				System.out.println("Conectado a BBDD de Octavio");
				conn = SqlTools.createConnection(address, userSQL, password);
			} else if (seleccion == 3) {
				address = JOptionPane.showInputDialog("Direccion del servidor");
				userSQL = JOptionPane.showInputDialog("Nombre del usuario");
				password = JOptionPane.showInputDialog("Password");
				conn = SqlTools.createConnection(address, userSQL, password);
			} else if (seleccion == 4) {
				JOptionPane.showMessageDialog(null, "Se ha salido con exito del programa.");
				break;
			}

			// Panel de selecci�n de ejercicio mediante showOptionalDialog.
			int seleccionEjercicio = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Ejercicio 1", "Ejercicio 2", "Ejercicio 3", "Ejercicio 4", "Ejercicio 5",
							"Ejercicio 6", "Ejercicio 7", "Ejercicio 8", "Ejercicio 9", "Exit" },
					" 1");

			// Condicional selector de ejercicio.
			if (seleccionEjercicio == 0) {
				Ejercicio_1.ejecutarEjercicio1(conn);
			} else if (seleccionEjercicio == 1) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 2) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 3) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 4) {
				Ejercicio5.ejecutarEjercicio5(conn);
			} else if (seleccionEjercicio == 5) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 6) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 7) {
				Ejercicio2.ejecutarEjercicio2(conn);
			} else if (seleccionEjercicio == 8) {
				Ejercicio9.ejecutarEjercicio9(conn);
			}else if (seleccionEjercicio == 9) {
				JOptionPane.showMessageDialog(null, "Se ha salido con exito");
				break;
			}

			// Cierre de conexi�n.
			SqlTools.closeConnection();
		}
	}

}
