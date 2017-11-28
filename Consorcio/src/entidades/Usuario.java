package entidades;

public class Usuario {
	private String user;
	private String pass;
	private String email;
	private String fechaNacimiento;
	

	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Usuario(){}
	
	public Usuario(String user, String pass, String email, String fechaNacimiento){
		this.user=user;
		this.pass=pass;
		this.email=email;
		this.fechaNacimiento=fechaNacimiento;
	}
	
}