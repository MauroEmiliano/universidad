package ui.Paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Departamento;

public class DepartamentoModeloTabla extends AbstractTableModel{
	
	//int piso, String depto, float expensas, String titular
	
	private static final long serialVersionUID = 1L;
	private final static int PISO = 0;
	private final static int DEPARTAMENTO = 1;
	private final static int EXPENSAS = 2;
	private final static int TITULAR = 3;
	private List<Departamento> departamentos;
	
	public DepartamentoModeloTabla(List<Departamento> listaDeptos) {
		this.departamentos = listaDeptos;
	}

	private String[] titulos = {"Piso","Departamento","Expensas","Titular"};
	
	
	public int getColumnCount() {
		return titulos.length;
	}

	public int getRowCount() {
		return departamentos.size();
	}
	
	public Departamento getDepartamento (int row){
		return departamentos.get(row);
		
	}
	
	public String getColumnName(int arg0) {
		return titulos[arg0];
	}
	
	public Object getValueAt(int row, int column) {
		Departamento d = getDepartamento(row);
		switch(column){
		case PISO: return d.getPiso();
		case DEPARTAMENTO: return d.getDepto();
		case EXPENSAS: return d.getExpensas();
		case TITULAR: return d.getTitular();
		}
		return null;
	}

}
