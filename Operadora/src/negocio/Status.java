package negocio;
 
public enum Status {

	ATIVO(1,"Cliente Ativo"),
	INATIVO(2,"Inativo"),
	BLOQUEADO(3,"Bloqueado"),
	CANCELADO(4,"Cancelado");
	
	
	private Integer codigo;
	private String descricao;
	
	private Status (int codigo ,String descricao) {
			
		this.codigo= codigo;
		this.descricao = descricao;
	}	
	
	public int getCodigo() {
		return codigo;
	}
	
	
	public String getDescricao() {
	
		return descricao;
	}
}
