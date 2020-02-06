package Internet;

import negocio.Plano;

public abstract class PlanoInternet extends Plano{
	
	
	private int velocidadeInternet;
	private int franquiaDados;
	
	
	public PlanoInternet() {
		
	}


	public PlanoInternet(int codigoPlano,String descricaoPlano,double valorPlano,int velocidadeInternet, int franquiaDados) {
		
		
		super(codigoPlano, descricaoPlano, valorPlano);
		this.velocidadeInternet = velocidadeInternet;
		this.franquiaDados = franquiaDados;
	}


	public int getVelocidadeInternet() {
		return velocidadeInternet;
	}


	public void setVelocidadeInternet(int velocidadeInternet) {
		this.velocidadeInternet = velocidadeInternet;
	}


	public int getFranquiaDados() {
		return franquiaDados;
	}


	public void setFranquiaDados(int franquiaDados) {
		this.franquiaDados = franquiaDados;
	}
	
	
	
	
}
