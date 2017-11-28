package ui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Usuario;
import exceptions.EntidadException;
import ui.Handler.HandlerDepto;
import ui.Handler.HandlerLogin;
import ui.Paneles.PanelPrincipal;

public class LogInFrame extends JFrame {
	
	private JTextField usuarioTF;
	private JTextField contraseñaPF;
	private JButton logBT;
	private JButton salirBT;
	private HandlerLogin lhandler;
	
	public LogInFrame(HandlerLogin lhandler) {
		super("Admin Consorcio'");
		this.lhandler = lhandler;
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initUI();
		this.setVisible(true);
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		JLabel titulo = new JLabel("LOGIN:");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(50));
		usuarioTF = new JTextField(20);
		createTextfieldRow("Usuario:",usuarioTF,vertical);
		vertical.add(vertical.createVerticalStrut(50));
		contraseñaPF = new JPasswordField(15);
		createTextfieldRow("Contraseña:",contraseñaPF,vertical);
		vertical.add(vertical.createVerticalStrut(50));
		logBT = new JButton("Ingresar");
		createButtonsRow(vertical, logBT);
		vertical.add(vertical.createVerticalStrut(50));
		salirBT = new JButton("Salir");
		createButtonsRow(vertical, salirBT);
		vertical.add(vertical.createVerticalStrut(50));
		
		logBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuarioTF.getText().isEmpty() || contraseñaPF.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else{
					Usuario u = new Usuario();
					u.setUser(usuarioTF.getText());
					u.setPass(contraseñaPF.getText());
					try {
						Usuario ulog = new Usuario();
						ulog = null;
						ulog = lhandler.usuarioLogIn(u);
						if(ulog.getUser() != null){ 
							if(ulog.getPass().equals(u.getPass())){
								new HandlerDepto();
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (EntidadException e1) {
						JOptionPane.showMessageDialog(null, e1, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		salirBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(vertical);
	}
	
	public void createTextfieldRow(String label, JTextField textfield, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		vertical.add(horizontal);
	}
	
	public void createCheckBoxRow(String label, JCheckBox cb, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(cb);
		vertical.add(horizontal);
	}
	
	public void createButtonsRow(Box vertical, JButton boton) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(horizontal.createHorizontalGlue());
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(boton);
		vertical.add(horizontal);
	}
}