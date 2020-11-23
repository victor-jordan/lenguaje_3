package sistemaRegistro;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntfBaseDato {
	
	public static Boolean Login(String ejecutar) throws SQLException {
		Connection conexion = IntfConexion.conectar();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(ejecutar);
		if(resultado.isBeforeFirst()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static DefaultTableModel retornarLista(String ejecutar) throws SQLException{
		Connection conexion = IntfConexion.conectar();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(ejecutar);
		ResultSetMetaData metaDatos = (ResultSetMetaData) resultado.getMetaData();
		
		int columnasCantidad = metaDatos.getColumnCount();
		Vector<String> columnasNombre = new Vector<String>();
		
		for(int c = 1; c <= columnasCantidad; c++) {
			columnasNombre.add(metaDatos.getColumnName(c));
		}
		
		Vector<Vector<Object>> lista = new Vector<Vector<Object>>();
		
		while(resultado.next()) {
			Vector<Object> fila = new Vector<Object>();
			for (int i = 1; i <= columnasCantidad; i++) {
				fila.add(resultado.getObject(i));
			}
			lista.add(fila);
		}
		return new DefaultTableModel(lista, columnasNombre);
	}
	
	public static Boolean Insertar(String ejecutar) throws SQLException {
		Connection conexion = IntfConexion.conectar();
		Statement sentencia = conexion.createStatement();
		if(sentencia.executeUpdate(ejecutar)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Boolean Modificar(String ejecutar) throws SQLException { return false; }
}
