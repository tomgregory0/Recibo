package negocio;

import java.util.Random;

public class Cliente {
	
	private int codigoCliente;
	private String nomeCompleto;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private Status status;    
	private String endereco;
	private String cidade;
	private String cep;
	private String telefone;

	
	public  Cliente () {
		
	}
	
	public Cliente(int codigoCliente, String nomeCompleto, String cpf, String rg, String dataNascimento,
			String endereco, String cidade, String cep, String telefone) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.status = status;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
