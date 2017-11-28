package basics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbImpl.DepartamentoDAODBImpl;
import entidades.Departamento;
import entidades.Usuario;
import basics.TableManager;


public class Main {
	public static void main(String [] args){
		
//		List<Departamento> edificio = new ArrayList<Departamento>();
		boolean sigo =true;
		
		while(sigo){
			System.out.println("***************************************");
//			System.out.println("* 1 - Crear Consorcio");
			//System.out.println("* 1 - Crear Departamento");
			System.out.println("* 2 - Crear Usuario");
			System.out.println("* 3 - Crear Tabla Usuario");
			System.out.println("* 4 - Borrar Tabla Usuario");
//			System.out.println("");
			System.out.println("* 0 - SALIR");
			System.out.println("***************************************");
			int opc = Dentre.entero("Ingrese Opcion: ");
			switch(opc){
			
			case 1: Departamento d = new Departamento(3,"a",5000,"Pepe");
//					DepartamentoDAODBImpl().insertarDepartamento(d); 
					d.setPiso(6);
					break;
			case 2: TableManager tb = new TableManager();
			tb.insertUserTable();
			break;
			case 3: TableManager tb2 = new TableManager();
				try {
					tb2.createUsuarioTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			case 4: TableManager tb3 = new TableManager();
			try {
				tb3.dropUserTable();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			case 0: sigo = false;
					 		break;
			
			default: System.out.println("Opcion incorrecta");
			}
		}
	
	}

}
