package Telefonia;

public class TelefoniaPlanoPos extends PlanoTelefonia {

	
	private double minutoAdicional;
	
	
	public TelefoniaPlanoPos() {
		
	}
	
	public TelefoniaPlanoPos(int codigoPlano,double minutoAdicional,double valorPlano,int franquiaMinuto,String descricaoPlano) {
		super(codigoPlano, descricaoPlano, valorPlano, franquiaMinuto);
		this.minutoAdicional = minutoAdicional;
	}

	public double getMinutoAdicional() {
		return minutoAdicional;
	}

	public void setMinutoAdicional(double minutoAdicional) {
		this.minutoAdicional = minutoAdicional;
	}
	
	
}


