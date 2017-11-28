package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Departamento;
import entidades.Usuario;
import ui.Handler.HandlerDepto;

public class AltaUsuarioPanel extends PanelPrincipal{
		
	public AltaUsuarioPanel(HandlerDepto handlerDepto){
		handler = handlerDepto;
		initUI();
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Insertar Usuario:");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(10));
		
		userTF = new JTextField(20);
		createTextfieldRow("Usuario:",userTF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		
		passTF = new JPasswordField(10);
		createTextfieldRow("Contraseña:",passTF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		
		emailTF = new JTextField(1);
		createTextfieldRow("Email:",emailTF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		
		fechaTF = new JTextField(10);
		createTextfieldRow("Fecha Nacimiento:",fechaTF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		
		aceptarBT = new JButton("Insertar");
		createButtonsRow(vertical, aceptarBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		volverBT = new JButton("Volver");
		createButtonsRow(vertical, volverBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		limpiarBT = new JButton("Limpiar");
		createButtonsRow(vertical, limpiarBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		aceptarBT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(validarCampo(userTF) || validarCampo(passTF) || validarCampo(emailTF) ||	validarCampo(fechaTF))
					handler.mostrarErrorIgreso("Por favor complete todos los campos.");
				else{
					Usuario u = new Usuario(userTF.getText(),passTF.getText(),emailTF.getText(),fechaTF.getText());
					handler.altaUsuario(u);
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
		
		add(vertical);
		
	}

	public void limpiarCampos(){
		userTF.setText("");
		passTF.setText("");
		emailTF.setText("");
		fechaTF.setText("");
	}
}