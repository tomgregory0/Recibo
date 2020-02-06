package negocio;

public class Plano {
	
	private int codigoPlano;
	private String descricaoPlano;
	private double valorPlano;
	
	
	
	private int franquiaDados;
	private double dadoAdcicional;
	private int franquiaMinuto;
	
	private double minutoAdicional;
	
	
	private int bonus;
	private int velocidadeInternet;
	
	
	public Plano() {
	
	}
	
	public Plano(int codigoPlano,String descricaoPlano,double valorPlano) {
		
		this.codigoPlano = codigoPlano;
		this.descricaoPlano = descricaoPlano;
		this.valorPlano = valorPlano;
	}
	
	
	public int getCodigoPlano() {
		return codigoPlano;
	}
	public void setCodigoPlano(int codigoPlano) {
		this.codigoPlano = codigoPlano;
	}
	public String getDescricaoPlano() {
		return descricaoPlano;
	}
	public void setDescricaoPlano(String descricaoPlano) {
		this.descricaoPlano = descricaoPlano;
	}
	public double getValorPlano() {
		return valorPlano;
	}
	public void setValorPlano(double valorPlano) {
		this.valorPlano = valorPlano;
	}

	@Override
	public String toString() {
		return "Plano \ncodigoPlano=" + codigoPlano + ", \ndescricaoPlano=" + descricaoPlano + ", \nvalorPlano=" + valorPlano
				+ ", \nfranquiaDados=" + franquiaDados + ", \ndadoAdcicional=" + dadoAdcicional + ", \nfranquiaMinuto="
				+ franquiaMinuto + ", \nminutoAdicional=" + minutoAdicional + ", \nbonus=" + bonus + ", \nvelocidadeInternet="
				+ velocidadeInternet ;
	}
	
	
}
