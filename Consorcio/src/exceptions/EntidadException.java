package exceptions;

import java.sql.SQLException;

public class EntidadException extends Exception {

	

	public EntidadException(String msj) {
		super(msj);
	}

	public EntidadException (String msj, SQLException eSQL){
		super(msj, eSQL);
	}

}
