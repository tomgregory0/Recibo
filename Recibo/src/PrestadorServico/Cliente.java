package PrestadorServico;

public class Cliente {

	private String nomeCompleto;
	private String endereco;
	private String cpf;
	private String matriculaInss;
	
	public Cliente() {

	}

	public Cliente(String nomeCompleto, String endereco, String cpf, String matriculaInss) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.cpf = cpf;
		this.matriculaInss = matriculaInss;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatriculaInss() {
		return matriculaInss;
	}

	public void setMatriculaInss(String matriculaInss) {
		this.matriculaInss = matriculaInss;
	}

	@Override
	public String toString() {
		return "Cliente [nomeCompleto=" + nomeCompleto + ", endereco=" + endereco + ", cpf=" + cpf + ", matriculaInss="
				+ matriculaInss + "]";
	}
}
