package negocio;

public class Operadora {
		
	private double codigoOperadora;
	private String nomeOperadora;
	
	
	public Operadora() {
		
	}
	
	
	public Operadora(double codigoOperadora,String nomeOperadora) {
		
		this.codigoOperadora = codigoOperadora;
		this.nomeOperadora = nomeOperadora;
		
	}	
	public double getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(double codigoOperadora) {
		this.codigoOperadora = codigoOperadora;     
	}
	public String getNomeOperadora() {
		return nomeOperadora;
	}
	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}
}