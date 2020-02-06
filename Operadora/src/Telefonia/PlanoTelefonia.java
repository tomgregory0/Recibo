package Telefonia;

import negocio.Plano;

public class PlanoTelefonia extends Plano {

	private int franquiaMinuto;

	
	public PlanoTelefonia() {	
		
	}	
	public PlanoTelefonia(int codigoPlano,String descricaoPlano,double valorPlano,int franquiaMinuto) {
		
		super(codigoPlano, descricaoPlano, valorPlano);
		this.franquiaMinuto = franquiaMinuto;
	
	}
	
	public int getFranquiaMinuto() {
		return franquiaMinuto;
	}

	public void setFranquiaMinuto(int franquiaMinuto) {
		this.franquiaMinuto = franquiaMinuto;
	}
}
