package ui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import entidades.Departamento;
import ui.Handler.HandlerDepto;

public class MiFrame extends JFrame {
	
	private HandlerDepto handlerDepto;
	
	public MiFrame(HandlerDepto deptoHandler) {
	super("Consorcio departamentos");
	this.handlerDepto = deptoHandler;
	setSize(700, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addMenuBar();
	}
	
	
	private void addMenuBar(){
		JMenuBar barra = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.add(new JMenuItem("Salir"));
		
		JMenu menuDeptos = new JMenu("Adminstracion Departamentos");
		
		JMenuItem insertarDepartamento = new JMenuItem("Insertar Departamento");
		insertarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				handlerDepto.MostrarInsertarDepartamento();				
			}
		});
		menuDeptos.add(insertarDepartamento);
		
		//JMenuItem modificarDepartamento = new JMenuItem("Modificar Departamento");
		//modificarDepartamento.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent ae) {
		//		handlerDepto.mostrarModificarDepartamento();
		//	}
		//});
		//menuDeptos.add(modificarDepartamento);
		
		JMenuItem eliminarDepartamento = new JMenuItem("Eliminar Departamento");
		eliminarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				handlerDepto.mostrarEliminarDepartamento();
			}
		});
		menuDeptos.add(eliminarDepartamento);
		
		
		JMenuItem mostrarTodos = new JMenuItem("Mostrar todos los Departamentos");
		mostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				handlerDepto.mostrarTodosDepartamentos();
			}
		});
		menuDeptos.add(mostrarTodos);
				
		barra.add(menuArchivo);
		barra.add(menuDeptos);
		
		JMenu usuarioMenu = new JMenu("Usuarios");
		JMenuItem altaUsuario = new JMenuItem("Alta");
		altaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlerDepto.mostrarAltaUsuario();
			}
		});
		usuarioMenu.add(altaUsuario);
		JMenuItem bajaUsuario = new JMenuItem("Baja");
		bajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlerDepto.mostrarBajaUsuario();
			}
		});
		/*usuarioMenu.add(bajaUsuario);
		JMenuItem modUsuario = new JMenuItem("Modificar");
		modUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlerDepto.mostrarModificarUsuario();
			}
		});*/
		//usuarioMenu.add(modUsuario);
		barra.add(usuarioMenu);
		
		
		setJMenuBar(barra);
	}
	
	public void cambiarPanel(JPanel panel){
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}
	
}
