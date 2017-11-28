package ui.Handler;

import bo.UsuarioBO;
import dbImpl.DepartamentoDAODBImpl;
import entidades.Usuario;
import dbImpl.UsuarioDAODBImpl;
import exceptions.EntidadException;
import ui.Frame.LogInFrame;

public class HandlerLogin {

	private LogInFrame logframe;
	private UsuarioBO usuarioBO;
	
	public HandlerLogin(){
		logframe = new LogInFrame(this);
		usuarioBO = new UsuarioBO();
		usuarioBO.setUsuarioDAO(new UsuarioDAODBImpl());
	}
	
	public Usuario usuarioLogIn(Usuario u) throws EntidadException{
		return usuarioBO.usuarioLogIn(u);
	}
}
