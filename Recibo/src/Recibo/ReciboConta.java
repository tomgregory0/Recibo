package Recibo;

public class ReciboConta extends CalculoRecibo {

	private float valorInss;
	private float valorIr;
	private float valorServico = 3100;
	private float valorLiquido;

	public ReciboConta() {

	}

	public ReciboConta(float valorInss,float valorIr, float valorServico, float valorLiquido) {
		super();
		this.valorInss = valorInss;
		this.valorIr = valorIr;
		this.valorServico = valorServico;
		this.valorLiquido = valorLiquido;
	}

	public float getValorInss() {
		return valorInss;
	}

	public void setValorInss(float valorInss) {
		this.valorInss = valorInss;
	}

	public float getValorIr() {
		return valorIr;
	}

	public void setValorIr(float valorIr) {
		this.valorIr = valorIr;
	}

	public float getValorServico() {
		return valorServico;
	}

	public void setValorServico(float valorServico) {
		this.valorServico = valorServico;
	}

	public float getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(float valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Override
	public String toString() {
		return "ReciboConta [valorInss="  +valorInss+ ", valorIr=" + valorIr + ", valorServico=" + valorServico
				+ ", valorLiquido=" + valorLiquido + "]";
	}
}
