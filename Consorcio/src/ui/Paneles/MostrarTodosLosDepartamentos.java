package ui.Paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Departamento;
import ui.Handler.HandlerDepto;

public class MostrarTodosLosDepartamentos extends JPanel{
	
	private HandlerDepto handlerDepto;
	private DepartamentoModeloTabla modeloDepto;

	
	private JTable tabla;
	private JButton botonBack;
	private JButton botonEditar;
	
	
	public MostrarTodosLosDepartamentos(HandlerDepto handlerDep, List<Departamento> departamentos) {
		handlerDepto = handlerDep;
		initUI(departamentos);
	}
	
	private void initUI(final List<Departamento> departamentos){
		modeloDepto = new DepartamentoModeloTabla(departamentos);
		tabla = new JTable(modeloDepto);
		botonBack = new JButton("Volver");
		botonEditar = new JButton("Editar");
		JScrollPane sp = new JScrollPane(tabla);
		sp.setPreferredSize(new Dimension(700,300));
		add(sp);
		add(botonBack);
		add(botonEditar);
		
		botonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlerDepto.volver();
				//handlerDepto.MostrarInsertarDepartamento();
			}
		});
		
		botonEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRowCount() != 1){
					JOptionPane.showMessageDialog(null, "Debe seleccionar uno y solo un Departamento");
															
			}
				else{
					int seleccionado = tabla.getSelectedRow();
					
					
					Departamento d = new Departamento();
					d = departamentos.get(seleccionado);
					
					System.out.println(seleccionado + " el departamento es " + d.getDepto() + " el titular es: " + d.getTitular());
					
					handlerDepto.mostrarModificarDepartamento(d);
				}
			}
		});
	}

}
