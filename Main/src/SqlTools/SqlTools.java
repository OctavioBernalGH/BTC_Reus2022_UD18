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
import Class.EquipoClass;
import Class.FacultadClass;
import Class.InvestigadorClass;
import Class.ReservaClass;

public class SqlTools {
	
	static Connection mysqlConn = null;
	
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
				//From DB to Object ReservaClass
				public static void printReservaObject(String query, Connection conn) throws SQLException{
					try {
						List<ReservaClass> lstReservas = new ArrayList<ReservaClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							ReservaClass reserva = new ReservaClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							reserva.setDni(rs.getString(1));
							reserva.setNumSerie(rs.getString(2));
							reserva.setComienzo(rs.getDate(3));
							reserva.setFin(rs.getDate(4));
							//Add to list
							lstReservas.add(reserva);
						}
						System.out.println("___________________________________________________");
						System.out.println("Reserva");
						System.out.println("___________________________________________________");
						for(ReservaClass ob : lstReservas) {
							System.out.println("******************************");
							System.out.println("Dni: "			+ob.dni);
							System.out.println("Num Serie: "	+ob.numSerie);
							System.out.println("Comienzo: "		+ob.comienzo);
							System.out.println("Fin: "			+ob.fin);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				//From DB to Object FacultadClass
				public static void printFacultadObject(String query, Connection conn) throws SQLException{
					try {
						List<FacultadClass> lstFacultades = new ArrayList<FacultadClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							FacultadClass facultad = new FacultadClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							facultad.setCodigo(rs.getInt(1));
							facultad.setNombre(rs.getString(2));
							
							//Add to list
							lstFacultades.add(facultad);
						}
						System.out.println("___________________________________________________");
						System.out.println("Facultad");
						System.out.println("___________________________________________________");
						for(FacultadClass ob : lstFacultades) {
							System.out.println("******************************");
							System.out.println("Codigo: "			+ob.codigo);
							System.out.println("Nombre: "			+ob.nombre);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				//From DB to Object InvestigadoresClass
				public static void printInvestigadorObject(String query, Connection conn) throws SQLException{
					try {
						List<InvestigadorClass> lstInvestigadores = new ArrayList<InvestigadorClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							InvestigadorClass investigador = new InvestigadorClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							investigador.setDni(rs.getString(1));
							investigador.setNomApels(rs.getString(2));
							investigador.setFacultad(rs.getInt(3));
							
							//Add to list
							lstInvestigadores.add(investigador);
						}
						System.out.println("___________________________________________________");
						System.out.println("Investigador");
						System.out.println("___________________________________________________");
						for(InvestigadorClass ob : lstInvestigadores) {
							System.out.println("******************************");
							System.out.println("Dni: "				+ob.dni);
							System.out.println("Nombre: "			+ob.nomApels);
							System.out.println("Facultad: "			+ob.facultad);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				//From DB to Object EquipoClass
				public static void printEquiposObject(String query, Connection conn) throws SQLException{
					try {
						List<EquipoClass> lstEquipo = new ArrayList<EquipoClass>();
						
						//Crear Table
						Statement st = (Statement) conn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							EquipoClass equipo = new EquipoClass();
							/*Conociendo la estructura de la base de datos, 
							 * indicamos que campo queremos obtener con la posicion de este
							 */
							equipo.setNumSerie(rs.getString(1));
							equipo.setNombre(rs.getString(2));
							equipo.setFacultad(rs.getInt(3));
							
							//Add to list
							lstEquipo.add(equipo);
						}
						System.out.println("___________________________________________________");
						System.out.println("Equipo");
						System.out.println("___________________________________________________");
						for(EquipoClass ob : lstEquipo) {
							System.out.println("******************************");
							System.out.println("NumSerie: "			+ob.numSerie);
							System.out.println("Nombre: "			+ob.nombre);
							System.out.println("Facultad: "			+ob.facultad);
						}
					}catch(SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
}