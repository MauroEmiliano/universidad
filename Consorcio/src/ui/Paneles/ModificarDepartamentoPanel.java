package ui.Paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entidades.Departamento;
import exceptions.EntidadException;
import ui.Handler.HandlerDepto;
public class ModificarDepartamentoPanel extends JPanel {

	private JTextField campoDepto;
	private JTextField campoPiso;
	private JTextField campoExpensas;
	private JTextField campoTitular;
	private HandlerDepto handlerDepto;
	private JButton botonModificar;
	private JButton botonBack;
	
	private Departamento dep;

	
	public ModificarDepartamentoPanel(HandlerDepto hanlderDepto){
		handlerDepto = hanlderDepto;
		initUI();
	}
	
	public ModificarDepartamentoPanel(HandlerDepto hanlderDepto, Departamento d){
		
		this.dep = d;
		
		handlerDepto = hanlderDepto;
		initUI();
		
		int piso = d.getPiso();
		String pisoS = String.valueOf(piso);
		
		this.campoPiso.setText(pisoS);
		this.campoDepto.setText(d.getDepto());
		this.campoTitular.setText(d.getTitular());
		
		
		float expensa = d.getExpensas();
		String expensaS = String.valueOf(expensa);
		this.campoExpensas.setText(expensaS);
		
		
		//this.campoExpensas.setText("expensa");
		//this.campoTitular.setText("titular");
		//this.campoPiso.setText(pisoS);
				
			
		
	}
	
	
	public void initUI(){
		
Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Modificar Departamento");
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
		
		botonModificar = new JButton("Modificar");
		createButtonsRow(vertical, botonModificar);
		vertical.add(vertical.createVerticalStrut(15));
		
		botonBack = new JButton("Volver");
		createButtonsRow(vertical, botonBack);
		vertical.add(vertical.createVerticalStrut(15));
		
		//Departamento dee = new Departamento();
		//dee.setDepto(dep.getDepto());
		//System.out.println( " el departamento es " + dee.getDepto() + " el titular es: " + dee.getTitular());
		
		/*int piso = d.getPiso();
		String pisoS = String.valueOf(piso);
		this.campoDepto.setText(pisoS);*/
		//this.campoTitular.setText(dep.getTitular());
		
		//System.out.println(dep.getTitular());
		
		//this.campoDepto.setText(dep.getDepto());
		/*this.campoPiso.setText("piso");
		this.campoExpensas.setText("expensa");
		this.campoTitular.setText("titular");*/
		
		this.campoDepto.setEditable(false);
		this.campoPiso.setEditable(false);
		
		botonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			handlerDepto.volver();
			}
		});
		
botonModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String expensas = campoExpensas.getText();
				String campoTit = campoTitular.getText();
				
				if (!(expensas.isEmpty() && expensas.isEmpty())){
					Departamento d = new Departamento(Integer.parseInt(campoPiso.getText()),
							  						  campoDepto.getText(),
				  						  			  Float.parseFloat(campoExpensas.getText()),
				  						  			  campoTitular.getText()
													 );
					//try{
						handlerDepto.modificarDepartamento(d, Integer.parseInt(campoPiso.getText()), campoDepto.getText());
					//}
						JOptionPane.showMessageDialog(null, "El departamento se modificó correctamente");
					//catch (EntidadException e){
					//	JOptionPane.showMessageDialog(null, "Hubo un error ERROR" + e);
					//}
										
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Titular y Expensas son campos obligatorios");
				}
				
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
}
