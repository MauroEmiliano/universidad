package bo;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;

import entidades.Usuario;
import exceptions.EntidadException;


public class UsuarioBO {
	
	private UsuarioDAO usuarioDAO;
	
	//traer usuario
	public Usuario getUsuario(String user) throws EntidadException{
		return usuarioDAO.getUsuario(user);
	}
	
	//insertar usuario
	public void altaUsuario(Usuario u) throws EntidadException{
		Usuario usuarioBase = new Usuario();
		usuarioBase = getUsuario(u.getUser());
		if(usuarioBase == null){
			usuarioDAO.altaUsuario(u);
		}
		else
			throw new EntidadException("El codigo del usuario ya existe");
	}
	//borrar usuario
	public void bajaUsuario(Usuario u) throws EntidadException{
		usuarioDAO.bajaUsuario(u);
	}
	//modificar usuario
	public void modificarUsuario(Usuario u) throws EntidadException{
		usuarioDAO.modificarUsuario(u);
	}
	
	//listar todos los usuarios
	public java.util.List<Usuario> getTodosLosUsuarios() throws EntidadException{
		return usuarioDAO.getTodosLosUsuarios();
	}
	
	//get usario
	public Usuario usuarioLogIn(Usuario u) throws EntidadException{
		return usuarioDAO.usuarioLogIn(u);
	}
	
	//set usuario
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
