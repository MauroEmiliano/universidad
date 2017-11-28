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
import exceptions.EntidadException;
import ui.Handler.HandlerDepto;

public class AltaDepartamentoPanel extends JPanel{
	
	private JTextField campoDepto;
	private JTextField campoPiso;
	private JTextField campoExpensas;
	private JTextField campoTitular;
	private HandlerDepto handlerDepto;
	private JButton botonAceptar;
	private JButton botonBack;
	
	
	public AltaDepartamentoPanel(HandlerDepto hanlderDepto){
		handlerDepto = hanlderDepto;
		initUI();
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Insertar Departamento");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(35));
		
		campoPiso = new JTextField(3);
		createTextfieldRow("Piso:", campoPiso, vertical);
		vertical.add(vertical.createVerticalStrut(35));
		
		campoDepto = new JTextField(2);
		createTextfieldRow("Letra/Numero Depto", campoDepto, vertical);
		vertical.add(vertical.createVerticalStrut(35));
		
		campoTitular = new JTextField(30);
		createTextfieldRow("Titular depto:", campoTitular, vertical);
		vertical.add(vertical.createVerticalStrut(35));
		
		campoExpensas = new JTextField(8);
		createTextfieldRow("Expensas:", campoExpensas, vertical);
		vertical.add(vertical.createVerticalStrut(35));
		
		botonAceptar = new JButton("Insertar");
		createButtonsRow(vertical, botonAceptar);
		vertical.add(vertical.createVerticalStrut(15));
		
		botonBack = new JButton("Volver");
		createButtonsRow(vertical, botonBack);
		vertical.add(vertical.createVerticalStrut(15));
		
		//Departamento(int piso, String depto, float expensas, String titular)
		
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				String piso = campoDepto.getText();
				String deptoLetra = campoPiso.getText();
				String expensas = campoExpensas.getText();
				String campoTit = campoTitular.getText();
				
				if (!(piso.isEmpty() || deptoLetra.isEmpty() || expensas.isEmpty() || campoTit.isEmpty())){
				
				Departamento d = new Departamento(Integer.parseInt(campoPiso.getText()),
												  campoDepto.getText(),
												  Float.parseFloat(campoExpensas.getText()),
												  campoTitular.getText()
												);
				try{
					handlerDepto.InsertarDepartamento(d);
					JOptionPane.showMessageDialog(null, "El departamento se insertó correctamente");
					limpiarCampos();
				}catch (EntidadException e){
					JOptionPane.showMessageDialog(null, "Hubo un error ERROR" + e);
				}
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios");
				}
			}
			
		});
		botonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			handlerDepto.volver();
			}
		});
		add(vertical);
	}
	
	
	
	private void createTextfieldRow(String label, JTextField textfield, Box vertical) {
		JLabel campo1 = new JLabel(label);
		
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		
		vertical.add(horizontal);
	}
	
	private void createButtonsRow(Box vertical, JButton boton){
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(horizontal.createHorizontalGlue());
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(boton);
		vertical.add(horizontal);
	}
	private void limpiarCampos(){
		this.campoDepto.setText("");
		this.campoPiso.setText("");
		this.campoExpensas.setText("");
		this.campoTitular.setText("");
	}
}
