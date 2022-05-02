package MainApp;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import SqlTools.SqlTools;
import View.ViewSelector;


public class MainApp {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ViewSelector.selectorVistas();

	}

}
