package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Departamento;
import entidades.Usuario;
import exceptions.EntidadException;
import ui.Handler.HandlerDepto;

public class BajaUsuarioPanel extends PanelPrincipal{
	
	private JTextField mensajeTF;
	private JButton eliminarBT;
	
	public BajaUsuarioPanel(HandlerDepto handlerDepto){
		handler = handlerDepto;
		initUI();
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("ELIMINAR USUARIO");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(10));
		
		userTF = new JTextField(20);
		JLabel campo1 = new JLabel("Codigo:");
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(userTF);
		vertical.add(horizontal);
		vertical.add(vertical.createVerticalStrut(15));
		
		eliminarBT = new JButton("Eliminar");
		volverBT = new JButton("Volver");
		vertical.add(eliminarBT);
		vertical.add(volverBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		mensajeTF = new JTextField(20);
		mensajeTF.setEnabled(false);
		vertical.add(mensajeTF);
		vertical.add(vertical.createVerticalStrut(10));
		
		limpiarBT = new JButton("Limpiar");
		createButtonsRow(vertical, limpiarBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		add(vertical);
		
		eliminarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?","ELIMINAR",JOptionPane.YES_NO_OPTION); 
				if(opcion == JOptionPane.YES_OPTION) {
					if(!validarCampo(userTF)) {
						String cod = userTF.getText();
						Usuario u = new Usuario();
						u = handler.getUsuario(userTF.getText());
						if(u != null){
							handler.bajaUsuario(u);
							mensajeTF.setText("El usuario "+userTF.getText()+" fue eliminado.");
						}else
							JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL USUARIO");
					}
				}
			}
		});
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.volver();
			}
		});	
		
		limpiarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}
	
	public void limpiarCampos(){
		mensajeTF.setText("");
		userTF.setText("");
	}
	
}