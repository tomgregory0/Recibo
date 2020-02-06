package negocio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Telefonia.TelefoniaPlanoPos;

public class ReciboClienteTxt {
	
	File file = new File ("Fatura.txt");
	Cliente cliente = new Cliente();
	
	
	//TelefoniaPlanoPos planoPosInternet = new TelefoniaPlanoPos();

	
	public void gerarReciboCliente(Cliente cliente, Plano planoPreInternet) {
		
		
		try (BufferedWriter saida = new BufferedWriter(new FileWriter(file, false))){
			
			saida.write("------------Cliente------------"+"\n \n \n \n");
			saida.write("Nome: " + cliente.getNomeCompleto()+"\n");
			saida.write("Cpf: " + cliente.getCpf()+"\n");
			saida.write("Data Nascimento: "+cliente.getDataNascimento()+"\n");
			saida.write("Endereço"+ cliente.getEndereco()+"\n");
			saida.write("Cidade"+cliente.getCidade()+"\n \n");
			
			
			saida.write("---------------Fatura a pagar---------------\n");
			//saida.write("Valor a pagar: " + );
			
			
			saida.flush();
			saida.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}		
}
