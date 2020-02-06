package negocio;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Telefonia.PlanoTelefoniaPrePago;

public class CadastroCliente {

	public void EntradaDados() {

		ReciboClienteTxt gerarArquivo = new ReciboClienteTxt();

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Bem Vindo\n\n Favor Inserir seus dados para realizar o cadastro de sua conta\n\n");
			System.out.println("Insira seu nome completo:	\n");
			String nomeCompleto = scanner.nextLine();

			System.out.println("Insira seu CPF:  \n");
			String cpf = scanner.nextLine();

			System.out.println("Insira seu RG:  \n");
			String rg = scanner.nextLine();

			System.out.println("Insira sua data de Nascimento:  \n");
			String dataNascimento = scanner.nextLine();

			// System.out.println("Favor informe o Status do cliente: \n");
			// String status = scanner.nextLine().toUpperCase();
			/////////////////////

			System.out.println("Favor insira seu endereco:   \n");
			String endereco = scanner.nextLine();

			System.out.println("Insira sua cidade:  \n");
			String cidade = scanner.nextLine();

			System.out.println("Insira seu cep:  \n");
			String cep = scanner.nextLine();

			System.out.println("Insira seu telefone:  \n");
			String telefone = scanner.nextLine();

			System.out.println("Seu codigo de cliente é   \n\n");
			Random gerador = new Random();
			int codigoCliente = gerador.nextInt(99999);
			System.out.println("       " + codigoCliente + "  ");

			// Plano planoPreInternet = new PlanoTelefoniaPrePago(01,"Plano Pre Internet",
			// 29.9, 100, 400);
			// Plano planoPosInternet = new Plano(02, "Plano Pos Internet", 69.99, 250, 150,
			// 300);

			Cliente cliente = new Cliente(codigoCliente, nomeCompleto, cpf, rg, dataNascimento, endereco, cidade, cep,
					telefone);

			// gerarArquivo.gerarReciboCliente(cliente,planoPosInternet);

		} catch (InputMismatchException e) {
			System.out.println("Erro digite corretamente." + e);
		} catch (NumberFormatException e) {
			System.out.println("Erro verifique o valor digitado. " + e);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("Erro digite corretamente o status.");
		}
	}
}