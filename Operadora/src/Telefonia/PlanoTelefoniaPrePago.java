package Telefonia;

public class PlanoTelefoniaPrePago extends PlanoTelefonia {
			
	private int bonus;
	
	
	public PlanoTelefoniaPrePago() {
		
	}


	public PlanoTelefoniaPrePago(int codigoPlano,String descricaoPlano,double valorPlano,int franquiaMinuto,int bonus) {
		super(codigoPlano,descricaoPlano,valorPlano,franquiaMinuto);
		this.bonus = bonus;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}	
}
