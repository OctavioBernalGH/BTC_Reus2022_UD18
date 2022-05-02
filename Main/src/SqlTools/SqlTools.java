package SqlTools;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

import Class.DepartamentoClass;
import Class.DespachoClass;
import Class.DirectorClass;
import Class.EmpleadoClass;

import Class.Cajas;
import Class.Almacenes;

import javax.swing.JOptionPane;

public class SqlTools {

	static Connection mysqlConn = null;

	
//Open connection

	//Open connection

	public static Connection createConnection(String address, String userMysql, String passwordMysql) throws ClassNotFoundException {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			mysqlConn =DriverManager.getConnection("jdbc:mysql://"+address+":3306?useTimezone=UTC",userMysql,passwordMysql);	
			System.out.println("Conectado");

		}catch(SQLException | ClassNotFoundException e){
			System.out.println("No se ha podido connectar a la base de datos");
			System.out.println(e);
		}

		return mysqlConn;
	}

	
//Close connection


	//Close connection

	public static void closeConnection() {
		try {
			mysqlConn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

	
//Create database @param: "name of database"
		public static void createDB(String name, Connection conn) throws SQLException {
			try {
				//Crear base de datos
				String query ="CREATE DATABASE IF NOT EXISTS " + name;
				Statement st = (Statement) conn.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Base de datos "+name+" creada");
				
				//Apuntar a la base de datos
				query ="USE " + name;
				st = (Statement) conn.createStatement();
				st.executeUpdate(query);
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				
			}
			
		}
		
		//Create Table on Database
				public static void createTable(String query, Connection conn) throws SQLException {
					try {
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tabla creada");
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
		//Create Tuple
				public static void createTuple(String query, Connection conn) throws SQLException{
					try {
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tupla creada");
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
		//TODO: Delete tuple
				public static void deleteTuple(String query, Connection conn) throws SQLException{
					
				}
		//From DB to Object EmpleadoClass
				public static void printEmpleadotoObject(String query, Connection conn) throws SQLException{
					try {
						List<EmpleadoClass> lstEmpleados = new ArrayList<EmpleadoClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							EmpleadoClass empleado = new EmpleadoClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con el nombre del campo
							 */
							empleado.setDni(rs.getString("DNI"));
							empleado.setNombre(rs.getString("NOMBRE"));
							empleado.setApellidos(rs.getString("APELLIDOS"));
							empleado.setDepartamento(rs.getInt("DEPARTAMENTO"));
							//Add to list
							lstEmpleados.add(empleado);
						}
						System.out.println("___________________________________________________");
						System.out.println("Empleados");
						System.out.println("___________________________________________________");
						for(EmpleadoClass ob : lstEmpleados) {
							System.out.println("******************************");
							System.out.println("Dni: "			+ob.dni);
							System.out.println("Nombre: "		+ob.nombre);
							System.out.println("Apellidos: "	+ob.apellidos);
							System.out.println("Departamento"	+ob.departamento);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
		//From DB to Object DepartamentoClass
				public static void printDepartamentoObject(String query, Connection conn) throws SQLException{
					try {
						List<DepartamentoClass> lstDepartamentos = new ArrayList<DepartamentoClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							DepartamentoClass departamento = new DepartamentoClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con el nombre del campo
							 */
							departamento.setCodigo(rs.getInt("CODIGO"));
							departamento.setNombre(rs.getString("NOMBRE"));
							departamento.setPresupuesto(rs.getInt("PRESUPUESTO"));
							//Add to list
							lstDepartamentos.add(departamento);
						}
						System.out.println("___________________________________________________");
						System.out.println("Departamentos");
						System.out.println("___________________________________________________");
						for(DepartamentoClass ob : lstDepartamentos) {
							System.out.println("******************************");
							System.out.println("Codigo: "		+ob.codigo);
							System.out.println("Nombre: "		+ob.nombre);
							System.out.println("Presupuesto: "	+ob.presupuesto);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				//From DB to Object DirectorClass
				public static void printDirectorObject(String query, Connection conn) throws SQLException{
					try {
						List<DirectorClass> lstDirectores = new ArrayList<DirectorClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							DirectorClass director = new DirectorClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							director.setDni(rs.getString(1));
							director.setNomApels(rs.getString(2));
							director.setDniJefe(rs.getString(3));
							director.setDespacho(rs.getInt(4));
							//Add to list
							lstDirectores.add(director);
						}
						System.out.println("___________________________________________________");
						System.out.println("Directores");
						System.out.println("___________________________________________________");
						for(DirectorClass ob : lstDirectores) {
							System.out.println("******************************");
							System.out.println("Dni: "					+ob.dni);
							System.out.println("Nombre y apellidos: "	+ob.nomApels);
							System.out.println("Dni del jefe: "			+ob.dniJefe);
							System.out.println("Despacho: "				+ob.dniJefe);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				//From DB to Object DespachorClass
				public static void printDespachoObject(String query, Connection conn) throws SQLException{
					try {
						List<DespachoClass> lstDespachos = new ArrayList<DespachoClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							DespachoClass despacho = new DespachoClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							despacho.setNumero(rs.getInt(1));
							despacho.setCapacidad(rs.getInt(2));
							//Add to list
							lstDespachos.add(despacho);
						}
						System.out.println("___________________________________________________");
						System.out.println("Despachos");
						System.out.println("___________________________________________________");
						for(DespachoClass ob : lstDespachos) {
							System.out.println("******************************");
							System.out.println("Número: "		+ob.numero);
							System.out.println("Capacidad: "	+ob.capacidad);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}


	//Create database @param: "name of database"
	public static void createDB(String name, Connection conn) throws SQLException {
		try {
			//Crear base de datos
			String query ="CREATE DATABASE IF NOT EXISTS " + name;
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Base de datos "+name+" creada");

			//Apuntar a la base de datos
			query ="USE " + name;
			st = (Statement) conn.createStatement();
			st.executeUpdate(query);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}

	//Create Table on Database
	public static void createTable(String query, Connection conn) throws SQLException {
		try {
			//Crear Table
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Tabla creada");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	//Create Tuple
	public static void createTuple(String query, Connection conn) throws SQLException{
		try {
			//Crear Table
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Tupla creada");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	//TODO: Delete tuple
	public static void deleteTuple(String query, Connection conn) throws SQLException{

	}

	//From DB to Object Almacenes
	public static void printAlmacenesObject(String query, Connection conn) throws SQLException{
		try {
			List<Almacenes> lstAlmacenes = new ArrayList<Almacenes>();

			//Crear Table
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Almacenes almacen = new Almacenes();
				/*Conociendo la estructura de la base de datos, 
				 * indicamos que campo queremos obtener con el nombre del campo
				 */
				almacen.setCodigo(rs.getInt("codigo"));
				almacen.setLugar(rs.getString("lugar"));
				almacen.setCapacidad(rs.getInt("capacidad"));
				//Add to list
				lstAlmacenes.add(almacen);
			}
			System.out.println("___________________________________________________");
			System.out.println("Almacenes");
			System.out.println("___________________________________________________");
			for(Almacenes ob : lstAlmacenes) {
				System.out.println("******************************");
				System.out.println("Codigo: " +ob.codigo);
				System.out.println("Lugar: " +ob.lugar);
				System.out.println("Capacidad: " +ob.capacidad);
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	//From DB to Object Cajas
	public static void printCajasObject(String query, Connection conn) throws SQLException{
		try {
			List<Cajas> lstCajas = new ArrayList<Cajas>();

			//Crear Table
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Cajas caja = new Cajas();
				/*Conociendo la estructura de la base de datos, 
				 * indicamos que campo queremos obtener con el nombre del campo
				 */
				caja.setNumReferencia(rs.getInt("numReferencia"));
				caja.setContenido(rs.getString("Contenido"));
				caja.setValor(rs.getInt("valor"));
				caja.setAlmacen(rs.getInt("Almacen"));
				//Add to list
				lstCajas.add(caja);
			}
			System.out.println("___________________________________________________");
			System.out.println("Cajas");
			System.out.println("___________________________________________________");
			for(Cajas ob : lstCajas) {
				System.out.println("******************************");
				System.out.println("numReferencia: " +ob.numReferencia);
				System.out.println("Contenido: " +ob.contenido);
				System.out.println("Valor: " +ob.valor);
				System.out.println("Almacen" +ob.almacen);
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}