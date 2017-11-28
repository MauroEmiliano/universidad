package dbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import basics.DBManager;
import dao.UsuarioDAO;
import entidades.Usuario;
import exceptions.EntidadException;;

public class UsuarioDAODBImpl implements UsuarioDAO{

	public Usuario getUsuario(String user) throws EntidadException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("SELECT * FROM usuarios where user = ?");
			p.setString(1, user);
			ResultSet rs = p.executeQuery();
			Usuario u = new Usuario();
			while(rs.next()){
				u.setUser(rs.getString("user"));
				u.setEmail(rs.getString("email"));
				u.setFechaNacimiento(rs.getString("fechaNacimiento"));
				return u;
			}				
		} catch (SQLException e) {
			throw new EntidadException("Hubo un error buscando el usuario seleccionado", e);
		}
		finally {
				try {c.close();}
				catch(SQLException e1){}}
		return null;
	}

	@Override
	public void altaUsuario(Usuario u) throws EntidadException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("INSERT INTO usuarios "
					+ "VALUES (?,?,?,?)");
			p.setString(1, u.getUser());
			p.setString(2, u.getPass());
			p.setString(3, u.getEmail());
			p.setString(4, u.getFechaNacimiento());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {throw new EntidadException("Hubo un error al querer insertar un usuario", e1);
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
	}

	@Override
	public void bajaUsuario(Usuario u) throws EntidadException {
		String sql = "DELETE FROM usuarios WHERE user = ?";
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, u.getUser());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {	throw new EntidadException("Hubo un error borrando el usuario seleccionado", e1);}
		}
	}

	@Override
	public void modificarUsuario(Usuario u) throws EntidadException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("UPDATE usuarios set email = ? where user = ?");
			p.setString(1, u.getEmail());
			p.setString(2, u.getUser());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {throw new EntidadException("Hubo un error actualizando el usuario", e1);}
		}
		
	}

	@Override
	public List<Usuario> getTodosLosUsuarios() throws EntidadException {
		List<Usuario> us = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setUser(rs.getString("user"));
				u.setEmail(rs.getString("email"));
				u.setFechaNacimiento(rs.getString("fechaNacimiento"));
				us.add(u);
			}
			return us;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {}  
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {throw new EntidadException("Hubo un error buscando todas los usuarios", e1);}
		}return null;
	}
	
	public Usuario usuarioLogIn(Usuario u) throws EntidadException {
		Connection c = DBManager.connect();
		Usuario ulog = new Usuario();
		try {
			PreparedStatement p = c.prepareStatement("select user,pass from usuarios where user = ?");
			p.setString(1, u.getUser());
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				ulog.setUser(rs.getString("user"));
				ulog.setPass(rs.getString("pass"));
			}
			return ulog;
			}
		 catch (SQLException e) {
			try {
				c.close();
				c.rollback();
			} catch (SQLException e1) {throw new EntidadException("Error, usuario o contraseña no coincide", e1);
			}
		}
		return ulog;
	}

}
