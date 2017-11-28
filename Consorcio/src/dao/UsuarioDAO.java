package dao;

import entidades.Usuario;
import exceptions.EntidadException;;


public interface UsuarioDAO {
	public Usuario getUsuario(String user) throws EntidadException;
	public void altaUsuario(Usuario u) throws EntidadException;
	public void bajaUsuario(Usuario u) throws EntidadException;
	public void modificarUsuario(Usuario u) throws EntidadException;
	public java.util.List<Usuario> getTodosLosUsuarios() throws EntidadException;
	public Usuario usuarioLogIn(Usuario u) throws EntidadException;
}
