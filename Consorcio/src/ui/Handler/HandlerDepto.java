package ui.Handler;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import bo.UsuarioBO;

import bo.DepartamentoBO;
import dbImpl.DepartamentoDAODBImpl;
import entidades.Departamento;
import entidades.Usuario;
import exceptions.EntidadException;
import ui.Frame.MiFrame;
import ui.Paneles.*;



import ui.Frame.LogInFrame;
import ui.Frame.MiFrame;
import ui.Paneles.*;


public class HandlerDepto {
	private MiFrame frame;
	private UsuarioBO usuarioBO;
	private DepartamentoBO departamentoBO;
	
	public HandlerDepto(){
		frame = new MiFrame(this);
		departamentoBO = new DepartamentoBO();
		departamentoBO.setDao(new DepartamentoDAODBImpl());
		
		frame.setVisible(true);
	}
	
	public void MostrarInsertarDepartamento() {
		frame.cambiarPanel(new AltaDepartamentoPanel(this) );
	}
	
	public void InsertarDepartamento(Departamento d) throws EntidadException{
		departamentoBO.insertarDepartamento(d);
	}
		
	
	public void mostrarModificarDepartamento( Departamento d){
		frame.cambiarPanel(new ModificarDepartamentoPanel(this, d));
	}
	
	public void modificarDepartamento(Departamento d, int piso, String depto){
		try{
			departamentoBO.updateDepartamento( d,  piso,  depto);
		}catch (EntidadException e){
			showError(e);
		}
	}
	
	public void mostrarTodosDepartamentos(){
		try{
			List<Departamento> datosDepto = departamentoBO.getDatosDepto();
			frame.cambiarPanel(new MostrarTodosLosDepartamentos(this, datosDepto));
		} catch (EntidadException e){
			showError(e);
		}
	}
	
	public void mostrarEliminarDepartamento(){
		frame.cambiarPanel(new EliminarDepartamentoPanel(this));
	}
	
	public void eliminarDepartamento(int piso, String depto){
		try{
			departamentoBO.deleteDepartamento(piso, depto);
		}
		catch(EntidadException e){
			showError(e);
		}
	}
	
	public Departamento getDepartamentoPorPisoDeptoDepto(int piso, String depto){
		Departamento d = null;
		try{
			d = departamentoBO.getUnDepartamento(piso, depto);
		}
		catch (EntidadException e){
			showError(e);
		}
		return d;
	}
		
	public void volver(){
		frame.cambiarPanel(new JPanel());
	}

	private void showError(EntidadException e){
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void mostrarAltaUsuario(){
		frame.cambiarPanel(new AltaUsuarioPanel(this));
	}
	public void mostrarErrorIgreso(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showSucces(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	public void altaUsuario(Usuario u){
		try {
			usuarioBO.altaUsuario(u);
			showSucces("Se inserto el usuario correctamente");
		} catch (EntidadException e) {
			showError(e);
		}
	}
	
	public void mostrarBajaUsuario(){
		frame.cambiarPanel(new BajaUsuarioPanel(this));
	}
	
	public void bajaUsuario(Usuario u){
		try{
			usuarioBO.bajaUsuario(u);
		}catch (EntidadException e){
			showError(e);
		}
	}
	
	/*public void mostrarModificarUsuario(){
		frame.cambiarPanel(new ModificarUsuarioPanel(this));
	}*/
	
	public void modificarUsuario(Usuario u){
		try{
			usuarioBO.modificarUsuario(u);
		}catch (EntidadException e){
			showError(e);
		}
	}
	
	public Usuario getUsuario(String user){
		try{
			return usuarioBO.getUsuario(user);
		}catch (EntidadException e){
			showError(e);
		}return null;
	}
}
