package sistemaRegistro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IntfConexion {
	static String USERNAME = "userdb";
	static String PASSWORD = "123456";
	static String CONN_STRING = "jdbc:mysql://localhost:3306/prueba";
	
	public static Connection conectar() throws SQLException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		return conexion;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
}
