package Recibo;

import Testes.InterfaceTeste;

public class CalculoRecibo implements InterfaceTeste {
	static ReciboConta recibo = new ReciboConta();

	@Override
	public float calculoInss(double valorInss) {
	

		
		if (recibo.getValorServico() <= 965.67) {
			
			valorInss = recibo.getValorServico() * 0.08;

		} else if (recibo.getValorServico() >= 965.68 && recibo.getValorServico() <= 1609.45) {

			valorInss = recibo.getValorServico() * 0.09;

			System.out.println("AAAAAAAAAAAAAAAAAAA");
			recibo.setValorInss((float) valorInss);

		} else if (recibo.getValorServico() >= 1609.46 && recibo.getValorServico() <= 3218.90) {

			valorInss = recibo.getValorServico() * 0.11;

		} else {
			valorInss = (recibo.getValorServico() - 354.08);
		}
		return recibo.getValorInss();
	}

	@Override
	public float calculoValorIr(double valorIr) {
		if (recibo.getValorServico() <= 1434) {
			valorIr = 0;
			recibo.setValorIr((float) valorIr);

		} else if (recibo.getValorServico() >= 1434.01 && recibo.getValorServico() <= 2150) {
			valorIr = recibo.getValorIr() * 0.75;

			recibo.setValorIr((float) valorIr);

		} else if (recibo.getValorServico() >= 2150.01 && recibo.getValorServico() <= 2866) {
			valorIr = recibo.getValorServico() * 0.15;

			recibo.setValorIr((float) valorIr);

		} else if (recibo.getValorServico() >= 2866.01 && recibo.getValorServico() <= 3582) {
			valorIr = recibo.getValorServico() * 0.225;
			recibo.setValorIr((float) valorIr);

		} else {
			valorIr = recibo.getValorServico() * 0.275;
			recibo.setValorIr((float) valorIr);

		}
		return recibo.getValorIr();
	}

	@Override
	public float calculoLiquido(double valorLiquido) {
		valorLiquido = (recibo.getValorServico() - recibo.getValorServico()) - recibo.getValorIr();

		System.out.println("ó o bicho vindo");
		return recibo.getValorLiquido();
	}

}
