package basics;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {
	//crear la tabla departamento
	public void createDepartamentoTable() throws SQLException {
		String sql = "create table departamento (piso int, depto varchar(100), expensas double,	titular varchar(100))";
		Connection c = DBManager.getInstance().connect();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		c.commit();
			
	}
	//crear tabla usuario
	public void createUsuarioTable() throws SQLException {
		String sql = "create table usuarios (user VARCHAR(256), pass VARCHAR(10), email VARCHAR(70), fechaNacimiento VARCHAR(70))";
		Connection c = DBManager.getInstance().connect();
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		c.commit();
			
	}
	
	//borrar tabla usuario
	public void dropUserTable() {
		String sql = "DROP TABLE usuarios";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//insertar un usuario
	public void insertUserTable() {
		String sql = "insert into usuarios values ('admin', 'admin', 'admin@admin.com', '01/01/89')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
