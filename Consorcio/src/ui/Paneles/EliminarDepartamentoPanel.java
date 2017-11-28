package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.EntidadException;
import ui.Handler.HandlerDepto;

public class EliminarDepartamentoPanel extends JPanel {

	private HandlerDepto handlerDepto;
	private JTextField depto;
	private JTextField pisoDepto;
	
	private JButton botonEliminar;
	private JButton botonBack;
	
	
	public EliminarDepartamentoPanel(HandlerDepto handlerDepto) {
		this.handlerDepto = handlerDepto;
		initUI();		
	}

	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Eliminar Departamento");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(5));
		
		
		depto = new JTextField(10);
		pisoDepto = new JTextField(10);
		
		JLabel labelNro = new JLabel("Depto:");
		JLabel labelPiso = new JLabel("Piso:");
		
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(labelNro);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(depto);
		
		horizontal.add(labelPiso);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(pisoDepto);
		
		vertical.add(horizontal);
		vertical.add(vertical.createVerticalStrut(15));
		
		botonEliminar = new JButton("Eliminar");
		botonBack = new JButton("Volver");
		
		vertical.add(botonEliminar);
		vertical.add(botonBack);
		
		vertical.add(vertical.createVerticalStrut(15));
		
		
		
		add(vertical);
		
		
		botonEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int opcion = JOptionPane.showConfirmDialog(null, "Desea continuar con la eliminación?", "Eliminar", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION){
					
					String piso = pisoDepto.getText();
					String deptoLetra = depto.getText();
					
					if(!(piso.trim().isEmpty() && deptoLetra.trim().isEmpty())){
						//try{
						handlerDepto.eliminarDepartamento(Integer.parseInt(pisoDepto.getText()), depto.getText());
						JOptionPane.showMessageDialog(null, "El departamento se eliminó");
						limpiarCampos();
						//}catch (EntidadException e1){
						//	JOptionPane.showMessageDialog(null, "Hubo un error ERROR" + e1);
						//}
					}
					else
						JOptionPane.showMessageDialog(null, "Los datos son obligatorios");
					
				}
			}
		});
		botonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			handlerDepto.volver();
			}
		});
		
		
		}
	private void limpiarCampos(){
		this.depto.setText("");
		this.pisoDepto.setText("");
		
	}
}
