package Testes;

import Recibo.CalculoRecibo;
import Recibo.ReciboConta;

public class ClasseTeste {

	static CalculoRecibo calculo = new CalculoRecibo();

	static ReciboConta recibo = new ReciboConta();

	public static void main(String[] args) {

		// recibo.setValorServico(1500);

		recibo.getValorLiquido();

		CalculoRecibo CalculoRecibo = new CalculoRecibo();

		InterfaceTeste valores = CalculoRecibo;

		// valores.calculoInss(recibo.getValorLiquido());

		// System.out.println(valores.calculoInss(recibo.getValorInss()));

		System.out.println(valores.calculoInss(recibo.getValorInss()));

		System.out.println(valores.calculoLiquido(recibo.getValorLiquido()));

		System.out.println(valores.calculoValorIr(recibo.getValorIr()));

	}
}
