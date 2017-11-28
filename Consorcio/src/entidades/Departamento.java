
package entidades;

public class Departamento {
	public Departamento(){};
	public Departamento(int piso, String depto, float expensas, String titular) {
		
		this.piso = piso;
		this.depto = depto;
		this.expensas = expensas;
		this.titular = titular;
	}

	private int piso;
	private String depto;
	private float expensas;
	private String titular;
	
	public int getPiso(){
		return piso;
	}
	
	public void setPiso(int piso){
		this.piso=piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public float getExpensas() {
		return expensas;
	}

	public void setExpensas(float expensas) {
		this.expensas = expensas;
	}
	
	public String getTitular(){
		return titular;
	}
	
	public void setTitular(String titular){
		this.titular =titular;
	}
	
	
}
