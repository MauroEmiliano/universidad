package ui;

import java.sql.SQLException;

import basics.TableManager;
import ui.Handler.HandlerDepto;
import ui.Handler.HandlerLogin;

public class Test {

	public static void main(String[] args){
		
		/*TableManager tm = new TableManager();
		try {
			tm.createDepartamentoTable();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}*/
		//Sin login
		//new HandlerDepto();
		//Con login
		new HandlerLogin();
	}
}
