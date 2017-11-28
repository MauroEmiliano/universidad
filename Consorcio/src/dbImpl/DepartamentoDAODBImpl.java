package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import basics.DBManager;
import dao.DepartamentoDAO;
import entidades.Departamento;
import exceptions.EntidadException;

public class DepartamentoDAODBImpl implements DepartamentoDAO{

	public void insertarDepartamento(Departamento d) throws EntidadException{

		String sql = "INSERT INTO departamento (depto, piso, expensas, titular) VALUES ('"+d.getDepto()+
						"','"+d.getPiso()+"','"+d.getExpensas()+"','"+d.getTitular()+"')";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
			throw new EntidadException("Hubo un error al crear el departamento", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
	}

	//FIXME rollback
	public void deleteDepartamento(int piso, String depto)  throws EntidadException{
		String sql = "DELETE FROM departamento WHERE piso = '" + piso + "' and depto = '"+ depto +"'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			}
		catch (SQLException e) {
			throw new EntidadException("Hubo un error al intentar eliminar el departamento");				
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}

	public void updateDepartamento(Departamento d, int piso, String depto)  throws EntidadException {
		//SET column1=value1,column2=value2
		String sql = "UPDATE departamento set depto = '" + d.getDepto() + "', piso = '" + d.getPiso() +
				"', expensas= '"+d.getExpensas() + "', titular = '"+d.getTitular()+"' WHERE depto = '" +
				depto + "' and piso = '"+piso+"'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
			throw new EntidadException("Hubo un error al crear el departamento", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
				
		
	}

	public List<Departamento> getDatosDepto() throws EntidadException {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		String sql = "select piso, depto, expensas, titular FROM departamento";
		
		Connection c = DBManager.getInstance().connect();
		try {
			Statement stmt =c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				Departamento departamento = new Departamento();
				departamento.setPiso(rs.getInt("piso"));
				departamento.setDepto(rs.getString("depto"));
				departamento.setExpensas(rs.getFloat("expensas"));
				departamento.setTitular(rs.getString("titular"));
				
				departamentos.add(departamento);
			}
		}
		catch (SQLException e){
			try {
				c.rollback();
			}
			catch (SQLException e1){
			}
			throw new EntidadException("Error al listar todos los departamentos", e);
			
		} finally {
			try{
				c.close();
			}
			catch (SQLException e1){}
		}
		return departamentos;
	}

	public Departamento getUnDepartamento(int piso, String depto) throws EntidadException {
		
		String sql = "select piso, depto, expensas, titular FROM departament where piso = '" + piso + "' and depto = '" + depto + "'"; ;
		
		Connection c = DBManager.getInstance().connect();
		try
		{
			Departamento deptoDevuelto = new Departamento();
			Statement stmt =c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				deptoDevuelto.setPiso(rs.getInt("piso"));
				deptoDevuelto.setDepto(rs.getString("depto"));
				deptoDevuelto.setExpensas(rs.getFloat("expensas"));
				deptoDevuelto.setTitular(rs.getString("titular"));
				
			}
			return deptoDevuelto;
			
		}
		catch (SQLException e){
			try{
				c.rollback();
			}
			catch(SQLException e1) {}
			throw new EntidadException("Hubo un error al listar el departamento", e);
		} finally {
		try {
		c.close();
		} catch (SQLException e1){}	
		
	}
		
	}


	

}

